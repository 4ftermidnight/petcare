package br.com.aftermidnight.petcare.model;

public enum TipoAnimal {

	CAO("Cachorro") {},
	GATO("Felino") {};
	
	
	TipoAnimal() {}
	
	private TipoAnimal(String descricao) {
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
