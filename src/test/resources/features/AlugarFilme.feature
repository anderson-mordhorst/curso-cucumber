# language: pt
#Author: anderson.mordhorst@gmail.com

Funcionalidade: alugar filme
	Como um usuário
	Eu quero cadastrar aluguéis de filmes
	Para controlar preços e datas de entrega
	
Cenario: Deve alugar um filme com sucesso
	Dado um filme
	| estoque | 2 |
	| aluguel | 3 | 
	| tipo    | comum | 
	Quando alugar
	Então o preço do aluguel será R$ 3
	E a data de entrega será em 1 dia
	E o estoque do filme será 1 unidade
	
Cenário: Não deve alugar filme sem estoque
	Dado um filme com estoque de 0 unidades
	Quando alugar
	Então não será possível por falta de estoque
	E o estoque do filme será 0 unidade
	
Esquema do Cenário: Deve dar condições conforme tipo do aluguel
	Dado um filme com estoque de 2 unidades
	E que o preço do aluguel seja R$ <preco>
	E que o tipo do aluguel seja <tipo>
	Quando alugar
	Então o preço do aluguel será R$ <valor>
	E a data de entrega será em <dias> dias
	E a pontuação será de <pontos> pontos
	
Exemplos:	
	| preco | tipo      | valor | dias | pontos |
	| 4     | extendido | 8     | 3    | 2      |
	| 4     | comum     | 4     | 1    | 1      |
	| 5     | semanal   | 15    | 7    | 3      |		
	