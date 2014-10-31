segespl : core games* :: _segespl ;

games : quiz+ :: quiz_
	| cards [minplayers] [maxplayers] [bugs] :: simules ;

quiz : reutilizacao
	| arquitetura
	| idiomas
	| aspectos
	| componentes ;

cards : buy cardsets :: _cards ;

buy : fixed
	| rolldice ;

cardsets : engineers [problems] [practices] :: _cardsets ;

minplayers : min2p
	| min4p ;

maxplayers : max4p
	| max6p ;

