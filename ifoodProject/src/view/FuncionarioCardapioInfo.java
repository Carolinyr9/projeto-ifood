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
	private Display display = getDisplay();
	private String nomeCardapio;
	private CardapioBanco cardapioBanco;

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}

	public FuncionarioCardapioInfo(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
        Shell shell = new Shell(display);
		createResourceManager();		
		setSize(468, 714);
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setLayout(new FormLayout());
		
		/*Grupo de teste - Depois apagar */
		DBConnection dbConnection = new DBConnection();
		Cardapio cardapio = new Cardapio();
		cardapioBanco = new CardapioBanco(dbConnection);
		cardapioBanco.criarCardapio(cardapio);
		int id = 1;
		List<ItemCardapio> itens = cardapioBanco.listarCardapioPorRestaurante(id);
		List<String> nomeItensCardapio = new ArrayList<String>();
		List<Double> precoItensCardapio = new ArrayList<Double>();
		List<Integer> idItensCardapio = new ArrayList<Integer>();
		List<String> tipoItensCardapio = new ArrayList<String>();
	
		for (ItemCardapio item: itens) {
			if (item instanceof Prato) {
				idItensCardapio.add(item.getIdPrato());
				tipoItensCardapio.add("Prato");
			} else 
				if(item instanceof Produto) {
					idItensCardapio.add(item.getIdProduto());
					tipoItensCardapio.add("Produto");
				}
			nomeItensCardapio.add(item.getNome());
			precoItensCardapio.add(item.getPreco());
		}
		
		arrowIcon = new Image(display, "./src/assets/images/backArrow.png");
		nomeCardapio = "Pizzas";
		
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
		lblTelaCardapioTitulo.setText(nomeCardapio);
		
		Button btnAdicionarItem = new Button(this, SWT.NONE);
		btnAdicionarItem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnAdicionarItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openRadioDialog(shell,mainPage);
				
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
				mainPage.navigateToScreenFuncionario(1);
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
		scrolledComposite.setContent(compositeItensCardapio);
		scrolledComposite.setMinSize(compositeItensCardapio.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		
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
		
		
		for(int i = 0; i < itens.size(); i++) {
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
					mainPage.showFuncionarioItemCardapioInfo(idItensCardapio.get(num), tipoItensCardapio.get(num));
				}
			});
			
			Label lblItemTitulo = new Label(compositeItem1, SWT.WRAP);
			GridData gd_lblItemTitulo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblItemTitulo.heightHint = 60;
			gd_lblItemTitulo.widthHint = 205;
			lblItemTitulo.setLayoutData(gd_lblItemTitulo);
			lblItemTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 0, 0))));
			lblItemTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblItemTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
			lblItemTitulo.setBounds(25, 23, 187, 28);
			lblItemTitulo.setText(nomeItensCardapio.get(i));
			lblItemTitulo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					mainPage.showFuncionarioItemCardapioInfo(idItensCardapio.get(num), tipoItensCardapio.get(num));
				}
			});
			new Label(compositeItem1, SWT.NONE);
			
			Label lblPrecoItem1 = new Label(compositeItem1, SWT.NONE);
			lblPrecoItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			lblPrecoItem1.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED));
			lblPrecoItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblPrecoItem1.setBounds(252, 26, 74, 28);
			lblPrecoItem1.setText("R$" + precoItensCardapio.get(i).toString());
			new Label(compositeItem1, SWT.NONE);
			new Label(compositeItem1, SWT.NONE);
			new Label(compositeItem1, SWT.NONE);
			new Label(compositeItem1, SWT.NONE);
			new Label(compositeItensCardapio, SWT.NONE);
		}
	}
		
	
	
	private static void openRadioDialog(Shell parent,MainPage mainPage) {
        Shell dialog = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        dialog.setText("Escolha uma opção");
        GridLayout gl_dialog = new GridLayout(1, false);
        gl_dialog.verticalSpacing = 10;
        gl_dialog.marginTop = 20;
        gl_dialog.marginLeft = 30;
        dialog.setLayout(gl_dialog);
        
        Label lblTipo = new Label(dialog, SWT.CENTER);
        lblTipo.setText("Que tipo de item deseja adicionar?");

        // Adiciona opções de rádio buttons
        Button optionPrato = new Button(dialog, SWT.RADIO);
        optionPrato.setText("Prato");
        optionPrato.setSelection(true); // Seleciona a primeira opção por padrão

        Button optionProduto = new Button(dialog, SWT.RADIO);
        optionProduto.setText("Produto");

        // Botão OK
        Button okButton = new Button(dialog, SWT.PUSH);
        okButton.setText("Prosseguir");
        GridData gridData = new GridData(SWT.CENTER, SWT.CENTER, true, false);
        okButton.setLayoutData(gridData);

        okButton.addListener(SWT.Selection, event -> {
            if (optionPrato.getSelection()) {
                pratoSelecionado(mainPage);
            } else if (optionProduto.getSelection()) {
            	produtoSelecionado(mainPage);
            }
            dialog.close();
        });

        dialog.setSize(350, 250);
        dialog.open();
    }

    private static void pratoSelecionado(MainPage mainPage) {
    	//Prato prato = new Prato();
    	mainPage.navigateToScreenFuncionario(4);
    }

    private static void produtoSelecionado(MainPage mainPage) {
    	//Produto produto = new Produto();
    	mainPage.navigateToScreenFuncionario(8);
    }
}
