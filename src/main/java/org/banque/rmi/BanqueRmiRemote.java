package org.banque.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.banque.entities.Compte;

public interface BanqueRmiRemote extends Remote {
	
	public Compte saveCompte (Compte compte) throws RemoteException;
	public Compte getCompte (String codeCompte) throws RemoteException;
	public boolean verser(String codeCompte, double montant, Long codeEmploye) throws RemoteException;;
	public boolean retirer(String codeCompte, double montant, Long codeEmploye) throws RemoteException;;
	public boolean virement(String cpte1, String cpte2,double montant, Long codeEmploye) throws RemoteException;;

}
