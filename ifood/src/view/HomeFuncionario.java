package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.GC;
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

public class HomeFuncionario extends Composite {

	private LocalResourceManager localResourceManager;

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}

	public HomeFuncionario(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setSize(468, 774);
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setLayout(new FormLayout());
		
		Composite compositeHeader = new Composite(this, SWT.NONE);
		compositeHeader.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		FormData fd_compositeHeader = new FormData();
		fd_compositeHeader.top = new FormAttachment(0);
		fd_compositeHeader.left = new FormAttachment(0);
		fd_compositeHeader.bottom = new FormAttachment(0, 73);
		fd_compositeHeader.right = new FormAttachment(0, 468);
		compositeHeader.setLayoutData(fd_compositeHeader);
		
		Label lblCardapios = new Label(compositeHeader, SWT.NONE);
		lblCardapios.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblCardapios.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		lblCardapios.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
		lblCardapios.setBounds(30, 25, 128, 38);
		lblCardapios.setText("Cardápios");
		
		Button btnAdicionarCardapio = new Button(this, SWT.NONE);
		btnAdicionarCardapio.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnAdicionarCardapio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreenEmployee(5);
			}
		});
		btnAdicionarCardapio.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		FormData fd_btnAdicionarCardapio = new FormData();
		fd_btnAdicionarCardapio.bottom = new FormAttachment(compositeHeader, 80, SWT.BOTTOM);
		fd_btnAdicionarCardapio.top = new FormAttachment(compositeHeader, 44);
		fd_btnAdicionarCardapio.left = new FormAttachment(0, 48);
		fd_btnAdicionarCardapio.right = new FormAttachment(0, 241);
		btnAdicionarCardapio.setLayoutData(fd_btnAdicionarCardapio);
		btnAdicionarCardapio.setText("Adicionar Cardápio");
		btnAdicionarCardapio.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnAdicionarCardapio.getBounds();
				Color blue = new Color(getDisplay(), new RGB(19, 41, 61));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));

				// Desenhando o fundo azul com bordas arredondadas
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 40, 40);

				// Desenhando o texto branco
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Adicionar Cardápio";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);

				blue.dispose();
				white.dispose();
			}
		});
		
		Composite compositeCasdapios = new Composite(this, SWT.NONE);
		compositeCasdapios.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeCasdapios.setLayout(new GridLayout(1, false));
		FormData fd_compositeCasdapios = new FormData();
		fd_compositeCasdapios.top = new FormAttachment(btnAdicionarCardapio, 22);
		fd_compositeCasdapios.left = new FormAttachment(0, 48);
		fd_compositeCasdapios.bottom = new FormAttachment(100, -28);
		fd_compositeCasdapios.right = new FormAttachment(0, 420);
		compositeCasdapios.setLayoutData(fd_compositeCasdapios);
		
		
		Composite compositeCardapio = new Composite(compositeCasdapios, SWT.NONE);
		compositeCardapio.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_compositeCardapio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeCardapio.heightHint = 112;
		gd_compositeCardapio.widthHint = 360;
		compositeCardapio.setLayoutData(gd_compositeCardapio);
		compositeCardapio.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
                gc.setAntialias(SWT.ON);
                Rectangle bounds = compositeCardapio.getClientArea();
                int arcWidth = 20;
                int arcHeight = 20;
                gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
                gc.fillRoundRectangle(0, 0, bounds.width, bounds.height, arcWidth, arcHeight);
                gc.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
                gc.drawRoundRectangle(0, 0, bounds.width - 1, bounds.height - 1, arcWidth, arcHeight);
			}
		});
		compositeCardapio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
            	mainPage.navigateToScreenEmployee(2);
            }
        });
		
		Label lblCardapio1 = new Label(compositeCardapio, SWT.NONE);
		lblCardapio1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 0, 0))));
		lblCardapio1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblCardapio1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		lblCardapio1.setBounds(25, 23, 115, 28);
		lblCardapio1.setText("Cardápio #1");
		
		Label lblsemItens = new Label(compositeCardapio, SWT.NONE);
		lblsemItens.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED));
		lblsemItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblsemItens.setBounds(23, 70, 70, 20);
		lblsemItens.setText("*sem itens");

	}
}
