package view;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.widgets.Control;


public class MainPage {

	protected Shell shell;
	private LocalResourceManager localResourceManager;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainPage window = new MainPage();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		
		showHome();
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void showMenuBar() {
		MenuBarClient menuBarClient = new MenuBarClient(shell, this);
		FormData fd_menuBarClient = new FormData();
		fd_menuBarClient.bottom = new FormAttachment(100);
		fd_menuBarClient.left = new FormAttachment(0);
		fd_menuBarClient.right = new FormAttachment(100);
		fd_menuBarClient.top = new FormAttachment(96, -50);  
		menuBarClient.setLayoutData(fd_menuBarClient);
	}

	private void showHome() {
		clearShell();
		Home home = new Home(shell, this);
		FormData fd_home = new FormData();
		fd_home.top = new FormAttachment(0);
		fd_home.left = new FormAttachment(0);
		fd_home.right = new FormAttachment(100);
		fd_home.bottom = new FormAttachment(90, -50);  
		home.setLayoutData(fd_home);
		showMenuBar();
		shell.layout();
	}

	private void showInfoProduct() {
		clearShell();
		InfoProduct infoProduct = new InfoProduct(shell, this);
		FormData fd_infoProduct = new FormData();
		fd_infoProduct.left = new FormAttachment(0);
		fd_infoProduct.right = new FormAttachment(100);
		fd_infoProduct.top = new FormAttachment(0);
		fd_infoProduct.bottom = new FormAttachment(100, -50); 
		infoProduct.setLayoutData(fd_infoProduct);
		showMenuBar();
		shell.layout();
	}

	protected void navigateToScreen(int screenNumber) {
		switch (screenNumber) {
		case 1:
			showHome();
			break;
		case 2:
			showInfoProduct();
			break;
		default:
			showHome();
			break;
		}
	}

	protected void createContents() {
		shell = new Shell();
		createResourceManager();
		shell.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255,255,255))));
		shell.setSize(482, 814);
		shell.setText("Início");
		shell.setLayout(new FormLayout());
	}

	private void clearShell() {
		for (Control control : shell.getChildren()) {
			if (!(control instanceof MenuBarClient)) {
				control.dispose();
			}
		}
	}

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(),shell);
	}
}

