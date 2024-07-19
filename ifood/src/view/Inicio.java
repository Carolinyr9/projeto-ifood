package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Inicio {

	protected Shell shell;
	private Text txtIfood;
	private LocalResourceManager localResourceManager;
	private Text txtBemVindoa;
	private Text txtLoguese;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Inicio window = new Inicio();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setLayout(new GridLayout(1, false));
		createResourceManager();
		shell.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		shell.setSize(482, 780);
		shell.setText("Início");
		new Label(shell, SWT.NONE);
		
		txtIfood = new Text(shell, SWT.READ_ONLY);
		txtIfood.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		txtIfood.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		txtIfood.setText("IFOOD");
		txtIfood.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 26, SWT.BOLD)));
		txtIfood.setBounds(156, 10, 155, 69);
		txtIfood.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		txtBemVindoa = new Text(shell, SWT.READ_ONLY | SWT.CENTER);
		txtBemVindoa.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		txtBemVindoa.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		txtBemVindoa.setText("Bem Vindo(a)!");
		txtBemVindoa.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
		txtBemVindoa.setBounds(133, 110, 196, 37);
		GridData gd_txtBemVindoa = new GridData(SWT.CENTER, SWT.CENTER, true, false);
		gd_txtBemVindoa.heightHint = 44;
		txtBemVindoa.setLayoutData(gd_txtBemVindoa);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		txtLoguese = new Text(shell, SWT.READ_ONLY | SWT.CENTER);
		txtLoguese.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		txtLoguese.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		txtLoguese.setText("Logue-se para continuar");
		txtLoguese.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 14, SWT.NORMAL)));
		txtLoguese.setBounds(99, 211, 281, 37);
		txtLoguese.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button btnSouFuncionario = new Button(shell, SWT.NONE);
		btnSouFuncionario.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		btnSouFuncionario.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSouFuncionario.setBounds(140, 387, 180, 37);
		btnSouFuncionario.setText("Sou funcionário");
		GridData gd_btnSouFuncionario = new GridData(SWT.CENTER, SWT.CENTER, true, false);
		gd_btnSouFuncionario.widthHint = 182;
		gd_btnSouFuncionario.heightHint = 43;
		btnSouFuncionario.setLayoutData(gd_btnSouFuncionario);
		new Label(shell, SWT.NONE);
		
		Button btnSouCliente = new Button(shell, SWT.NONE);
		btnSouCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSouCliente.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		btnSouCliente.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		btnSouCliente.setBounds(151, 285, 160, 37);
		btnSouCliente.setText("Sou Cliente");
		GridData gd_btnSouCliente = new GridData(SWT.CENTER, SWT.CENTER, true, false);
		gd_btnSouCliente.heightHint = 40;
		gd_btnSouCliente.widthHint = 145;
		btnSouCliente.setLayoutData(gd_btnSouCliente);

	}
	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(),shell);
	}
}
