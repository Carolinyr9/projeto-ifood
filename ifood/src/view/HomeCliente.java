package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;

/*Essa classe está utilizando o Composite como pai, para herdar seu tipo e para que no final ele fique que nem um 
 * componente e apenas seja adicionado na página principal*/
public class HomeCliente extends Composite {

	private Image bannerImage;
	private Image pizza1;
	private Image pizza2;
	private Image pizza3;
	private Image restauranteLogoImage;
	
	//Variável para poder utilizar tamanho de letras e cores diferentes
    private LocalResourceManager localResourceManager;
    
    //Variável para poder utilizar imagens
    private Display display = getDisplay();
    
    //Esse método tem que ser chamado na função principal para que se possa usar letras maiores e de cor diferente usando RGB
    private void createResourceManager() {
    	localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
    }
    
    public HomeCliente(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		
		// O formLayout controla a posição e o tamanho de cada elemento colocado na tela 
		setLayout(new FormLayout());
		
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		
		//Através da função Image eu pego as imagem, até agora o primeiro parâmetro sempre foi 'display'
		bannerImage = new Image(display, "./src/assets/images/Banner.png");
		restauranteLogoImage = new Image(display, "./src/assets/images/restauranteLogo.png");
		pizza1 = new Image(display, "./src/assets/images/pizza1.png");
		pizza2 = new Image(display, "./src/assets/images/pizza2.png");
		pizza3 = new Image(display, "./src/assets/images/pizza3.png");
		
		/* O primeiro parâmentro depois de criar o elemento, nesse caso a Label, é usado para informar em qual elemento ele está dentro
		 * por exemplo, se no lugar do 'this' estivesse a variável 'compositeMain', quer dizer que na tela, essa Label está
		 * dentro do compositeMain (compositeMain é o nome da variável, e no caso ela é um composite)  */
		Label labelBanner = new Label(this, SWT.NONE);
		FormData fd_labelBanner = new FormData();
		labelBanner.setLayoutData(fd_labelBanner);
		// Dentro dessa label eu coloquei uma imagem, usando a função setImage
		labelBanner.setImage(bannerImage);		
		//As variáveis de baixo são usadas para definir o posicionamento (ainda não entendi como se usa elas)
		fd_labelBanner.left = new FormAttachment(0);
		fd_labelBanner.right = new FormAttachment(100);
		fd_labelBanner.top = new FormAttachment(0);
		
		Label lblRestauranteLogo = new Label(this, SWT.NONE);
		lblRestauranteLogo.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		fd_labelBanner.bottom = new FormAttachment(lblRestauranteLogo, -6);
		FormData fd_lblRestauranteLogo = new FormData();
		fd_lblRestauranteLogo.top = new FormAttachment(0, 110);
		fd_lblRestauranteLogo.left = new FormAttachment(0, 36);
		lblRestauranteLogo.setLayoutData(fd_lblRestauranteLogo);
		// Dentro dessa label eu coloquei uma imagem, usando a função setImage
		lblRestauranteLogo.setImage(restauranteLogoImage);
		
		Label lblRestauranteNome = new Label(this, SWT.NONE);
		fd_lblRestauranteLogo.right = new FormAttachment(100, -318);
		// Editando o background da label
		lblRestauranteNome.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		// Editando a cor da letra da label
		lblRestauranteNome.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(4, 42, 94))));
		// Editando o tipo de fonte da label
		lblRestauranteNome.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 17, SWT.BOLD)));
		FormData fd_lblRestauranteNome = new FormData();
		fd_lblRestauranteNome.top = new FormAttachment(labelBanner, 6);
		fd_lblRestauranteNome.right = new FormAttachment(100, -41);
		fd_lblRestauranteNome.left = new FormAttachment(lblRestauranteLogo, 6);
		lblRestauranteNome.setLayoutData(fd_lblRestauranteNome);
		lblRestauranteNome.setText("Boa Pizza - Delivery");
		
		/* Note que eu utilizei o SWT.WRAP, que é usado para quebrar o texto quando o tamanho da label é menor que o texto
		 * mas por padrão é utilizado o SWT.NONE*/
		Label lblRestauranteDescricao = new Label(this, SWT.WRAP);
		fd_lblRestauranteNome.bottom = new FormAttachment(lblRestauranteDescricao, -6);
		lblRestauranteDescricao.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 9, SWT.BOLD)));
		lblRestauranteDescricao.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblRestauranteDescricao.setAlignment(SWT.CENTER);
		FormData fd_lblRestauranteDescricao = new FormData();
		fd_lblRestauranteDescricao.right = new FormAttachment(100, -41);
		fd_lblRestauranteDescricao.left = new FormAttachment(lblRestauranteLogo, 6);
		fd_lblRestauranteDescricao.top = new FormAttachment(0, 154);
		lblRestauranteDescricao.setLayoutData(fd_lblRestauranteDescricao);
		lblRestauranteDescricao.setText("Bem-vindo à \"Boa Pizza\", onde cada mordida é uma viagem ao coração da Itália! ");
		
		Label lblRestauranteEndereco = new Label(this, SWT.WRAP);
		fd_lblRestauranteLogo.bottom = new FormAttachment(lblRestauranteEndereco, -6);
		fd_lblRestauranteDescricao.bottom = new FormAttachment(lblRestauranteEndereco, -21);
		lblRestauranteEndereco.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 9, SWT.BOLD)));
		lblRestauranteEndereco.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblRestauranteEndereco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblRestauranteEndereco.setAlignment(SWT.CENTER);
		FormData fd_lblRestauranteEndereco = new FormData();
		fd_lblRestauranteEndereco.top = new FormAttachment(0, 240);
		fd_lblRestauranteEndereco.right = new FormAttachment(100, -73);
		fd_lblRestauranteEndereco.left = new FormAttachment(0, 91);
		lblRestauranteEndereco.setLayoutData(fd_lblRestauranteEndereco);
		lblRestauranteEndereco.setText("R. da Consolação, 3527 - Cerqueira César, SP    1.5km de você");
		
		Label lblCardapioNome = new Label(this, SWT.NONE);
		fd_lblRestauranteEndereco.bottom = new FormAttachment(lblCardapioNome, -34);
		lblCardapioNome.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblCardapioNome.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblCardapioNome.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 15, SWT.BOLD)));
		FormData fd_lblCardapioNome = new FormData();
		fd_lblCardapioNome.left = new FormAttachment(0, 36);
		fd_lblCardapioNome.top = new FormAttachment(0, 312);
		lblCardapioNome.setLayoutData(fd_lblCardapioNome);
		lblCardapioNome.setText("Pizzas");
		
		/* O Composite eu utilizo como um container e coloco os elemento que quero dentro dele, e pra ajustar esses elementos e utilizo 
		 o gridLayout, porque ficam espaçados na mesma ordem.
		 Para você utilizar o gridLayout você pode procurar na parte de Layouts, na aba de Design, depois que você clicar nele é só clicar
		 no composite que deseja que tenha o gridLayout*/
		Composite compositePizzas = new Composite(this, SWT.NONE);
		compositePizzas.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositePizzas.setLayout(new FormLayout());
		FormData fd_compositePizzas = new FormData();
		fd_compositePizzas.left = new FormAttachment(labelBanner, 0, SWT.LEFT);
		fd_compositePizzas.top = new FormAttachment(lblCardapioNome, 6);
		fd_compositePizzas.right = new FormAttachment(100);
		fd_compositePizzas.bottom = new FormAttachment(100);
		compositePizzas.setLayoutData(fd_compositePizzas);
		
		Composite compositeItem1 = new Composite(compositePizzas, SWT.NONE);
		compositeItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		FormData fd_compositeItem1 = new FormData();
		fd_compositeItem1.left = new FormAttachment(0, 29);
		fd_compositeItem1.top = new FormAttachment(0, 10);
		compositeItem1.setLayoutData(fd_compositeItem1);
		compositeItem1.setLayout(new GridLayout(1, false));
		
		Button buttonImagePizza1 = new Button(compositeItem1, SWT.NONE);
		/*Função que adiciona um evento de click no botão*/
		buttonImagePizza1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/*Depois que o button é clicado, é chamada uma função da página principal, para mudar de tela*/
				mainPage.navigateToScreen(2);
			}
		});
		/*Como o botão tinha bordas e ficava feio, tive que usar a função abaixo para adicionar a imagem e tirar as bordas*/
		buttonImagePizza1.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    /*Aqui é onde é colocado a imagem, sendo o primeiro parâmetro a imagem, o segundo é 
			     * tipo um padding-top e o último é um padding-left*/
			    event.gc.drawImage(pizza1, 6, 0);
			  }
			} );
		buttonImagePizza1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_buttonImagePizza1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_buttonImagePizza1.widthHint = 132;
		gd_buttonImagePizza1.heightHint = 111;
		buttonImagePizza1.setLayoutData(gd_buttonImagePizza1);
		
		Label lblTituloItem1 = new Label(compositeItem1, SWT.WRAP);
		lblTituloItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTituloItem1.setAlignment(SWT.CENTER);
		GridData gd_lblTituloItem1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTituloItem1.widthHint = 122;
		lblTituloItem1.setLayoutData(gd_lblTituloItem1);
		lblTituloItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblTituloItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblTituloItem1.setText("Pizza de Peperonni");
		
		Label lblPrecoItem1 = new Label(compositeItem1, SWT.NONE);
		GridData gd_lblPrecoItem1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPrecoItem1.widthHint = 117;
		lblPrecoItem1.setLayoutData(gd_lblPrecoItem1);
		lblPrecoItem1.setAlignment(SWT.CENTER);
		lblPrecoItem1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoItem1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblPrecoItem1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		lblPrecoItem1.setText("R$46,99");
		
		Composite compositeItem2 = new Composite(compositePizzas, SWT.NONE);
		fd_compositeItem1.bottom = new FormAttachment(compositeItem2, 0, SWT.BOTTOM);
		fd_compositeItem1.right = new FormAttachment(compositeItem2, -6);
		compositeItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeItem2.setLayout(new GridLayout(1, false));
		FormData fd_compositeItem2 = new FormData();
		fd_compositeItem2.bottom = new FormAttachment(100, -70);
		fd_compositeItem2.top = new FormAttachment(0, 10);
		compositeItem2.setLayoutData(fd_compositeItem2);
		
		Button buttonImagePizza2 = new Button(compositeItem2, SWT.NONE);
		/*Função que adiciona um evento de click no botão*/
		buttonImagePizza2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreen(2);
			}
		});
		/*Adicionar imagem e tirar bordas*/
		buttonImagePizza2.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(pizza2, 6, 0);
			  }
			} );
		buttonImagePizza2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_buttonImagePizza2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_buttonImagePizza2.widthHint = 125;
		gd_buttonImagePizza2.heightHint = 112;
		buttonImagePizza2.setLayoutData(gd_buttonImagePizza2);
		
		Label lblTituloItem2 = new Label(compositeItem2, SWT.WRAP);
		lblTituloItem2.setAlignment(SWT.CENTER);
		GridData gd_lblTituloItem2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTituloItem2.widthHint = 122;
		lblTituloItem2.setLayoutData(gd_lblTituloItem2);
		lblTituloItem2.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblTituloItem2.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblTituloItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTituloItem2.setText("Pizza de Frango");
		
		Label lblPrecoItem2 = new Label(compositeItem2, SWT.NONE);
		GridData gd_lblPrecoItem2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPrecoItem2.widthHint = 123;
		lblPrecoItem2.setLayoutData(gd_lblPrecoItem2);
		lblPrecoItem2.setAlignment(SWT.CENTER);
		lblPrecoItem2.setText("R$49,99");
		lblPrecoItem2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoItem2.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblPrecoItem2.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		Composite compositeItem3 = new Composite(compositePizzas, SWT.NONE);
		fd_compositeItem2.right = new FormAttachment(compositeItem3, -6);
		compositeItem3.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositeItem3.setLayout(new GridLayout(1, false));
		FormData fd_compositeItem3 = new FormData();
		fd_compositeItem3.bottom = new FormAttachment(100, -70);
		fd_compositeItem3.top = new FormAttachment(0, 10);
		fd_compositeItem3.left = new FormAttachment(0, 319);
		fd_compositeItem3.right = new FormAttachment(100, -29);
		compositeItem3.setLayoutData(fd_compositeItem3);
		
		Button buttonImagePizza3 = new Button(compositeItem3, SWT.NONE);
		/*Função que adiciona um evento de click no botão*/
		buttonImagePizza3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainPage.navigateToScreen(2);
			}
		});
		/*Adicionar imagem e tirar bordas*/
		buttonImagePizza3.addPaintListener( new PaintListener() {
			  @Override
			  public void paintControl( PaintEvent event ) {
			    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_WHITE ) );
			    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
			    event.gc.drawImage(pizza3, 6, 0);
			  }
			} );
		buttonImagePizza3.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		GridData gd_buttonImagePizza3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_buttonImagePizza3.widthHint = 123;
		gd_buttonImagePizza3.heightHint = 112;
		buttonImagePizza3.setLayoutData(gd_buttonImagePizza3);
		
		Label lblTituloItem3= new Label(compositeItem3, SWT.NONE);
		lblTituloItem3.setText("Pizza de Queijo");
		lblTituloItem3.setAlignment(SWT.CENTER);
		GridData gd_lblTituloItem3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTituloItem3.heightHint = 58;
		gd_lblTituloItem3.widthHint = 122;
		lblTituloItem3.setLayoutData(gd_lblTituloItem3);
		lblTituloItem3.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTituloItem3.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblTituloItem3.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		
		Label lblPrecoItem3 = new Label(compositeItem3, SWT.NONE);
		GridData gd_lblPrecoItem3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPrecoItem3.widthHint = 117;
		lblPrecoItem3.setLayoutData(gd_lblPrecoItem3);
		lblPrecoItem3.setText("R$79,99");
		lblPrecoItem3.setAlignment(SWT.CENTER);
		lblPrecoItem3.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoItem3.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblPrecoItem3.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));

	}
}
