package view;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class FuncionarioPedidos extends Composite {
		
	private LocalResourceManager localResourceManager;
	private Integer numPedidosAndamento;
	private Integer numPedidosRotaEntrega;
	private ArrayList<List<String>> pedidosEmAndamentoList; 
	private List<String> pedidoEmAndamento;

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}

    public FuncionarioPedidos(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setSize(482, 774);
		setLayout(new FormLayout());
		
		numPedidosAndamento = 3;
		numPedidosRotaEntrega = 3;
		
		pedidosEmAndamentoList = new ArrayList<>();
        pedidoEmAndamento = new ArrayList<>();

        pedidoEmAndamento.add("1234");
        pedidoEmAndamento.add("Em Andamento");
        pedidoEmAndamento.add("José de Fátima");
        pedidoEmAndamento.add("Pizza de queijo");
        pedidoEmAndamento.add("1 item");
        pedidoEmAndamento.add("23,55");

        pedidosEmAndamentoList.add(pedidoEmAndamento);
        pedidosEmAndamentoList.add(pedidoEmAndamento);
        System.out.println(pedidosEmAndamentoList);
        
        numPedidosAndamento = pedidosEmAndamentoList.size();
		
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
		gl_compositePedidosAndamento.verticalSpacing = 20;
		compositePedidosAndamento.setLayout(gl_compositePedidosAndamento);
		GridData gd_compositePedidosAndamento = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositePedidosAndamento.widthHint = 410;
		compositePedidosAndamento.setLayoutData(gd_compositePedidosAndamento);
		
		
		Label lblPedidosEmAndamento = new Label(compositePedidosAndamento, SWT.NONE);
		lblPedidosEmAndamento.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.NORMAL)));
		lblPedidosEmAndamento.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(4, 42, 92))));
		lblPedidosEmAndamento.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPedidosEmAndamento.setText("Pedidos em andamento");
		
		for(int i = 0; i<numPedidosAndamento; i++) {
			Composite compositeCardPedidoAndamento = new Composite(compositePedidosAndamento, SWT.NONE);
			compositeCardPedidoAndamento.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			GridData gd_compositeCardPedidoAndamento = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_compositeCardPedidoAndamento.widthHint = 399;
			gd_compositeCardPedidoAndamento.heightHint = 266;
			compositeCardPedidoAndamento.setLayoutData(gd_compositeCardPedidoAndamento);
			compositeCardPedidoAndamento.addPaintListener(new PaintListener() {
				@Override
				public void paintControl(PaintEvent e) {
					GC gc = e.gc;
					gc.setAntialias(SWT.ON);
					Rectangle bounds = compositeCardPedidoAndamento.getClientArea();
					int arcWidth = 20;
					int arcHeight = 20;
					gc.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
					gc.fillRoundRectangle(0, 0, bounds.width, bounds.height, arcWidth, arcHeight);
					gc.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
					gc.drawRoundRectangle(0, 0, bounds.width - 1, bounds.height - 1, arcWidth, arcHeight);
				}
			});
			
			Label lblNumPedidoAndamento = new Label(compositeCardPedidoAndamento, SWT.NONE);
			lblNumPedidoAndamento.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			lblNumPedidoAndamento.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblNumPedidoAndamento.setBounds(39, 23, 256, 25);
			lblNumPedidoAndamento.setText(pedidosEmAndamentoList.get(i).get(0));
			
			Label lblPedidoStatusAndamento = new Label(compositeCardPedidoAndamento, SWT.NONE);
			lblPedidoStatusAndamento.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
			lblPedidoStatusAndamento.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblPedidoStatusAndamento.setBounds(39, 53, 256, 20);
			lblPedidoStatusAndamento.setText(pedidosEmAndamentoList.get(i).get(1));
			
			Label lblNomeClientePedidoAndamento = new Label(compositeCardPedidoAndamento, SWT.NONE);
			lblNomeClientePedidoAndamento.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			lblNomeClientePedidoAndamento.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblNomeClientePedidoAndamento.setBounds(39, 82, 256, 25);
			lblNomeClientePedidoAndamento.setText(pedidosEmAndamentoList.get(i).get(2));
			
			Label labelHorizontalAndamento = new Label(compositeCardPedidoAndamento, SWT.SEPARATOR | SWT.HORIZONTAL);
			labelHorizontalAndamento.setBounds(39, 119, 337, 2);
			
			Label lblNomeItemPedidoAndamento = new Label(compositeCardPedidoAndamento, SWT.NONE);
			lblNomeItemPedidoAndamento.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			lblNomeItemPedidoAndamento.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblNomeItemPedidoAndamento.setBounds(39, 132, 256, 25);
			lblNomeItemPedidoAndamento.setText(pedidosEmAndamentoList.get(i).get(3));
			
			Label lblQuantidadeItensPedidoAndamento = new Label(compositeCardPedidoAndamento, SWT.NONE);
			lblQuantidadeItensPedidoAndamento.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
			lblQuantidadeItensPedidoAndamento.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblQuantidadeItensPedidoAndamento.setBounds(39, 161, 256, 25);
			lblQuantidadeItensPedidoAndamento.setText(pedidosEmAndamentoList.get(i).get(4));
			
			Label lblTotalPedidoAndamento = new Label(compositeCardPedidoAndamento, SWT.NONE);
			lblTotalPedidoAndamento.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			lblTotalPedidoAndamento.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblTotalPedidoAndamento.setBounds(39, 192, 90, 25);
			lblTotalPedidoAndamento.setText("Total");
			
			Label lblPrecototalPedidoAndamento = new Label(compositeCardPedidoAndamento, SWT.NONE);
			lblPrecototalPedidoAndamento.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			lblPrecototalPedidoAndamento.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblPrecototalPedidoAndamento.setBounds(247, 192, 137, 25);
			lblPrecototalPedidoAndamento.setText(pedidosEmAndamentoList.get(i).get(5));
			
			Button btnDetalhesPedidoAndamento = new Button(compositeCardPedidoAndamento, SWT.NONE);
			btnDetalhesPedidoAndamento.setBounds(153, 226, 90, 30);
			btnDetalhesPedidoAndamento.setText("Detalhes");
			btnDetalhesPedidoAndamento.addSelectionListener(new SelectionAdapter() {
				Integer iNum = 0;
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					mainPage.navigateToScreenFuncionario(6);
					System.out.println(pedidosEmAndamentoList.get(iNum).get(0));
					iNum = iNum + 1;
				}
				
			});
			btnDetalhesPedidoAndamento.addPaintListener(new PaintListener() {
				@Override
				public void paintControl(PaintEvent e) {
					GC gc = e.gc;
					Rectangle rect = btnDetalhesPedidoAndamento.getBounds();
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
		
		Composite compositePedidosRotaEntrega = new Composite(compositePedidos, SWT.NONE);
		compositePedidosRotaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridLayout gl_compositePedidosRotaEntrega = new GridLayout(1, false);
		gl_compositePedidosRotaEntrega.verticalSpacing = 20;
		compositePedidosRotaEntrega.setLayout(gl_compositePedidosRotaEntrega);
		GridData gd_compositePedidosRotaEntrega = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_compositePedidosRotaEntrega.widthHint = 409;
		compositePedidosRotaEntrega.setLayoutData(gd_compositePedidosRotaEntrega);
		
		Label lblPedidosEmRota = new Label(compositePedidosRotaEntrega, SWT.NONE);
		GridData gd_lblPedidosEmRota = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPedidosEmRota.widthHint = 280;
		lblPedidosEmRota.setLayoutData(gd_lblPedidosEmRota);
		lblPedidosEmRota.setText("Pedidos em rota de entrega");
		lblPedidosEmRota.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.NORMAL)));
		lblPedidosEmRota.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(4, 42, 92))));
		lblPedidosEmRota.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		for(int i = 0; i<numPedidosRotaEntrega; i++) {
			Composite compositeCardPedidoRotaEntrega = new Composite(compositePedidosRotaEntrega, SWT.NONE);
			compositeCardPedidoRotaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			GridData gd_compositeCardPedidoRotaEntrega = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_compositeCardPedidoRotaEntrega.widthHint = 399;
			gd_compositeCardPedidoRotaEntrega.heightHint = 209;
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
			lblNumPedidoRotaEntrega.setText("numPedido");
			
			Label lblPedidoStatusRotaEntrega = new Label(compositeCardPedidoRotaEntrega, SWT.NONE);
			lblPedidoStatusRotaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
			lblPedidoStatusRotaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblPedidoStatusRotaEntrega.setBounds(39, 53, 256, 20);
			lblPedidoStatusRotaEntrega.setText("pedidoStatus");
			
			Label lblNomeClientePedidoRotaEntrega = new Label(compositeCardPedidoRotaEntrega, SWT.NONE);
			lblNomeClientePedidoRotaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			lblNomeClientePedidoRotaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblNomeClientePedidoRotaEntrega.setBounds(39, 82, 256, 25);
			lblNomeClientePedidoRotaEntrega.setText("nomeClientePedido");
			
			Label lblTotalPedidoRotaEntrega = new Label(compositeCardPedidoRotaEntrega, SWT.NONE);
			lblTotalPedidoRotaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			lblTotalPedidoRotaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblTotalPedidoRotaEntrega.setBounds(39, 126, 90, 25);
			lblTotalPedidoRotaEntrega.setText("Total");
			
			Label lblPrecoTotalPedidoRotaEntrega = new Label(compositeCardPedidoRotaEntrega, SWT.NONE);
			lblPrecoTotalPedidoRotaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
			lblPrecoTotalPedidoRotaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
			lblPrecoTotalPedidoRotaEntrega.setBounds(247, 126, 137, 25);
			lblPrecoTotalPedidoRotaEntrega.setText("precoTotalPedido");
			
			Button btnDetalhesPedidoRotaEntrega = new Button(compositeCardPedidoRotaEntrega, SWT.NONE);
			btnDetalhesPedidoRotaEntrega.setBounds(146, 164, 90, 30);
			btnDetalhesPedidoRotaEntrega.setText("Detalhes");
			btnDetalhesPedidoRotaEntrega.addPaintListener(new PaintListener() {
				@Override
				public void paintControl(PaintEvent e) {
					GC gc = e.gc;
					Rectangle rect = btnDetalhesPedidoRotaEntrega.getBounds();
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
			
			Label labelHorizontalRotaEntrega = new Label(compositeCardPedidoRotaEntrega, SWT.SEPARATOR | SWT.HORIZONTAL);
			labelHorizontalRotaEntrega.setBounds(39, 118, 337, 2);
		}	
		
		scrolledComposite.setContent(compositePedidos);
		scrolledComposite.setMinSize(compositePedidos.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
}
