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

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CardapioInfo extends Composite {

	private LocalResourceManager localResourceManager;
	private Image arrowIcon;
	private Display display = getDisplay();

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}

	public CardapioInfo(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setLayout(new FormLayout());
		
		arrowIcon = new Image(display, "./src/assets/images/backArrow.png");
		
		Composite compositeHeader = new Composite(this, SWT.NONE);
		compositeHeader.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		FormData fd_compositeHeader = new FormData();
		fd_compositeHeader.top = new FormAttachment(0);
		fd_compositeHeader.left = new FormAttachment(0);
		fd_compositeHeader.bottom = new FormAttachment(0, 73);
		fd_compositeHeader.right = new FormAttachment(0, 468);
		compositeHeader.setLayoutData(fd_compositeHeader);
		
		Label lblCardapios = new Label(compositeHeader, SWT.CENTER);
		lblCardapios.setAlignment(SWT.CENTER);
		lblCardapios.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblCardapios.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		lblCardapios.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
		lblCardapios.setBounds(85, 12, 155, 51);
		lblCardapios.setText("Cardápio #1");
		
		Button btnAdicionarItem = new Button(this, SWT.NONE);
		btnAdicionarItem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnAdicionarItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreenEmployee(4);
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
				mainPage.navigateToScreenEmployee(1);
			}
		});
		btnBack.setBounds(20, 10, 60, 53);
		/* Função para adicionar imagem e tirar bordas */
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
		btnAdicionarItem.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnAdicionarItem.getBounds();
				Color blue = new Color(getDisplay(), new RGB(19, 41, 61));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));

				// Desenhando o fundo azul com bordas arredondadas
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 40, 40);

				// Desenhando o texto branco
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
		
		Composite compositeItens = new Composite(this, SWT.NONE);
		compositeItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeItens.setLayout(new GridLayout(1, false));
		FormData fd_compositeItens = new FormData();
		fd_compositeItens.top = new FormAttachment(btnAdicionarItem, 22);
		fd_compositeItens.left = new FormAttachment(0, 48);
		fd_compositeItens.bottom = new FormAttachment(100, -28);
		fd_compositeItens.right = new FormAttachment(0, 420);
		compositeItens.setLayoutData(fd_compositeItens);
		
		
		Composite compositeItem1 = new Composite(compositeItens, SWT.NONE);
		compositeItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_compositeItem1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeItem1.heightHint = 68;
		gd_compositeItem1.widthHint = 360;
		compositeItem1.setLayoutData(gd_compositeItem1);
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
            	mainPage.navigateToScreenEmployee(3);
            }
        });
		
		Label lblItem1 = new Label(compositeItem1, SWT.NONE);
		lblItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 0, 0))));
		lblItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		lblItem1.setBounds(25, 23, 187, 28);
		lblItem1.setText("Item #1");
		lblItem1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                mainPage.navigateToScreenEmployee(3);
            }
        });
		
		Label lblPreco = new Label(compositeItem1, SWT.NONE);
		lblPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblPreco.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED));
		lblPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPreco.setBounds(252, 26, 74, 28);
		lblPreco.setText("R$19.77");
		new Label(compositeItens, SWT.NONE);
		
		Composite compositeItem2 = new Composite(compositeItens, SWT.NONE);
		GridData gd_compositeItem2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeItem2.heightHint = 66;
		gd_compositeItem2.widthHint = 359;
		compositeItem2.setLayoutData(gd_compositeItem2);
		compositeItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeItem2.addPaintListener(new PaintListener() {
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
		compositeItem2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
            	mainPage.navigateToScreenEmployee(3);
            }
        });
		
		Label lblItem2 = new Label(compositeItem2, SWT.NONE);
		lblItem2.setText("Item #2");
		lblItem2.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 0, 0))));
		lblItem2.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		lblItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblItem2.setBounds(25, 23, 224, 28);
		lblItem2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
            	mainPage.navigateToScreenEmployee(3);
            }
        });
		
		Label lblPreco_1 = new Label(compositeItem2, SWT.NONE);
		lblPreco_1.setText("R$19.77");
		lblPreco_1.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED));
		lblPreco_1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblPreco_1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPreco_1.setBounds(255, 26, 74, 28);

	}
}
