package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import database.CardapioBanco;
import database.DBConnection;
import model.Cardapio;
import model.ItemCardapio;
import model.Prato;
import model.Produto;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.ScrolledComposite;

public class FuncionarioCardapioInfo extends Composite {

	private LocalResourceManager localResourceManager;
	private Image arrowIcon;
	private Label lblItemTitulo;
	private Label lblPrecoItem1;
	private Display display = getDisplay();
	private CardapioBanco cardapioBanco;
	private String nomeSessao;
	private List<String> nomePratosCardapio;
	private List<String> nomeProdutosCardapio;
	private List<Double> precoPratosCardapio;
	private List<Double> precoProdutosCardapio;

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}
	
	private void setLabels(int i) {
		
		if(nomeSessao == "Pratos") {
			lblItemTitulo.setText(nomePratosCardapio.get(i));
			lblPrecoItem1.setText("R$" + precoPratosCardapio.get(i).toString());
		}else if(nomeSessao == "Produtos"){
			lblItemTitulo.setText(nomeProdutosCardapio.get(i));
			lblPrecoItem1.setText("R$" + precoProdutosCardapio.get(i).toString());
		}
	}

	public FuncionarioCardapioInfo(Composite parent, MainPage mainPage, String nomeSessaoCardapio) {
		super(parent, SWT.NONE);
        Shell shell = new Shell(display);
		createResourceManager();		
		setSize(468, 714);
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setLayout(new FormLayout());
		
		nomeSessao = nomeSessaoCardapio;
		DBConnection dbConnection = new DBConnection();
		Cardapio cardapio = new Cardapio();
		cardapioBanco = new CardapioBanco(dbConnection);
		cardapioBanco.criarCardapio(cardapio);
		int id = 1;
		List<ItemCardapio> itens = cardapioBanco.listarCardapioPorRestaurante(id);
		List<Integer> idProdutosCardapio = new ArrayList<Integer>();
		List<Integer> idPratosCardapio = new ArrayList<Integer>();
		List<String> tipoItensCardapio = new ArrayList<String>();
		nomePratosCardapio = new ArrayList<String>();
		nomeProdutosCardapio = new ArrayList<String>();
		precoPratosCardapio = new ArrayList<Double>();
		precoProdutosCardapio = new ArrayList<Double>();
	
		for (ItemCardapio item: itens) {
			if (item instanceof Prato) {
				idPratosCardapio.add(item.getIdPrato());
				tipoItensCardapio.add("Prato");
				nomePratosCardapio.add(item.getNome());
				precoPratosCardapio.add(item.getPreco());
			} else 
				if(item instanceof Produto) {
					idProdutosCardapio.add(item.getIdProduto());
					tipoItensCardapio.add("Produto");
					nomeProdutosCardapio.add(item.getNome());
					precoProdutosCardapio.add(item.getPreco());
				}
		}
		
		arrowIcon = new Image(display, "./src/assets/images/backArrow.png");
		
		Composite compositeHeader = new Composite(this, SWT.NONE);
		compositeHeader.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		FormData fd_compositeHeader = new FormData();
		fd_compositeHeader.top = new FormAttachment(0);
		fd_compositeHeader.left = new FormAttachment(0);
		fd_compositeHeader.bottom = new FormAttachment(0, 73);
		fd_compositeHeader.right = new FormAttachment(0, 468);
		compositeHeader.setLayoutData(fd_compositeHeader);
		
		Label lblTelaCardapioTitulo = new Label(compositeHeader, SWT.CENTER);
		lblTelaCardapioTitulo.setAlignment(SWT.LEFT);
		lblTelaCardapioTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblTelaCardapioTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		lblTelaCardapioTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
		lblTelaCardapioTitulo.setBounds(85, 12, 336, 51);
		lblTelaCardapioTitulo.setText(nomeSessao);
		
		Button btnAdicionarItem = new Button(this, SWT.NONE);
		btnAdicionarItem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnAdicionarItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(nomeSessao == "Pratos") {
					mainPage.showFuncionarioCadPratoCardapio();
				}else if(nomeSessao == "Produtos"){
					mainPage.showFuncionarioCadProdutoCardapio();
				}
				
			}
		});
		btnAdicionarItem.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		FormData fd_btnAdicionarItem = new FormData();
		fd_btnAdicionarItem.bottom = new FormAttachment(compositeHeader, 80, SWT.BOTTOM);
		fd_btnAdicionarItem.top = new FormAttachment(compositeHeader, 44);
		
		Button btnBack = new Button(compositeHeader, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.showHomeFuncionario();
			}
		});
		btnBack.setBounds(20, 10, 60, 53);
		btnBack.addPaintListener( new PaintListener() {
		  @Override
		  public void paintControl( PaintEvent event ) {
		    event.gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
		    event.gc.drawImage(arrowIcon, 0, 0);
		  }
		} );
		
		fd_btnAdicionarItem.left = new FormAttachment(0, 48);
		fd_btnAdicionarItem.right = new FormAttachment(0, 241);
		btnAdicionarItem.setLayoutData(fd_btnAdicionarItem);
		btnAdicionarItem.setText("Adicionar Item");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.top = new FormAttachment(btnAdicionarItem, 17);
		fd_scrolledComposite.left = new FormAttachment(0, 48);
		scrolledComposite.setExpandVertical(true);
		fd_scrolledComposite.bottom = new FormAttachment(100, -10);
		fd_scrolledComposite.right = new FormAttachment(0, 420);
		scrolledComposite.setLayoutData(fd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		
		Composite compositeItensCardapio = new Composite(scrolledComposite, SWT.NONE);
		compositeItensCardapio.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeItensCardapio.setLayout(new GridLayout(1, false));
		
		btnAdicionarItem.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnAdicionarItem.getBounds();
				Color blue = new Color(getDisplay(), new RGB(19, 41, 61));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Adicionar Item";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);

				blue.dispose();
				white.dispose();
			}
		});
		
		int numSize = 0;
		if(nomeSessaoCardapio == "Pratos") {
			numSize = nomePratosCardapio.size();
		}else {
			numSize = nomeProdutosCardapio.size();
		}
		
		for(int i = 0; i < numSize; i++) {
			int num = i;
			Composite compositeItem1 = new Composite(compositeItensCardapio, SWT.NONE);
			GridLayout gl_compositeItem1 = new GridLayout(7, false);
			gl_compositeItem1.horizontalSpacing = 10;
			gl_compositeItem1.marginTop = 10;
			gl_compositeItem1.marginLeft = 20;
			compositeItem1.setLayout(gl_compositeItem1);
			GridData gd_compositeItem1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_compositeItem1.widthHint = 357;
			gd_compositeItem1.heightHint = 70;
			compositeItem1.setLayoutData(gd_compositeItem1);
			compositeItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			compositeItem1.addPaintListener(new PaintListener() {
				@Override
				public void paintControl(PaintEvent e) {
					GC gc = e.gc;
					gc.setAntialias(SWT.ON);
					gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
					gc.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
					int width = getClientArea().width;
					gc.drawLine(0, 0, width, 0);
				}
			});
			compositeItem1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					
					if(nomeSessao == "Pratos") {
						mainPage.showFuncionarioItemCardapioInfo(idPratosCardapio.get(num), "Prato", nomeSessao);
					}else if(nomeSessao == "Produtos"){
						mainPage.showFuncionarioItemCardapioInfo(idProdutosCardapio.get(num), "Produto", nomeSessao);
					}
				}
			});
			
			lblItemTitulo = new Label(compositeItem1, SWT.WRAP);
			GridData gd_lblItemTitulo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblItemTitulo.heightHint = 60;
			gd_lblItemTitulo.widthHint = 205;
			lblItemTitulo.setLayoutData(gd_lblItemTitulo);
			lblItemTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 0, 0))));
			lblItemTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblItemTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
			lblItemTitulo.setBounds(25, 23, 187, 28);
			lblItemTitulo.setText("A");
			lblItemTitulo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					
					if(nomeSessao == "Pratos") {
						mainPage.showFuncionarioItemCardapioInfo(idPratosCardapio.get(num), "Prato", nomeSessao);
					}else if(nomeSessao == "Produtos"){
						mainPage.showFuncionarioItemCardapioInfo(idProdutosCardapio.get(num), "Produto", nomeSessao);
					}
				}
			});
			new Label(compositeItem1, SWT.NONE);
			
			lblPrecoItem1 = new Label(compositeItem1, SWT.NONE);
			lblPrecoItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			lblPrecoItem1.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED));
			lblPrecoItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblPrecoItem1.setBounds(252, 26, 74, 28);
			lblPrecoItem1.setText("R$");
			new Label(compositeItem1, SWT.NONE);
			new Label(compositeItem1, SWT.NONE);
			new Label(compositeItem1, SWT.NONE);
			new Label(compositeItem1, SWT.NONE);
			new Label(compositeItensCardapio, SWT.NONE);
			
			setLabels(i);
		}
		
		scrolledComposite.setContent(compositeItensCardapio);
		scrolledComposite.setMinSize(compositeItensCardapio.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
}