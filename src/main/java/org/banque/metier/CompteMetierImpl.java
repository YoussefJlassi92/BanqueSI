package org.banque.metier;

import java.util.Date;
import java.util.List;

import org.banque.dao.CompteRepository;
import org.banque.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier{
	
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte compte) {
		compte.setDateCreation(new Date());
		return compteRepository.save(compte);
	}

	@Override
	public Compte getCompte(String codeCompte) {
		return compteRepository.findOne(codeCompte);
	}

	@Override
	public List<Compte> listCompte() {
		return compteRepository.findAll();
	}

}
