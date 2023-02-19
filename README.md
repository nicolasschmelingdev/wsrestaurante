ESCRIÇÃO DO PROBLEMA

Somos uma startup do ramo de alimentos e precisamos de uma aplicação web para gerir
nosso negócio. Nossa especialidade é a venda de lanches, de modo que alguns lanches
são opções de cardápio e outros podem conter ingredientes personalizados.

INGREDIENTES
● Alface: R$ 0.40
● Bacon: R$ 2,00
● Hambúrguer: R$ 3,00
● Ovo: R$ 0,80
● Queijo: R$ 1,50

LANCHES

● X-Bacon: Bacon, hambúrguer de carne e queijo
● X-Burger: Hambúrguer de carne e queijo
● X-Egg: Ovo, hambúrguer de carne e queijo
● X-Egg Bacon: Ovo, bacon, hambúrguer de carne e queijo

O valor de cada opção do cardápio é dado pela soma dos ingredientes que compõe o
lanche. Além destas opções, o cliente pode personalizar seu lanche e escolher os
ingredientes que desejar. Nesse caso, o preço do lanche também será calculado pela soma
dos ingredientes.

Existe uma exceção à regra para o cálculo de preço, quando o lanche pertencer à uma
promoção. 

PROMOÇÃO

● Light: Se o lanche tem alface e não tem bacon, ganha 10% de desconto.

● Muita carne: A cada 3 porções de hambúrguer o cliente só paga 2, a cada 6
porções, o cliente pagará 4 e assim sucessivamente.

● Muito queijo: A cada 3 porções de queijo o cliente só paga 2, a cada 6
porções, o cliente pagará 4 e assim sucessivamente.

Inflação: Os valores dos ingredientes são alterados com frequência e não gostaríamos que
isso influenciasse.

CRITÉRIOS DE ENTREGA

O projeto deve ser entregue atendendo os seguintes critérios:

● O projeto deve ser desenvolvido em Java 8, utilizando Maven para gerenciar as
dependências. Além disso, deverá ser utilizado um framework de controle
transacional (Spring Boot ou Spring MVC) e de controle de persistência para banco
de dados.

● O projeto deverá ser realizado em uma arquitetura REST API.

● Disponibilizar o projeto, com instruções de execução, em um repositório git.

