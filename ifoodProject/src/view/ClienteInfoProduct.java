package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import database.CarrinhoBanco;
import database.DBConnection;
import database.PratoBanco;
import database.ProdutoBanco;
import model.Carrinho;
import model.Cliente;
import model.Prato;
import model.Produto;
import model.Usuario;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;

import javax.management.loading.PrivateClassLoader;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;

public class ClienteInfoProduct extends Composite {

	private Composite compositeBtnAddCarinho;
	private Label lblAddProductBag;
	private Label lblAdicionarAoCarrinho;
	private Label lblItemTitulo;
	private Label lblItemPreco;
	private Label lblItemDescricao;
	private Label lblIngredientes;
	private Image backArrowImage;
	private Image addProductBagImage;
	private Image productBannerImage;
	private Cliente cliente;
	private Produto produto = null;
	private Prato prato = null;
	private PratoBanco bancoPrato;
	private ProdutoBanco bancoProduto;
	private Carrinho carrinho;
	private CarrinhoBanco bancoCarrinho;
	private DBConnection connection = new DBConnection("localhost", "3307", "bddelivery", "root", "2024Root.");
	
	private LocalResourceManager localResourceManager;
	
	private Display display = getDisplay();

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}
    
    private void getProdutoPrato(Integer idProduto, Integer idPrato) {
    	if(idPrato != 0) {
			bancoPrato = new PratoBanco(connection);
			prato = bancoPrato.visualizarPrato(idPrato);
			
		}else if(idProduto != 0) {
			bancoProduto = new ProdutoBanco(connection);
			produto = bancoProduto.visualizarProduto(idProduto);
		}
    }
    
    private void setLabels(Prato prato, Produto produto, MainPage mainPage) {
    	if(prato != null) {
    		lblItemTitulo.setText(prato.getNome());
    		lblItemDescricao.setText(prato.getDescricao());
    		lblItemPreco.setText("R$" + prato.getPreco());
    		lblIngredientes.setText(prato.getIngredientes());
    		compositeBtnAddCarinho.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseDown(MouseEvent e) {
                	carrinho = new Carrinho(cliente.getId(),prato.getIdRestaurante(), prato.getIdPrato(),0,prato.getPreco(),cliente.getEndereco(),1);
                    mainPage.showClienteCarrinho();
                }
            });
    	}else if(produto != null) {
    		lblItemTitulo.setText(produto.getNome());
    		lblItemDescricao.setText(produto.getDescricao());
    		lblItemPreco.setText("R$" + produto.getPreco());
    		compositeBtnAddCarinho.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseDown(MouseEvent e) {
                	carrinho = new Carrinho(cliente.getId(),produto.getIdRestaurante(), 0,produto.getIdProduto(),produto.getPreco(),cliente.getEndereco(),1);
                    mainPage.showClienteCarrinho();
                }
            });
    	}
    }

	public ClienteInfoProduct(Composite parent, MainPage mainPage, Integer idProduto, Integer idPrato, Cliente cliente) {
		super(parent, SWT.NONE);
		createResourceManager();
		setLayout(new FormLayout());
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));		
		
		getProdutoPrato(idProduto, idPrato);
		bancoCarrinho = new CarrinhoBanco(connection);
		this.cliente = cliente;
		
		productBannerImage = new Image(display, "./src/assets/images/productBanner.png");
		backArrowImage = new Image(display, "./src/assets/images/backArrow.png");
		addProductBagImage = new Image(display, "./src/assets/images/addProductBag.png");

		Composite compositeItemBanner = new Composite(this, SWT.NONE);
        FormData fd_compositeItemBanner = new FormData();
        fd_compositeItemBanner.left = new FormAttachment(0);
        fd_compositeItemBanner.top = new FormAttachment(0);
        fd_compositeItemBanner.bottom = new FormAttachment(0, 293);
        compositeItemBanner.setLayoutData(fd_compositeItemBanner);
        compositeItemBanner.setBackgroundImage(productBannerImage);

        Canvas btnBack = new Canvas(compositeItemBanner, SWT.NONE);
        btnBack.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TRANSPARENT));
        btnBack.setBounds(27, 26, 82, 64);

        Composite compositeItemInfo = new Composite(this, SWT.NONE);
        fd_compositeItemBanner.right = new FormAttachment(compositeItemInfo, 0, SWT.RIGHT);
        compositeItemInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        compositeItemInfo.setLayout(new GridLayout(1, false));
        FormData fd_compositeItemInfo = new FormData();
        fd_compositeItemInfo.bottom = new FormAttachment(100, -10);
        fd_compositeItemInfo.top = new FormAttachment(compositeItemBanner, 6);
        fd_compositeItemInfo.right = new FormAttachment(0, 464);
        fd_compositeItemInfo.left = new FormAttachment(0);
        compositeItemInfo.setLayoutData(fd_compositeItemInfo);
        new Label(compositeItemInfo, SWT.NONE);

        lblItemTitulo = new Label(compositeItemInfo, SWT.NONE);
        lblItemTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblItemTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
        lblItemTitulo.setAlignment(SWT.CENTER);
        lblItemTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 15, SWT.NORMAL)));
        GridData gd_lblItemTitulo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblItemTitulo.widthHint = 459;
        lblItemTitulo.setLayoutData(gd_lblItemTitulo);

        lblItemPreco = new Label(compositeItemInfo, SWT.NONE);
        lblItemPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblItemPreco.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
        lblItemPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.NORMAL)));
        lblItemPreco.setAlignment(SWT.CENTER);
        GridData gd_lblItemPreco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblItemPreco.heightHint = 42;
        gd_lblItemPreco.widthHint = 455;
        lblItemPreco.setLayoutData(gd_lblItemPreco);

        lblItemDescricao = new Label(compositeItemInfo, SWT.WRAP | SWT.CENTER);
        lblItemDescricao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
        lblItemDescricao.setAlignment(SWT.CENTER);
        GridData gd_lblItemDescricao = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        gd_lblItemDescricao.heightHint = 119;
        gd_lblItemDescricao.widthHint = 355;
        lblItemDescricao.setLayoutData(gd_lblItemDescricao);
        lblItemDescricao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        
        if(idPrato != 0) {
        	lblIngredientes = new Label(compositeItemInfo, SWT.WRAP | SWT.CENTER);
            lblIngredientes.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
            lblIngredientes.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            lblIngredientes.setAlignment(SWT.CENTER);
            GridData gd_lblIngredientes = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
            gd_lblIngredientes.heightHint = 122;
            gd_lblIngredientes.widthHint = 404;
            lblIngredientes.setLayoutData(gd_lblIngredientes);
        }

        compositeBtnAddCarinho = new Composite(compositeItemInfo, SWT.NONE);
        compositeBtnAddCarinho.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        compositeBtnAddCarinho.setLayout(new GridLayout(2, false));
        GridData gd_compositeBtnAddCarinho = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        gd_compositeBtnAddCarinho.heightHint = 60;
        gd_compositeBtnAddCarinho.widthHint = 272;
        compositeBtnAddCarinho.setLayoutData(gd_compositeBtnAddCarinho);
        compositeBtnAddCarinho.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                GC gc = e.gc;
                gc.setAntialias(SWT.ON);
                Rectangle bounds = compositeBtnAddCarinho.getClientArea();
                int arcWidth = 20;
                int arcHeight = 20;
                gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
                gc.fillRoundRectangle(0, 0, bounds.width, bounds.height, arcWidth, arcHeight);
                gc.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
                gc.drawRoundRectangle(0, 0, bounds.width - 1, bounds.height - 1, arcWidth, arcHeight);
            }
        });
                
        lblAddProductBag = new Label(compositeBtnAddCarinho, SWT.NONE);
        lblAddProductBag.setAlignment(SWT.CENTER);
        lblAddProductBag.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
        GridData gd_lblAddProductBag = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblAddProductBag.widthHint = 54;
        gd_lblAddProductBag.heightHint = 49;
        lblAddProductBag.setLayoutData(gd_lblAddProductBag);
        lblAddProductBag.setImage(addProductBagImage);
        lblAddProductBag.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
            	
            	mainPage.showClienteCarrinho();
            }
        });
                        
	    lblAdicionarAoCarrinho = new Label(compositeBtnAddCarinho, SWT.NONE);
	    lblAdicionarAoCarrinho.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
	    lblAdicionarAoCarrinho.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
	    lblAdicionarAoCarrinho.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
	    GridData gd_lblAdicionarAoCarrinho = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	    gd_lblAdicionarAoCarrinho.widthHint = 189;
	    lblAdicionarAoCarrinho.setLayoutData(gd_lblAdicionarAoCarrinho);
	    lblAdicionarAoCarrinho.setText("Adicionar ao carrinho");
	    lblAdicionarAoCarrinho.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseDown(MouseEvent e) {
            	/*Colocar aqui a função que irá add o item ao carrinho*/
	        	mainPage.showClienteCarrinho();
	        }
	    });

        btnBack.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.drawImage(backArrowImage, 0, 0);
            }
        });
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
            	mainPage.navigateToScreenCliente(1);
            }
        });
        
        setLabels(prato, produto, mainPage);
	}
}
