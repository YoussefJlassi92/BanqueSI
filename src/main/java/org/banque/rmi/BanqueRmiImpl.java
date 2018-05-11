package org.banque.rmi;

import java.rmi.RemoteException;

import org.banque.entities.Compte;
import org.banque.metier.CompteMetier;
import org.banque.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myRmiService")
public class BanqueRmiImpl implements BanqueRmiRemote{
	
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;

	@Override
	public Compte saveCompte(Compte compte) throws RemoteException {
		return compteMetier.saveCompte(compte);
	}

	@Override
	public Compte getCompte(String codeCompte) throws RemoteException {
		return compteMetier.getCompte(codeCompte);
	}

	@Override
	public boolean verser(String codeCompte, double montant, Long codeEmploye) throws RemoteException {
		return operationMetier.verser(codeCompte, montant, codeEmploye);
	}

	@Override
	public boolean retirer(String codeCompte, double montant, Long codeEmploye) throws RemoteException {
		return operationMetier.retirer(codeCompte, montant, codeEmploye);
	}

	@Override
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmploye) throws RemoteException {
		return operationMetier.virement(cpte1, cpte2, montant, codeEmploye);
	}

}
