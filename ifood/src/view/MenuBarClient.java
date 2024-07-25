package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;

/*Essa classe está utilizando o Composite como pai, para herdar seu tipo e para que no final ele fique que nem um 
 * componente e apenas seja adicionado na página principal*/
public class MenuBarClient extends Composite {

    private LocalResourceManager localResourceManager;
    private Image lupaIcon;
    private Image houseIcon;
    private Image perfilIcon;
    private Image bagIcon;
    private Display display = getDisplay();

    private void createResourceManager() {
    	localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
    }
    public MenuBarClient(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
        createResourceManager();
        addTopBorderPaintListener();
        
        lupaIcon = new Image(display, "./src/assets/images/lupaIcon.png");
        houseIcon = new Image(display, "./src/assets/images/houseIcon.png");
        perfilIcon = new Image(display, "./src/assets/images/perfilIcon.png");
        bagIcon = new Image(display, "./src/assets/images/bagIcon.png");

        setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        setLayout(new GridLayout(6, false));
        
        Composite composite_1 = new Composite(this, SWT.NONE);
        composite_1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_composite_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_1.widthHint = 25;
		composite_1.setLayoutData(gd_composite_1);
		
		Button btnImageLupa = new Button(this, SWT.TRANSPARENT);
		btnImageLupa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Lupa clicada");
			}
		});
		/* Função para adicionar imagem e tirar bordas */
		btnImageLupa.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(lupaIcon, 20, 6);
			  }
			} );
		GridData gd_btnImageLupa = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImageLupa.widthHint = 95;
		gd_btnImageLupa.heightHint = 60;
		btnImageLupa.setLayoutData(gd_btnImageLupa);
		
		Button btnImageHouse = new Button(this, SWT.PUSH);
		btnImageHouse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("House clicada");
				mainPage.navigateToScreen(1);
			}
		});
		/* Função para adicionar imagem e tirar bordas */
		btnImageHouse.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(houseIcon, 20, 6);
			  }
			} );
		GridData gd_btnImageHouse = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImageHouse.widthHint = 95;
		gd_btnImageHouse.heightHint = 60;
		btnImageHouse.setLayoutData(gd_btnImageHouse);
		
		Button btnImagePerson = new Button(this, SWT.NONE);
		btnImagePerson.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Perfil clicada");
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
				mainPage.navigateToScreen(3);
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
    
    /* Função para adicionar uma borda no top do MenuBarClient */
    private void addTopBorderPaintListener() {
        addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                GC gc = e.gc;
                gc.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
                int width = getClientArea().width;
                gc.drawLine(0, 0, width, 0); // Draw top border
            }
        });
    }

}
