package view;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class EntregadorInfoPedido extends Composite {
		
	private LocalResourceManager localResourceManager;
	private Display display = getDisplay();

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}


    public EntregadorInfoPedido(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setSize(482, 774);
		setLayout(new FormLayout());
		
		Integer numItens = 20;
		
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
		GridLayout gl_compositePedido = new GridLayout(2, false);
		gl_compositePedido.marginLeft = 40;
		gl_compositePedido.verticalSpacing = 15;
		compositePedido.setLayout(gl_compositePedido);
		
		Composite compositeRestauranteInfo = new Composite(compositePedido, SWT.NONE);
		GridData gd_compositeRestauranteInfo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeRestauranteInfo.widthHint = 387;
		gd_compositeRestauranteInfo.heightHint = 125;
		compositeRestauranteInfo.setLayoutData(gd_compositeRestauranteInfo);
		compositeRestauranteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblNomeRestaurante = new Label(compositeRestauranteInfo, SWT.NONE);
		lblNomeRestaurante.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblNomeRestaurante.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNomeRestaurante.setBounds(34, 44, 340, 28);
		lblNomeRestaurante.setText("New Label");
		
		Label lblEnderecorestaurante = new Label(compositeRestauranteInfo, SWT.NONE);
		lblEnderecorestaurante.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblEnderecorestaurante.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblEnderecorestaurante.setBounds(34, 78, 340, 28);
		lblEnderecorestaurante.setText("EnderecoRestaurante");
		
		Label lblNumpedido = new Label(compositeRestauranteInfo, SWT.NONE);
		lblNumpedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblNumpedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNumpedido.setBounds(34, 10, 239, 28);
		lblNumpedido.setText("NumPedido");
		
		Label labelHorizontalRestauranteInfo = new Label(compositeRestauranteInfo, SWT.SEPARATOR | SWT.HORIZONTAL);
		labelHorizontalRestauranteInfo.setBounds(10, 112, 360, 2);
		
		Composite compositeClienteInfo = new Composite(compositePedido, SWT.NONE);
		GridData gd_compositeClienteInfo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeClienteInfo.heightHint = 141;
		compositeClienteInfo.setLayoutData(gd_compositeClienteInfo);
		compositeClienteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblNomecliente = new Label(compositeClienteInfo, SWT.NONE);
		lblNomecliente.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblNomecliente.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNomecliente.setBounds(28, 10, 339, 25);
		lblNomecliente.setText("NomeCliente");
		
		Label lblPrevisoDeEntrega = new Label(compositeClienteInfo, SWT.NONE);
		lblPrevisoDeEntrega.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblPrevisoDeEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrevisoDeEntrega.setAlignment(SWT.CENTER);
		lblPrevisoDeEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblPrevisoDeEntrega.setBounds(10, 72, 339, 25);
		lblPrevisoDeEntrega.setText("Previsão de entrega:");
		
		Label labelHoraEntrega = new Label(compositeClienteInfo, SWT.NONE);
		labelHoraEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		labelHoraEntrega.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(36, 123, 160))));
		labelHoraEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		labelHoraEntrega.setAlignment(SWT.CENTER);
		labelHoraEntrega.setBounds(127, 96, 117, 25);
		labelHoraEntrega.setText("22:21 - 22:31");
		
		Label lblHorizontalclienteinfo = new Label(compositeClienteInfo, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblHorizontalclienteinfo.setText("HorizontalClienteInfo");
		lblHorizontalclienteinfo.setBounds(10, 129, 360, 2);
		
		Label lblEndereco = new Label(compositeClienteInfo, SWT.NONE);
		lblEndereco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblEndereco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblEndereco.setBounds(27, 41, 360, 25);
		lblEndereco.setText("Endereco");
		
		Composite compositeStatus = new Composite(compositePedido, SWT.NONE);
		GridData gd_compositeStatus = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeStatus.heightHint = 120;
		compositeStatus.setLayoutData(gd_compositeStatus);
		compositeStatus.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		
		Label lblStatusEmRota = new Label(compositeStatus, SWT.NONE);
		lblStatusEmRota.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblStatusEmRota.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblStatusEmRota.setAlignment(SWT.CENTER);
		lblStatusEmRota.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblStatusEmRota.setBounds(0, 10, 384, 25);
		lblStatusEmRota.setText("Status: Em rota de entrega");
		
		Label label = new Label(compositeStatus, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(108, 41, 162, 2);
		
		Label lblMudarStatusPara = new Label(compositeStatus, SWT.NONE);
		lblMudarStatusPara.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblMudarStatusPara.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblMudarStatusPara.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblMudarStatusPara.setBounds(27, 49, 240, 20);
		lblMudarStatusPara.setText("Mudar status para:");
		
		Button btnPedidoEntregue = new Button(compositeStatus, SWT.NONE);
		btnPedidoEntregue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnPedidoEntregue.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnPedidoEntregue.getBounds();
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));
				
				gc.setAntialias(SWT.ON);
				gc.setBackground(white);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
				
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Pedido entregue";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);
				
				white.dispose();
			}
		});
		btnPedidoEntregue.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnPedidoEntregue.setBounds(109, 75, 161, 30);
		btnPedidoEntregue.setText("Pedido entregue");
		
		Composite compositeItensPedido = new Composite(compositePedido, SWT.NONE);
		GridLayout gl_compositeItensPedido = new GridLayout(2, false);
		gl_compositeItensPedido.marginLeft = 15;
		compositeItensPedido.setLayout(gl_compositeItensPedido);
		GridData gd_compositeItensPedido = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeItensPedido.widthHint = 380;
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
		
		for(int i = 0; i < numItens; i++) {
			Label lblItem = new Label(compositeItens, SWT.WRAP);
			lblItem.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
			lblItem.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblItem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			GridData gd_lblItem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblItem.widthHint = 223;
			lblItem.setLayoutData(gd_lblItem);
			lblItem.setText("Item");
			
			Label lblPreco = new Label(compositeItens, SWT.NONE);
			lblPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
			lblPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			GridData gd_lblPreco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblPreco.widthHint = 84;
			lblPreco.setLayoutData(gd_lblPreco);
			lblPreco.setText("Preco");
		}	
		
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
		lblPrecototal.setText("PrecoTotal");
		
		Composite compositeButtons = new Composite(compositePedido, SWT.NONE);
		compositeButtons.setLayout(null);
		compositeButtons.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_compositeButtons = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_compositeButtons.heightHint = 51;
		gd_compositeButtons.widthHint = 389;
		compositeButtons.setLayoutData(gd_compositeButtons);
		
		Button btnCalcularRota = new Button(compositeButtons, SWT.NONE);
		btnCalcularRota.setBounds(33, 5, 133, 35);
		btnCalcularRota.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnCalcularRota.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		btnCalcularRota.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		btnCalcularRota.setText("Calcular rota");
		btnCalcularRota.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnCalcularRota.getBounds();
				Color blue = new Color(getDisplay(), new RGB(0, 100, 141));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));
				
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
				
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Calcular rota";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);
				
				blue.dispose();
				white.dispose();
			}
		});
		
		Button btnReportarErro = new Button(compositeButtons, SWT.NONE);
		btnReportarErro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnReportarErro.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnReportarErro.getBounds();
				Color blue = new Color(getDisplay(), new RGB(0, 100, 141));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));
				
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
				
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Reportar erro";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);
				
				blue.dispose();
				white.dispose();
			}
		});
		btnReportarErro.setBounds(203, 5, 133, 35);
		btnReportarErro.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		btnReportarErro.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnReportarErro.setText("Reportar erro");
		btnReportarErro.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		
		scrolledComposite.setContent(compositePedido);
		scrolledComposite.setMinSize(compositePedido.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	
	}
}
