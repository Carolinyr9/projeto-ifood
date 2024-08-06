package view;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class EntregadorPedidos extends Composite {
	
private LocalResourceManager localResourceManager;

/* Tinha utilizados essas variáveis para fazer testes, mas não precisa necessariamente usar todas elas
 * 
 * 				numPedidosRotaEntrega = é a quantidade de pedidos que estão em andamento 
 * 
 * 				pedidosRotaEntregaList = é uma lista onde tem todos os pedidos em andamento
 *  			pedidoRotaEntrega = essa variável não precisa ser usada
 * */
private Integer numPedidosRotaEntrega;
private ArrayList<List<String>> pedidosRotaEntregaList; 
private List<String> pedidoRotaEntrega;

private void createResourceManager() {
	localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
}

public EntregadorPedidos(Composite parent, MainPage mainPage) {
	super(parent, SWT.NONE);
	createResourceManager();
	setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
	setSize(482, 774);
	setLayout(new FormLayout());
	
	/*Grupo de teste, depois excluir*/
	numPedidosRotaEntrega = 3;
	pedidosRotaEntregaList = new ArrayList<>();
    pedidoRotaEntrega = new ArrayList<>();
    pedidoRotaEntrega.add("1234");
    pedidoRotaEntrega.add("Em Andamento");
    pedidoRotaEntrega.add("José de Fátima");
    pedidoRotaEntrega.add("Rua Bom Te Ver, 23");
    pedidoRotaEntrega.add("23,55");
    pedidosRotaEntregaList.add(pedidoRotaEntrega);
    pedidosRotaEntregaList.add(pedidoRotaEntrega);
    System.out.println(pedidosRotaEntregaList);
    numPedidosRotaEntrega = pedidosRotaEntregaList.size();
	
	Composite compositeHeader = new Composite(this, SWT.NONE);
	compositeHeader.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
	FormData fd_compositeHeader = new FormData();
	fd_compositeHeader.top = new FormAttachment(0);
	fd_compositeHeader.left = new FormAttachment(0);
	fd_compositeHeader.bottom = new FormAttachment(0, 73);
	fd_compositeHeader.right = new FormAttachment(0, 482);
	compositeHeader.setLayoutData(fd_compositeHeader);
	
	Label lblItem1 = new Label(compositeHeader, SWT.CENTER);
	lblItem1.setText("Pedidos");
	lblItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
	lblItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
	lblItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
	lblItem1.setBounds(22, 26, 108, 37);
	
	ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
	scrolledComposite.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
	FormData fd_scrolledComposite = new FormData();
	fd_scrolledComposite.top = new FormAttachment(0, 79);
	fd_scrolledComposite.bottom = new FormAttachment(100);
	fd_scrolledComposite.left = new FormAttachment(0);
	fd_scrolledComposite.right = new FormAttachment(0, 482);
	scrolledComposite.setLayoutData(fd_scrolledComposite);
	scrolledComposite.setExpandHorizontal(true);
	scrolledComposite.setExpandVertical(true);
	
	Composite compositePedidos = new Composite(scrolledComposite, SWT.NONE);
	compositePedidos.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
	GridLayout gl_compositePedidos = new GridLayout(1, false);
	gl_compositePedidos.verticalSpacing = 15;
	gl_compositePedidos.marginLeft = 30;
	compositePedidos.setLayout(gl_compositePedidos);
	
	Composite compositePedidosAndamento = new Composite(compositePedidos, SWT.NONE);
	compositePedidosAndamento.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
	GridLayout gl_compositePedidosAndamento = new GridLayout(1, false);
	gl_compositePedidosAndamento.verticalSpacing = 30;
	compositePedidosAndamento.setLayout(gl_compositePedidosAndamento);
	GridData gd_compositePedidosAndamento = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	gd_compositePedidosAndamento.widthHint = 410;
	compositePedidosAndamento.setLayoutData(gd_compositePedidosAndamento);
	
	Label lblPedidosRotaEntrega = new Label(compositePedidosAndamento, SWT.NONE);
	lblPedidosRotaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.NORMAL)));
	lblPedidosRotaEntrega.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(4, 42, 92))));
	lblPedidosRotaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
	lblPedidosRotaEntrega.setText("Pedidos em rota de entrega");
	
	/* Colocar aqui a função que vai pegar os dados dos pedidos em rota de entrega
	 * Abaixo tem um loop que vai motrar todos os pedidos em rota de entrega*/
	for(int i = 0; i<numPedidosRotaEntrega; i++) {
		Composite compositeCardPedidoRotaEntrega = new Composite(compositePedidosAndamento, SWT.NONE);
		compositeCardPedidoRotaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_compositeCardPedidoRotaEntrega = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositeCardPedidoRotaEntrega.widthHint = 399;
		gd_compositeCardPedidoRotaEntrega.heightHint = 230;
		compositeCardPedidoRotaEntrega.setLayoutData(gd_compositeCardPedidoRotaEntrega);
		compositeCardPedidoRotaEntrega.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.setAntialias(SWT.ON);
				Rectangle bounds = compositeCardPedidoRotaEntrega.getClientArea();
				int arcWidth = 20;
				int arcHeight = 20;
				gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
				gc.fillRoundRectangle(0, 0, bounds.width, bounds.height, arcWidth, arcHeight);
				gc.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
				gc.drawRoundRectangle(0, 0, bounds.width - 1, bounds.height - 1, arcWidth, arcHeight);
			}
		});
		
		Label lblNumPedidoRotaEntrega = new Label(compositeCardPedidoRotaEntrega, SWT.NONE);
		lblNumPedidoRotaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblNumPedidoRotaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNumPedidoRotaEntrega.setBounds(39, 23, 256, 25);
		/* Abaixo, dentro da função setText(), colocar o número do pedido
		 * 
		 *	 								o get(i) é como se eu estivesse pegando pelo indice, assim como nomeArray[i]
		 **/
		lblNumPedidoRotaEntrega.setText("Pedido #"+pedidosRotaEntregaList.get(i).get(0));
		
		Label lblPedidoStatusRotaEntrega = new Label(compositeCardPedidoRotaEntrega, SWT.NONE);
		lblPedidoStatusRotaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblPedidoStatusRotaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPedidoStatusRotaEntrega.setBounds(39, 53, 256, 20);
		/* Abaixo, dentro da função setText(), colocar o status do pedido
		 * 
		 *	 								o get(i) é como se eu estivesse pegando pelo indice, assim como nomeArray[i]
		 **/
		lblPedidoStatusRotaEntrega.setText(pedidosRotaEntregaList.get(i).get(1));
		
		Label lblNomeCliente = new Label(compositeCardPedidoRotaEntrega, SWT.NONE);
		lblNomeCliente.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblNomeCliente.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNomeCliente.setBounds(39, 82, 256, 25);
		/* Abaixo, dentro da função setText(), colocar o nome do cliente do pedido
		 * 
		 *	 								o get(i) é como se eu estivesse pegando pelo indice, assim como nomeArray[i]
		 **/
		lblNomeCliente.setText(pedidosRotaEntregaList.get(i).get(2));
		
		Label labelHorizontalAndamento = new Label(compositeCardPedidoRotaEntrega, SWT.SEPARATOR | SWT.HORIZONTAL);
		labelHorizontalAndamento.setBounds(39, 119, 337, 2);
		
		Label lblTotalPedido = new Label(compositeCardPedidoRotaEntrega, SWT.NONE);
		lblTotalPedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblTotalPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTotalPedido.setBounds(39, 158, 90, 25);
		lblTotalPedido.setText("Total");
		
		Label lblPrecototalPedido = new Label(compositeCardPedidoRotaEntrega, SWT.NONE);
		lblPrecototalPedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblPrecototalPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecototalPedido.setBounds(288, 158, 90, 25);
		/* Abaixo, dentro da função setText(), colocar o total do pedido
		 * 
		 *	 								o get(i) é como se eu estivesse pegando pelo indice, assim como nomeArray[i]
		 **/
		lblPrecototalPedido.setText("R$"+pedidosRotaEntregaList.get(i).get(4));
		
		Label lblEnderecoPedido = new Label(compositeCardPedidoRotaEntrega, SWT.WRAP);
		lblEnderecoPedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblEnderecoPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblEnderecoPedido.setBounds(39, 127, 200, 25);
		/* Abaixo, dentro da função setText(), colocar o endereço do cliente
		 * 
		 *	 								o get(i) é como se eu estivesse pegando pelo indice, assim como nomeArray[i]
		 **/
		lblEnderecoPedido.setText(pedidosRotaEntregaList.get(i).get(3));
		
		Button btnDetalhesPedido = new Button(compositeCardPedidoRotaEntrega, SWT.NONE);
		btnDetalhesPedido.setBounds(153, 190, 90, 30);
		btnDetalhesPedido.setText("Detalhes");
		btnDetalhesPedido.addSelectionListener(new SelectionAdapter() {
			Integer iNum = 0;
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreenEntregador(3);
				System.out.println(pedidosRotaEntregaList.get(iNum).get(0));
				iNum = iNum + 1;
			}
			
		});
		btnDetalhesPedido.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnDetalhesPedido.getBounds();
				Color blue = new Color(getDisplay(), new RGB(19, 41, 61));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));
				
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
				
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Detalhes";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);
				
				blue.dispose();
				white.dispose();
			}
		});
		new Label(compositePedidos, SWT.NONE);
		
	}
	
	scrolledComposite.setContent(compositePedidos);
	scrolledComposite.setMinSize(compositePedidos.computeSize(SWT.DEFAULT, SWT.DEFAULT));
}
}
