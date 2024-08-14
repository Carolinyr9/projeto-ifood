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


import java.nio.file.Paths;
import java.nio.file.Path;

public class MenuBarFuncionario extends Composite {

    private LocalResourceManager localResourceManager;
    private Image restaurantIcon;
    private Image starIcon;
    private Image taskIcon;
    private Image perfilIcon;
    private Display display = getDisplay();

    private void createResourceManager() {
    	localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
    }
    public MenuBarFuncionario(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
        createResourceManager();
        addTopBorderPaintListener();
        
        Path restaurantIconPath = Paths.get("src/assets/images/restaurantIcon.png").toAbsolutePath();
        Path starIconPath = Paths.get("src/assets/images/starIcon.png").toAbsolutePath();
        Path taskIconPath = Paths.get("src/assets/images/taskIcon.png").toAbsolutePath();
        Path perfilIconPath = Paths.get("src/assets/images/perfilIcon.png").toAbsolutePath();

        restaurantIcon = new Image(display, restaurantIconPath.toString());
        starIcon = new Image(display, starIconPath.toString());
        perfilIcon = new Image(display, perfilIconPath.toString());
        taskIcon = new Image(display, taskIconPath.toString());

        setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        setLayout(new GridLayout(6, false));
        
        Composite composite_1 = new Composite(this, SWT.NONE);
        composite_1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_composite_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_1.widthHint = 25;
		composite_1.setLayoutData(gd_composite_1);
		
		Button btnImageRestaurant = new Button(this, SWT.TRANSPARENT);
		btnImageRestaurant.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.showHomeFuncionario();
			}
		});
		btnImageRestaurant.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(restaurantIcon, 26, 8);
			  }
			} );
		GridData gd_btnImageRestaurant = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImageRestaurant.widthHint = 95;
		gd_btnImageRestaurant.heightHint = 60;
		btnImageRestaurant.setLayoutData(gd_btnImageRestaurant);
		
		Button btnImageStar = new Button(this, SWT.PUSH);
		btnImageStar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnImageStar.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(starIcon, 20, 3);
			  }
			} );
		GridData gd_btnImageStar = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImageStar.widthHint = 95;
		gd_btnImageStar.heightHint = 60;
		btnImageStar.setLayoutData(gd_btnImageStar);
		
		Button btnImageTasks = new Button(this, SWT.NONE);
		btnImageTasks.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.showFuncionarioPedidos();
			}
		});
		btnImageTasks.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(taskIcon, 20, 6);
			  }
			} );
		GridData gd_btnImageTasks = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImageTasks.widthHint = 95;
		gd_btnImageTasks.heightHint = 60;
		btnImageTasks.setLayoutData(gd_btnImageTasks);
		
		Button btnImagePerson = new Button(this, SWT.NONE);
		btnImagePerson.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.showUsuarioPerfil();
			}
		});
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
                gc.drawLine(0, 0, width, 0); // Draw top border
            }
        });
    }

}
