package view;

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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
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
import database.UsuarioBanco;
import model.Carrinho;
import model.Pedido;
import model.Prato;
import model.Produto;
import model.Restaurante;

public class ClienteInfoPedido extends Composite {
		
	private LocalResourceManager localResourceManager;
	private Display display = getDisplay();
	private Image restauranteLogoPqIcon;
	private Pedido pedido;
	private Integer idPedido;
	private DBConnection connection = new DBConnection();
	private PedidoBanco bancoPedido;
	private Restaurante restaurante;
	private RestauranteBanco bancoRestaurante;
	private List<Carrinho> carrinho;
	private CarrinhoBanco bancoCarrinho;
	private List<Integer> listaIdProdutos;
	private List<Integer> listaIdPratos;
	private ProdutoBanco bancoProduto;
	private PratoBanco bancoPrato;
	private List<Produto> listaProdutos;
	private List<Prato> listaPratos;

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}


    public ClienteInfoPedido(Composite parent, MainPage mainPage, Integer id_pedido) {
		super(parent, SWT.NONE);
		createResourceManager();
		setSize(482, 774);
		setLayout(new FormLayout());
		
		idPedido = id_pedido;
		
		bancoPedido = new PedidoBanco(connection);
		pedido = bancoPedido.visualizarPedido(idPedido);
		
		bancoRestaurante = new RestauranteBanco(connection);
		restaurante = bancoRestaurante.visualizarRestaurante(pedido.getIdRestaurante());
		
		bancoCarrinho = new CarrinhoBanco(connection);
		carrinho = bancoCarrinho.visualizarCarrinho(pedido.getIdCarrinho());
		
		bancoProduto = new ProdutoBanco(connection);
		bancoPrato = new PratoBanco(connection);
		
		for(int j = 0; j < carrinho.size(); j++) {
			if(carrinho.get(j).getIdPrato() != 0) {
				listaIdPratos.add(carrinho.get(j).getIdPrato()); 
			}else if(carrinho.get(j).getIdProduto() != 0) {
				listaIdProdutos.add(carrinho.get(j).getIdProduto()); 
			}
			
		}
		
		for(int k = 0; k < listaIdPratos.size(); k++) {
			listaPratos.add(bancoPrato.visualizarPrato(listaIdPratos.get(k)));
		}
		
		for(int l = 0; l < listaIdProdutos.size(); l++) {
			listaProdutos.add(bancoProduto.visualizarProduto(listaIdProdutos.get(l)));
		}
		
		Double precoTotal = null;
		for(int m = 0; m < carrinho.size(); m++) {
			precoTotal = precoTotal + (listaPratos.get(m).getPreco() + listaPratos.get(m).getPreco());
		}
		
		
		Image arrowIcon = new Image(display, "./src/assets/images/backArrow.png");
		restauranteLogoPqIcon = new Image(display, "./src/assets/images/restauranteLogoPqIcon.png");
		
		Composite compositeHeader = new Composite(this, SWT.NONE);
		compositeHeader.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		FormData fd_compositeHeader = new FormData();
		fd_compositeHeader.top = new FormAttachment(0);
		fd_compositeHeader.left = new FormAttachment(0);
		fd_compositeHeader.bottom = new FormAttachment(0, 73);
		fd_compositeHeader.right = new FormAttachment(0, 482);
		compositeHeader.setLayoutData(fd_compositeHeader);
		
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
		btnBack.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(arrowIcon, 0, 0);
			  }
			} );
		btnBack.setBounds(20, 10, 60, 53);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.top = new FormAttachment(compositeHeader, 6);
		fd_scrolledComposite.bottom = new FormAttachment(100, 10);
		fd_scrolledComposite.right = new FormAttachment(compositeHeader, 0, SWT.RIGHT);
		fd_scrolledComposite.left = new FormAttachment(0);
		scrolledComposite.setLayoutData(fd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite compositePedido = new Composite(scrolledComposite, SWT.NONE);
		compositePedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridLayout gl_compositePedido = new GridLayout(2, false);
		gl_compositePedido.marginLeft = 40;
		gl_compositePedido.verticalSpacing = 15;
		compositePedido.setLayout(gl_compositePedido);
		
		Composite compositeRestauranteInfo = new Composite(compositePedido, SWT.NONE);
		GridData gd_compositeRestauranteInfo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeRestauranteInfo.widthHint = 387;
		gd_compositeRestauranteInfo.heightHint = 125;
		compositeRestauranteInfo.setLayoutData(gd_compositeRestauranteInfo);
		compositeRestauranteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblStatus = new Label(compositeRestauranteInfo, SWT.NONE);
		lblStatus.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblStatus.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblStatus.setBounds(34, 44, 340, 28);
		/* Colocar aqui o status do pedido, dentro de setText()*/
		lblStatus.setText("Em preparo");
		
		Label lblNumpedido = new Label(compositeRestauranteInfo, SWT.NONE);
		lblNumpedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblNumpedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNumpedido.setBounds(34, 10, 239, 28);
		/* Colocar aqui o número do pedido, dentro de setText()*/
		lblNumpedido.setText("Pedido #" + pedido.getId().toString());
		
		Label labelHorizontalRestauranteInfo = new Label(compositeRestauranteInfo, SWT.SEPARATOR | SWT.HORIZONTAL);
		labelHorizontalRestauranteInfo.setBounds(10, 112, 360, 2);
		
		ProgressBar progressBar = new ProgressBar(compositeRestauranteInfo, SWT.NONE);
		progressBar.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 255, 64))));
		progressBar.setMaximum(3);
		/*Colocar aqui a lógica que faz a barra de progresso aumentar, de acordo com:
		 * 
		 *  status: em aceitação -> progressBar.setSelection(1)
		 *  status: em preparo -> progressBar.setSelection(2)
		 *  status: em rota de entrega -> progressBar.setSelection(3)*/
		progressBar.setSelection(1);
		progressBar.setBounds(84, 83, 212, 23);
		
		Composite compositeClienteInfo = new Composite(compositePedido, SWT.NONE);
		GridData gd_compositeClienteInfo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeClienteInfo.widthHint = 387;
		gd_compositeClienteInfo.heightHint = 83;
		compositeClienteInfo.setLayoutData(gd_compositeClienteInfo);
		compositeClienteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblPrevisoDeEntrega = new Label(compositeClienteInfo, SWT.NONE);
		lblPrevisoDeEntrega.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblPrevisoDeEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrevisoDeEntrega.setAlignment(SWT.CENTER);
		lblPrevisoDeEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblPrevisoDeEntrega.setBounds(10, 10, 339, 25);
		lblPrevisoDeEntrega.setText("Previsão de entrega:");
		
		Label labelHoraEntrega = new Label(compositeClienteInfo, SWT.NONE);
		labelHoraEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		labelHoraEntrega.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(36, 123, 160))));
		labelHoraEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		labelHoraEntrega.setAlignment(SWT.CENTER);
		labelHoraEntrega.setBounds(126, 41, 117, 25);
		/*Colocar aqui o hora estimada, dentro de setText()*/
		labelHoraEntrega.setText(pedido.getEstimativaTempo().toString());
		
		Composite compositeItensPedido = new Composite(compositePedido, SWT.NONE);
		compositeItensPedido.setLayout(new GridLayout(2, false));
		GridData gd_compositeItensPedido = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeItensPedido.heightHint = 213;
		gd_compositeItensPedido.widthHint = 390;
		compositeItensPedido.setLayoutData(gd_compositeItensPedido);
		compositeItensPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblPedidoEm_1 = new Label(compositeItensPedido, SWT.NONE);
		lblPedidoEm_1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPedidoEm_1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		lblPedidoEm_1.setText("Pedido em:");
		new Label(compositeItensPedido, SWT.NONE);
		
		Label lblLogoRestaurante = new Label(compositeItensPedido, SWT.NONE);
		GridData gd_lblLogoRestaurante = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblLogoRestaurante.widthHint = 81;
		gd_lblLogoRestaurante.heightHint = 82;
		lblLogoRestaurante.setLayoutData(gd_lblLogoRestaurante);
		lblLogoRestaurante.setImage(restauranteLogoPqIcon);
		lblLogoRestaurante.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblNomeRestaurante = new Label(compositeItensPedido, SWT.WRAP);
		lblNomeRestaurante.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(4, 42, 92))));
		lblNomeRestaurante.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNomeRestaurante.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		/*Colocar aqui o nome do restaurante, dentro de setText()*/
		lblNomeRestaurante.setText(restaurante.getNome());
		
		Label lblResumoDoPedido = new Label(compositeItensPedido, SWT.NONE);
		lblResumoDoPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblResumoDoPedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblResumoDoPedido.setText("Resumo do pedido");
		new Label(compositeItensPedido, SWT.NONE);
		
		Composite compositeItens = new Composite(compositeItensPedido, SWT.NONE);
		GridData gd_compositeItens = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeItens.widthHint = 364;
		compositeItens.setLayoutData(gd_compositeItens);
		compositeItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridLayout gl_compositeItens = new GridLayout(2, false);
		gl_compositeItens.marginLeft = 10;
		gl_compositeItens.horizontalSpacing = 10;
		compositeItens.setLayout(gl_compositeItens);
		
		Label lblTotal = new Label(compositeItensPedido, SWT.NONE);
		lblTotal.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblTotal.setText("Total");
		
		Label lblPrecototal = new Label(compositeItensPedido, SWT.NONE);
		lblPrecototal.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblPrecototal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecototal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		/*Colocar aqui o preço total do pedido (com a taxa de entrega), dentro de setText()*/
		lblPrecototal.setText("R$" + precoTotal);
		new Label(compositePedido, SWT.NONE);
		
		if(listaIdPratos.size() > 0) {
			for(int i = 0; i < listaPratos.size(); i++) {
				Label lblItem = new Label(compositeItens, SWT.WRAP);
				lblItem.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
				lblItem.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
				lblItem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				GridData gd_lblItem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_lblItem.widthHint = 223;
				lblItem.setLayoutData(gd_lblItem);
				lblItem.setText(listaPratos.get(i).getNome());
				
				Label lblPreco = new Label(compositeItens, SWT.NONE);
				lblPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
				lblPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
				GridData gd_lblPreco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_lblPreco.widthHint = 84;
				lblPreco.setLayoutData(gd_lblPreco);
				lblPreco.setText("R$" + listaPratos.get(i).getPreco().toString());
			}	
		}
		
		if(listaIdProdutos.size() > 0) {
			for(int i = 0; i < listaProdutos.size(); i++) {
				Label lblItem = new Label(compositeItens, SWT.WRAP);
				lblItem.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
				lblItem.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
				lblItem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				GridData gd_lblItem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_lblItem.widthHint = 223;
				lblItem.setLayoutData(gd_lblItem);
				lblItem.setText(listaProdutos.get(i).getNome());
				
				Label lblPreco = new Label(compositeItens, SWT.NONE);
				lblPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
				lblPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
				GridData gd_lblPreco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_lblPreco.widthHint = 84;
				lblPreco.setLayoutData(gd_lblPreco);
				lblPreco.setText("R$" + listaProdutos.get(i).getPreco().toString());
			}	
		}
		
		
		Composite compositeStatus = new Composite(compositePedido, SWT.NONE);
		GridData gd_compositeStatus = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeStatus.widthHint = 389;
		gd_compositeStatus.heightHint = 77;
		compositeStatus.setLayoutData(gd_compositeStatus);
		compositeStatus.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		
		Label lblEntregaEm = new Label(compositeStatus, SWT.NONE);
		lblEntregaEm.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 64, 128))));
		lblEntregaEm.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblEntregaEm.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 9, SWT.NORMAL)));
		lblEntregaEm.setBounds(28, 10, 323, 25);
		lblEntregaEm.setText("Entrega em:");
		
		Label lblEndereco = new Label(compositeStatus, SWT.WRAP);
		/*Colocar aqui o endereço do cliente, dentro de setText()*/
		lblEndereco.setText("Endereco");
		lblEndereco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblEndereco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblEndereco.setBounds(28, 37, 329, 25);
		new Label(compositePedido, SWT.NONE);
		
		Composite compositeButtons = new Composite(compositePedido, SWT.NONE);
		compositeButtons.setLayout(null);
		compositeButtons.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_compositeButtons = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeButtons.heightHint = 51;
		gd_compositeButtons.widthHint = 389;
		compositeButtons.setLayoutData(gd_compositeButtons);
		
		Button btnCancelaPedido = new Button(compositeButtons, SWT.NONE);
		btnCancelaPedido.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/*Colocar aqui a lógica para cancelar o pedido*/
			}
		});
		btnCancelaPedido.setBounds(41, 5, 156, 35);
		btnCancelaPedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnCancelaPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		btnCancelaPedido.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		btnCancelaPedido.setText("Cancelar pedido");
		btnCancelaPedido.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnCancelaPedido.getBounds();
				Color blue = new Color(getDisplay(), new RGB(0, 100, 141));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));
				
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
				
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Cancelar pedido";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);
				
				blue.dispose();
				white.dispose();
			}
		});
		new Label(compositePedido, SWT.NONE);
		
		scrolledComposite.setContent(compositePedido);
		scrolledComposite.setMinSize(compositePedido.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	
	}
}