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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class ClienteCarrinho extends Composite {
	
	private Integer idProduto;
	private String nomeProduto;
	private String descricao;
	private Double preco;
	private String nomeRestaurante;
	private String enderecoRestaurante;
	private LocalResourceManager localResourceManager;

    public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}
	
	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
	}

	public String getEnderecoRestaurante() {
		return enderecoRestaurante;
	}

	public void setEnderecoRestaurante(String enderecoRestaurante) {
		this.enderecoRestaurante = enderecoRestaurante;
	}

	private void setVariables(Integer idProduto,String nomeProduto,String descricao,Double preco,String nomeRestaurante,String enderecoRestaurante) {
		setIdProduto(idProduto);
		setNomeProduto(nomeProduto);
		setDescricao(descricao);
		setPreco(preco);
		setNomeRestaurante(nomeRestaurante);
		setEnderecoRestaurante(enderecoRestaurante);
	}


    public ClienteCarrinho(Composite parent, MainPage mainPage,Integer idProduto,String nomeProduto,String descricao,Double preco,String nomeRestaurante,String enderecoRestaurante) {
		super(parent, SWT.NONE);
		createResourceManager();
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setSize(482, 740);
		setLayout(new FormLayout());
		
		setVariables(idProduto, nomeProduto, descricao, preco, nomeRestaurante, enderecoRestaurante);
		Integer numItens = 4;

        ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        FormData fd_scrolledComposite = new FormData();
        fd_scrolledComposite.bottom = new FormAttachment(0, 697);
        fd_scrolledComposite.right = new FormAttachment(0, 480);
        fd_scrolledComposite.top = new FormAttachment(0);
        fd_scrolledComposite.left = new FormAttachment(0);
        scrolledComposite.setLayoutData(fd_scrolledComposite);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);

        Composite compositeCarrinho = new Composite(scrolledComposite, SWT.NONE);
        compositeCarrinho.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        scrolledComposite.setContent(compositeCarrinho);
        GridLayout gl_compositeCarrinho = new GridLayout(1, false);
        gl_compositeCarrinho.verticalSpacing = 10;
        gl_compositeCarrinho.marginTop = 20;
        gl_compositeCarrinho.marginLeft = 40;
        compositeCarrinho.setLayout(gl_compositeCarrinho);

        new Label(compositeCarrinho, SWT.NONE);

        Composite compositeRestauranteInfo = new Composite(compositeCarrinho, SWT.NONE);
        GridData gd_compositeRestauranteInfo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_compositeRestauranteInfo.widthHint = 378;
        compositeRestauranteInfo.setLayoutData(gd_compositeRestauranteInfo);
        compositeRestauranteInfo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        compositeRestauranteInfo.setLayout(new GridLayout(1, false));

        Label lblRestauranteNome = new Label(compositeRestauranteInfo, SWT.WRAP);
        GridData gd_lblRestauranteNome = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblRestauranteNome.heightHint = 45;
        gd_lblRestauranteNome.widthHint = 359;
        lblRestauranteNome.setLayoutData(gd_lblRestauranteNome);
        lblRestauranteNome.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.BOLD)));
        lblRestauranteNome.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblRestauranteNome.setText(getNomeRestaurante());

        Label lblRestauranteEndereco = new Label(compositeRestauranteInfo, SWT.WRAP);
        GridData gd_lblRestauranteEndereco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblRestauranteEndereco.widthHint = 357;
        gd_lblRestauranteEndereco.heightHint = 41;
        lblRestauranteEndereco.setLayoutData(gd_lblRestauranteEndereco);
        lblRestauranteEndereco.setText(getEnderecoRestaurante());
        lblRestauranteEndereco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));

        Label lblItens = new Label(compositeCarrinho, SWT.NONE);
        GridData gd_lblItens = new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1);
        gd_lblItens.heightHint = 27;
        gd_lblItens.widthHint = 64;
        lblItens.setLayoutData(gd_lblItens);
        lblItens.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
        lblItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblItens.setText("Itens");

        Composite compositeItens = new Composite(compositeCarrinho, SWT.NONE);
        GridData gd_compositeItens = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_compositeItens.widthHint = 380;
        compositeItens.setLayoutData(gd_compositeItens);
        compositeItens.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        compositeItens.setLayout(new GridLayout(1, false));

        for (int i = 0; i < numItens; i++) {
            Composite compositeCardItem = new Composite(compositeItens, SWT.NONE);
            compositeCardItem.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            compositeCardItem.setLayout(null);
            GridData gd_compositeCardItem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
            gd_compositeCardItem.heightHint = 107;
            gd_compositeCardItem.widthHint = 365;
            compositeCardItem.setLayoutData(gd_compositeCardItem);

            Label lblNomeItem = new Label(compositeCardItem, SWT.NONE);
            lblNomeItem.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            lblNomeItem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
            lblNomeItem.setBounds(10, 10, 252, 51);
            lblNomeItem.setText(getNomeProduto());

            Label lblPrecoItem = new Label(compositeCardItem, SWT.NONE);
            lblPrecoItem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
            lblPrecoItem.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            lblPrecoItem.setBounds(279, 10, 76, 30);
            lblPrecoItem.setText("R$" + getPreco().toString());

            Label lblRemoverItem = new Label(compositeCardItem, SWT.NONE);
            lblRemoverItem.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            lblRemoverItem.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 141))));
            lblRemoverItem.setBounds(10, 67, 70, 20);
            lblRemoverItem.setText("Remover");

            Label label_1 = new Label(compositeCardItem, SWT.SEPARATOR | SWT.HORIZONTAL);
            label_1.setBounds(10, 95, 345, 2);
        }

        Composite compositePrecoTotal = new Composite(compositeCarrinho, SWT.NONE);
        GridData gd_compositePrecoTotal = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_compositePrecoTotal.heightHint = 190;
        gd_compositePrecoTotal.widthHint = 378;
        compositePrecoTotal.setLayoutData(gd_compositePrecoTotal);
        compositePrecoTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));

        Label lblSubtotal = new Label(compositePrecoTotal, SWT.NONE);
        lblSubtotal.setBounds(10, 29, 70, 20);
        lblSubtotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.BOLD)));
        lblSubtotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblSubtotal.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(128, 128, 128))));
        lblSubtotal.setText("Subtotal");

        Label lblTaxaDeEntrega = new Label(compositePrecoTotal, SWT.NONE);
        lblTaxaDeEntrega.setBounds(10, 66, 135, 20);
        lblTaxaDeEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.BOLD)));
        lblTaxaDeEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblTaxaDeEntrega.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(128, 128, 128))));
        lblTaxaDeEntrega.setText("Taxa de entrega");

        Label lblTotal = new Label(compositePrecoTotal, SWT.NONE);
        lblTotal.setBounds(10, 104, 70, 30);
        lblTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblTotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
        lblTotal.setText("Total");

        Label lblPrecoSubtotal = new Label(compositePrecoTotal, SWT.NONE);
        lblPrecoSubtotal.setBounds(274, 29, 70, 20);
        lblPrecoSubtotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
        lblPrecoSubtotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblPrecoSubtotal.setText("R$" + getPreco().toString());

        Label lblPrecoTaxaEntrega = new Label(compositePrecoTotal, SWT.NONE);
        lblPrecoTaxaEntrega.setBounds(274, 66, 70, 20);
        lblPrecoTaxaEntrega.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
        lblPrecoTaxaEntrega.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblPrecoTaxaEntrega.setText("R$23,77");

        Label lblPrecoTotal = new Label(compositePrecoTotal, SWT.NONE);
        lblPrecoTotal.setBounds(274, 106, 70, 20);
        lblPrecoTotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
        lblPrecoTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblPrecoTotal.setText("R$23,77");

        Button btnFinalizarPedido = new Button(compositePrecoTotal, SWT.NONE);
        btnFinalizarPedido.setBounds(10, 150, 135, 30);
        btnFinalizarPedido.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // Lógica para finalizar o pedido
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

				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 30, 30);

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

        compositeCarrinho.layout();
        scrolledComposite.setMinSize(compositeCarrinho.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
	}
}
