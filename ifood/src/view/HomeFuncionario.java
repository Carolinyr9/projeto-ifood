package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
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

public class HomeFuncionario extends Composite {


	private Image addProductBagImage;
	private LocalResourceManager localResourceManager;
	private Display display = getDisplay();

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}

	public HomeFuncionario(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setSize(468, 774);
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));		


		addProductBagImage = new Image(display, "./src/assets/images/addProductBag.png");
        setLayout(new GridLayout(1, false));
        FormData fd_compositeProductInfo = new FormData();
        fd_compositeProductInfo.top = new FormAttachment(0, 299);
        fd_compositeProductInfo.bottom = new FormAttachment(100, -1);
        fd_compositeProductInfo.right = new FormAttachment(0, 464);
        fd_compositeProductInfo.left = new FormAttachment(0);
        GridData gd_lblPizzaDeFrango = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblPizzaDeFrango.widthHint = 459;
        GridData gd_lblPizzaPreco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblPizzaPreco.heightHint = 42;
        gd_lblPizzaPreco.widthHint = 455;
        GridData gd_lblPizzaDescricao = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        gd_lblPizzaDescricao.heightHint = 119;
        gd_lblPizzaDescricao.widthHint = 355;
        GridData gd_compositeBtnAddCarinho = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        gd_compositeBtnAddCarinho.heightHint = 60;
        gd_compositeBtnAddCarinho.widthHint = 272;
        GridData gd_lblAddProductBag = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblAddProductBag.widthHint = 54;
        gd_lblAddProductBag.heightHint = 49;
        GridData gd_lblAdicionarAoCarrinho = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblAdicionarAoCarrinho.widthHint = 189;
        new Label(this, SWT.NONE);
        
        Composite compositeHeader = new Composite(this, SWT.NONE);
        FormData fd_compositeHeader = new FormData();
        fd_compositeHeader.top = new FormAttachment(0);
        fd_compositeHeader.left = new FormAttachment(0);
        fd_compositeHeader.bottom = new FormAttachment(0, 65);
        
        Label lblCardpios = new Label(compositeHeader, SWT.NONE);
        lblCardpios.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 15, SWT.NORMAL)));
        lblCardpios.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
        lblCardpios.setBounds(48, 20, 112, 35);
        lblCardpios.setText("Cardápios");
        
        Composite composite_1 = new Composite(this, SWT.NONE);
        FormData fd_composite_1 = new FormData();
        fd_composite_1.top = new FormAttachment(compositeHeader, 46);
        fd_composite_1.bottom = new FormAttachment(0, 205);
        fd_composite_1.right = new FormAttachment(compositeHeader, 0, SWT.RIGHT);
        new Label(this, SWT.NONE);
        
        Composite compositeProductInfo = new Composite(this, SWT.NONE);
        compositeProductInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        compositeProductInfo.setLayout(new GridLayout(1, false));
        new Label(compositeProductInfo, SWT.NONE);
        
		Label lblPizzaDeFrango = new Label(compositeProductInfo, SWT.NONE);
		lblPizzaDeFrango.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPizzaDeFrango.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblPizzaDeFrango.setAlignment(SWT.CENTER);
		lblPizzaDeFrango.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 15, SWT.NORMAL)));
		lblPizzaDeFrango.setText("Pizza Meia Margherita Meio Frango");
		
		Label lblPizzaPreco = new Label(compositeProductInfo, SWT.NONE);
		lblPizzaPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPizzaPreco.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblPizzaPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.NORMAL)));
		lblPizzaPreco.setAlignment(SWT.CENTER);
		lblPizzaPreco.setText("R$54,99");
		
		Label lblPizzaDescricao = new Label(compositeProductInfo, SWT.WRAP | SWT.CENTER);
		lblPizzaDescricao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblPizzaDescricao.setAlignment(SWT.CENTER);
		lblPizzaDescricao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPizzaDescricao.setText("A \"Pizza Meia Margherita Meio Frango com Azeitonas Pretas e Tomate\" da Boa Pizza combina o clássico sabor da Margherita com a ousadia do frango.");
		
		Composite compositeBtnAddCarinho = new Composite(compositeProductInfo, SWT.NONE);
		compositeBtnAddCarinho.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeBtnAddCarinho.setLayout(new GridLayout(2, false));
		compositeBtnAddCarinho.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseDown(MouseEvent e) {
		        System.out.println("Composite clicado");
		    }
		});
		
        compositeBtnAddCarinho.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                GC gc = e.gc;
                gc.setAntialias(SWT.ON);
                Rectangle bounds = compositeBtnAddCarinho.getClientArea();
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
		lblAdicionarAoCarrinho.setText("Adicionar ao carrinho");
		fd_compositeHeader.right = new FormAttachment(compositeProductInfo, 4, SWT.RIGHT);
		
		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite.heightHint = 213;
		gd_composite.widthHint = 453;
		composite.setLayoutData(gd_composite);
		lblAdicionarAoCarrinho.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseDown(MouseEvent e) {
		        System.out.println("Composite clicado");
		    }
		});
        fd_composite_1.left = new FormAttachment(0);
	}
}
