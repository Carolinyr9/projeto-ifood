package view;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Shell;

import model.Cliente;
import model.Entregador;
import model.Funcionario;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.LocalResourceManager;

public class MainPage {

	protected Shell shell;
	private LocalResourceManager localResourceManager;
	private String tipoUsuario;
	private Funcionario funcionario;
	private Entregador entregador;
	private Cliente cliente;
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(),shell);
	}
	
	public static void main(String[] args) {
		try {
			MainPage window = new MainPage();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	
	public void showLogin() {
		clearShell();
		Login login = new Login(shell, this);
		FormData fd_login = new FormData();
		fd_login.left = new FormAttachment(0);
		fd_login.right = new FormAttachment(100);
		fd_login.top = new FormAttachment(0);
		fd_login.bottom = new FormAttachment(90, 83); 
		login.setLayoutData(fd_login);
		setTipoUsuario(login.getTipoUsuario());
		shell.layout();
	}

	public void showMenuBarClient() {
		MenuBarCliente menuBarClient = new MenuBarCliente(shell, this, this.cliente);
		FormData fd_menuBarClient = new FormData();
		fd_menuBarClient.bottom = new FormAttachment(100);
		fd_menuBarClient.left = new FormAttachment(0);
		fd_menuBarClient.right = new FormAttachment(100);
		fd_menuBarClient.top = new FormAttachment(96, -50);  
		menuBarClient.setLayoutData(fd_menuBarClient);
	}
	

	public void showHomeCliente() {
		System.out.println(cliente.getNome());
		System.out.println(cliente.getId());
		System.out.println(cliente.getNome());
		clearShell();
		HomeCliente home = new HomeCliente(shell, this, this.cliente);
		FormData fd_homeFuncionario = new FormData();
		fd_homeFuncionario.top = new FormAttachment(0);
		fd_homeFuncionario.left = new FormAttachment(0);
		fd_homeFuncionario.right = new FormAttachment(100);
		fd_homeFuncionario.bottom = new FormAttachment(90, -5);  
		home.setLayoutData(fd_homeFuncionario);
		showMenuBarClient();
		shell.layout();
	}

	public void showClienteInfoProduct(Integer idProduto, Integer idPrato, Cliente cliente) {
		clearShell();
		ClienteInfoProduct infoProduct = new ClienteInfoProduct(shell, this, idProduto, idPrato, cliente);
		FormData fd_infoProduct = new FormData();
		fd_infoProduct.left = new FormAttachment(0);
		fd_infoProduct.right = new FormAttachment(100);
		fd_infoProduct.top = new FormAttachment(0);
		fd_infoProduct.bottom = new FormAttachment(90, -5); 
		infoProduct.setLayoutData(fd_infoProduct);
		showMenuBarClient();
		shell.layout();
	}
	
	public void showClienteCarrinho(Cliente cliente) {
		clearShell();
		ClienteCarrinho carrinho = new ClienteCarrinho(shell, this, cliente);
		FormData fd_carrinho = new FormData();
		fd_carrinho.left = new FormAttachment(0);
		fd_carrinho.right = new FormAttachment(100);
		fd_carrinho.top = new FormAttachment(0);
		fd_carrinho.bottom = new FormAttachment(90, -5); 
		carrinho.setLayoutData(fd_carrinho);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	public void showClientePedidos() {
		clearShell();
		ClientePedidos clientePedidos = new ClientePedidos(shell, this);
		FormData fd_clientePedidos = new FormData();
		fd_clientePedidos.left = new FormAttachment(0);
		fd_clientePedidos.right = new FormAttachment(100);
		fd_clientePedidos.top = new FormAttachment(0);
		fd_clientePedidos.bottom = new FormAttachment(90, -5); 
		clientePedidos.setLayoutData(fd_clientePedidos);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	public void showClienteInfoPedido(Integer id_pedido) {
		clearShell();
		ClienteInfoPedido clienteInfoPedido = new ClienteInfoPedido(shell, this, id_pedido);
		FormData fd_clienteInfoPedido = new FormData();
		fd_clienteInfoPedido.left = new FormAttachment(0);
		fd_clienteInfoPedido.right = new FormAttachment(100);
		fd_clienteInfoPedido.top = new FormAttachment(0);
		fd_clienteInfoPedido.bottom = new FormAttachment(90, -5); 
		clienteInfoPedido.setLayoutData(fd_clienteInfoPedido);
		showMenuBarFuncionario();
		shell.layout();
	}

	public void showMenuBarFuncionario() {
		MenuBarFuncionario menuBarFuncionario = new MenuBarFuncionario(shell, this);
		FormData fd_menuBarFuncionario = new FormData();
		fd_menuBarFuncionario.bottom = new FormAttachment(100);
		fd_menuBarFuncionario.left = new FormAttachment(0);
		fd_menuBarFuncionario.right = new FormAttachment(100);
		fd_menuBarFuncionario.top = new FormAttachment(96, -50);  
		menuBarFuncionario.setLayoutData(fd_menuBarFuncionario);
	}
	
	public void showHomeFuncionario() {
		clearShell();
		HomeFuncionario homeFuncionario = new HomeFuncionario(shell, this);
		FormData fd_homeFuncionario = new FormData();
		fd_homeFuncionario.top = new FormAttachment(0);
		fd_homeFuncionario.left = new FormAttachment(0);
		fd_homeFuncionario.right = new FormAttachment(100);
		fd_homeFuncionario.bottom = new FormAttachment(90, -5);  
		homeFuncionario.setLayoutData(fd_homeFuncionario);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	public void showFuncionarioCardapioInfo(String nomeSessaoCardapio) {
		clearShell();
		FuncionarioCardapioInfo cadCardapioInfo = new FuncionarioCardapioInfo(shell, this, nomeSessaoCardapio);
		FormData fd_cadapioInfo = new FormData();
		fd_cadapioInfo.left = new FormAttachment(0);
		fd_cadapioInfo.right = new FormAttachment(100);
		fd_cadapioInfo.top = new FormAttachment(0);
		fd_cadapioInfo.bottom = new FormAttachment(90, -5); 
		cadCardapioInfo.setLayoutData(fd_cadapioInfo);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	public void showFuncionarioItemCardapioInfo(Integer idProduct, String tipo, String nomeSessaoCardapio) {
		clearShell();
		FuncionarioItemCardapioInfo itemCardapioInfo = new FuncionarioItemCardapioInfo(shell, this, idProduct, tipo, nomeSessaoCardapio);
		FormData fd_itemCardapioInfo = new FormData();
		fd_itemCardapioInfo.left = new FormAttachment(0);
		fd_itemCardapioInfo.right = new FormAttachment(100);
		fd_itemCardapioInfo.top = new FormAttachment(0);
		fd_itemCardapioInfo.bottom = new FormAttachment(90, -5); 
		itemCardapioInfo.setLayoutData(fd_itemCardapioInfo);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	public void showFuncionarioCadPratoCardapio() {
		clearShell();
		FuncionarioCadPratoCardapio cadPratoCardapio = new FuncionarioCadPratoCardapio(shell, this);
		FormData fd_cadPratoCardapio = new FormData();
		fd_cadPratoCardapio.left = new FormAttachment(0);
		fd_cadPratoCardapio.right = new FormAttachment(100);
		fd_cadPratoCardapio.top = new FormAttachment(0);
		fd_cadPratoCardapio.bottom = new FormAttachment(90, -3); 
		cadPratoCardapio.setLayoutData(fd_cadPratoCardapio);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	public void showFuncionarioCadProdutoCardapio() {
		clearShell();
		FuncionarioCadProdutoCardapio cadProdutoCardapio = new FuncionarioCadProdutoCardapio(shell, this);
		FormData fd_cadProdutoCardapio = new FormData();
		fd_cadProdutoCardapio.left = new FormAttachment(0);
		fd_cadProdutoCardapio.right = new FormAttachment(100);
		fd_cadProdutoCardapio.top = new FormAttachment(0);
		fd_cadProdutoCardapio.bottom = new FormAttachment(90, -3); 
		cadProdutoCardapio.setLayoutData(fd_cadProdutoCardapio);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	public void showFuncionarioCadCardapio() {
		clearShell();
		FuncionarioCadCardapio cadCardapio = new FuncionarioCadCardapio(shell, this);
		FormData fd_cadCardapio = new FormData();
		fd_cadCardapio.left = new FormAttachment(0);
		fd_cadCardapio.right = new FormAttachment(100);
		fd_cadCardapio.top = new FormAttachment(0);
		fd_cadCardapio.bottom = new FormAttachment(90, -5); 
		cadCardapio.setLayoutData(fd_cadCardapio);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	public void showFuncionarioPedidos() {
		clearShell();
		FuncionarioPedidos pedidosFuncionario = new FuncionarioPedidos(shell, this);
		FormData fd_pedidosFuncionario = new FormData();
		fd_pedidosFuncionario.left = new FormAttachment(0);
		fd_pedidosFuncionario.right = new FormAttachment(100);
		fd_pedidosFuncionario.top = new FormAttachment(0);
		fd_pedidosFuncionario.bottom = new FormAttachment(90, -5); 
		pedidosFuncionario.setLayoutData(fd_pedidosFuncionario);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	public void showFuncionarioInfoPedido(Integer id_pedido) {
		clearShell();
		FuncionarioInfoPedido funcionarioInfoPedido = new FuncionarioInfoPedido(shell, this, id_pedido);
		FormData fd_funcionarioInfoPedido = new FormData();
		fd_funcionarioInfoPedido.left = new FormAttachment(0);
		fd_funcionarioInfoPedido.right = new FormAttachment(100);
		fd_funcionarioInfoPedido.top = new FormAttachment(0);
		fd_funcionarioInfoPedido.bottom = new FormAttachment(90, -5); 
		funcionarioInfoPedido.setLayoutData(fd_funcionarioInfoPedido);
		showMenuBarEntregador();
		shell.layout();
	}
	
	public void showMenuBarEntregador() {
		MenuBarEntregador menuBarEntregador = new MenuBarEntregador(shell, this);
		FormData fd_menuBarEntregador = new FormData();
		fd_menuBarEntregador.bottom = new FormAttachment(100);
		fd_menuBarEntregador.left = new FormAttachment(0);
		fd_menuBarEntregador.right = new FormAttachment(100);
		fd_menuBarEntregador.top = new FormAttachment(96, -50);  
		menuBarEntregador.setLayoutData(fd_menuBarEntregador);
	}
	
	public void showHomeEntregador() {
		clearShell();
		HomeEntregador homeEntregador = new HomeEntregador(shell, this);
		FormData fd_homeEntregador = new FormData();
		fd_homeEntregador.left = new FormAttachment(0);
		fd_homeEntregador.right = new FormAttachment(100);
		fd_homeEntregador.top = new FormAttachment(0);
		fd_homeEntregador.bottom = new FormAttachment(90, -5); 
		homeEntregador.setLayoutData(fd_homeEntregador);
		showMenuBarEntregador();
		shell.layout();
	}
	
	public void showEntregadorPedidos() {
		clearShell();
		EntregadorPedidos entregadorPedidos = new EntregadorPedidos(shell, this);
		FormData fd_entregadorPedidos = new FormData();
		fd_entregadorPedidos.left = new FormAttachment(0);
		fd_entregadorPedidos.right = new FormAttachment(100);
		fd_entregadorPedidos.top = new FormAttachment(0);
		fd_entregadorPedidos.bottom = new FormAttachment(90, -5); 
		entregadorPedidos.setLayoutData(fd_entregadorPedidos);
		showMenuBarEntregador();
		shell.layout();
	}
	
	public void showEntregadorInfoPedido(Integer id_pedido) {
		clearShell();
		EntregadorInfoPedido entregadorInfoPedido = new EntregadorInfoPedido(shell, this,id_pedido);
		FormData fd_entregadorInfoPedido = new FormData();
		fd_entregadorInfoPedido.left = new FormAttachment(0);
		fd_entregadorInfoPedido.right = new FormAttachment(100);
		fd_entregadorInfoPedido.top = new FormAttachment(0);
		fd_entregadorInfoPedido.bottom = new FormAttachment(90, -5); 
		entregadorInfoPedido.setLayoutData(fd_entregadorInfoPedido);
		showMenuBarEntregador();
		shell.layout();
	}
	
	public void showUsuarioPerfil() {
		clearShell();
		UsuarioPerfil usuarioPerfil = new UsuarioPerfil(shell, this, this.funcionario, this.entregador, this.cliente);
		FormData fd_usuarioPerfil = new FormData();
		fd_usuarioPerfil.left = new FormAttachment(0);
		fd_usuarioPerfil.right = new FormAttachment(100);
		fd_usuarioPerfil.top = new FormAttachment(0);
		fd_usuarioPerfil.bottom = new FormAttachment(90, -5); 
		usuarioPerfil.setLayoutData(fd_usuarioPerfil);
		if(tipoUsuario == "funcionario") {
			showMenuBarFuncionario();
		}else if(tipoUsuario == "entregador") {
			showMenuBarEntregador();
		}else if(tipoUsuario == "cliente") {
			showMenuBarClient();
		}
		shell.layout();
	}	

	protected void createContents() {
		shell = new Shell();
		createResourceManager();
		shell.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255,255,255))));
		shell.setSize(482, 874);
		shell.setText("Início");
		shell.setLayout(new FormLayout());
		
		showLogin();
	}

	private void clearShell() {
		for (Control control : shell.getChildren()) {
			if (!(control instanceof MenuBarCliente)) {
				control.dispose();
			}
		}
	}
}
