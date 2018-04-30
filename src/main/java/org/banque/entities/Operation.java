package org.banque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name="V",value=Versement.class),
	@Type(name="R",value=Retrait.class)
})
public class Operation implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroOperation;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="CODE_EMP")
	private Employe employe;
	
	public Operation() {
		super();
	}
	
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	
	public Long getNumeroOperation() {
		return numeroOperation;
	}
	public void setNumeroOperation(Long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	@JsonIgnore
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte cp) {
		this.compte = cp;
	}
	@JsonIgnore
	public Employe getEmploye() {
		return employe;
	}
	@JsonSetter
	public void setEmploye(Employe emp) {
		this.employe = emp;
	}

}
