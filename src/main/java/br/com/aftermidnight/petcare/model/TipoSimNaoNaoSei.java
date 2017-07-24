package br.com.aftermidnight.petcare.model;

public enum TipoSimNaoNaoSei {

	SIM("Sim") {},
	NAO("Não") {},
	NAOSEI("Não Sei") {};
	
	
	TipoSimNaoNaoSei() {}
	
	private TipoSimNaoNaoSei(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;
	
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}		
}
