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
		
		//showHome();
		showHomeEmployee();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void showMenuBarClient() {
		MenuBarClient menuBarClient = new MenuBarClient(shell, this);
		FormData fd_menuBarClient = new FormData();
		fd_menuBarClient.bottom = new FormAttachment(100);
		fd_menuBarClient.left = new FormAttachment(0);
		fd_menuBarClient.right = new FormAttachment(100);
		fd_menuBarClient.top = new FormAttachment(96, -50);  
		menuBarClient.setLayoutData(fd_menuBarClient);
	}
	
	private void showMenuBarEmployee() {
		MenuBarEmployee menuBarEmployee = new MenuBarEmployee(shell, this);
		FormData fd_menuBarEmployee = new FormData();
		fd_menuBarEmployee.bottom = new FormAttachment(100);
		fd_menuBarEmployee.left = new FormAttachment(0);
		fd_menuBarEmployee.right = new FormAttachment(100);
		fd_menuBarEmployee.top = new FormAttachment(96, -50);  
		menuBarEmployee.setLayoutData(fd_menuBarEmployee);
	}

	private void showHome() {
		clearShell();
		Home home = new Home(shell, this);
		FormData fd_homeFuncionario = new FormData();
		fd_homeFuncionario.top = new FormAttachment(0);
		fd_homeFuncionario.left = new FormAttachment(0);
		fd_homeFuncionario.right = new FormAttachment(100);
		fd_homeFuncionario.bottom = new FormAttachment(90, -50);  
		home.setLayoutData(fd_homeFuncionario);
		showMenuBarClient();
		shell.layout();
	}

	private void showInfoProduct() {
		clearShell();
		InfoProduct infoProduct = new InfoProduct(shell, this);
		FormData fd_infoProduct = new FormData();
		fd_infoProduct.left = new FormAttachment(0);
		fd_infoProduct.right = new FormAttachment(100);
		fd_infoProduct.top = new FormAttachment(0);
		fd_infoProduct.bottom = new FormAttachment(90, -50); 
		infoProduct.setLayoutData(fd_infoProduct);
		showMenuBarClient();
		shell.layout();
	}

	private void showHomeEmployee() {
		clearShell();
		HomeFuncionario homeFuncionario = new HomeFuncionario(shell, this);
		FormData fd_homeFuncionario = new FormData();
		fd_homeFuncionario.top = new FormAttachment(0);
		fd_homeFuncionario.left = new FormAttachment(0);
		fd_homeFuncionario.right = new FormAttachment(100);
		fd_homeFuncionario.bottom = new FormAttachment(90, -50);  
		homeFuncionario.setLayoutData(fd_homeFuncionario);
		showMenuBarEmployee();
		shell.layout();
	}
	
	private void showCardapioInfo() {
		clearShell();
		CardapioInfo cadCardapioInfo = new CardapioInfo(shell, this);
		FormData fd_cadapioInfo = new FormData();
		fd_cadapioInfo.left = new FormAttachment(0);
		fd_cadapioInfo.right = new FormAttachment(100);
		fd_cadapioInfo.top = new FormAttachment(0);
		fd_cadapioInfo.bottom = new FormAttachment(90, -50); 
		cadCardapioInfo.setLayoutData(fd_cadapioInfo);
		showMenuBarEmployee();
		shell.layout();
	}
	
	private void showItemCardapioInfo() {
		clearShell();
		ItemCardapioInfo itemCardapioInfo = new ItemCardapioInfo(shell, this);
		FormData fd_itemCardapioInfo = new FormData();
		fd_itemCardapioInfo.left = new FormAttachment(0);
		fd_itemCardapioInfo.right = new FormAttachment(100);
		fd_itemCardapioInfo.top = new FormAttachment(0);
		fd_itemCardapioInfo.bottom = new FormAttachment(90, -50); 
		itemCardapioInfo.setLayoutData(fd_itemCardapioInfo);
		showMenuBarEmployee();
		shell.layout();
	}
	
	private void showCadItemCardapio() {
		clearShell();
		CadItemCardapio cadItemCardapio = new CadItemCardapio(shell, this);
		FormData fd_cadItemCardapio = new FormData();
		fd_cadItemCardapio.left = new FormAttachment(0);
		fd_cadItemCardapio.right = new FormAttachment(100);
		fd_cadItemCardapio.top = new FormAttachment(0);
		fd_cadItemCardapio.bottom = new FormAttachment(90, -50); 
		cadItemCardapio.setLayoutData(fd_cadItemCardapio);
		showMenuBarEmployee();
		shell.layout();
	}
	
	private void showCadCardapio() {
		clearShell();
		CadCardapio cadCardapio = new CadCardapio(shell, this);
		FormData fd_cadCardapio = new FormData();
		fd_cadCardapio.left = new FormAttachment(0);
		fd_cadCardapio.right = new FormAttachment(100);
		fd_cadCardapio.top = new FormAttachment(0);
		fd_cadCardapio.bottom = new FormAttachment(90, -50); 
		cadCardapio.setLayoutData(fd_cadCardapio);
		showMenuBarEmployee();
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
	
	protected void navigateToScreenEmployee(int screenNumber) {
		switch (screenNumber) {
		case 1:
			showHomeEmployee();
			break;
		case 2:
			showCardapioInfo();
			break;
		case 3:
			showItemCardapioInfo();
			break;
		case 4:
			showCadItemCardapio();
			break;
		case 5:
			showCadCardapio();
			break;
		default:
			showHomeEmployee();
			break;
		}
	}
	

	protected void createContents() {
		shell = new Shell();
		createResourceManager();
		shell.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255,255,255))));
		shell.setSize(482, 874);
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

