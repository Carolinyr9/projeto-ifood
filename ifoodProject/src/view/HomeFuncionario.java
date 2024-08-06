package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.RGB;
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

public class HomeFuncionario extends Composite {

	private LocalResourceManager localResourceManager;
	private List<String> tipoItemCardapio;

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}

	public HomeFuncionario(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setSize(468, 774);
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setLayout(new FormLayout());
		
		tipoItemCardapio = new ArrayList<String>();
		tipoItemCardapio.add(0, "Pizzas");
		tipoItemCardapio.add(1, "Bebidas");
		int numCardapio = tipoItemCardapio.size();
		
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
		lblCardapios.setText("Cardápio");
		
		Composite compositeCasdapios = new Composite(this, SWT.NONE);
		compositeCasdapios.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridLayout gl_compositeCasdapios = new GridLayout(1, false);
		gl_compositeCasdapios.verticalSpacing = 30;
		compositeCasdapios.setLayout(gl_compositeCasdapios);
		FormData fd_compositeCasdapios = new FormData();
		fd_compositeCasdapios.top = new FormAttachment(compositeHeader, 36);
		fd_compositeCasdapios.bottom = new FormAttachment(100, -28);
		fd_compositeCasdapios.left = new FormAttachment(0, 48);
		fd_compositeCasdapios.right = new FormAttachment(0, 420);
		compositeCasdapios.setLayoutData(fd_compositeCasdapios);
		
		/* Este loop exibe as sessões do cardápio, sendo a de produto e a de prato */
		for (int i = 0; i < numCardapio; i++) {
			Composite compositeCardapio1 = new Composite(compositeCasdapios, SWT.NONE);
			compositeCardapio1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			GridLayout gl_compositeCardapio1 = new GridLayout(1, false);
			gl_compositeCardapio1.marginTop = 10;
			gl_compositeCardapio1.marginLeft = 20;
			compositeCardapio1.setLayout(gl_compositeCardapio1);
			GridData gd_compositeCardapio1 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
			gd_compositeCardapio1.heightHint = 112;
			gd_compositeCardapio1.widthHint = 361;
			compositeCardapio1.setLayoutData(gd_compositeCardapio1);
			compositeCardapio1.addPaintListener(new PaintListener() {
				@Override
				public void paintControl(PaintEvent e) {
					GC gc = e.gc;
	                gc.setAntialias(SWT.ON);
	                Rectangle bounds = compositeCardapio1.getClientArea();
	                int arcWidth = 20;
	                int arcHeight = 20;
	                gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
	                gc.fillRoundRectangle(0, 0, bounds.width, bounds.height, arcWidth, arcHeight);
	                gc.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
	                gc.drawRoundRectangle(0, 0, bounds.width - 1, bounds.height - 1, arcWidth, arcHeight);
				}
			});
			compositeCardapio1.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseDown(MouseEvent e) {
	            	/*Terá que deixar o showFuncionarioPratoInfo */
	            	mainPage.navigateToScreenFuncionario(2);
	            }
	        });
			
			Label lblCardapioTitulo = new Label(compositeCardapio1, SWT.NONE);
			lblCardapioTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 0, 0))));
			lblCardapioTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblCardapioTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
			lblCardapioTitulo.setText(tipoItemCardapio.get(i));
			new Label(compositeCardapio1, SWT.NONE);
			
			Label lblPossuiItens = new Label(compositeCardapio1, SWT.NONE);
			lblPossuiItens.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED));
			lblPossuiItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			/*Detro do setText(), colocar se a sessão do cardápio possui itens ou não*/
			lblPossuiItens.setText("*sem itens");
        }

	}
}
