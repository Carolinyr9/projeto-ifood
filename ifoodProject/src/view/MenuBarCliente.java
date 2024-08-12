package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import model.Cliente;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;

public class MenuBarCliente extends Composite {

    private LocalResourceManager localResourceManager;
    private Image pedidosIcon;
    private Image houseIcon;
    private Image perfilIcon;
    private Image bagIcon;
    private Cliente cliente;
    private Display display = getDisplay();
    
    private void createResourceManager() {
    	localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
    }
    
    public MenuBarCliente(Composite parent, MainPage mainPage, Cliente clienteLogado) {
		super(parent, SWT.NONE);
        createResourceManager();
        addTopBorderPaintListener();
        
        this.cliente = clienteLogado;
        
        houseIcon = new Image(display, "./src/assets/images/houseIcon.png");
        pedidosIcon = new Image(display, "./src/assets/images/taskIcon.png");
        perfilIcon = new Image(display, "./src/assets/images/perfilIcon.png");
        bagIcon = new Image(display, "./src/assets/images/bagIcon.png");

        setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        setLayout(new GridLayout(6, false));
        
        Composite composite_1 = new Composite(this, SWT.NONE);
        composite_1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_composite_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_1.widthHint = 25;
		composite_1.setLayoutData(gd_composite_1);
		
		Button btnImageHome = new Button(this, SWT.TRANSPARENT);
		btnImageHome.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreenCliente(1);
			}
		});
		btnImageHome.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(houseIcon, 20, 6);
			  }
			} );
		GridData gd_btnImageHome = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImageHome.widthHint = 95;
		gd_btnImageHome.heightHint = 60;
		btnImageHome.setLayoutData(gd_btnImageHome);
		
		Button btnImagePedidos = new Button(this, SWT.PUSH);
		btnImagePedidos.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreenCliente(5);
			}
		});
		btnImagePedidos.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(pedidosIcon, 20, 6);
			  }
			} );
		GridData gd_btnImagePedidos = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImagePedidos.widthHint = 95;
		gd_btnImagePedidos.heightHint = 60;
		btnImagePedidos.setLayoutData(gd_btnImagePedidos);
		
		Button btnImagePerson = new Button(this, SWT.NONE);
		btnImagePerson.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreenCliente(4);
			}
		});
		/* Função para adicionar imagem e tirar bordas */
		btnImagePerson.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(perfilIcon, 20, 6);
			  }
			} );
		GridData gd_btnImagePerson = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImagePerson.widthHint = 95;
		gd_btnImagePerson.heightHint = 60;
		btnImagePerson.setLayoutData(gd_btnImagePerson);
		
		Button btnImageBag = new Button(this, SWT.NONE);
		btnImageBag.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.showClienteCarrinho(cliente);
			}
		});
		/* Função para adicionar imagem e tirar bordas */
		btnImageBag.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(bagIcon, 20, 0);
			  }
			} );
		GridData gd_btnImageBag = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImageBag.widthHint = 95;
		gd_btnImageBag.heightHint = 60;
		btnImageBag.setLayoutData(gd_btnImageBag);
		
		Composite composite_2 = new Composite(this, SWT.NONE);
		composite_2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_composite_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_2.widthHint = 21;
		composite_2.setLayoutData(gd_composite_2);
    }
    
    private void addTopBorderPaintListener() {
        addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                GC gc = e.gc;
                gc.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
                int width = getClientArea().width;
                gc.drawLine(0, 0, width, 0); 
            }
        });
    }

}
