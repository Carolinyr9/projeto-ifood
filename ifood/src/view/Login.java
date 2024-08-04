package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/* Ainda tenho que transformar essa tela em um componente para colocar na tela principal*/

public class Login {

	protected Shell shell;
	private LocalResourceManager localResourceManager;
	private Label lbLogin;
	private Composite composite;
	private Label lblEmail;
	private Text textEmail;
	private ViewForm viewForm;
	private Label lblSenha;
	private Text txtSenha;
	private Button btnSouEntregador;
	private Label lblSaudacao;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
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
		createResourceManager();
		shell.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		shell.setSize(482, 780);
		shell.setText("Login");
		shell.setLayout(new FormLayout());
		
		composite = new Composite(shell, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 68);
		fd_composite.right = new FormAttachment(0, 464);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		composite.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		
		lbLogin = new Label(composite, SWT.CENTER);
		lbLogin.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lbLogin.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lbLogin.setText("Login");
		lbLogin.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 18, SWT.BOLD)));
		lbLogin.setBounds(191, 10, 78, 37);
		
		lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 14, SWT.NORMAL)));
		lblEmail.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		FormData fd_lblEmail = new FormData();
		fd_lblEmail.left = new FormAttachment(0, 95);
		fd_lblEmail.right = new FormAttachment(100, -260);
		lblEmail.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblEmail.setLayoutData(fd_lblEmail);
		lblEmail.setText("Email");
		
		viewForm = new ViewForm(shell, SWT.NONE);
		FormData fd_viewForm = new FormData();
		fd_viewForm.top = new FormAttachment(0, 298);
		fd_viewForm.left = new FormAttachment(0, 5);
		viewForm.setLayoutData(fd_viewForm);
		
		textEmail = new Text(shell, SWT.BORDER);
		fd_lblEmail.bottom = new FormAttachment(100, -491);
		FormData fd_textEmail = new FormData();
		fd_textEmail.top = new FormAttachment(lblEmail, 6);
		fd_textEmail.left = new FormAttachment(lblEmail, 0, SWT.LEFT);
		fd_textEmail.right = new FormAttachment(100, -108);
		textEmail.setLayoutData(fd_textEmail);
		
		lblSenha = new Label(shell, SWT.NONE);
		fd_textEmail.bottom = new FormAttachment(lblSenha, -35);
		lblSenha.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 14, SWT.NORMAL)));
		lblSenha.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		FormData fd_lblSenha = new FormData();
		fd_lblSenha.left = new FormAttachment(0, 96);
		lblSenha.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblSenha.setLayoutData(fd_lblSenha);
		lblSenha.setText("Senha");
		
		txtSenha = new Text(shell, SWT.BORDER);
		fd_lblSenha.bottom = new FormAttachment(100, -388);
		FormData fd_txtSenha = new FormData();
		fd_txtSenha.top = new FormAttachment(lblSenha, 6);
		fd_txtSenha.left = new FormAttachment(lblEmail, 0, SWT.LEFT);
		fd_txtSenha.right = new FormAttachment(0, 356);
		txtSenha.setLayoutData(fd_txtSenha);
		
		Button btnConcluir = new Button(shell, SWT.CENTER);
		btnConcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnConcluir.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		FormData fd_btnConcluir = new FormData();
		fd_btnConcluir.left = new FormAttachment(0, 173);
		fd_btnConcluir.bottom = new FormAttachment(100, -197);
		btnConcluir.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		fd_btnConcluir.right = new FormAttachment(100, -182);
		btnConcluir.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		btnConcluir.setLayoutData(fd_btnConcluir);
		btnConcluir.setText("Concluir");
		
		Button btnSouCliente = new Button(shell, SWT.RADIO);
		fd_txtSenha.bottom = new FormAttachment(100, -351);
		lblSenha.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		btnSouCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		FormData fd_btnSouCliente = new FormData();
		fd_btnSouCliente.left = new FormAttachment(lblEmail, 0, SWT.LEFT);
		btnSouCliente.setLayoutData(fd_btnSouCliente);
		btnSouCliente.setText("Sou cliente");
		
		Button btnSouFuncionrio = new Button(shell, SWT.RADIO);
		btnSouFuncionrio.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		fd_btnConcluir.top = new FormAttachment(btnSouFuncionrio, 22);
		FormData fd_btnSouFuncionrio = new FormData();
		fd_btnSouFuncionrio.left = new FormAttachment(lblEmail, 0, SWT.LEFT);
		btnSouFuncionrio.setLayoutData(fd_btnSouFuncionrio);
		btnSouFuncionrio.setText("Sou funcionário");
		
		btnSouEntregador = new Button(shell, SWT.RADIO);
		btnSouEntregador.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		fd_btnSouFuncionrio.top = new FormAttachment(btnSouEntregador, 6);
		fd_btnSouCliente.bottom = new FormAttachment(100, -308);
		btnSouEntregador.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		FormData fd_btnSouEntregador = new FormData();
		fd_btnSouEntregador.top = new FormAttachment(btnSouCliente, 6);
		fd_btnSouEntregador.left = new FormAttachment(lblEmail, 0, SWT.LEFT);
		btnSouEntregador.setLayoutData(fd_btnSouEntregador);
		btnSouEntregador.setText("Sou entregador");
		
		lblSaudacao = new Label(shell, SWT.NONE);
		lblSaudacao.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblSaudacao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		FormData fd_lblSaudacao = new FormData();
		fd_lblSaudacao.top = new FormAttachment(composite, 58);
		fd_lblSaudacao.right = new FormAttachment(100, -149);
		lblSaudacao.setLayoutData(fd_lblSaudacao);
		lblSaudacao.setText("Bem vindo ao ______!");

	}
	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(),shell);
	}
}
