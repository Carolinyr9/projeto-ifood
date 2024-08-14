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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import database.ProdutoBanco;
import database.CardapioBanco;
import database.DBConnection;
import model.Produto;
import model.Cardapio;

import org.eclipse.swt.custom.ScrolledComposite;

import org.eclipse.swt.widgets.FileDialog;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class FuncionarioCadProdutoCardapio extends Composite {
		
	private LocalResourceManager localResourceManager;
	private Shell shell = getShell();
	private Display display = getDisplay();
	MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
	private FileDialog fileImage = new FileDialog(getShell(), SWT.OPEN);
	private String selectedFile;
	private String fileName;
	private Text textPreco;
	private Text txtTitulo;
	private Text txtDescricao;
	private ProdutoBanco produtoBanco;
	private CardapioBanco cardapioBanco;

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}
    
    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

    public FuncionarioCadProdutoCardapio(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();		
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		setSize(468, 813);
		
		Image arrowIcon = new Image(display, "./src/assets/images/backArrow.png");
		setLayout(null);
		
		Composite compositeHeader = new Composite(this, SWT.NONE);
		compositeHeader.setBounds(0, 0, 468, 73);
		compositeHeader.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		
		Label lblTelaTitulo = new Label(compositeHeader, SWT.CENTER);
		lblTelaTitulo.setAlignment(SWT.CENTER);
		lblTelaTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(232, 241, 242))));
		lblTelaTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 145))));
		lblTelaTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 16, SWT.NORMAL)));
		lblTelaTitulo.setBounds(86, 12, 259, 51);
		lblTelaTitulo.setText("Cadastrar Produto");
		
		Button btnBack = new Button(compositeHeader, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreenFuncionario(2);
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
		scrolledComposite.setBounds(0, 79, 468, 706);
		scrolledComposite.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite compositeForm = new Composite(scrolledComposite, SWT.NONE);
		compositeForm.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridLayout gl_compositeForm = new GridLayout(1, false);
		gl_compositeForm.verticalSpacing = 15;
		gl_compositeForm.marginTop = 30;
		gl_compositeForm.marginLeft = 45;
		compositeForm.setLayout(gl_compositeForm);
		
		Label lblTitulo = new Label(compositeForm, SWT.NONE);
		lblTitulo.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 142))));
		lblTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		lblTitulo.setText("Título");
		
		txtTitulo = new Text(compositeForm, SWT.BORDER);
		GridData gd_txtTitulo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtTitulo.heightHint = 33;
		gd_txtTitulo.widthHint = 330;
		txtTitulo.setLayoutData(gd_txtTitulo);
		txtTitulo.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		txtTitulo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		Label lblPreco = new Label(compositeForm, SWT.NONE);
		lblPreco.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 142))));
		lblPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		lblPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPreco.setText("Preço");
		
		textPreco = new Text(compositeForm, SWT.BORDER);
		GridData gd_textPreco = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_textPreco.heightHint = 33;
		gd_textPreco.widthHint = 330;
		textPreco.setLayoutData(gd_textPreco);
		textPreco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		textPreco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		
		Button btnAdicionarImagem = new Button(compositeForm, SWT.NONE);
		GridData gd_btnAdicionarImagem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnAdicionarImagem.widthHint = 178;
		btnAdicionarImagem.setLayoutData(gd_btnAdicionarImagem);
		btnAdicionarImagem.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnAdicionarImagem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        String fileNameAux = "";
		        fileImage.setFilterExtensions(new String[] {"*.png", "*.jpeg", "*.jpg", "*.gif"});
		        selectedFile = fileImage.open();

		        if (selectedFile != null) {
		            Path sourcePath = Paths.get(selectedFile);
		            fileNameAux = sourcePath.getFileName().toString();
		            setFileName(fileNameAux);
		            Path destinationPath = Paths.get("./src/assets/images/", sourcePath.getFileName().toString());

		            
		            try {
		                Files.copy(sourcePath, destinationPath);
		                messageBox.setMessage("Imagem arquivada com sucesso!");
		                messageBox.open();
		            } catch (IOException e1) {
		            	messageBox.setMessage("Erro ao copiar o arquivo: " + e1.getMessage());
		            	messageBox.open();
		            }
		        }
		    }
		});
		btnAdicionarImagem.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnAdicionarImagem.getBounds();
				Color blue = new Color(getDisplay(), new RGB(19, 41, 61));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Adicionar Imagem";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);

				blue.dispose();
				white.dispose();
			}
		});
		btnAdicionarImagem.setText("Adicionar Imagem");
		
		Label lblDescricao = new Label(compositeForm, SWT.NONE);
		lblDescricao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		lblDescricao.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 142))));
		lblDescricao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblDescricao.setText("Descrição");
		
		txtDescricao = new Text(compositeForm, SWT.BORDER);
		GridData gd_txtDescricao = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtDescricao.heightHint = 123;
		gd_txtDescricao.widthHint = 330;
		txtDescricao.setLayoutData(gd_txtDescricao);
		txtDescricao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 10, SWT.NORMAL)));
		txtDescricao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		
		Button btnConcluir = new Button(compositeForm, SWT.NONE);
		GridData gd_btnConcluir = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnConcluir.widthHint = 99;
		btnConcluir.setLayoutData(gd_btnConcluir);
		btnConcluir.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {

		        String titulo = txtTitulo.getText();
		        double preco = Double.parseDouble(textPreco.getText());
		        String descricao = txtDescricao.getText();
		        
		        int idRestaurante = 1;
		        
		        Produto produto = new Produto(idRestaurante, preco, titulo, descricao, fileName);
		        
		        Cardapio cardapio = new Cardapio();
		        cardapio.adicionarItem(produto);
		        
		        DBConnection dbConnection = new DBConnection();
		        produtoBanco = new ProdutoBanco(dbConnection);
		        boolean isInserted = produtoBanco.criarProduto(produto);
		        
		        if (isInserted) {
					messageBox.setMessage("Produto inserido com sucesso!");
	                messageBox.open();
				} else {
					messageBox.setMessage("Erro ao inserir o produto!");
	                messageBox.open();

				}
		        
		        cardapioBanco = new CardapioBanco(dbConnection);
		        cardapioBanco.criarCardapio(cardapio);
		    }
		});
		btnConcluir.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
		btnConcluir.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		btnConcluir.setText("Concluir");
		btnConcluir.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle rect = btnConcluir.getBounds();
				Color blue = new Color(getDisplay(), new RGB(19, 41, 61));
				Color white = new Color(getDisplay(), new RGB(255, 255, 255));
				gc.setAntialias(SWT.ON);
				gc.setBackground(blue);
				gc.fillRoundRectangle(0, 0, rect.width, rect.height, 20, 20);
				gc.setForeground(white);
				gc.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.NORMAL)));
				String text = "Concluir";
				int textWidth = gc.textExtent(text).x;
				int textHeight = gc.textExtent(text).y;
				gc.drawText(text, (rect.width - textWidth) / 2, (rect.height - textHeight) / 2, true);

				blue.dispose();
				white.dispose();
			}
		});
		
		scrolledComposite.setContent(compositeForm);
		scrolledComposite.setMinSize(compositeForm.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
    
    private static void saveFile(String sourceFilePath, String targetDirectory) {
        File sourceFile = new File(sourceFilePath);
        File targetDir = new File(targetDirectory);
        
        // Verifica se o diretório de destino existe, se não, cria
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        // Define o caminho do arquivo de destino
        File targetFile = new File(targetDir, sourceFile.getName());

        try {
            // Copia o arquivo selecionado para o diretório da aplicação
            Files.copy(sourceFile.toPath(), targetFile.toPath());
            System.out.println("File saved to: " + targetFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
