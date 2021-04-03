# Custumer Service

# Orientação a objetos

♦  A **Injeção de dependencia** é usada para "separarmos" certos métodos de outras classes e ainda sim usa-los, isso para que uma classe não fique totalmente dependente de outra dificultando assim a manutenabilidade.
por isso é usada a injeção de dependencia, pois na maioria dos casos ela provem de uma interface que por sua vez possui metodos implementados, então caso precisemos adidionar um parametro a um método, não será necessário altera-lo
em todas as outras classes em que ele foi colocado.
ao fazermos uma injeção dependência nós utilizamos a anotação @Autowired fazendo com que a mesma tenha seus metodos instanciados automaticamente em outras classes.

♦ **SOLID** são principios da POO, onde são levados em consideração as boas práticas de programação, e consistência do código, como exemplo nós temos os pricipios de aberto/fechado onde requer que as principais classes sejam extendiveis porém não modificaveis.
principio de responsabilidade unica, onde a classe precisa excluir-se de redundancias no código, isso inclui o Boilerplate code que é basicamente repetição de linhas já codificadas, implicando indiretamente com o principio de baixo acoplamento.

♦**Design pattern Strategy** Onde temos diversas classes se relacionando de forma "externa" com outros algoritmos como interfaces e repositorios, essa estratégia é para que possam ser criados novos códigos e os mesmo tenham ligações independentes com uma classe entidade, repositorio e camada de serviço.
um exemplo é a própria criação de interfaces para termos metodos implementados de serviços, então nós criamos algumas classes de serviços e fazemos a interface implementar seus metodos, assim as classes que vão consumir esses metodos passarão a ter injetadas
nelas a interface.

# Spring Framework

♦Possuo projetos com Spring Security, com os dois metodos de implementação de autenticação (autenticação via memória e autenticação via banco de dados com criptografia de senha), também com Spring Data JPA Onde ele faz a intermediação de dados de clases Entity, coim o banco
além de agregar colunas para classes filhas e persistencia de dados no DB. **Spring MVC** onde temos o conceito de camadas MVC -  Model, View e controller, nesse conceito podemos trabalhar desenvolvendo uma api (como nesse caso) e introduzir camadas "intermediárias"
para essa api com uma view. o **controller** recebe as requisições onde ele faz um "pré-processamento" dessas requisições, as trata e as envia mais fundo no back-END, onde o restante do tratamento é feito lá e também a persistencia, ou select.
**view** recebe as requisiçoes de volta já tratadas e com os seus devidos parametros já setados para a exibição em um HTML.
**model** executa e trata as regras de negocio que foram mais a fundo, aqui ficam as entidades e respostas tratadas, convertidas ou negadas (exceptions), um exemplo de um tipo de classe model são essas entidades onde sempre estão presentes na orientação a objetos.

♦No Spring podemos injetar Beans como algumas anotações que são @Bean, @Service, @Repository os mesmos podem ter configurações pré-setadas e complementadas através da injeção em outras classes. além dessas existem outras anotações que fazem o spring gerenciar as classes
e também testes.

♦As **transações** que podem ser anotadas com @Transactional, que possuem um tipo de "memória temporaria" na qual a mesma gerencia certas transações com o banco de dados e as sincroniza para que haja a persistência com o banco, isso inclui entidades filhas que estão relacionadas
às principais entidades via @OneToMany e @ManyToOne.

# Rest

♦ **Serviços RestFull** são serviços que provem de uma API que pode ser feita ou consumida em JSON ou XML, essas APIs possuem entrada de dados onde esses dados são tratados e retornados para consumo de um Client como o Angular por exemplo.
no exemplo desse projeto foi consumida um API de endereço, onde entramos com o CEP, o e as outras informações são preechidas automaticamente graças a estrutura MVC que permite a captura da requisição, processamento dos dados pelo WebClient e retorno na view
pronto para consumo.

♦**Algumas das boas práticas** são a utilização correta dos verbos GET, POST, PUT e DELETE onde o aprofundamento desse mapeamento nos leva ao nível HATEOAS que possibilita a fácil compreensão da API para manutenção ou consumo.

♦**GET** -> Utilizado para requisitar uma ou mais informações do back-END, seja ela do bando de dados ou não.
  **POST** -> Utilizado para enviar dados para a persistencia no banco.
  **PUT**  -> Utilizado para a atualização de dados, na maioria das vezes é necessário passar o identificados para que o objeto seja atualizado.
  **DELETE** -> Utilizado para deletar um objeto do banco, seguindo o principio do PUT onde é passado o identificador ou o corpo completo do JSON via RequestBody.
  
♦ **200** indica que a solicitação obteve sucesso
   **400**  indica que há algo de errado com a solicitação e a mesma precisa ser refeita
   **500** indica que há um erro no servidor ou na camada bruta de negócio.
   
                                  # SOBRE O PROJETO
	
	  Foi implementado o código de cadastro de pessoa com nome, email e uma lista de endereço, onde para passarmos esses valores é só seguirmos o seguinte padrão:
	  
	    {
        "name": "Adelson",
        "email": "delsonsaint@hotmail.com",
		"address": [
		     {"cep":"08775050"}, 
			 {"cep":"08775060"}, 
		]
        
     
    }
	
	[POST] o corpo mostrado anteriormente define que serão buscados 2 CEPs e serão preenchidos automaticamente os outros campos e os mesmos serão vinculados a esse nome.
	
	[GET] fazendo um GET para "/customers" nós teremos uma lista de pessoas e seus endereços vinculados, para esse PATH a busca não terá pagincação.
	
	[GET] fazendo um GET para "/customer/pages" nós teremos uma lista de pessoas e seus endereços, para customizarmos a buscar nós inserimos no caminho "?page=1&size=5" , onde **page** significa a pagina a ser carregadas e **size** significa quantos objetos serão carregados por página
	
	[PUT] fazendo um PUT para "/customers/update" nós atualizamos apenas a pessoa, não é necessário passar os objetos do endereço.
	
	[DELETE] fazendo um DELETE para "/customers/delete" nós excluimos uma pessoa e seus endereços agregados, é necessário passar apenas o id,nome e email, sem os objetos do endereço.
	
#                                       ♦
EM CASO DE DÚVIDAS É SÓ ME CHAMAR VIA E-MAIL OU WHATSAPP
	

### Requisitos

1. JDK 8
1. Maven 3

### Rodando

1. Clone o projeto: `https://github.com/leonardohenrique/tokio-test.git`
1. Entre na pasta `tokio-test` e execute: `mvn spring-boot:run`
1. Acesse: `http://localhost:8080/customers`



