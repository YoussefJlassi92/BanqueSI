package org.banque.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.banque.entities.Compte;
import org.banque.metier.CompteMetier;
import org.banque.metier.OperationMetier;
import org.banque.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService
public class BanqueSoapService {
	
	@Autowired
	private CompteMetier compteMetier;
	
	@Autowired
	private OperationMetier operationMetier;
	
	@WebMethod
	public Compte getCompte(@WebParam(name="codeCompte") String codeCompte) {
		return compteMetier.getCompte(codeCompte);
	}
	
	@WebMethod
	public boolean verser(@WebParam(name="codeCompte") String codeCompte, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmploye") Long codeEmploye) {
		return operationMetier.verser(codeCompte, montant, codeEmploye);
	}
	
	@WebMethod
	public boolean retirer(@WebParam(name="codeCompte") String codeCompte, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmploye") Long codeEmploye) {
		return operationMetier.retirer(codeCompte, montant, codeEmploye);
	}
	
	@WebMethod
	public boolean virement(@WebParam(name="cpte1") String cpte1, 
			@WebParam(name="cpte2") String cpte2, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmploye") Long codeEmploye) {
		return operationMetier.virement(cpte1, cpte2, montant, codeEmploye);
	}
	
	@WebMethod
	public PageOperation getOperations(@WebParam(name="codeCompte") String codeCompte, 
			@WebParam(name="page") int page, 
			@WebParam(name="size") int size) {
		return operationMetier.getOperations(codeCompte, page, size);
	}

}
