package br.com.aftermidnight.petcare.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "animal")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long codigo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_animal")
	private TipoAnimal tipoAnimal;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@Size(max = 200, message = "O tamanho da descrição deve estar entre 1 e 200")
	private String descricao;
	
	@NotNull(message = "O cliente é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_dono")
	private Cliente cliente;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@OneToMany(mappedBy = "codigo")
	private List<MedicamentoUso> medicamentoUso;
	
	
		
	@Column(name = "foto")
	private String foto;
	
	@Column(name = "content_type")
	private String contentType;
	
	
	@Transient
	private boolean novaFoto;
	
	@Transient
	private String urlFoto;
	
	@Transient
	private String urlThumbnailFoto;
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	
	public Animal() {
		super();
	}
	
	public Animal(Long codigo, TipoAnimal tipoAnimal, String nome, String descricao, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.tipoAnimal = tipoAnimal;
		this.nome = nome;
		this.descricao = descricao;
		this.cliente = cliente;
	}
	
	
	
	
	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}


	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public boolean isNovaFoto() {
		return novaFoto;
	}


	public void setNovaFoto(boolean novaFoto) {
		this.novaFoto = novaFoto;
	}


	public String getUrlFoto() {
		return urlFoto;
	}


	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}


	public String getUrlThumbnailFoto() {
		return urlThumbnailFoto;
	}


	public void setUrlThumbnailFoto(String urlThumbnailFoto) {
		this.urlThumbnailFoto = urlThumbnailFoto;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
	
	
	
}
