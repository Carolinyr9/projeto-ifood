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
import org.eclipse.swt.graphics.RGB;

public class Carrinho extends Composite {
		
	private LocalResourceManager localResourceManager;

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}


    public Carrinho(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		setSize(468, 774);
		setLayout(new FormLayout());
		
		Composite compositeCarrinho = new Composite(this, SWT.NONE);
		compositeCarrinho.setLayout(null);
		FormData fd_compositeCarrinho = new FormData();
		fd_compositeCarrinho.bottom = new FormAttachment(0, 679);
		fd_compositeCarrinho.top = new FormAttachment(0);
		fd_compositeCarrinho.left = new FormAttachment(0);
		fd_compositeCarrinho.right = new FormAttachment(0, 468);
		compositeCarrinho.setLayoutData(fd_compositeCarrinho);
		
		Composite compositeNomeRestaurante = new Composite(compositeCarrinho, SWT.NONE);
		compositeNomeRestaurante.setBounds(55, 57, 362, 612);
		
		Label lblNewLabel = new Label(compositeNomeRestaurante, SWT.NONE);
		lblNewLabel.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.BOLD)));
		lblNewLabel.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNewLabel.setBounds(21, 24, 164, 30);
		lblNewLabel.setText("Pizzaria Manoel");
		
		Label label = new Label(compositeNomeRestaurante, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(21, 112, 319, 8);
		
		Label lblItens = new Label(compositeNomeRestaurante, SWT.NONE);
		lblItens.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblItens.setBounds(21, 85, 70, 20);
		lblItens.setText("Itens");
		
		Label lblNomeItem1 = new Label(compositeNomeRestaurante, SWT.NONE);
		lblNomeItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNomeItem1.setBounds(21, 145, 177, 20);
		lblNomeItem1.setText("Pizza Quatro Queijos");
		
		Label lblPrecoItem1 = new Label(compositeNomeRestaurante, SWT.NONE);
		lblPrecoItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		lblPrecoItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoItem1.setBounds(270, 145, 70, 20);
		lblPrecoItem1.setText("R$49.89");
		
		Label lblRemoverItem1 = new Label(compositeNomeRestaurante, SWT.NONE);
		lblRemoverItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblRemoverItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblRemoverItem1.setBounds(21, 197, 70, 20);
		lblRemoverItem1.setText("Remover");
		
		Label label_1 = new Label(compositeNomeRestaurante, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(21, 234, 319, 2);
		
		Label lblNomeItem2 = new Label(compositeNomeRestaurante, SWT.NONE);
		lblNomeItem2.setText("Pizza Quatro Queijos");
		lblNomeItem2.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		lblNomeItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNomeItem2.setBounds(21, 266, 177, 30);
		
		Label lblPrecoItem2 = new Label(compositeNomeRestaurante, SWT.NONE);
		lblPrecoItem2.setText("R$39.89");
		lblPrecoItem2.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		lblPrecoItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoItem2.setBounds(270, 266, 70, 20);
		
		Label lblRemoverItem2 = new Label(compositeNomeRestaurante, SWT.NONE);
		lblRemoverItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblRemoverItem2.setText("Remover");
		lblRemoverItem2.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
		lblRemoverItem2.setBounds(21, 315, 70, 20);
		
		Label lblSubtotal = new Label(compositeNomeRestaurante, SWT.NONE);
		lblSubtotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.BOLD)));
		lblSubtotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblSubtotal.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(128, 128, 128))));
		lblSubtotal.setBounds(21, 486, 70, 20);
		lblSubtotal.setText("Subtotal");
		
		Label lblTaxaDeEntrega = new Label(compositeNomeRestaurante, SWT.NONE);
		lblTaxaDeEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.BOLD)));
		lblTaxaDeEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTaxaDeEntrega.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(128, 128, 128))));
		lblTaxaDeEntrega.setBounds(21, 521, 135, 20);
		lblTaxaDeEntrega.setText("Taxa de entrega");
		
		Label lblTotal = new Label(compositeNomeRestaurante, SWT.NONE);
		lblTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		lblTotal.setBounds(21, 559, 70, 30);
		lblTotal.setText("Total");
		
		Label lblPrecoSubtotal = new Label(compositeNomeRestaurante, SWT.NONE);
		lblPrecoSubtotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblPrecoSubtotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoSubtotal.setBounds(270, 486, 70, 20);
		lblPrecoSubtotal.setText("R$23,77");
		
		Label lblPrecoTaxaEntrega = new Label(compositeNomeRestaurante, SWT.NONE);
		lblPrecoTaxaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		lblPrecoTaxaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoTaxaEntrega.setText("R$23,77");
		lblPrecoTaxaEntrega.setBounds(270, 521, 70, 20);
		
		Label lblPrecoTotal = new Label(compositeNomeRestaurante, SWT.NONE);
		lblPrecoTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoTotal.setText("R$23,77");
		lblPrecoTotal.setBounds(270, 559, 70, 20);
		
		
	}
}
