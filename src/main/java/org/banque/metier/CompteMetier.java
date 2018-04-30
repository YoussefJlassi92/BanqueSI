package org.banque.metier;

import java.util.List;

import org.banque.entities.Compte;

public interface CompteMetier {
	
	public Compte saveCompte(Compte compte);
	public Compte getCompte(String codeCompte);
	public List<Compte> listCompte();

}
