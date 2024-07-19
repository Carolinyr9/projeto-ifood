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
public class Home extends Composite {

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
    
    public Home(Composite parent, MainPage mainPage) {
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
		
		Label lblBoaPizza = new Label(this, SWT.NONE);
		fd_lblRestauranteLogo.right = new FormAttachment(100, -318);
		// Editando o background da label
		lblBoaPizza.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		// Editando a cor da letra da label
		lblBoaPizza.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(4, 42, 94))));
		// Editando o tipo de fonte da label
		lblBoaPizza.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 17, SWT.BOLD)));
		FormData fd_lblBoaPizza = new FormData();
		fd_lblBoaPizza.top = new FormAttachment(labelBanner, 6);
		fd_lblBoaPizza.right = new FormAttachment(100, -41);
		fd_lblBoaPizza.left = new FormAttachment(lblRestauranteLogo, 6);
		lblBoaPizza.setLayoutData(fd_lblBoaPizza);
		lblBoaPizza.setText("Boa Pizza - Delivery");
		
		/* Note que eu utilizei o SWT.WRAP, que é usado para quebrar o texto quando o tamanho da label é menor que o texto
		 * mas por padrão é utilizado o SWT.NONE*/
		Label lblBemvindoboa = new Label(this, SWT.WRAP);
		fd_lblBoaPizza.bottom = new FormAttachment(lblBemvindoboa, -6);
		lblBemvindoboa.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 9, SWT.BOLD)));
		lblBemvindoboa.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblBemvindoboa.setAlignment(SWT.CENTER);
		FormData fd_lblBemvindoboa = new FormData();
		fd_lblBemvindoboa.right = new FormAttachment(100, -41);
		fd_lblBemvindoboa.left = new FormAttachment(lblRestauranteLogo, 6);
		fd_lblBemvindoboa.top = new FormAttachment(0, 154);
		lblBemvindoboa.setLayoutData(fd_lblBemvindoboa);
		lblBemvindoboa.setText("Bem-vindo à \"Boa Pizza\", onde cada mordida é uma viagem ao coração da Itália! ");
		
		Label lblNewLabel = new Label(this, SWT.WRAP);
		fd_lblRestauranteLogo.bottom = new FormAttachment(lblNewLabel, -6);
		fd_lblBemvindoboa.bottom = new FormAttachment(lblNewLabel, -21);
		lblNewLabel.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 9, SWT.BOLD)));
		lblNewLabel.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblNewLabel.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblNewLabel.setAlignment(SWT.CENTER);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.top = new FormAttachment(0, 240);
		fd_lblNewLabel.right = new FormAttachment(100, -73);
		fd_lblNewLabel.left = new FormAttachment(0, 91);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("R. da Consolação, 3527 - Cerqueira César, SP    1.5km de você");
		
		Label lblPizzas = new Label(this, SWT.NONE);
		fd_lblNewLabel.bottom = new FormAttachment(lblPizzas, -34);
		lblPizzas.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPizzas.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblPizzas.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 15, SWT.BOLD)));
		FormData fd_lblPizzas = new FormData();
		fd_lblPizzas.left = new FormAttachment(0, 36);
		fd_lblPizzas.top = new FormAttachment(0, 312);
		lblPizzas.setLayoutData(fd_lblPizzas);
		lblPizzas.setText("Pizzas");
		
		/* O Composite eu utilizo como um container e coloco os elemento que quero dentro dele, e pra ajustar esses elementos e utilizo 
		 o gridLayout, porque ficam espaçados na mesma ordem.
		 Para você utilizar o gridLayout você pode procurar na parte de Layouts, na aba de Design, depois que você clicar nele é só clicar
		 no composite que deseja que tenha o gridLayout*/
		Composite compositePizzas = new Composite(this, SWT.NONE);
		compositePizzas.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositePizzas.setLayout(new FormLayout());
		FormData fd_compositePizzas = new FormData();
		fd_compositePizzas.left = new FormAttachment(labelBanner, 0, SWT.LEFT);
		fd_compositePizzas.top = new FormAttachment(lblPizzas, 6);
		fd_compositePizzas.right = new FormAttachment(100);
		fd_compositePizzas.bottom = new FormAttachment(100);
		compositePizzas.setLayoutData(fd_compositePizzas);
		
		Composite compositePizza1 = new Composite(compositePizzas, SWT.NONE);
		compositePizza1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		FormData fd_compositePizza1 = new FormData();
		fd_compositePizza1.left = new FormAttachment(0, 29);
		fd_compositePizza1.top = new FormAttachment(0, 10);
		compositePizza1.setLayoutData(fd_compositePizza1);
		compositePizza1.setLayout(new GridLayout(1, false));
		
		Button buttonImagePizza1 = new Button(compositePizza1, SWT.NONE);
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
		
		Label lblTituloPizza1 = new Label(compositePizza1, SWT.WRAP);
		lblTituloPizza1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTituloPizza1.setAlignment(SWT.CENTER);
		GridData gd_lblTituloPizza1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTituloPizza1.widthHint = 122;
		lblTituloPizza1.setLayoutData(gd_lblTituloPizza1);
		lblTituloPizza1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblTituloPizza1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblTituloPizza1.setText("Pizza de Peperonni");
		
		Label lblPrecoPizza1 = new Label(compositePizza1, SWT.NONE);
		GridData gd_lblPrecoPizza1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPrecoPizza1.widthHint = 117;
		lblPrecoPizza1.setLayoutData(gd_lblPrecoPizza1);
		lblPrecoPizza1.setAlignment(SWT.CENTER);
		lblPrecoPizza1.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoPizza1.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblPrecoPizza1.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		lblPrecoPizza1.setText("R$46,99");
		
		Composite compositePizza2 = new Composite(compositePizzas, SWT.NONE);
		fd_compositePizza1.bottom = new FormAttachment(compositePizza2, 0, SWT.BOTTOM);
		fd_compositePizza1.right = new FormAttachment(compositePizza2, -6);
		compositePizza2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositePizza2.setLayout(new GridLayout(1, false));
		FormData fd_compositePizza2 = new FormData();
		fd_compositePizza2.bottom = new FormAttachment(100, -70);
		fd_compositePizza2.top = new FormAttachment(0, 10);
		compositePizza2.setLayoutData(fd_compositePizza2);
		
		Button buttonImagePizza2 = new Button(compositePizza2, SWT.NONE);
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
		
		Label lblTituloPizza2 = new Label(compositePizza2, SWT.WRAP);
		lblTituloPizza2.setAlignment(SWT.CENTER);
		GridData gd_lblTituloPizza2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTituloPizza2.widthHint = 122;
		lblTituloPizza2.setLayoutData(gd_lblTituloPizza2);
		lblTituloPizza2.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblTituloPizza2.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		lblTituloPizza2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTituloPizza2.setText("Pizza de Frango");
		
		Label lblPrecoPizza2 = new Label(compositePizza2, SWT.NONE);
		GridData gd_lblPrecoPizza2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPrecoPizza2.widthHint = 123;
		lblPrecoPizza2.setLayoutData(gd_lblPrecoPizza2);
		lblPrecoPizza2.setAlignment(SWT.CENTER);
		lblPrecoPizza2.setText("R$49,99");
		lblPrecoPizza2.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoPizza2.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblPrecoPizza2.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));
		Composite compositePizza3 = new Composite(compositePizzas, SWT.NONE);
		fd_compositePizza2.right = new FormAttachment(compositePizza3, -6);
		compositePizza3.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		compositePizza3.setLayout(new GridLayout(1, false));
		FormData fd_compositePizza3 = new FormData();
		fd_compositePizza3.bottom = new FormAttachment(100, -70);
		fd_compositePizza3.top = new FormAttachment(0, 10);
		fd_compositePizza3.left = new FormAttachment(0, 319);
		fd_compositePizza3.right = new FormAttachment(100, -29);
		compositePizza3.setLayoutData(fd_compositePizza3);
		
		Button buttonImagePizza3 = new Button(compositePizza3, SWT.NONE);
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
		
		Label lblTituloPizza3= new Label(compositePizza3, SWT.NONE);
		lblTituloPizza3.setText("Pizza de Queijo");
		lblTituloPizza3.setAlignment(SWT.CENTER);
		GridData gd_lblTituloPizza3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTituloPizza3.heightHint = 58;
		gd_lblTituloPizza3.widthHint = 122;
		lblTituloPizza3.setLayoutData(gd_lblTituloPizza3);
		lblTituloPizza3.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblTituloPizza3.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.NORMAL)));
		lblTituloPizza3.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(19, 41, 61))));
		
		Label lblPrecoPizza3 = new Label(compositePizza3, SWT.NONE);
		GridData gd_lblPrecoPizza3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPrecoPizza3.widthHint = 117;
		lblPrecoPizza3.setLayoutData(gd_lblPrecoPizza3);
		lblPrecoPizza3.setText("R$79,99");
		lblPrecoPizza3.setAlignment(SWT.CENTER);
		lblPrecoPizza3.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		lblPrecoPizza3.setForeground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(0, 100, 148))));
		lblPrecoPizza3.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 11, SWT.BOLD)));

	}
}
