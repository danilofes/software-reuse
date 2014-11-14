package sege.quiz;

public class QuestionsPool {

	public void initPool() {
		original();
		this.addQuestion(
			"A engenharia de software baseada em reúso é uma abordagem de desenvolvimento que tenta maximizar o uso de software existente.",
			"Verdadeiro",
			"Falso");
		this.addQuestion(
			"As unidades reusáveis de software podem ser de tamanhos diferentes. As opções abaixo indicam exemplos de tipos de reúso conforme a granularidade reusada, exceto.",
			"Reuso de frameworks",
			"Reuso de sistema de aplicação",
			"Reuso de componentes",
			"Reuso de objetos e funções");
		this.addQuestion(
			"As seguintes opções são vantagens da reutilização de software, exceto.",
			"Documentação completa e abrangente",
			"Redução de custos globais de desenvolvimento",
			"Risco de processo reduzido",
			"Conformidade com padrões",
			"Uso eficaz de especialistas");
		this.addQuestion(
			"As seguintes opções são potenciais problemas associados a reutilização de software, exceto.",
			"Maior treinamento da equipe",
			"Maiores custos de manutenção",
			"Manutenção de uma biblioteca de componentes",
			"Falta de ferramentas de suporte");
		this.addQuestion(
			"Qual dos seguintes fatores não é citado no livro texto como determinante para o planejamento de reutilização?",
			"Ferramentas disponíveis",
			"Cronograma de desenvolvimento",
			"Importância do software e seus requisitos não funcionais",
			"Domínio da aplicação");
		this.addQuestion(
			"Qual a técnica de reutilização abaixo que melhor se aplica a seguinte definição: “Classes abstratas e concretas que criam a estrutura de uma aplicação”?",
			"Frameworks",
			"Componentes",
			"Linhas de produtos",
			"Bibliotecas",
			"Padrões");
		this.addQuestion(
			"Qual a técnica de reutilização abaixo que melhor se aplica a seguinte definição: “Soluções genéricas para problemas recorrentes”?",
			"Padrões",
			"Frameworks",
			"Componentes",
			"Linhas de produtos",
			"Bibliotecas");
		this.addQuestion(
			"Qual a técnica de reutilização abaixo que melhor se aplica a seguinte definição: “Famílias de aplicações desenvolvidas em torno de uma arquitetura comum”?",
			"Linhas de produtos",
			"Frameworks",
			"Componentes",
			"Bibliotecas",
			"Padrões");
		this.addQuestion("Qual a técnica de reutilização abaixo que melhor se aplica a seguinte definição: “Subsistemas que são integrados para criação da aplicação”?",
			"Componentes",
			"Frameworks",
			"Linhas de produtos",
			"Bibliotecas",
			"Padrões");
		this.addQuestion("Qual a técnica de reutilização abaixo que melhor se aplica a seguinte definição: “Classes e funções que implementam abstrações comumente usadas”?",
			"Bibliotecas",
			"Frameworks",
			"Componentes",
			"Linhas de produtos",
			"Padrões");
	}
}