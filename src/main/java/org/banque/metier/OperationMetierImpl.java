package org.banque.metier;

import java.util.Date;

import org.banque.dao.CompteRepository;
import org.banque.dao.EmployeRepository;
import org.banque.dao.OperationRepository;
import org.banque.entities.Compte;
import org.banque.entities.Employe;
import org.banque.entities.Operation;
import org.banque.entities.Retrait;
import org.banque.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OperationMetierImpl implements OperationMetier{
	
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public boolean verser(String codeCompte, double montant, Long codeEmploye) {
		Compte cp = compteRepository.findOne(codeCompte);
		Employe emp = employeRepository.findOne(codeEmploye);
		if (cp == null || emp == null){
			throw new RuntimeException("Compte ou Employé inexistant");
		}
		Operation op = new Versement();
		op.setDateOperation(new Date());
		op.setMontant(montant);
		op.setCompte(cp);
		op.setEmploye(emp);
		operationRepository.save(op);
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}

	@Override
	public boolean retirer(String codeCompte, double montant, Long codeEmploye) {
		Compte cp = compteRepository.findOne(codeCompte);
		Employe emp = employeRepository.findOne(codeEmploye);
		if (cp == null || emp == null){
			throw new RuntimeException("Compte ou Employé inexistant");
		}
		if (cp.getSolde() < montant){
			throw new RuntimeException("Solde insuffisant !");
		}
		Operation op = new Retrait();
		op.setDateOperation(new Date());
		op.setMontant(montant);
		op.setCompte(cp);
		op.setEmploye(emp);
		operationRepository.save(op);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Override
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmploye) {
		retirer(cpte1, montant, codeEmploye);
		verser(cpte2, montant, codeEmploye);
		return true;
	}

	@Override
	public PageOperation getOperations(String codeCompte, int page, int size) {
		@SuppressWarnings("deprecation")
		Page<Operation> ops = operationRepository.getOperation(codeCompte, new PageRequest(page, size));
		PageOperation pageOperaion = new PageOperation();
		pageOperaion.setOperations(ops.getContent());
		pageOperaion.setNombreOperation(ops.getNumberOfElements());
		pageOperaion.setNumeroPage(ops.getNumber());
		pageOperaion.setTotalPages(ops.getTotalPages());
		pageOperaion.setTotalOperation((int)ops.getTotalElements());
		return pageOperaion;
	}
	
	

}
