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

import model.Cliente;
import model.Entregador;
import model.Funcionario;
import model.Usuario;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class UsuarioPerfil extends Composite {
		
	private LocalResourceManager localResourceManager;
	private Label lblNomeusuario;
	private Label lblEmailusuario;
	private Label lblCpfusuario;
	private Label lblCodfuncionalusuario;
	private Label lblCnhusuario;
	private Label labelTelefoneUsuario;
	private Label lblEnderecoUsuario;
	private Funcionario funcionario;
	private Entregador entregador;
	private Cliente cliente ;

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}


    public UsuarioPerfil(Composite parent, MainPage mainPage,Funcionario funcionarioLogado,Entregador entregadoLogado,Cliente clienteLogado) {
		super(parent, SWT.NONE);
		createResourceManager();
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		setSize(482, 774);
		setLayout(null);
		
		funcionario = funcionarioLogado;
		entregador = entregadoLogado;
		cliente = clienteLogado;
		
		Label lblPerfil = new Label(this, SWT.NONE);
		lblPerfil.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPerfil.setBounds(22, 26, 108, 37);
		lblPerfil.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblPerfil.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
		lblPerfil.setText("Perfil");

		lblNomeusuario = new Label(this, SWT.NONE);
		lblNomeusuario.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNomeusuario.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblNomeusuario.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblNomeusuario.setBounds(56, 113, 378, 25);
		
		lblEmailusuario = new Label(this, SWT.NONE);
		lblEmailusuario.setBounds(56, 177, 378, 25);
		lblEmailusuario.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblEmailusuario.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblEmailusuario.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		
		lblCpfusuario = new Label(this, SWT.NONE);
		lblCpfusuario.setBounds(56, 230, 378, 25);
		lblCpfusuario.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblCpfusuario.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblCpfusuario.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		
		lblCodfuncionalusuario = new Label(this, SWT.NONE);
		lblCodfuncionalusuario.setBounds(56, 288, 378, 20);
		lblCodfuncionalusuario.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblCodfuncionalusuario.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblCodfuncionalusuario.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		
		lblCnhusuario = new Label(this, SWT.NONE);
		lblCnhusuario.setBounds(56, 337, 374, 25);
		lblCnhusuario.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblCnhusuario.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblCnhusuario.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		
		labelTelefoneUsuario = new Label(this, SWT.NONE);
		labelTelefoneUsuario.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		labelTelefoneUsuario.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		labelTelefoneUsuario.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		labelTelefoneUsuario.setBounds(56, 341, 378, 25);
		
		lblEnderecoUsuario = new Label(this, SWT.NONE);
		lblEnderecoUsuario.setBounds(56, 283, 378, 25);
		lblEnderecoUsuario.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblEnderecoUsuario.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblEnderecoUsuario.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		
		setLabels();
		
		Button btnLogoff = new Button(this, SWT.NONE);
		btnLogoff.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/* Colocar aqui evento de logoff*/
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
    
    private void setLabels() {
    	if(funcionario != null) {
    		lblNomeusuario.setText("Nome: " + funcionario.getNome());
    		lblCodfuncionalusuario.setText("Código Funcional: " + funcionario.getCodFuncional().toString());
    		lblEmailusuario.setText("Email: " + funcionario.getEmail());
    		lblCpfusuario.setText("CPF: " + funcionario.getCpf().toString());
    	}else if(entregador != null) {
    		lblNomeusuario.setText("Nome: " + entregador.getNome());
    		lblCnhusuario.setText("CNH: " + entregador.getCnh().toString());
    		lblEmailusuario.setText("Email: " + entregador.getEmail());
    		lblCpfusuario.setText("CPF: " + entregador.getCpf().toString());
    		lblEnderecoUsuario.setText("Endereço: " + entregador.getEndereco());
    	}else if(cliente != null) {
    		lblNomeusuario.setText("Nome: " + cliente.getNome());
    		lblEmailusuario.setText("Email: " + cliente.getEmail());
    		lblCpfusuario.setText("CPF: " + cliente.getCpf().toString());
    		lblEnderecoUsuario.setText("Endereço: " + cliente.getEndereco());
    	}
    }
}
