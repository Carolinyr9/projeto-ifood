package view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ProgressBar;

import database.CarrinhoBanco;
import database.DBConnection;
import database.PedidoBanco;
import database.PratoBanco;
import database.ProdutoBanco;
import database.RestauranteBanco;
import model.Carrinho;
import model.ItemCardapio;
import model.Pedido;
import model.Prato;
import model.Produto;
import model.Restaurante;

public class FuncionarioInfoPedido extends Composite {
	
	private LocalResourceManager localResourceManager;
	private Display display = getDisplay();
	private Image restauranteLogoPqIcon;
	private Pedido pedido;
	private Integer idPedido;
	private DBConnection connection = new DBConnection();
	private PedidoBanco bancoPedido;
	private Restaurante restaurante;
	private RestauranteBanco bancoRestaurante;
	private CarrinhoBanco bancoCarrinho;
	private ProdutoBanco bancoProduto;
	private PratoBanco bancoPrato;

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}

	public FuncionarioInfoPedido(Composite parent, MainPage mainPage, Integer id_pedido) {
		super(parent, SWT.NONE);
		createResourceManager();
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setSize(482, 774);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);

		idPedido = id_pedido;

		bancoPedido = new PedidoBanco(connection);
		pedido = bancoPedido.visualizarPedido(idPedido);
		
		bancoRestaurante = new RestauranteBanco(connection);
		restaurante = bancoRestaurante.visualizarRestaurante(pedido.getIdRestaurante());
        String enderecoRestaurante = restaurante.getRua() + ", " + restaurante.getNumeroResidencial() + " - " + restaurante.getCidade() + ", " + restaurante.getEstado();

		bancoProduto = new ProdutoBanco(connection);
		bancoPrato = new PratoBanco(connection);

		// Use os itens dessa lista para mostrar as informações
		List<ItemCardapio> itensCardapio = obterItensCardapio(this.pedido);

		// Aplique a lógica para o preço total usando itensCardapio
		Double precoTotal = calcularPrecoTotal(itensCardapio);

		Image arrowIcon = new Image(display, "./src/assets/images/backArrow.png");
		restauranteLogoPqIcon = new Image(display, "./src/assets/images/restauranteLogoPqIcon.png");
		
		Composite compositeHeader = new Composite(this, SWT.NONE);
		GridData gd_compositeHeader = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeHeader.heightHint = 71;
		gd_compositeHeader.widthHint = 478;
		compositeHeader.setLayoutData(gd_compositeHeader);
		compositeHeader.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));

		Label lblTelaTitulo = new Label(compositeHeader, SWT.CENTER);
		lblTelaTitulo.setAlignment(SWT.CENTER);
		lblTelaTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblTelaTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		lblTelaTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
		lblTelaTitulo.setBounds(86, 20, 95, 43);
		lblTelaTitulo.setText("Pedido");

		Button btnBack = new Button(compositeHeader, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreenEntregador(2);
			}
		});
		btnBack.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent event) {
				event.gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
				event.gc.fillRectangle(event.x, event.y, event.width, event.height);
				event.gc.drawImage(arrowIcon, 0, 0);
			}
		});
		btnBack.setBounds(20, 10, 60, 53);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_scrolledComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_scrolledComposite.heightHint = 697;
		gd_scrolledComposite.widthHint = 480;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite compositeInfoPedido = new Composite(scrolledComposite, SWT.NONE);
		compositeInfoPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		scrolledComposite.setContent(compositeInfoPedido);
		scrolledComposite.setMinSize(compositeInfoPedido.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		GridLayout gl_compositeInfoPedido = new GridLayout(1, false);
		gl_compositeInfoPedido.marginLeft = 35;
		compositeInfoPedido.setLayout(gl_compositeInfoPedido);

		Composite compositeRestauranteInfo = new Composite(compositeInfoPedido, SWT.NONE);
		GridData gd_compositeRestauranteInfo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeRestauranteInfo.widthHint = 401;
		compositeRestauranteInfo.setLayoutData(gd_compositeRestauranteInfo);
		gd_compositeRestauranteInfo.widthHint = 387;
		gd_compositeRestauranteInfo.heightHint = 197;
		compositeRestauranteInfo.setLayoutData(gd_compositeRestauranteInfo);
		compositeRestauranteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblStatus = new Label(compositeRestauranteInfo, SWT.NONE);
		lblStatus.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblStatus.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblStatus.setBounds(34, 44, 340, 28);
		lblStatus.setText(pedido.getStatusString());
		
		Label lblNumpedido = new Label(compositeRestauranteInfo, SWT.NONE);
		lblNumpedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblNumpedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNumpedido.setBounds(34, 10, 239, 28);
		lblNumpedido.setText("Pedido #" + pedido.getId().toString());
		Label labelHorizontalRestauranteInfo = new Label(compositeRestauranteInfo, SWT.SEPARATOR | SWT.HORIZONTAL);
		labelHorizontalRestauranteInfo.setBounds(10, 185, 360, 2);
		
		
		ProgressBar progressBar = new ProgressBar(compositeRestauranteInfo, SWT.NONE);
		progressBar.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 255, 64))));
		progressBar.setMaximum(3);
		progressBar.setSelection(1);
		progressBar.setBounds(84, 83, 212, 23);
		
		Button btnMudarStatus = new Button(compositeRestauranteInfo, SWT.NONE);
		btnMudarStatus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnMudarStatus.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		btnMudarStatus.setBounds(128, 143, 119, 30);
		
		Label lblMudarStatusPara = new Label(compositeRestauranteInfo, SWT.NONE);
		lblMudarStatusPara.setBounds(123, 117, 150, 20);
		lblMudarStatusPara.setText("Mudar status para:");
		
		switch (pedido.getStatus().getStatus()) {
			case ABERTO:
				progressBar.setSelection(0);
				btnMudarStatus.setText("Em preparo");
				btnMudarStatus.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						PedidoBanco banco = new PedidoBanco(connection);
						
						banco.atualizarStatusProduto(pedido.getId(), "em_preparo");
					}
				});
				break;
			case EM_PREPARO:
				progressBar.setSelection(1);
				btnMudarStatus.setText("A caminho");
				btnMudarStatus.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						PedidoBanco banco = new PedidoBanco(connection);
						
						banco.atualizarStatusProduto(pedido.getId(), "a_caminho");
					}
				});
				break;
			case A_CAMINHO:
				progressBar.setSelection(2);
				btnMudarStatus.setText("Entregue");
				break;
			case ENTREGUE:
				progressBar.setSelection(3);
				break;
			case CANCELADO:
				progressBar.setSelection(0);
				break;
		}
		
		Composite compositeClienteInfo = new Composite(compositeInfoPedido, SWT.NONE);
		GridData gd_compositeClienteInfo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeClienteInfo.widthHint = 387;
		gd_compositeClienteInfo.heightHint = 83;
		compositeClienteInfo.setLayoutData(gd_compositeClienteInfo);
		compositeClienteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblPrevisoDeEntrega = new Label(compositeClienteInfo, SWT.NONE);
		lblPrevisoDeEntrega.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblPrevisoDeEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrevisoDeEntrega.setAlignment(SWT.CENTER);
		lblPrevisoDeEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 14, SWT.NORMAL)));
		lblPrevisoDeEntrega.setBounds(10, 10, 367, 28);
		lblPrevisoDeEntrega.setText("Previsão de entrega");
		
		Label lblHora = new Label(compositeClienteInfo, SWT.NONE);
		lblHora.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 0, 0))));
		lblHora.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblHora.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblHora.setAlignment(SWT.CENTER);
		lblHora.setBounds(10, 44, 367, 28);
		lblHora.setText(String.format("%02d:%02d", pedido.getEstimativaTempo().getHour(), pedido.getEstimativaTempo().getMinute()));

		Label labelHorizontalClienteInfo = new Label(compositeClienteInfo, SWT.SEPARATOR | SWT.HORIZONTAL);
		labelHorizontalClienteInfo.setBounds(10, 79, 360, 2);

		Composite compositeRestauranteCard = new Composite(compositeInfoPedido, SWT.NONE);
		GridData gd_compositeRestauranteCard = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeRestauranteCard.widthHint = 387;
		gd_compositeRestauranteCard.heightHint = 125;
		compositeRestauranteCard.setLayoutData(gd_compositeRestauranteCard);
		compositeRestauranteCard.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));

		Label lblLogoRestaurante = new Label(compositeRestauranteCard, SWT.NONE);
		lblLogoRestaurante.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblLogoRestaurante.setImage(restauranteLogoPqIcon);
		lblLogoRestaurante.setBounds(10, 10, 90, 88);

		Label lblRestauranteNome = new Label(compositeRestauranteCard, SWT.NONE);
		lblRestauranteNome.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblRestauranteNome.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblRestauranteNome.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 14, SWT.NORMAL)));
		lblRestauranteNome.setAlignment(SWT.CENTER);
		lblRestauranteNome.setBounds(76, 10, 289, 30);
		lblRestauranteNome.setText(restaurante.getNome());

		Label lblRestauranteEndereco = new Label(compositeRestauranteCard, SWT.NONE);
		lblRestauranteEndereco.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblRestauranteEndereco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblRestauranteEndereco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblRestauranteEndereco.setAlignment(SWT.CENTER);
		lblRestauranteEndereco.setBounds(76, 46, 289, 30);
		lblRestauranteEndereco.setText(enderecoRestaurante);

		Label labelHorizontalRestauranteCard = new Label(compositeRestauranteCard, SWT.SEPARATOR | SWT.HORIZONTAL);
		labelHorizontalRestauranteCard.setBounds(10, 113, 360, 2);

		Label lblItensPedido = new Label(compositeInfoPedido, SWT.NONE);
		lblItensPedido.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblItensPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblItensPedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 14, SWT.NORMAL)));
		lblItensPedido.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblItensPedido.setText("Itens do Pedido");
		
		// Defina a largura para todos os itens no pedido
		GridData gd_lblItemNome = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblItemNome.widthHint = 200;

		Composite compositeItensPedido = new Composite(compositeInfoPedido, SWT.NONE);
		compositeItensPedido.setLayout(new GridLayout(2, false));
		GridData gd_compositeItensPedido = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeItensPedido.widthHint = 384;
		compositeItensPedido.setLayoutData(gd_compositeItensPedido);
		
		// Use a lista de itensCardapio para preencher os itens do pedido
		for (ItemCardapio item : itensCardapio) {
			Label lblItem = new Label(compositeItensPedido, SWT.WRAP);
			GridData gd_lblItem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblItem.widthHint = 277;
			lblItem.setLayoutData(gd_lblItem);
			lblItem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
			lblItem.setText(item.getNome());
			
			Label lblItemPreco = new Label(compositeItensPedido, SWT.NONE);
			GridData gd_lblItemPreco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblItemPreco.widthHint = 88;
			lblItemPreco.setLayoutData(gd_lblItemPreco);
			lblItemPreco.setText(String.format("R$ %.2f", item.getPreco()));
		}
		Double precoFinal = precoTotal + 5;			

		Composite compositeResumo = new Composite(compositeInfoPedido, SWT.NONE);
		GridData gd_compositeResumo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeResumo.widthHint = 387;
		gd_compositeResumo.heightHint = 147;
		compositeResumo.setLayoutData(gd_compositeResumo);
		compositeResumo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label labelHorizontalResumo = new Label(compositeResumo, SWT.SEPARATOR | SWT.HORIZONTAL);
		labelHorizontalResumo.setBounds(10, 0, 360, 2);
				
		Label lblSubTotal = new Label(compositeResumo, SWT.NONE);
		lblSubTotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblSubTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblSubTotal.setBounds(20, 10, 92, 23);
		lblSubTotal.setText("SubTotal");
		
		Label lblSubTotalPreco = new Label(compositeResumo, SWT.NONE);
		lblSubTotalPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblSubTotalPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblSubTotalPreco.setAlignment(SWT.RIGHT);
		lblSubTotalPreco.setBounds(256, 10, 104, 23);
		lblSubTotalPreco.setText(String.format("R$ %.2f", precoTotal));
		
		Label lblTaxaEntrega = new Label(compositeResumo, SWT.NONE);
		lblTaxaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblTaxaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTaxaEntrega.setBounds(20, 39, 142, 23);
		lblTaxaEntrega.setText("Taxa de entrega");
				
		Label lblPrecoTaxaEntrega = new Label(compositeResumo, SWT.NONE);
		lblPrecoTaxaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblPrecoTaxaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoTaxaEntrega.setAlignment(SWT.RIGHT);
		lblPrecoTaxaEntrega.setBounds(256, 39, 104, 23);
		lblPrecoTaxaEntrega.setText(String.format("R$ %.2f", 5.00));
										
		Label lblDesconto = new Label(compositeResumo, SWT.NONE);
		lblDesconto.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblDesconto.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblDesconto.setBounds(20, 68, 92, 23);
		lblDesconto.setText("Desconto");
														
		Label lblPrecoDesconto = new Label(compositeResumo, SWT.NONE);
		lblPrecoDesconto.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblPrecoDesconto.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoDesconto.setAlignment(SWT.RIGHT);
		lblPrecoDesconto.setBounds(256, 68, 104, 23);
		lblPrecoDesconto.setText(String.format("Sem desconto"));
		
		Label labelHorizontalResumo2 = new Label(compositeResumo, SWT.SEPARATOR | SWT.HORIZONTAL);
		labelHorizontalResumo2.setBounds(10, 103, 360, 2);
		
		Label lblPrecoFinal = new Label(compositeResumo, SWT.NONE);
		lblPrecoFinal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblPrecoFinal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoFinal.setBounds(20, 111, 70, 23);
		lblPrecoFinal.setText("Total");
		
		Label lblPrecoTotalFinal = new Label(compositeResumo, SWT.NONE);
		lblPrecoTotalFinal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblPrecoTotalFinal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoTotalFinal.setAlignment(SWT.RIGHT);
		lblPrecoTotalFinal.setBounds(226, 111, 134, 23);
		lblPrecoTotalFinal.setText(String.format("R$ %.2f", precoFinal));
		
		scrolledComposite.setContent(compositeInfoPedido);
		scrolledComposite.setMinSize(compositeInfoPedido.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
    
    private List<ItemCardapio> obterItensCardapio(Pedido pedido) {
        PratoBanco pratoBanco = new PratoBanco(connection);
        ProdutoBanco produtoBanco = new ProdutoBanco(connection);
        List<ItemCardapio> itens = new ArrayList<>();
        for (Integer idPrato : pedido.getIdsPratos()) {
            Prato prato = pratoBanco.visualizarPrato(idPrato);
            
            System.out.println("id do prato");
            System.out.println(prato.getIdPrato());
            if(prato != null) {
            	itens.add(prato);
            }
        }
        for (Integer idProduto : pedido.getIdsProdutos()) {
            Produto produto = produtoBanco.visualizarProduto(idProduto);
            System.out.println("id do prato");
            System.out.println(produto.getIdPrato());
            if(produto != null) {
            	itens.add(produto);
            }
        }
        return itens;
    }
    
    private Double calcularPrecoTotal(List<ItemCardapio> itens) {
    	Double preco = 0.0;
    	for (ItemCardapio item : itens) {
    		preco += item.getPreco();
		}
    	
    	return preco;
    }
}
