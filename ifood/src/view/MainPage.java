package view;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Shell;
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
		
//		showHomeCliente();
		showHomeFuncionario();
//		showHomeEntregador();
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
	

	private void showHomeCliente() {
		clearShell();
		HomeCliente home = new HomeCliente(shell, this);
		FormData fd_homeFuncionario = new FormData();
		fd_homeFuncionario.top = new FormAttachment(0);
		fd_homeFuncionario.left = new FormAttachment(0);
		fd_homeFuncionario.right = new FormAttachment(100);
		fd_homeFuncionario.bottom = new FormAttachment(90, -50);  
		home.setLayoutData(fd_homeFuncionario);
		showMenuBarClient();
		shell.layout();
	}

	private void showClienteInfoProduct() {
		clearShell();
		ClienteInfoProduct infoProduct = new ClienteInfoProduct(shell, this);
		FormData fd_infoProduct = new FormData();
		fd_infoProduct.left = new FormAttachment(0);
		fd_infoProduct.right = new FormAttachment(100);
		fd_infoProduct.top = new FormAttachment(0);
		fd_infoProduct.bottom = new FormAttachment(90, -50); 
		infoProduct.setLayoutData(fd_infoProduct);
		showMenuBarClient();
		shell.layout();
	}
	
	public void showClienteCarrinho(Integer idProduto,String nomeProduto,String descricao,Double preco,String nomeRestaurante,String enderecoRestaurante) {
		clearShell();
		ClienteCarrinho carrinho = new ClienteCarrinho(shell, this, idProduto, nomeProduto, descricao, preco, nomeRestaurante, enderecoRestaurante);
		FormData fd_carrinho = new FormData();
		fd_carrinho.left = new FormAttachment(0);
		fd_carrinho.right = new FormAttachment(100);
		fd_carrinho.top = new FormAttachment(0);
		fd_carrinho.bottom = new FormAttachment(90, -50); 
		carrinho.setLayoutData(fd_carrinho);
		showMenuBarFuncionario();
		shell.layout();
	}

	private void showMenuBarFuncionario() {
		MenuBarFuncionario menuBarFuncionario = new MenuBarFuncionario(shell, this);
		FormData fd_menuBarFuncionario = new FormData();
		fd_menuBarFuncionario.bottom = new FormAttachment(100);
		fd_menuBarFuncionario.left = new FormAttachment(0);
		fd_menuBarFuncionario.right = new FormAttachment(100);
		fd_menuBarFuncionario.top = new FormAttachment(96, -50);  
		menuBarFuncionario.setLayoutData(fd_menuBarFuncionario);
	}
	
	private void showHomeFuncionario() {
		clearShell();
		HomeFuncionario homeFuncionario = new HomeFuncionario(shell, this);
		FormData fd_homeFuncionario = new FormData();
		fd_homeFuncionario.top = new FormAttachment(0);
		fd_homeFuncionario.left = new FormAttachment(0);
		fd_homeFuncionario.right = new FormAttachment(100);
		fd_homeFuncionario.bottom = new FormAttachment(90, -50);  
		homeFuncionario.setLayoutData(fd_homeFuncionario);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	private void showFuncionarioCardapioInfo() {
		clearShell();
		FuncionarioCardapioInfo cadCardapioInfo = new FuncionarioCardapioInfo(shell, this);
		FormData fd_cadapioInfo = new FormData();
		fd_cadapioInfo.left = new FormAttachment(0);
		fd_cadapioInfo.right = new FormAttachment(100);
		fd_cadapioInfo.top = new FormAttachment(0);
		fd_cadapioInfo.bottom = new FormAttachment(90, -50); 
		cadCardapioInfo.setLayoutData(fd_cadapioInfo);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	public void showFuncionarioItemCardapioInfo(Integer idProduct, Integer idCardapio, String nomeProduto, Double preco, String ingredientes, String descricao) {
		clearShell();
		FuncionarioItemCardapioInfo itemCardapioInfo = new FuncionarioItemCardapioInfo(shell, this, idProduct, idCardapio, nomeProduto, preco, ingredientes, descricao);
		FormData fd_itemCardapioInfo = new FormData();
		fd_itemCardapioInfo.left = new FormAttachment(0);
		fd_itemCardapioInfo.right = new FormAttachment(100);
		fd_itemCardapioInfo.top = new FormAttachment(0);
		fd_itemCardapioInfo.bottom = new FormAttachment(90, -50); 
		itemCardapioInfo.setLayoutData(fd_itemCardapioInfo);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	private void showFuncionarioCadItemCardapio() {
		clearShell();
		FuncionarioCadItemCardapio cadItemCardapio = new FuncionarioCadItemCardapio(shell, this);
		FormData fd_cadItemCardapio = new FormData();
		fd_cadItemCardapio.left = new FormAttachment(0);
		fd_cadItemCardapio.right = new FormAttachment(100);
		fd_cadItemCardapio.top = new FormAttachment(0);
		fd_cadItemCardapio.bottom = new FormAttachment(90, -50); 
		cadItemCardapio.setLayoutData(fd_cadItemCardapio);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	private void showFuncionarioCadCardapio() {
		clearShell();
		FuncionarioCadCardapio cadCardapio = new FuncionarioCadCardapio(shell, this);
		FormData fd_cadCardapio = new FormData();
		fd_cadCardapio.left = new FormAttachment(0);
		fd_cadCardapio.right = new FormAttachment(100);
		fd_cadCardapio.top = new FormAttachment(0);
		fd_cadCardapio.bottom = new FormAttachment(90, -50); 
		cadCardapio.setLayoutData(fd_cadCardapio);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	private void showFuncionarioPedidos() {
		clearShell();
		FuncionarioPedidos pedidosFuncionario = new FuncionarioPedidos(shell, this);
		FormData fd_pedidosFuncionario = new FormData();
		fd_pedidosFuncionario.left = new FormAttachment(0);
		fd_pedidosFuncionario.right = new FormAttachment(100);
		fd_pedidosFuncionario.top = new FormAttachment(0);
		fd_pedidosFuncionario.bottom = new FormAttachment(90, -50); 
		pedidosFuncionario.setLayoutData(fd_pedidosFuncionario);
		showMenuBarFuncionario();
		shell.layout();
	}
	
	private void showFuncionarioInfoPedido() {
		clearShell();
		FuncionarioInfoPedido funcionarioInfoPedido = new FuncionarioInfoPedido(shell, this);
		FormData fd_funcionarioInfoPedido = new FormData();
		fd_funcionarioInfoPedido.left = new FormAttachment(0);
		fd_funcionarioInfoPedido.right = new FormAttachment(100);
		fd_funcionarioInfoPedido.top = new FormAttachment(0);
		fd_funcionarioInfoPedido.bottom = new FormAttachment(90, -50); 
		funcionarioInfoPedido.setLayoutData(fd_funcionarioInfoPedido);
		showMenuBarEntregador();
		shell.layout();
	}
	
	private void showMenuBarEntregador() {
		MenuBarEntregador menuBarEntregador = new MenuBarEntregador(shell, this);
		FormData fd_menuBarEntregador = new FormData();
		fd_menuBarEntregador.bottom = new FormAttachment(100);
		fd_menuBarEntregador.left = new FormAttachment(0);
		fd_menuBarEntregador.right = new FormAttachment(100);
		fd_menuBarEntregador.top = new FormAttachment(96, -50);  
		menuBarEntregador.setLayoutData(fd_menuBarEntregador);
	}
	
	private void showHomeEntregador() {
		clearShell();
		HomeEntregador homeEntregador = new HomeEntregador(shell, this);
		FormData fd_homeEntregador = new FormData();
		fd_homeEntregador.left = new FormAttachment(0);
		fd_homeEntregador.right = new FormAttachment(100);
		fd_homeEntregador.top = new FormAttachment(0);
		fd_homeEntregador.bottom = new FormAttachment(90, -50); 
		homeEntregador.setLayoutData(fd_homeEntregador);
		showMenuBarEntregador();
		shell.layout();
	}
	
	private void showEntregadorPedidos() {
		clearShell();
		EntregadorPedidos entregadorPedidos = new EntregadorPedidos(shell, this);
		FormData fd_entregadorPedidos = new FormData();
		fd_entregadorPedidos.left = new FormAttachment(0);
		fd_entregadorPedidos.right = new FormAttachment(100);
		fd_entregadorPedidos.top = new FormAttachment(0);
		fd_entregadorPedidos.bottom = new FormAttachment(90, -50); 
		entregadorPedidos.setLayoutData(fd_entregadorPedidos);
		showMenuBarEntregador();
		shell.layout();
	}
	
	private void showEntregadorInfoPedido() {
		clearShell();
		EntregadorInfoPedido entregadorInfoPedido = new EntregadorInfoPedido(shell, this);
		FormData fd_entregadorInfoPedido = new FormData();
		fd_entregadorInfoPedido.left = new FormAttachment(0);
		fd_entregadorInfoPedido.right = new FormAttachment(100);
		fd_entregadorInfoPedido.top = new FormAttachment(0);
		fd_entregadorInfoPedido.bottom = new FormAttachment(90, -50); 
		entregadorInfoPedido.setLayoutData(fd_entregadorInfoPedido);
		showMenuBarEntregador();
		shell.layout();
	}
	
	protected void navigateToScreen(int screenNumber) {
		switch (screenNumber) {
		case 1:
			showHomeCliente();
			break;
		case 2:
			showClienteInfoProduct();
			break;
		case 3:
//			showClienteCarrinho();
			break;
		default:
			showHomeCliente();
			break;
		}
	}
	
	protected void navigateToScreenEmployee(int screenNumber) {
		switch (screenNumber) {
		case 1:
			showHomeFuncionario();
			break;
		case 2:
			showFuncionarioCardapioInfo();
			break;
		case 3:
			showFuncionarioPedidos();
			break;
		case 4:
			showFuncionarioCadItemCardapio();
			break;
		case 5:
			showFuncionarioCadCardapio();
			break;
		case 6:
			showFuncionarioInfoPedido();
			break;
		default:
			showHomeFuncionario();
			break;
		}
	}
	
	protected void navigateToScreenEntregador(int screenNumber) {
		switch (screenNumber) {
		case 1:
			showHomeEntregador();
			break;
		case 2:
			showEntregadorPedidos();
			break;
		case 3:
			showEntregadorInfoPedido();
			break;
		case 4:
//			showEntregadorInfoPedido();
			break;
		default:
			showHomeEntregador();
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

