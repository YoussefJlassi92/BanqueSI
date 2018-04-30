package org.banque.metier;

import java.io.Serializable;
import java.util.List;

import org.banque.entities.Operation;

public class PageOperation implements Serializable{
	
	private List<Operation> operations;
	private int numeroPage;
	private int nombreOperation;
	private int totalOperation;
	private int totalPages;
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public int getNumeroPage() {
		return numeroPage;
	}
	public void setNumeroPage(int numeroPage) {
		this.numeroPage = numeroPage;
	}
	public int getNombreOperation() {
		return nombreOperation;
	}
	public void setNombreOperation(int nombreOperation) {
		this.nombreOperation = nombreOperation;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalOperation() {
		return totalOperation;
	}
	public void setTotalOperation(int totalOperation) {
		this.totalOperation = totalOperation;
	}
	

}
