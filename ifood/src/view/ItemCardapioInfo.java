package view;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ItemCardapioInfo extends Composite {
		
	private LocalResourceManager localResourceManager;
	private Display display = getDisplay();
	private Text txtIngredientes;
	private Text textPreco;
	private Text txtTitulo;
	private Text txtDescricao;

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}


    public ItemCardapioInfo(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setSize(468, 714);
		setLayout(new FormLayout());
		
		Image arrowIcon = new Image(display, "./src/assets/images/backArrow.png");
		
		Composite compositeHeader = new Composite(this, SWT.NONE);
		compositeHeader.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		FormData fd_compositeHeader = new FormData();
		fd_compositeHeader.top = new FormAttachment(0);
		fd_compositeHeader.left = new FormAttachment(0);
		fd_compositeHeader.bottom = new FormAttachment(0, 73);
		fd_compositeHeader.right = new FormAttachment(0, 468);
		compositeHeader.setLayoutData(fd_compositeHeader);
		
		Label lblItem1 = new Label(compositeHeader, SWT.CENTER);
		lblItem1.setAlignment(SWT.CENTER);
		lblItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		lblItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
		lblItem1.setBounds(86, 12, 96, 51);
		lblItem1.setText("Item #1");
		
		Button btnBack = new Button(compositeHeader, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreenEmployee(2);
			}
		});
		btnBack.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(arrowIcon, 0, 0);
			  }
			} );
		btnBack.setBounds(20, 10, 60, 53);
		
		Composite compositeForm = new Composite(this, SWT.NONE);
		compositeForm.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeForm.setLayout(null);
		FormData fd_compositeForm = new FormData();
		fd_compositeForm.bottom = new FormAttachment(compositeHeader, 634, SWT.BOTTOM);
		fd_compositeForm.right = new FormAttachment(compositeHeader, 0, SWT.RIGHT);
		fd_compositeForm.top = new FormAttachment(compositeHeader, 6);
		fd_compositeForm.left = new FormAttachment(0);
		compositeForm.setLayoutData(fd_compositeForm);
		
		Label lblTitulo = new Label(compositeForm, SWT.NONE);
		lblTitulo.setBounds(63, 30, 56, 29);
		lblTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 142))));
		lblTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		lblTitulo.setText("Título");
		
		txtTitulo = new Text(compositeForm, SWT.BORDER);
		txtTitulo.setBounds(63, 64, 114, 36);
		txtTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		txtTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		txtTitulo.setText("Titulo");
		
		Label lblPreco = new Label(compositeForm, SWT.NONE);
		lblPreco.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 142))));
		lblPreco.setBounds(63, 130, 63, 35);
		lblPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		lblPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPreco.setText("Preço");
		
		textPreco = new Text(compositeForm, SWT.BORDER);
		textPreco.setBounds(63, 170, 114, 36);
		textPreco.setText("Preço");
		textPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		textPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Button btnTemIngredientes = new Button(compositeForm, SWT.CHECK);
		btnTemIngredientes.setBounds(63, 236, 184, 28);
		btnTemIngredientes.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		btnTemIngredientes.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		btnTemIngredientes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnTemIngredientes.getSelection()) {
					txtIngredientes.setEnabled(true);
					txtIngredientes.setEditable(true);
                } else {
                	txtIngredientes.setEnabled(false);
            		txtIngredientes.setEditable(false);
            		txtIngredientes.setText("");
                }
			}
		});
		btnTemIngredientes.setText("Tem ingredientes");
		
		txtIngredientes = new Text(compositeForm, SWT.BORDER);
		txtIngredientes.setBounds(63, 269, 351, 105);
		txtIngredientes.setEnabled(false);
		txtIngredientes.setEditable(false);
		txtIngredientes.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		txtIngredientes.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		txtIngredientes.setText("ingredientes");
		
		Label lblDescricao = new Label(compositeForm, SWT.NONE);
		lblDescricao.setBounds(63, 404, 96, 28);
		lblDescricao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		lblDescricao.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 142))));
		lblDescricao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblDescricao.setText("Descrição");
		
		txtDescricao = new Text(compositeForm, SWT.BORDER);
		txtDescricao.setBounds(63, 437, 350, 103);
		txtDescricao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		txtDescricao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		txtDescricao.setText("Descrição");
		
		Button btnEditar = new Button(compositeForm, SWT.NONE);
		btnEditar.setBounds(63, 570, 96, 35);
		btnEditar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnEditar.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnEditar.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		btnEditar.setText("Editar");
		btnEditar.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnEditar.getBounds();
				Color blue = new Color(getDisplay(), new RGB(19, 41, 61));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));

				// Desenhando o fundo azul com bordas arredondadas
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 40, 40);

				// Desenhando o texto branco
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Editar";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);

				blue.dispose();
				white.dispose();
			}
		});
		
		
	}
}
