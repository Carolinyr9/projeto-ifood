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

/*Essa classe está utilizando o Composite como pai, para herdar seu tipo e para que no final ele fique que nem um 
 * componente e apenas seja adicionado na página principal*/
public class InfoProduct extends Composite {

	private Image productBannerImage;
	private Image backArrowImage;
	private Image addProductBagImage;
	
	//Variável para poder utilizar tamanho de letras e cores diferentes
	private LocalResourceManager localResourceManager;
	
	//Variável para poder utilizar imagens
	private Display display = getDisplay();

	//Esse método tem que ser chamado na função principal para que se possa usar letras maiores e de cor diferente usando RGB
    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}

	public InfoProduct(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setLayout(new FormLayout());
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));		

		productBannerImage = new Image(display, "./src/assets/images/productBanner.png");
		backArrowImage = new Image(display, "./src/assets/images/backArrow.png");
		addProductBagImage = new Image(display, "./src/assets/images/addProductBag.png");

		Composite compositeProductBanner = new Composite(this, SWT.NONE);
        FormData fd_compositeProductBanner = new FormData();
        fd_compositeProductBanner.left = new FormAttachment(0);
        fd_compositeProductBanner.top = new FormAttachment(0);
        fd_compositeProductBanner.bottom = new FormAttachment(0, 293);
        compositeProductBanner.setLayoutData(fd_compositeProductBanner);
        compositeProductBanner.setBackgroundImage(productBannerImage);

        Canvas btnBack = new Canvas(compositeProductBanner, SWT.NONE);
        btnBack.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TRANSPARENT));
        btnBack.setBounds(27, 26, 82, 64);

        Composite compositeProductInfo = new Composite(this, SWT.NONE);
        fd_compositeProductBanner.right = new FormAttachment(compositeProductInfo, 0, SWT.RIGHT);
        compositeProductInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        compositeProductInfo.setLayout(new GridLayout(1, false));
        FormData fd_compositeProductInfo = new FormData();
        fd_compositeProductInfo.bottom = new FormAttachment(100, -10);
        fd_compositeProductInfo.top = new FormAttachment(compositeProductBanner, 6);
        fd_compositeProductInfo.right = new FormAttachment(0, 464);
        fd_compositeProductInfo.left = new FormAttachment(0);
        compositeProductInfo.setLayoutData(fd_compositeProductInfo);
        new Label(compositeProductInfo, SWT.NONE);

        Label lblPizzaDeFrango = new Label(compositeProductInfo, SWT.NONE);
        lblPizzaDeFrango.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblPizzaDeFrango.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
        lblPizzaDeFrango.setAlignment(SWT.CENTER);
        lblPizzaDeFrango.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 15, SWT.NORMAL)));
        GridData gd_lblPizzaDeFrango = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblPizzaDeFrango.widthHint = 459;
        lblPizzaDeFrango.setLayoutData(gd_lblPizzaDeFrango);
        lblPizzaDeFrango.setText("Pizza Meia Margherita Meio Frango");

        Label lblPizzaPreco = new Label(compositeProductInfo, SWT.NONE);
        lblPizzaPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblPizzaPreco.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
        lblPizzaPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.NORMAL)));
        lblPizzaPreco.setAlignment(SWT.CENTER);
        GridData gd_lblPizzaPreco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblPizzaPreco.heightHint = 42;
        gd_lblPizzaPreco.widthHint = 455;
        lblPizzaPreco.setLayoutData(gd_lblPizzaPreco);
        lblPizzaPreco.setText("R$54,99");

        Label lblPizzaDescricao = new Label(compositeProductInfo, SWT.WRAP | SWT.CENTER);
        lblPizzaDescricao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
        lblPizzaDescricao.setAlignment(SWT.CENTER);
        GridData gd_lblPizzaDescricao = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        gd_lblPizzaDescricao.heightHint = 119;
        gd_lblPizzaDescricao.widthHint = 355;
        lblPizzaDescricao.setLayoutData(gd_lblPizzaDescricao);
        lblPizzaDescricao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblPizzaDescricao.setText("A \"Pizza Meia Margherita Meio Frango com Azeitonas Pretas e Tomate\" da Boa Pizza combina o clássico sabor da Margherita com a ousadia do frango.");

        Composite compositeBtnAddCarinho = new Composite(compositeProductInfo, SWT.NONE);
        compositeBtnAddCarinho.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        compositeBtnAddCarinho.setLayout(new GridLayout(2, false));
        GridData gd_compositeBtnAddCarinho = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        gd_compositeBtnAddCarinho.heightHint = 60;
        gd_compositeBtnAddCarinho.widthHint = 272;
        compositeBtnAddCarinho.setLayoutData(gd_compositeBtnAddCarinho);
        compositeBtnAddCarinho.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                System.out.println("Composite clicado");
            }
        });

        /* Função para deixar as bordas redondas */
        compositeBtnAddCarinho.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                GC gc = e.gc;
                gc.setAntialias(SWT.ON);
                Rectangle bounds = compositeBtnAddCarinho.getClientArea();
                /* Aqui eu coloco quanto eu quero deixar redondo */
                int arcWidth = 40;
                int arcHeight = 40;
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
                System.out.println("Composite clicado");
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
                System.out.println("Composite clicado");
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
                System.out.println("Botão 'Voltar' clicado");
            }
        });
	}
}
