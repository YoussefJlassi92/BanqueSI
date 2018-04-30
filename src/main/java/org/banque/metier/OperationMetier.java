package org.banque.metier;

public interface OperationMetier {
	
	public boolean verser(String codeCompte, double montant, Long codeEmploye);
	public boolean retirer(String codeCompte, double montant, Long codeEmploye);
	public boolean virement(String cpte1, String cpte2,double montant, Long codeEmploye);
	public PageOperation getOperations(String codeCompte, int page, int size);

}
