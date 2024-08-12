package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import database.CardapioBanco;
import database.DBConnection;
import database.PratoBanco;
import database.ProdutoBanco;
import database.RestauranteBanco;
import model.Cliente;
import model.ItemCardapio;
import model.Prato;
import model.Produto;
import model.Restaurante;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;

public class HomeCliente extends Composite {

	private DBConnection connection = new DBConnection();
    private Image bannerImage;
    private Image pizza1;
    private Image restauranteLogoImage;
    private LocalResourceManager localResourceManager;
    private Display display = getDisplay();
    private Restaurante restaurante;
    private RestauranteBanco banco;
    private CardapioBanco bancoCardapio;
    private List<ItemCardapio> itemCardapioLista;
    private PratoBanco bancoPrato;
    private List<Prato> pratoLista;
    private ProdutoBanco bancoProduto;
    private List<Produto> produtoLista;

    private void createResourceManager() {
        localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
    }

    public HomeCliente(Composite parent, MainPage mainPage, Cliente cliente) {
        super(parent, SWT.NONE);
        createResourceManager();
        setSize(482, 836);
        setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        setLayout(null);
        
        banco = new RestauranteBanco(connection);
        restaurante = banco.visualizarRestaurante(1);
        String enderecoRestaurante = restaurante.getRua() + ", " + restaurante.getNumeroResidencial() + " - " + restaurante.getCidade() + ", " + restaurante.getEstado();
        
        bancoCardapio = new CardapioBanco(connection);
        itemCardapioLista = bancoCardapio.listarCardapioPorRestaurante(restaurante.getId());
        
        bancoPrato = new PratoBanco(connection);
        pratoLista = new ArrayList<Prato>();
        produtoLista = new ArrayList<Produto>();
        bancoProduto = new ProdutoBanco(connection);
        System.out.println("a1");
        for(int i = 0 ;i < itemCardapioLista.size(); i++) {
        	int idPrato = itemCardapioLista.get(i).getIdPrato();
        	int idProduto = itemCardapioLista.get(i).getIdProduto();
        	if(idPrato != 0) {
        		pratoLista.add(bancoPrato.visualizarPrato(idPrato));
        	}else if(idProduto != 0) {
        		produtoLista.add(bancoProduto.visualizarProduto(idProduto));
        	}
        }
        System.out.println("a2");
        
        ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        scrolledComposite.setBounds(0, 0, 482, 836);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);

        bannerImage = new Image(display, "./src/assets/images/Banner.png");
        restauranteLogoImage = new Image(display, "./src/assets/images/restauranteLogo.png");
        pizza1 = new Image(display, "./src/assets/images/pizza1.png");

        Composite compositeHomeCliente = new Composite(scrolledComposite, SWT.NONE);
        compositeHomeCliente.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        GridLayout gl_compositeHomeCliente = new GridLayout(1, false);
        gl_compositeHomeCliente.marginWidth = 0;
        gl_compositeHomeCliente.horizontalSpacing = 0;
        gl_compositeHomeCliente.marginHeight = 0;
        compositeHomeCliente.setLayout(gl_compositeHomeCliente);

        Composite compositeRestauranteInfo = new Composite(compositeHomeCliente, SWT.NONE);
        compositeRestauranteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        GridData gd_compositeRestauranteInfo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_compositeRestauranteInfo.widthHint = 470;
        gd_compositeRestauranteInfo.heightHint = 282;
        compositeRestauranteInfo.setLayoutData(gd_compositeRestauranteInfo);

        Label labelBanner = new Label(compositeRestauranteInfo, SWT.NONE);
        labelBanner.setBounds(0, 0, 479, 107);
        labelBanner.setImage(bannerImage);

        Label lblRestauranteLogo = new Label(compositeRestauranteInfo, SWT.NONE);
        lblRestauranteLogo.setBounds(30, 113, 114, 115);
        lblRestauranteLogo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblRestauranteLogo.setImage(restauranteLogoImage);

        Label lblRestauranteNome = new Label(compositeRestauranteInfo, SWT.NONE);
        lblRestauranteNome.setBounds(175, 113, 260, 38);
        lblRestauranteNome.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblRestauranteNome.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(4, 42, 94))));
        lblRestauranteNome.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 17, SWT.BOLD)));
        lblRestauranteNome.setText(restaurante.getNome());

        Label lblRestauranteDescricao = new Label(compositeRestauranteInfo, SWT.WRAP);
        lblRestauranteDescricao.setBounds(163, 157, 293, 62);
        lblRestauranteDescricao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 9, SWT.BOLD)));
        lblRestauranteDescricao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblRestauranteDescricao.setAlignment(SWT.CENTER);
        lblRestauranteDescricao.setText("Bem-vindo Ã  " + restaurante.getNome());

        Label lblRestauranteEndereco = new Label(compositeRestauranteInfo, SWT.WRAP);
        lblRestauranteEndereco.setBounds(86, 235, 318, 38);
        lblRestauranteEndereco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 9, SWT.BOLD)));
        lblRestauranteEndereco.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
        lblRestauranteEndereco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblRestauranteEndereco.setAlignment(SWT.CENTER);
        lblRestauranteEndereco.setText(enderecoRestaurante);

        Composite compositeRestauranteCardapio = new Composite(compositeHomeCliente, SWT.NONE);
        compositeRestauranteCardapio.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        compositeRestauranteCardapio.setLayout(new GridLayout(1, false));
        GridData gd_compositeRestauranteCardapio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_compositeRestauranteCardapio.widthHint = 470;
        compositeRestauranteCardapio.setLayoutData(gd_compositeRestauranteCardapio);
        System.out.println("a3");
  
        if(pratoLista.size() > 0) {
        	Label lblTituloSessaoCardapio = new Label(compositeRestauranteCardapio, SWT.NONE);
        	lblTituloSessaoCardapio.setAlignment(SWT.CENTER);
        	GridData gd_lblTituloSessaoCardapio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        	gd_lblTituloSessaoCardapio.widthHint = 128;
        	lblTituloSessaoCardapio.setLayoutData(gd_lblTituloSessaoCardapio);
        	lblTituloSessaoCardapio.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
        	lblTituloSessaoCardapio.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        	lblTituloSessaoCardapio.setText("Pratos");
        	
        	ScrolledComposite scrolledCompositePrato = new ScrolledComposite(compositeRestauranteCardapio, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        	GridData gd_scrolledCompositePrato = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        	gd_scrolledCompositePrato.heightHint = 225;
        	gd_scrolledCompositePrato.widthHint = 561;
        	scrolledCompositePrato.setLayoutData(gd_scrolledCompositePrato);
        	scrolledCompositePrato.setExpandHorizontal(true);
        	scrolledCompositePrato.setExpandVertical(true);
        	
        	Composite compositePratos = new Composite(scrolledCompositePrato, SWT.NONE);
        	compositePratos.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        	RowLayout rl_compositePratos = new RowLayout(SWT.HORIZONTAL);
        	rl_compositePratos.marginRight = 20;
        	rl_compositePratos.marginLeft = 20;
        	rl_compositePratos.spacing = 15;
        	compositePratos.setLayout(rl_compositePratos);
        	
    		for(int j = 0; j < pratoLista.size(); j++) {
    			int idPrato = pratoLista.get(j).getIdPrato();
    			
    			Composite compositeItem1 = new Composite(compositePratos, SWT.NONE);
    			compositeItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
    			compositeItem1.setLayout(new GridLayout(1, false));
    			compositeItem1.setLayoutData(new RowData(147, 212));
    			compositeItem1.addMouseListener(new MouseAdapter() {
    				@Override
    				public void mouseDown(MouseEvent e) {
    					System.out.println("id: " + cliente.getId());
    					mainPage.showClienteInfoProduct(0, idPrato, cliente);
    				}
    			});
    			
    			Button buttonImagePizza1 = new Button(compositeItem1, SWT.NONE);
    			GridData gd_buttonImagePizza1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    			buttonImagePizza1.setLayoutData(gd_buttonImagePizza1);
    			buttonImagePizza1.addSelectionListener(new SelectionAdapter() {
    				@Override
    				public void widgetSelected(SelectionEvent e) {
    					mainPage.showClienteInfoProduct(0, idPrato, cliente);
    				}
    			});
    			buttonImagePizza1.addPaintListener( new PaintListener() {
    				@Override
    				public void paintControl( PaintEvent event ) {
    					event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
    					event.gc.fillRectangle( event.x, event.y, event.width, event.height );
    					event.gc.drawImage(pizza1, 6, 0);
    				}
    			} );
    			buttonImagePizza1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
    			gd_buttonImagePizza1.widthHint = 140;
    			gd_buttonImagePizza1.heightHint = 116;
    			buttonImagePizza1.setLayoutData(gd_buttonImagePizza1);
    			
    			Label lblTituloItem1 = new Label(compositeItem1, SWT.WRAP);
    			lblTituloItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
    			lblTituloItem1.setAlignment(SWT.CENTER);
    			GridData gd_lblTituloItem1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    			gd_lblTituloItem1.widthHint = 122;
    			lblTituloItem1.setLayoutData(gd_lblTituloItem1);
    			lblTituloItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
    			lblTituloItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
    			lblTituloItem1.setText(pratoLista.get(j).getNome());
    			lblTituloItem1.addMouseListener(new MouseAdapter() {
    				@Override
    				public void mouseDown(MouseEvent e) {
    					mainPage.showClienteInfoProduct(0, idPrato, cliente);
    				}
    			});
    			
    			Label lblPrecoItem1 = new Label(compositeItem1, SWT.NONE);
    			GridData gd_lblPrecoItem1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    			gd_lblPrecoItem1.heightHint = 23;
    			gd_lblPrecoItem1.widthHint = 117;
    			lblPrecoItem1.setLayoutData(gd_lblPrecoItem1);
    			lblPrecoItem1.setAlignment(SWT.CENTER);
    			lblPrecoItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
    			lblPrecoItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
    			lblPrecoItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
    			lblPrecoItem1.setText("R$" + pratoLista.get(j).getPreco());
    			lblPrecoItem1.addMouseListener(new MouseAdapter() {
    				@Override
    				public void mouseDown(MouseEvent e) {
    					mainPage.showClienteInfoProduct(0, idPrato, cliente);
    				}
    			});
    		}
    		scrolledCompositePrato.setContent(compositePratos);
    		scrolledCompositePrato.setMinSize(compositePratos.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    	}
        
		if(produtoLista.size() > 0) {
			Label lblTituloSessaoCardapio = new Label(compositeRestauranteCardapio, SWT.NONE);
			lblTituloSessaoCardapio.setAlignment(SWT.CENTER);
			GridData gd_lblTituloSessaoCardapio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblTituloSessaoCardapio.widthHint = 128;
			lblTituloSessaoCardapio.setLayoutData(gd_lblTituloSessaoCardapio);
			lblTituloSessaoCardapio.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
			lblTituloSessaoCardapio.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblTituloSessaoCardapio.setText("Produto");
			
			ScrolledComposite scrolledCompositeProdutos = new ScrolledComposite(compositeRestauranteCardapio, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
			GridData gd_scrolledCompositeProdutos = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_scrolledCompositeProdutos.heightHint = 225;
			gd_scrolledCompositeProdutos.widthHint = 461;
			scrolledCompositeProdutos.setLayoutData(gd_scrolledCompositeProdutos);
			scrolledCompositeProdutos.setExpandHorizontal(true);
			scrolledCompositeProdutos.setExpandVertical(true);
			
			Composite compositeProdutos = new Composite(scrolledCompositeProdutos, SWT.NONE);
			compositeProdutos.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			RowLayout rl_compositeProdutos = new RowLayout(SWT.HORIZONTAL);
			rl_compositeProdutos.marginRight = 20;
			rl_compositeProdutos.marginLeft = 20;
			rl_compositeProdutos.spacing = 15;
			compositeProdutos.setLayout(rl_compositeProdutos);
			
			for(int j = 0; j < produtoLista.size(); j++) {
				int idProduto = produtoLista.get(j).getIdProduto();
				
				Composite compositeItem1 = new Composite(compositeProdutos, SWT.NONE);
				compositeItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
				compositeItem1.setLayout(new GridLayout(1, false));
				compositeItem1.setLayoutData(new RowData(147, 212));
				compositeItem1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						mainPage.showClienteInfoProduct(0, idProduto, cliente);
					}
				});
				
				Button buttonImagePizza1 = new Button(compositeItem1, SWT.NONE);
				GridData gd_buttonImagePizza1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				buttonImagePizza1.setLayoutData(gd_buttonImagePizza1);
				buttonImagePizza1.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						mainPage.showClienteInfoProduct(0, idProduto, cliente);
					}
				});
				buttonImagePizza1.addPaintListener( new PaintListener() {
					@Override
					public void paintControl( PaintEvent event ) {
						event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
						event.gc.fillRectangle( event.x, event.y, event.width, event.height );
						event.gc.drawImage(pizza1, 6, 0);
					}
				} );
				buttonImagePizza1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
				gd_buttonImagePizza1.widthHint = 140;
				gd_buttonImagePizza1.heightHint = 116;
				buttonImagePizza1.setLayoutData(gd_buttonImagePizza1);
				
				Label lblTituloItem1 = new Label(compositeItem1, SWT.WRAP);
				lblTituloItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
				lblTituloItem1.setAlignment(SWT.CENTER);
				GridData gd_lblTituloItem1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_lblTituloItem1.widthHint = 122;
				lblTituloItem1.setLayoutData(gd_lblTituloItem1);
				lblTituloItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
				lblTituloItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
				lblTituloItem1.setText(produtoLista.get(j).getNome());
				lblTituloItem1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						mainPage.showClienteInfoProduct(0, idProduto, cliente);
					}
				});
				
				Label lblPrecoItem1 = new Label(compositeItem1, SWT.NONE);
				GridData gd_lblPrecoItem1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_lblPrecoItem1.heightHint = 23;
				gd_lblPrecoItem1.widthHint = 117;
				lblPrecoItem1.setLayoutData(gd_lblPrecoItem1);
				lblPrecoItem1.setAlignment(SWT.CENTER);
				lblPrecoItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
				lblPrecoItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
				lblPrecoItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
				lblPrecoItem1.setText("R$" + produtoLista.get(j).getPreco());
				lblPrecoItem1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						mainPage.showClienteInfoProduct(0, idProduto, cliente);
					}
				});
			}
			scrolledCompositeProdutos.setContent(compositeProdutos);
			scrolledCompositeProdutos.setMinSize(compositeProdutos.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		}
        
        scrolledComposite.setContent(compositeHomeCliente);
        scrolledComposite.setMinSize(compositeRestauranteCardapio.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    }
}