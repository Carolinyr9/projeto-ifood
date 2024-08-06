package view;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class FuncionarioInfoPedido extends Composite {
	
	private LocalResourceManager localResourceManager;
	private Display display = getDisplay();
	
	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}
	
	/* Não esqueça de criar a função para pegar os dados do pedido*/


	public FuncionarioInfoPedido(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setSize(482, 774);
		setLayout(new FormLayout());
		
		Integer numItens = 2;
		
		Image arrowIcon = new Image(display, "./src/assets/images/backArrow.png");
		
		Composite compositeHeader = new Composite(this, SWT.NONE);
		compositeHeader.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		FormData fd_compositeHeader = new FormData();
		fd_compositeHeader.top = new FormAttachment(0);
		fd_compositeHeader.left = new FormAttachment(0);
		fd_compositeHeader.bottom = new FormAttachment(0, 73);
		fd_compositeHeader.right = new FormAttachment(0, 482);
		compositeHeader.setLayoutData(fd_compositeHeader);
		
		Label lblTelaTitulo = new Label(compositeHeader, SWT.CENTER);
		lblTelaTitulo.setAlignment(SWT.CENTER);
		lblTelaTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblTelaTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		lblTelaTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
		lblTelaTitulo.setBounds(86, 20, 95, 43);
		lblTelaTitulo.setText("Pedido");
		
		Button btnBack = new Button(compositeHeader, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreenEntregador(2);
			}
		});
		btnBack.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(arrowIcon, 0, 0);
			  }
			} );
		btnBack.setBounds(20, 10, 60, 53);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.top = new FormAttachment(compositeHeader, 6);
		fd_scrolledComposite.bottom = new FormAttachment(100, 10);
		fd_scrolledComposite.right = new FormAttachment(compositeHeader, 0, SWT.RIGHT);
		fd_scrolledComposite.left = new FormAttachment(0);
		scrolledComposite.setLayoutData(fd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite compositePedido = new Composite(scrolledComposite, SWT.NONE);
		compositePedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridLayout gl_compositePedido = new GridLayout(1, false);
		gl_compositePedido.marginLeft = 40;
		gl_compositePedido.verticalSpacing = 15;
		compositePedido.setLayout(gl_compositePedido);
		
		Composite compositeRestauranteInfo = new Composite(compositePedido, SWT.NONE);
		GridData gd_compositeRestauranteInfo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeRestauranteInfo.widthHint = 387;
		gd_compositeRestauranteInfo.heightHint = 93;
		compositeRestauranteInfo.setLayoutData(gd_compositeRestauranteInfo);
		compositeRestauranteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblStatus = new Label(compositeRestauranteInfo, SWT.NONE);
		lblStatus.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblStatus.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblStatus.setBounds(30, 44, 340, 28);
		/* Colocar aqui qual o status do pedido dentro do setText()*/
		lblStatus.setText("Status: Em confirmação");
		
		Label lblNumpedido = new Label(compositeRestauranteInfo, SWT.NONE);
		lblNumpedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblNumpedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNumpedido.setBounds(34, 10, 239, 28);
		/* Colocar aqui o número do pedido dentro do setText()*/
		lblNumpedido.setText("NumPedido");
		
		Label labelHorizontalRestauranteInfo = new Label(compositeRestauranteInfo, SWT.SEPARATOR | SWT.HORIZONTAL);
		labelHorizontalRestauranteInfo.setBounds(10, 78, 360, 2);
		
		Composite compositeStatus = new Composite(compositePedido, SWT.NONE);
		GridData gd_compositeStatus = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeStatus.widthHint = 388;
		gd_compositeStatus.heightHint = 146;
		compositeStatus.setLayoutData(gd_compositeStatus);
		compositeStatus.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblMudarStatusPara = new Label(compositeStatus, SWT.NONE);
		lblMudarStatusPara.setAlignment(SWT.CENTER);
		lblMudarStatusPara.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblMudarStatusPara.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblMudarStatusPara.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblMudarStatusPara.setBounds(69, 10, 240, 20);
		lblMudarStatusPara.setText("Mudar status para:");
		
		Button btnStatus = new Button(compositeStatus, SWT.NONE);
		btnStatus.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		btnStatus.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		btnStatus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/* Colocar aqui a função que vai fazer a mudança de status do pedido*/
			}
		});
		btnStatus.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnStatus.getBounds();
				Color blue = new Color(getDisplay(), new RGB(19, 41, 61));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));
				
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
				
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Em preparo";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);
				
				blue.dispose();
				white.dispose();
			}
		});
		btnStatus.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		btnStatus.setBounds(125, 36, 145, 30);
		/* Colocar aqui o status do pedido, dentro do setText()*/
		btnStatus.setText("Em preparo");
		
		Label lblPrevisoDeEntrega_1 = new Label(compositeStatus, SWT.NONE);
		lblPrevisoDeEntrega_1.setText("Previsão de entrega:");
		lblPrevisoDeEntrega_1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(36, 123, 160))));
		lblPrevisoDeEntrega_1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblPrevisoDeEntrega_1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrevisoDeEntrega_1.setBounds(20, 72, 339, 25);
		
		Label labelHoraEntrega = new Label(compositeStatus, SWT.NONE);
		/* Colocar aqui a previsão de entrega do pedido, dentro do setText()*/
		labelHoraEntrega.setText("22:21 - 22:31");
		labelHoraEntrega.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(36, 123, 160))));
		labelHoraEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		labelHoraEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		labelHoraEntrega.setAlignment(SWT.CENTER);
		labelHoraEntrega.setBounds(129, 99, 117, 25);
		
		Label label = new Label(compositeStatus, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 134, 368, 2);
		
		Composite compositeItensPedido = new Composite(compositePedido, SWT.NONE);
		GridLayout gl_compositeItensPedido = new GridLayout(2, false);
		gl_compositeItensPedido.marginLeft = 15;
		compositeItensPedido.setLayout(gl_compositeItensPedido);
		GridData gd_compositeItensPedido = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeItensPedido.widthHint = 388;
		compositeItensPedido.setLayoutData(gd_compositeItensPedido);
		compositeItensPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblResumoDoPedido = new Label(compositeItensPedido, SWT.NONE);
		lblResumoDoPedido.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblResumoDoPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblResumoDoPedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblResumoDoPedido.setText("Resumo do pedido");
		
		Composite compositeItens = new Composite(compositeItensPedido, SWT.NONE);
		GridData gd_compositeItens = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeItens.widthHint = 340;
		compositeItens.setLayoutData(gd_compositeItens);
		compositeItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridLayout gl_compositeItens = new GridLayout(2, false);
		gl_compositeItens.marginLeft = 10;
		gl_compositeItens.horizontalSpacing = 10;
		compositeItens.setLayout(gl_compositeItens);
		
		Label lblTotal = new Label(compositeItensPedido, SWT.NONE);
		GridData gd_lblTotal = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTotal.widthHint = 217;
		lblTotal.setLayoutData(gd_lblTotal);
		lblTotal.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblTotal.setText("Total");
		
		Label lblPrecototal = new Label(compositeItensPedido, SWT.NONE);
		lblPrecototal.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblPrecototal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecototal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		/* Colocar aqui o preço total do pedido (com a taxa de entrega e o todo do pedido), dentro do setText()*/
		lblPrecototal.setText("PrecoTotal");
		
		Composite compositeClienteInfo = new Composite(compositePedido, SWT.NONE);
		GridData gd_compositeClienteInfo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeClienteInfo.heightHint = 141;
		compositeClienteInfo.setLayoutData(gd_compositeClienteInfo);
		compositeClienteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		
		Label lblNomeCliente = new Label(compositeClienteInfo, SWT.NONE);
		lblNomeCliente.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 0, 0))));
		lblNomeCliente.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblNomeCliente.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblNomeCliente.setBounds(28, 37, 339, 25);
		/* Colocar aqui o nome do cliente que fez o pedido, dentro do setText()*/
		lblNomeCliente.setText("NomeCliente");
		
		Label lblEnderecoCliente = new Label(compositeClienteInfo, SWT.NONE);
		lblEnderecoCliente.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 0, 0))));
		lblEnderecoCliente.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblEnderecoCliente.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblEnderecoCliente.setBounds(28, 94, 360, 25);
		/* Colocar aqui o endereço do cliente que fez o pedido, dentro do setText()*/
		lblEnderecoCliente.setText("Endereco");
		
		Label lblCliente = new Label(compositeClienteInfo, SWT.NONE);
		lblCliente.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblCliente.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblCliente.setBounds(28, 11, 70, 20);
		lblCliente.setText("Cliente");
		
		Label lblEndereco = new Label(compositeClienteInfo, SWT.NONE);
		lblEndereco.setText("Endereço");
		lblEndereco.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblEndereco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblEndereco.setBounds(28, 68, 70, 20);
		
		/* Colocar aqui a função para pegar os itens do pedido
		 * 
		 * Abaixo tem um loop que vai mostrar todos os itens comprados pelo cliente, com seus respectivos preços*/
		for(int i = 0; i < numItens; i++) {
			Label lblItem = new Label(compositeItens, SWT.WRAP);
			lblItem.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
			lblItem.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblItem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			GridData gd_lblItem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblItem.widthHint = 223;
			lblItem.setLayoutData(gd_lblItem);
			/* Colocar aqui o nome do item, dentro do setText()*/
			lblItem.setText("Item");
			
			Label lblPreco = new Label(compositeItens, SWT.NONE);
			lblPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
			lblPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			GridData gd_lblPreco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblPreco.widthHint = 84;
			lblPreco.setLayoutData(gd_lblPreco);
			/* Colocar aqui o preço do item, dentro do setText()*/
			lblPreco.setText("Preco");
		}
		
		scrolledComposite.setContent(compositePedido);
		scrolledComposite.setMinSize(compositePedido.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	
	}
}
