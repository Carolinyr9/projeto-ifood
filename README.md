# Projeto SIEG

O SIEG (Sistemas de Entregas Gastronômicas), como o nome já diz, é um sistema que faz entregas de comidas. Nele é possível três tipos de usuários se logar, sendo o cliente, o entregador e o funcionário do restaurante.

<video src="documentacao/projetoSIEGvideo.mp4" width="320" height="240" controls autoplay></video>

## Stack utilizada

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

## Funcionalidades

<h3>Login</h3>

* Realizar login como cliente, funcionário ou entregador.

<h3>Na parte do cliente</h3>

* Visualizar de itens do restaurante;
* Visualizar de informações do item escolhido;
* Acrescentar itens ao carrinho;
* Deletar itens do carrinho;
* Fazer pedidos a partir dos itens do carrinho;
* Visualizar pedidos feitos;
* Visualizar informação sobre um pedido;
* Cancelar pedido.

<h3>Na parte do funcionário</h3>

* Visualizar cardápio do restaurante;
* Visualizar de itens do restaurante por sessão do cardápio;
* Visualizar de informações do item escolhido;
* Editar informações do item escolhido;
* Adicionar um item ao cardápio;
* Visualizar pedidos feitos por clientes;
* Visualizar informação sobre um pedido;
* Mudar status de um pedido para "aceitar", "em preparo" ou "em entrega".

<h3>Na parte do entregador</h3>

* Visualizar pedidos feitos por clientes;
* Visualizar informação sobre um pedido;
* Mudar status de um pedido para "entregue".

## Rodando localmente

O que você precisa ter antes de rodar:

* Eclipse IDE (De preferência)
* Java JDK (>= versão 21) 
* Puglins: WindowBuilder, SWT
* MySQL Workbench

1. Clone o projeto

```bash
  git clone https://github.com/Carolinyr9/projeto-ifood.git
```

2. Abra o **Eclipse IDE** e adicione o projeto a ele.

3. Adicione os arquivos jars dos plugins citados acima.

4. Abra o **MySQL Workbench** e importe o arquivo **BancoDadosDBDelivery** que está na pasta **database** do projeto

5. Por fim, rode o projeto 

## Autores
| [Adriely Ferreira Santos](https://www.linkedin.com/in/adriely-ferreira-santos-4b2831257/) | [Alex Miranda Silva](https://www.linkedin.com/in/alex-miranda-8878561a1/) | [Caroliny Rocha Sampaio](https://www.linkedin.com/in/caroliny-rocha-sampaio/) | [Jéssica Bueno Ramos](https://www.linkedin.com/in/jessica-bueno-ramos-275315150/) | 
|:--:|:----:|:----:|:----:|
| <img width="140px" src="https://media.licdn.com/dms/image/v2/D4D03AQFwAjfYROy6bQ/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1719761742783?e=1729728000&v=beta&t=aFd9hpg36EcX1eZdS9adz1t3kn6npUkRBfg5uFTNFX4" /> | <img width="140px" src="https://media.licdn.com/dms/image/v2/D4D03AQGWYpbQazyjjQ/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1688527886483?e=1729728000&v=beta&t=1afiDfQMZJgSLp_Ctjk6x37B2xCuaGL_wCAZj46wTZA" /> | <img width="140px" src="https://media.licdn.com/dms/image/v2/D4D03AQFwdxZ2nVGpgw/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1701464799453?e=1729728000&v=beta&t=jUcXwrgsNHMasNwfxFAQfyPCv7Xzc3r8islczB2wk7g" /> | <img width="140px" src="https://media.licdn.com/dms/image/v2/D4D03AQEUbHQf8Kx8aA/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1706197354963?e=1729728000&v=beta&t=hPhmR8Wvk-LwuajymfB-OpXo5pdeCgqizKlW9MxWvLI" /> | 




