package br.com.aftermidnight.petcare.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "calendario_med_uso")
public class CalendarioMedUso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long codigo;
	
	@NotNull(message = "O medicamento é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_med_uso")
	private MedicamentoUso medicamentoUso;
	
	@Column(name = "data_uso")
	private LocalDate dataUso;
	
	private Boolean administrado;

	public CalendarioMedUso() {
		super();
	}

	public CalendarioMedUso(Long codigo, MedicamentoUso medicamentoUso, LocalDate dataUso, Boolean administrado) {
		super();
		this.codigo = codigo;
		this.medicamentoUso = medicamentoUso;
		this.dataUso = dataUso;
		this.administrado = administrado;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public MedicamentoUso getMedicamentoUso() {
		return medicamentoUso;
	}

	public void setMedicamentoUso(MedicamentoUso medicamentoUso) {
		this.medicamentoUso = medicamentoUso;
	}

	public LocalDate getDataUso() {
		return dataUso;
	}

	public void setDataUso(LocalDate dataUso) {
		this.dataUso = dataUso;
	}

	public Boolean getAdministrado() {
		return administrado;
	}

	public void setAdministrado(Boolean administrado) {
		this.administrado = administrado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarioMedUso other = (CalendarioMedUso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}

