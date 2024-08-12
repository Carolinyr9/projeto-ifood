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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import database.DBConnection;
import database.PedidoBanco;
import database.PratoBanco;
import database.ProdutoBanco;
import database.UsuarioBanco;
import model.Cliente;
import model.ItemCardapio;
import model.Pedido;
import model.Prato;
import model.Produto;

import org.eclipse.swt.custom.ScrolledComposite;

public class EntregadorPedidos extends Composite {
    
    private LocalResourceManager localResourceManager;
    private PedidoBanco pedidoBanco;
    
    private List<Pedido> pedidoAberto;
    private List<Pedido> pedidoCancelado;
    private List<Pedido> pedidoEntregue;
    private List<Pedido> pedidoEmPreparo;
    private List<Pedido> pedidoACaminho;
    private DBConnection dbConnection = new DBConnection();

    private void createResourceManager() {
        localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
    }

    public EntregadorPedidos(Composite parent, MainPage mainPage) {
        super(parent, SWT.NONE);
        createResourceManager();
        setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        setSize(482, 774);
        setLayout(new FormLayout());
        
        pedidoAberto = new ArrayList<>();
        pedidoCancelado = new ArrayList<>();
        pedidoEntregue = new ArrayList<>();
        pedidoEmPreparo = new ArrayList<>();
        pedidoACaminho = new ArrayList<>();
        
        pedidoBanco = new PedidoBanco(dbConnection);
        List<Pedido> pedidosFeitos = pedidoBanco.listarTodosPedidos();
        
        for (Pedido ped : pedidosFeitos) {
            if (ped.getStatus() != null) {
            	
                switch (ped.getStatus().getStatus()) {
                    case ABERTO:
                        pedidoAberto.add(ped);
                        break;
                    case EM_PREPARO:
                        pedidoEmPreparo.add(ped);
                        break;
                    case A_CAMINHO:
                        pedidoACaminho.add(ped);
                        break;
                    case ENTREGUE:
                        pedidoEntregue.add(ped);
                        break;
                    case CANCELADO:
                        pedidoCancelado.add(ped);
                        break;
                }
            } else {
            	MessageBox messageBox = new MessageBox(new Shell(), SWT.ICON_WARNING | SWT.OK);
                messageBox.setText("Aviso");
                messageBox.setMessage("Status do pedido é null para o ID: " + ped.getId());
                messageBox.open();
            }
        }
        
        
        criarLayout(mainPage);
        
    }

    private void criarLayout(MainPage mainPage) {
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

        if (pedidoAberto.size() > 0) {
            criarSecaoPedidos(compositePedidos, "Aberto", pedidoAberto, mainPage);
        }

        if (pedidoEmPreparo.size() > 0) {
            criarSecaoPedidos(compositePedidos, "Em Preparo", pedidoEmPreparo, mainPage);
        }

        if (pedidoACaminho.size() > 0) {
            criarSecaoPedidos(compositePedidos, "A Caminho", pedidoACaminho, mainPage);
        }

        if (pedidoEntregue.size() > 0) {
            criarSecaoPedidos(compositePedidos, "Entregue", pedidoEntregue, mainPage);
        }

        if (pedidoCancelado.size() > 0) {
            criarSecaoPedidos(compositePedidos, "Cancelado", pedidoCancelado, mainPage);
        }

        scrolledComposite.setContent(compositePedidos);
        scrolledComposite.setMinSize(compositePedidos.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);
    }

    private void criarSecaoPedidos(Composite parent, String statusLabel, List<Pedido> pedidos,MainPage mainPage) {
        Composite compositeSecao = new Composite(parent, SWT.NONE);
        compositeSecao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        GridLayout gl_compositeSecao = new GridLayout(1, false);
        gl_compositeSecao.verticalSpacing = 20;
        compositeSecao.setLayout(gl_compositeSecao);
        GridData gd_compositeSecao = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_compositeSecao.widthHint = 410;
        compositeSecao.setLayoutData(gd_compositeSecao);

        Label lblSecao = new Label(compositeSecao, SWT.NONE);
        lblSecao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.NORMAL)));
        lblSecao.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(4, 42, 92))));
        lblSecao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
        lblSecao.setText("Pedidos " + statusLabel);

        for (Pedido pedido : pedidos) {
            Composite compositeCardPedido = new Composite(compositeSecao, SWT.NONE);
            compositeCardPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            GridData gd_compositeCardPedido = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
            gd_compositeCardPedido.widthHint = 399;
            gd_compositeCardPedido.heightHint = 266;
            compositeCardPedido.setLayoutData(gd_compositeCardPedido);
            compositeCardPedido.addPaintListener(new PaintListener() {
                @Override
                public void paintControl(PaintEvent e) {
                    GC gc = e.gc;
                    gc.setAntialias(SWT.ON);
                    Rectangle bounds = compositeCardPedido.getClientArea();
                    int arcWidth = 20;
                    int arcHeight = 20;
                    gc.drawRoundRectangle(bounds.x, bounds.y, bounds.width - 1, bounds.height - 1, arcWidth, arcHeight);
                }
            });

            Cliente cliente = obterInformacoesCliente(pedido.getIdCliente());
            List<ItemCardapio> itensCardapio = obterItensCardapio(pedido);

            Label lblNomeCliente = new Label(compositeCardPedido, SWT.NONE);
            // ARRUMAR + + restaurante.getNome()
            // NÃO FUNCIONA PQ AINDA N TEMOS RESTAURANTES CADASTRADOS
            lblNomeCliente.setText("Carol" ); // ARRUMAR e colocar + restauranter.getNome()
            lblNomeCliente.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
            lblNomeCliente.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            lblNomeCliente.setBounds(22, 53, 380, 25);

            Label lblIdPedido = new Label(compositeCardPedido, SWT.NONE);    
            lblIdPedido.setText("N°" + pedido.getId());
            lblIdPedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
            lblIdPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            lblIdPedido.setBounds(22, 22, 301, 25);

            Label lblPrecoTotal = new Label(compositeCardPedido, SWT.NONE);
            lblPrecoTotal.setText("R$"+ String.format("%.2f", pedido.getPrecoTotal()));
            lblPrecoTotal.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
            lblPrecoTotal.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            lblPrecoTotal.setBounds(22, 84, 210, 25);
            
            Label lblItensPedido = new Label(compositeCardPedido, SWT.NONE);
            List<String> itens = new ArrayList<>();
            for (int i = 0; i < Math.min(itensCardapio.size(), 2); i++) {
            	ItemCardapio item = itensCardapio.get(i);
            	if (item != null) {
            		itens.add(item.getNome());
            		itens.add(item.getPreco().toString());
            	}
            }
            lblItensPedido.setText("Itens: "+ String.join(", ", itens));   
            lblItensPedido.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
            lblItensPedido.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
            lblItensPedido.setBounds(22, 115, 367, 69);
            
            Button btnVerMais = new Button(compositeCardPedido, SWT.NONE);
            btnVerMais.setText("Ver mais...");
            btnVerMais.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
            btnVerMais.setBounds(149, 203, 111, 35);
            btnVerMais.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                	mainPage.showClienteInfoPedido(pedido.getId());
                }
            });
            btnVerMais.addPaintListener(new PaintListener() {
    			@Override
    			public void paintControl(PaintEvent e) {
    				GC gc = e.gc;
    				Rectangle rect = btnVerMais.getBounds();
    				Color blue = new Color(getDisplay(), new RGB(19, 41, 61));
    				Color white = new Color(getDisplay(), new RGB(255, 255, 255));
    				
    				gc.setAntialias(SWT.ON);
    				gc.setBackground(blue);
    				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
    				
    				gc.setForeground(white);
    				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
    				String text = "Ver mais...";
    				int textWidth = gc.textExtent(text).x;
    				int textHeight = gc.textExtent(text).y;
    				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);
    				
    				blue.dispose();
    				white.dispose();
    			}
    		});
        }
    }

    private Cliente obterInformacoesCliente(int idCliente) {
        UsuarioBanco usuarioBanco = new UsuarioBanco(dbConnection);
        return usuarioBanco.obterClientePorId(idCliente);
    }

    private List<ItemCardapio> obterItensCardapio(Pedido pedido) {
        PratoBanco pratoBanco = new PratoBanco(dbConnection);
        ProdutoBanco produtoBanco = new ProdutoBanco(dbConnection);
        List<ItemCardapio> itens = new ArrayList<>();
        for (Integer idPrato : pedido.getIdsPratos()) {
            Prato prato = pratoBanco.visualizarPrato(idPrato);
            if(prato != null) {
            	itens.add(prato);
            }
        }
        for (Integer idProduto : pedido.getIdsProdutos()) {
            Produto produto = produtoBanco.visualizarProduto(idProduto);
            if(produto != null) {
            	itens.add(produto);
            }
        }
        return itens;
    }
}