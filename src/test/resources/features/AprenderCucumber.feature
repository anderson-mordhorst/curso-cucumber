# language: pt
Funcionalidade: Aprender cucumber
	Como um aluno
	Eu quero aprender a utilizar o cucumber
	Para que eu possa automatizar critérios de aceitação
	
Cenário: Deve executar especificação
	Dado que criei o arquivo corretamente
	Quando executá-lo
	Então a especificação deve finalizar com sucesso
	
Cenario: Deve incrementar contador
	Dado que o valor do contador é 15
	Quando eu incrementar em 5
	Então o valor do contador será 20
	
Cenário: Deve calcular atraso na entrega
	Dado que a entrega é dia 05/04/2018
	Quando a entrega atrasar em 2 dias
	Então a entrega será efetuada em 07/04/2018
	
Cenário: Deve calcular atraso na entrega da China
	Dado que a entrega é dia 05/04/2018
	Quando a entrega atrasar em 2 meses
	Então a entrega será efetuada em 05/06/2018	
