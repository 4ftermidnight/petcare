package br.com.aftermidnight.petcare.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "medicamentouso")
public class MedicamentoUso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long codigo;
	
	@NotBlank(message = "Nome do medicamento é obrigatório")
	private String nome;
	
	@NotBlank(message = "Motivo é obrigatório")
	private String motivo;
	
	@Column(name = "data_registro")
	private LocalDate data_registro;
	
	@OneToMany(mappedBy = "codigo")
	private List<CalendarioMedUso> calendario;
	
	@NotNull(message = "O animal é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_animal")
	private Animal animal;
	
	@Column(name = "observacao")
	private String observacao;
	
	
	
	
	

}
