package br.ce.wcaquino.entidade;

public enum TipoAluguel {
	COMUM,
	EXTENDIDO,
	SEMANAL;

	public static TipoAluguel of(String tipo) {
		if("comum".equals(tipo)) {
			return TipoAluguel.COMUM;
		}
		
		if("extendido".equals(tipo)) {
			return TipoAluguel.EXTENDIDO;
		}		
		
		return TipoAluguel.SEMANAL;
	}
}
