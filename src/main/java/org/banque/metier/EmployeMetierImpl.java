package org.banque.metier;

import java.util.List;

import org.banque.dao.EmployeRepository;
import org.banque.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeMetierImpl implements EmployeMetier {

	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public Employe saveEmploye(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public List<Employe> listEmploye() {
		return employeRepository.findAll();
	}

}
