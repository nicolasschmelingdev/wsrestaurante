<h1> Gerenciador de Lanches </h1>
Este é um projeto de aplicação web que tem como objetivo gerenciar um negócio de venda de lanches. A aplicação permite que o usuário escolha entre as opções de cardápio ou personalize seu próprio lanche. Além disso, a aplicação oferece promoções que dão descontos para lanches que atendem a determinadas regras.

## Ingredientes
A seguir, apresentamos a lista de ingredientes disponíveis e seus respectivos preços:

Alface: R$ 0,40<br>
Bacon: R$ 2,00<br>
Hambúrguer: R$ 3,00<br>
Ovo: R$ 0,80<br>
Queijo: R$ 1,50<br>

## Opções de Cardápio
Segue as opções de cardápio e seus respectivos ingredientes:

X-Bacon: Bacon, hambúrguer de carne e queijo<br>
X-Burger: Hambúrguer de carne e queijo<br>
X-Egg: Ovo, hambúrguer de carne e queijo<br>
X-Egg Bacon: Ovo, bacon, hambúrguer de carne e queijo<br>

*O valor de cada opção do cardápio é dado pela soma dos ingredientes que compõem o lanche. Caso o usuário atualize o preço de alguem ingrediente que compõe o lanche o preço de todos os lanches que possuem aquele ingrediente serão atualizados*

## Personalização de Lanches

O cliente pode personalizar seu lanche e escolher os ingredientes que desejar. Nesse caso, o preço do lanche também será calculado pela soma dos ingredientes.

## Promoções

A seguir, apresentamos a lista de promoções e suas respectivas regras de negócio:

Light: Se o lanche tem alface e não tem bacon, ganha 10% de desconto.

*Um metodo verifica se o pedido tem alface e nao tem bacon, tanto como ingredientes adicionais(lanche personalizado) quando com lanche selecionado + ingrediente adicional. Ex: X-Bacon + 2 Alfaces > O usuário não terá direito ao desconto de 10% no preço final (promoção Light)*

Muita carne: A cada 3 porções de hambúrguer o cliente só paga 2, a cada 6 porções, o cliente pagará 4 e assim sucessivamente.
Muito queijo: A cada 3 porções de queijo o cliente só paga 2, a cada 6 porções, o cliente pagará 4 e assim sucessivamente.

*Um metodo verifica a existência da quantidade de queijo/hamburguer presente tanto no lanche personalizado quanto no personalizado + lanche escolhido*

## Critérios de Entrega

O projeto foi desenvolvido em Java 8, utilizando Maven para gerenciar as dependências. Além disso, foi utilizado o framework Spring Boot para controle transacional e de persistência para banco de dados (Spring Data). O Banco de dados utilizado foi MySql. A aplicação foi implementada em uma arquitetura REST API e está disponível em um repositório git com instruções de execução, assim como a Query criada para produção das tabelas e relações utilizadas.

## Diferenciais

Além da implementação dos critérios de entrega, foram implementados os seguintes diferenciais:

Segurança: a aplicação utiliza autenticação e autorização para proteger as rotas de acesso POST através de ferramentas gerenciadas pelo Spring Security.
Swagger: a aplicação disponibiliza uma documentação Swagger com a descrição de todas as rotas disponíveis.
Clean Code: a aplicação foi desenvolvida seguindo as boas práticas de programação, com foco na legibilidade e manutenibilidade do código.

Para executar a aplicação, siga os seguintes passos:

* Clone o repositório em sua máquina local.
* Certifique-se de ter o Java 8 (JDK 1.8)
* Faça a build do projeto através do comando mvn spring-boot:run
* Caso deseje fazer a depuração faça através de algum depurador remoto como "Remote Java Application"
* Utilize os seguintes dados para as requisições que exigem Basic Auth (Metodos POST):
<p>			Usuario: nicolas </p>
<p>			Senha: 12345678  </p>




