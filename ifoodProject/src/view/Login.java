package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Text;

import database.DBConnection;
import database.UsuarioBanco;
import model.Cliente;
import model.Entregador;
import model.Funcionario;
import model.Usuario;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Login extends Composite {

    private LocalResourceManager localResourceManager;
    private UsuarioBanco banco;
    private Usuario usuario;
    private Funcionario funcionarioLogado = null;
    private Cliente clienteLogado = null;
    private Entregador entregadorLogado = null;
    private String tipoUsuario;
    private DBConnection connection = new DBConnection();

    public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

	public Cliente getClienteLogado() {
		return clienteLogado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setClienteLogado(Cliente clienteLogado) {
		this.clienteLogado = clienteLogado;
	}

	public Entregador getEntregadorLogado() {
		return entregadorLogado;
	}

	public void setEntregadorLogado(Entregador entregadorLogado) {
		this.entregadorLogado = entregadorLogado;
	}

    public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Login(Composite parent, MainPage mainpage) {
        super(parent, SWT.NONE);
        createResourceManager();
        setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        setSize(466, 780);
        setLayout(new FormLayout());
        
        this.clienteLogado = new Cliente();
        this.funcionarioLogado = new Funcionario();
        this.entregadorLogado = new Entregador();
        
        Composite composite = new Composite(this, SWT.NONE);
        FormData fd_composite = new FormData();
        fd_composite.bottom = new FormAttachment(0, 68);
        fd_composite.right = new FormAttachment(0, 464);
        fd_composite.top = new FormAttachment(0);
        fd_composite.left = new FormAttachment(0);
        composite.setLayoutData(fd_composite);
        composite.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
        
        Label lbLogin = new Label(composite, SWT.CENTER);
        lbLogin.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lbLogin.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
        lbLogin.setText("Login");
        lbLogin.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 18, SWT.BOLD)));
        lbLogin.setBounds(191, 10, 78, 48);
        
        Label lblEmail = new Label(this, SWT.NONE);
        lblEmail.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 14, SWT.NORMAL)));
        lblEmail.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        FormData fd_lblEmail = new FormData();
        fd_lblEmail.left = new FormAttachment(0, 95);
        fd_lblEmail.right = new FormAttachment(100, -260);
        lblEmail.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
        lblEmail.setLayoutData(fd_lblEmail);
        lblEmail.setText("Email");
        
        ViewForm viewForm = new ViewForm(this, SWT.NONE);
        FormData fd_viewForm = new FormData();
        fd_viewForm.top = new FormAttachment(0, 298);
        fd_viewForm.left = new FormAttachment(0, 5);
        viewForm.setLayoutData(fd_viewForm);
        
        Text textEmail = new Text(this, SWT.BORDER);
        fd_lblEmail.bottom = new FormAttachment(100, -491);
        FormData fd_textEmail = new FormData();
        fd_textEmail.top = new FormAttachment(lblEmail, 6);
        fd_textEmail.left = new FormAttachment(lblEmail, 0, SWT.LEFT);
        fd_textEmail.right = new FormAttachment(100, -108);
        textEmail.setLayoutData(fd_textEmail);
        
        Label lblSenha = new Label(this, SWT.NONE);
        fd_textEmail.bottom = new FormAttachment(lblSenha, -35);
        lblSenha.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 14, SWT.NORMAL)));
        lblSenha.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        FormData fd_lblSenha = new FormData();
        fd_lblSenha.left = new FormAttachment(0, 96);
        lblSenha.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
        lblSenha.setLayoutData(fd_lblSenha);
        lblSenha.setText("Senha");
        
        Text txtSenha = new Text(this, SWT.BORDER | SWT.PASSWORD);
        fd_lblSenha.bottom = new FormAttachment(100, -388);
        FormData fd_txtSenha = new FormData();
        fd_txtSenha.top = new FormAttachment(lblSenha, 6);
        fd_txtSenha.left = new FormAttachment(lblEmail, 0, SWT.LEFT);
        fd_txtSenha.right = new FormAttachment(0, 356);
        txtSenha.setLayoutData(fd_txtSenha);
        
        Button btnSouCliente = new Button(this, SWT.RADIO);
        btnSouCliente.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        fd_txtSenha.bottom = new FormAttachment(100, -351);
        lblSenha.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        FormData fd_btnSouCliente = new FormData();
        fd_btnSouCliente.left = new FormAttachment(lblEmail, 0, SWT.LEFT);
        btnSouCliente.setLayoutData(fd_btnSouCliente);
        btnSouCliente.setText("Sou cliente");
        
        Button btnSouFuncionario = new Button(this, SWT.RADIO);
        btnSouFuncionario.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        FormData fd_btnSouFuncionario = new FormData();
        fd_btnSouFuncionario.left = new FormAttachment(lblEmail, 0, SWT.LEFT);
        btnSouFuncionario.setLayoutData(fd_btnSouFuncionario);
        btnSouFuncionario.setText("Sou funcionário");
        
        Button btnSouEntregador = new Button(this, SWT.RADIO);
        btnSouEntregador.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        fd_btnSouFuncionario.top = new FormAttachment(btnSouEntregador, 6);
        fd_btnSouCliente.bottom = new FormAttachment(100, -308);
        FormData fd_btnSouEntregador = new FormData();
        fd_btnSouEntregador.top = new FormAttachment(btnSouCliente, 6);
        fd_btnSouEntregador.left = new FormAttachment(lblEmail, 0, SWT.LEFT);
        btnSouEntregador.setLayoutData(fd_btnSouEntregador);
        btnSouEntregador.setText("Sou entregador");
        
        Button btnConcluir = new Button(this, SWT.CENTER);
        btnConcluir.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
        FormData fd_btnConcluir = new FormData();
        fd_btnConcluir.left = new FormAttachment(0, 173);
        fd_btnConcluir.bottom = new FormAttachment(100, -197);
        btnConcluir.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
        fd_btnConcluir.right = new FormAttachment(100, -182);
        btnConcluir.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        btnConcluir.setLayoutData(fd_btnConcluir);
        btnConcluir.setText("Concluir");
        fd_btnConcluir.top = new FormAttachment(btnSouFuncionario, 22);
        btnConcluir.addSelectionListener(new SelectionAdapter() {
            
            private Shell shell;

            @Override
            public void widgetSelected(SelectionEvent e) {
                usuario = new Usuario(textEmail.getText(), txtSenha.getText());
                banco = new UsuarioBanco(connection);
                
                Shell shell = getShell();
                
                if (btnSouCliente.getSelection()) {
                    clienteLogado = banco.logarCliente(usuario);
                    if(clienteLogado != null && clienteLogado.getNome() != null ) {
                        tipoUsuario = "cliente";
                        mainpage.setTipoUsuario(tipoUsuario);
                        mainpage.setCliente(clienteLogado);
                        mainpage.showHomeCliente(clienteLogado);
                    } else {
                        MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
                        messageBox.setMessage("Falha no login. Verifique suas credenciais.");
                        messageBox.open();
                    }

                } else if (btnSouFuncionario.getSelection()) {
                    funcionarioLogado = banco.logarFuncionario(usuario);

                    if(funcionarioLogado != null && funcionarioLogado.getNome() != null) {
                        tipoUsuario = "funcionario";
                        mainpage.setTipoUsuario(tipoUsuario);
                        mainpage.setFuncionario(funcionarioLogado);
                        mainpage.showHomeFuncionario();
                    } else {
                        MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
                        messageBox.setMessage("Falha no login. Verifique suas credenciais.");
                        messageBox.open();
                    }

                } else if (btnSouEntregador.getSelection()) {
                    entregadorLogado = banco.logarEntregador(usuario);

                    if(entregadorLogado != null && entregadorLogado.getNome() != null) {
                        tipoUsuario = "entregador";
                        mainpage.setTipoUsuario(tipoUsuario);
                        mainpage.setEntregador(entregadorLogado);
                        mainpage.showHomeEntregador();
                    } else {
                        MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
                        messageBox.setMessage("Falha no login. Verifique suas credenciais.");
                        messageBox.open();
                    }
                }
            }
        });
        
        Label lblSaudacao = new Label(this, SWT.NONE);
        lblSaudacao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblSaudacao.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
        lblSaudacao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
        FormData fd_lblSaudacao = new FormData();
        fd_lblSaudacao.top = new FormAttachment(composite, 58);
        fd_lblSaudacao.left = new FormAttachment(0, 135);
        lblSaudacao.setLayoutData(fd_lblSaudacao);
        lblSaudacao.setText("Bem vindo ao SIEGEG!");
    }

    private void createResourceManager() {
        localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
    }
       
}