package br.com.aftermidnight.petcare.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class Visita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long codigo;
	
	@NotNull(message = "O cliente é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;
	
	@Column(name = "data_visita_ini")
	private LocalDate dataVisitaInicio;
	
	@Column(name = "data_visita_fim")
	private LocalDate dataVisitaFim;
	
	@Column(name = "observacao")
	private LocalDate observacao;
	
	@DecimalMin(value = "0.50", message = "O valor da visita deve ser maior que R$0,50")
	@DecimalMax(value = "9999999.99", message = "O valor da visita deve ser menor que R$9.999.999,99")
	private BigDecimal valor;
	
	@DecimalMax(value = "9999999.99", message = "O valor do custo deve ser menor que R$9.999.999,99")
	private BigDecimal custo;
		
	private Boolean pago;
	
	
	@PrePersist 
	@PreUpdate
	private void prePersistPreUpdate(){
		if(this.dataVisitaFim == null){
			dataVisitaFim = dataVisitaInicio;
		}
	}

	public Visita() {
		super();
	}

	public Visita(Long codigo, Cliente cliente, LocalDate dataVisitaInicio, LocalDate dataVisitaFim, LocalDate observacao,
			BigDecimal valor, BigDecimal custo, Boolean pago) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.dataVisitaInicio = dataVisitaInicio;
		this.dataVisitaFim = dataVisitaFim;
		this.observacao = observacao;
		this.valor = valor;
		this.custo = custo;
		this.pago = pago;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataVisitaInicio() {
		return dataVisitaInicio;
	}

	public void setDataVisitaInicio(LocalDate dataVisitaInicio) {
		this.dataVisitaInicio = dataVisitaInicio;
	}

	public LocalDate getDataVisitaFim() {
		return dataVisitaFim;
	}

	public void setDataVisitaFim(LocalDate dataVisitaFim) {
		this.dataVisitaFim = dataVisitaFim;
	}

	public LocalDate getObservacao() {
		return observacao;
	}

	public void setObservacao(LocalDate observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
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
		Visita other = (Visita) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
	
}
