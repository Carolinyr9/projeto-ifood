package view;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class UsuarioPerfil extends Composite {
		
	private LocalResourceManager localResourceManager;

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}


    public UsuarioPerfil(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		setSize(482, 774);
		setLayout(null);
		
		Label lblPerfil = new Label(this, SWT.NONE);
		lblPerfil.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPerfil.setBounds(22, 26, 108, 37);
		lblPerfil.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblPerfil.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
		lblPerfil.setText("Perfil");
		
		Label lblNomeusuario = new Label(this, SWT.NONE);
		lblNomeusuario.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNomeusuario.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblNomeusuario.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblNomeusuario.setBounds(56, 113, 122, 25);
		lblNomeusuario.setText("NomeUsuario");
		
		Button btnLogoff = new Button(this, SWT.NONE);
		btnLogoff.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLogoff.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnLogoff.getBounds();
				Color blue = new Color(getDisplay(), new RGB(255, 255, 255));
				Color white = new Color(getDisplay(), new RGB(0, 100, 141));
				
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
				
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
				String text = "Logoff";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);
				
				blue.dispose();
				white.dispose();
			}
		});
		btnLogoff.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		btnLogoff.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		btnLogoff.setBounds(56, 655, 90, 30);
		btnLogoff.setText("Logoff");
		
		
		
	}
}
