package view;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.ScrolledComposite;

public class Carrinho extends Composite {
		
	private LocalResourceManager localResourceManager;

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}


    public Carrinho(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setSize(468, 727);
		setLayout(new FormLayout());
		
		Composite compositeCarrinho = new Composite(this, SWT.NONE);
		compositeCarrinho.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeCarrinho.setLayout(null);
		FormData fd_compositeCarrinho = new FormData();
		fd_compositeCarrinho.bottom = new FormAttachment(0, 708);
		fd_compositeCarrinho.top = new FormAttachment(0);
		fd_compositeCarrinho.left = new FormAttachment(0);
		fd_compositeCarrinho.right = new FormAttachment(0, 468);
		compositeCarrinho.setLayoutData(fd_compositeCarrinho);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(compositeCarrinho, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(30, 46, 411, 652);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite compositeRestaurante = new Composite(scrolledComposite, SWT.NONE);
		compositeRestaurante.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Composite compositeRestauranteInfo = new Composite(compositeRestaurante, SWT.NONE);
		compositeRestauranteInfo.setBounds(27, 0, 354, 89);
		compositeRestauranteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		scrolledComposite.setContent(compositeRestaurante);
		scrolledComposite.setMinSize(compositeRestaurante.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		
		Label lblRestauranteNome = new Label(compositeRestauranteInfo, SWT.NONE);
		lblRestauranteNome.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.BOLD)));
		lblRestauranteNome.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblRestauranteNome.setBounds(21, 24, 164, 30);
		lblRestauranteNome.setText("Pizzaria Manoel");
		
		Label lblRestauranteEndereco = new Label(compositeRestauranteInfo, SWT.NONE);
		lblRestauranteEndereco.setBounds(21, 60, 312, 20);
		lblRestauranteEndereco.setText("Rua das Flores, 89");
		lblRestauranteEndereco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label label = new Label(compositeRestaurante, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		label.setBounds(47, 95, 319, 8);
		
		Label lblItens = new Label(compositeRestaurante, SWT.NONE);
		lblItens.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblItens.setBounds(45, 109, 81, 20);
		lblItens.setText("Itens");
		lblItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Composite compositePrecoTotal = new Composite(compositeRestaurante, SWT.NONE);
		compositePrecoTotal.setBounds(27, 402, 354, 177);
		compositePrecoTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblSubtotal = new Label(compositePrecoTotal, SWT.NONE);
		lblSubtotal.setBounds(10, 10, 70, 20);
		lblSubtotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.BOLD)));
		lblSubtotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblSubtotal.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(128, 128, 128))));
		lblSubtotal.setText("Subtotal");
		
		Label lblTaxaDeEntrega = new Label(compositePrecoTotal, SWT.NONE);
		lblTaxaDeEntrega.setBounds(10, 47, 135, 20);
		lblTaxaDeEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.BOLD)));
		lblTaxaDeEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTaxaDeEntrega.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(128, 128, 128))));
		lblTaxaDeEntrega.setText("Taxa de entrega");
		
		Label lblTotal = new Label(compositePrecoTotal, SWT.NONE);
		lblTotal.setBounds(10, 85, 70, 30);
		lblTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		lblTotal.setText("Total");
		
		Label lblPrecoSubtotal = new Label(compositePrecoTotal, SWT.NONE);
		lblPrecoSubtotal.setBounds(274, 10, 70, 20);
		lblPrecoSubtotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblPrecoSubtotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoSubtotal.setText("R$23,77");
		
		Label lblPrecoTaxaEntrega = new Label(compositePrecoTotal, SWT.NONE);
		lblPrecoTaxaEntrega.setBounds(274, 47, 70, 20);
		lblPrecoTaxaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblPrecoTaxaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoTaxaEntrega.setText("R$23,77");
		
		Label lblPrecoTotal = new Label(compositePrecoTotal, SWT.NONE);
		lblPrecoTotal.setBounds(274, 87, 70, 20);
		lblPrecoTotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblPrecoTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoTotal.setText("R$23,77");
		
		Button btnFinalizarPedido = new Button(compositePrecoTotal, SWT.NONE);
		btnFinalizarPedido.setBounds(10, 131, 135, 30);
		btnFinalizarPedido.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFinalizarPedido.setText("Finalizar pedido");
		
		btnFinalizarPedido.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnFinalizarPedido.getBounds();
				Color blue = new Color(getDisplay(), new RGB(19, 41, 61));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));

				// Desenhando o fundo azul com bordas arredondadas
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 40, 40);

				// Desenhando o texto branco
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Finalizar pedido";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);

				blue.dispose();
				white.dispose();
			}
		});		
		
		Composite compositeItens = new Composite(compositeRestaurante, SWT.NONE);
		compositeItens.setBounds(27, 135, 354, 250);
		compositeItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Composite compositeCardItem1 = new Composite(compositeItens, SWT.NONE);
		compositeCardItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeCardItem1.setBounds(0, 0, 354, 112);
		
		Label label_1 = new Label(compositeCardItem1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(10, 102, 329, 10);
		
		Label lblRemoverItem1 = new Label(compositeCardItem1, SWT.NONE);
		lblRemoverItem1.setBounds(10, 76, 70, 20);
		lblRemoverItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblRemoverItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblRemoverItem1.setText("Remover");
		
		Label lblNomeItem1 = new Label(compositeCardItem1, SWT.WRAP);
		lblNomeItem1.setBounds(10, 6, 224, 64);
		lblNomeItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNomeItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblNomeItem1.setText("Pizza Quatro Queijos");
		
		Label lblPrecoItem1 = new Label(compositeCardItem1, SWT.NONE);
		lblPrecoItem1.setBounds(258, 6, 70, 20);
		lblPrecoItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		lblPrecoItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoItem1.setText("R$49.89");
		
		Composite compositeCardItem2 = new Composite(compositeItens, SWT.NONE);
		compositeCardItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeCardItem2.setBounds(0, 119, 354, 113);
		
		Label lblNomeItem2 = new Label(compositeCardItem2, SWT.WRAP);
		lblNomeItem2.setBounds(10, 0, 226, 69);
		lblNomeItem2.setText("Pizza Quatro Queijos");
		lblNomeItem2.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblNomeItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblPrecoItem2 = new Label(compositeCardItem2, SWT.NONE);
		lblPrecoItem2.setBounds(258, 0, 70, 20);
		lblPrecoItem2.setText("R$39.89");
		lblPrecoItem2.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		lblPrecoItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblRemoverItem2 = new Label(compositeCardItem2, SWT.NONE);
		lblRemoverItem2.setBounds(11, 75, 70, 20);
		lblRemoverItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblRemoverItem2.setText("Remover");
		lblRemoverItem2.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		
		Label label_1_1 = new Label(compositeCardItem2, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_1.setBounds(10, 101, 319, 2);
		
	}
}
