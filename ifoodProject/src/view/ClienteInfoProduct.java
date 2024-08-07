package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;

public class ClienteInfoProduct extends Composite {

	private Image backArrowImage;
	private Image addProductBagImage;
	private Image productBannerImage;
	
	/*Variáveis de teste,*/
	private String nomeProduto;
	private Integer idRestaurante;
	private Double preco;
	private String descricao;
	private Integer idProduto;
	private String nomeRestaurante;
	private String enderecoRestaurante;
	
	/*Variável que vai ser usada em uma estrutura condicional para ser mostrado o campo de ingredientes*/
	private String tipoItem;
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	
	public Integer getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(Integer idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
	}

	public String getEnderecoRestaurante() {
		return enderecoRestaurante;
	}

	public void setEnderecoRestaurante(String enderecoRestaurante) {
		this.enderecoRestaurante = enderecoRestaurante;
	}

	private LocalResourceManager localResourceManager;
	
	private Display display = getDisplay();

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}

	public ClienteInfoProduct(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setLayout(new FormLayout());
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));		

		/*Grupo de teste, excluir depois*/
		setNomeProduto("Pizza Meia Margherita Meio Frango");
		setPreco(65.66);
		setDescricao("A \"Pizza Meia Margherita Meio Frango com Azeitonas Pretas e Tomate\" da Boa Pizza combina o clássico sabor da Margherita com a ousadia do frango.");
		setIdProduto(1);
		setNomeRestaurante("Pizzaria Manoel");
		setEnderecoRestaurante("Rua das flores, 79");
		tipoItem = "prato";
		
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

        Label lblItemTitulo = new Label(compositeItemInfo, SWT.NONE);
        lblItemTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblItemTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
        lblItemTitulo.setAlignment(SWT.CENTER);
        lblItemTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 15, SWT.NORMAL)));
        GridData gd_lblItemTitulo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblItemTitulo.widthHint = 459;
        lblItemTitulo.setLayoutData(gd_lblItemTitulo);
        /*Colocar aqui o nome do item, dentro de setText()*/
        lblItemTitulo.setText(getNomeProduto());

        Label lblItemPreco = new Label(compositeItemInfo, SWT.NONE);
        lblItemPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblItemPreco.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
        lblItemPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.NORMAL)));
        lblItemPreco.setAlignment(SWT.CENTER);
        GridData gd_lblItemPreco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblItemPreco.heightHint = 42;
        gd_lblItemPreco.widthHint = 455;
        lblItemPreco.setLayoutData(gd_lblItemPreco);
        /*Colocar aqui o preço do item, dentro de setText()*/
        lblItemPreco.setText("R$" + getPreco().toString());

        Label lblItemDescricao = new Label(compositeItemInfo, SWT.WRAP | SWT.CENTER);
        lblItemDescricao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
        lblItemDescricao.setAlignment(SWT.CENTER);
        GridData gd_lblItemDescricao = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        gd_lblItemDescricao.heightHint = 119;
        gd_lblItemDescricao.widthHint = 355;
        lblItemDescricao.setLayoutData(gd_lblItemDescricao);
        lblItemDescricao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        /*Colocar aqui a descrição do item, dentro de setText()*/
        lblItemDescricao.setText(getDescricao());
        
        /* Aqui a variável tipoItem vai decidir se o campo abaixo (onde são mostrados os ingredientes) será mostrado ou não, a partir do que tipo é o item*/
        if(tipoItem == "prato") {
        	Label lblIngredientes = new Label(compositeItemInfo, SWT.WRAP | SWT.CENTER);
            lblIngredientes.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
            lblIngredientes.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            lblIngredientes.setAlignment(SWT.CENTER);
            GridData gd_lblIngredientes = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
            gd_lblIngredientes.heightHint = 122;
            gd_lblIngredientes.widthHint = 404;
            lblIngredientes.setLayoutData(gd_lblIngredientes);
            /*Colocar aqui os ingredientes do item, dentro de setText()*/
            lblIngredientes.setText("Ingredientes: ");
        }

        Composite compositeBtnAddCarinho = new Composite(compositeItemInfo, SWT.NONE);
        compositeBtnAddCarinho.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        compositeBtnAddCarinho.setLayout(new GridLayout(2, false));
        GridData gd_compositeBtnAddCarinho = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        gd_compositeBtnAddCarinho.heightHint = 60;
        gd_compositeBtnAddCarinho.widthHint = 272;
        compositeBtnAddCarinho.setLayoutData(gd_compositeBtnAddCarinho);
        compositeBtnAddCarinho.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
            	/*Colocar aqui a função que irá add o item ao carrinho*/
                mainPage.showClienteCarrinho();
            }
        });
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
                
        Label lblAddProductBag = new Label(compositeBtnAddCarinho, SWT.NONE);
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
            	/*Colocar aqui a função que irá add o item ao carrinho*/
            	mainPage.showClienteCarrinho();
            }
        });
                        
	    Label lblAdicionarAoCarrinho = new Label(compositeBtnAddCarinho, SWT.NONE);
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
	}
}
