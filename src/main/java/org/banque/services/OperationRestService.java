package org.banque.services;

import org.banque.metier.OperationMetier;
import org.banque.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {
	
	@Autowired
	private OperationMetier operationMetier;

	@RequestMapping(value = "/versement", method = RequestMethod.PUT)
	public boolean verser(@RequestParam String codeCompte, @RequestParam double montant, @RequestParam Long codeEmploye) {
		return operationMetier.verser(codeCompte, montant, codeEmploye);
	}

	@RequestMapping(value = "/retrait", method = RequestMethod.PUT)
	public boolean retirer(@RequestParam String codeCompte, @RequestParam double montant, @RequestParam Long codeEmploye) {
		return operationMetier.retirer(codeCompte, montant, codeEmploye);
	}

	@RequestMapping(value = "/virement", method = RequestMethod.PUT)
	public boolean virement(@RequestParam String cpte1, @RequestParam String cpte2, @RequestParam double montant, @RequestParam Long codeEmploye) {
		return operationMetier.virement(cpte1, cpte2, montant, codeEmploye);
	}

	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	public PageOperation getOperations(@RequestParam String codeCompte, @RequestParam int page, @RequestParam int size) {
		return operationMetier.getOperations(codeCompte, page, size);
	}

	
	
	

}
