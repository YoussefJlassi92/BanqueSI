package org.banque.metier;

import java.util.List;

import org.banque.entities.Employe;

public interface EmployeMetier {
	public Employe saveEmploye(Employe employe);
	public List<Employe> listEmploye();

}
