package com.minsait.emprestimo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CPF
	private String cpfClient;
	@NotNull
	private Double initialValue;
	private Double finalValue;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date initialDate;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date finalDate;
	private Relation relation;
	public Loan(Double initialValue, Date initialDate, Date finalDate, Relation relation) {
		this.initialValue = initialValue;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.relation = relation;
	}
	
	
	
}
