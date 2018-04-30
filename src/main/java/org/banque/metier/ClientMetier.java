package org.banque.metier;

import java.util.List;

import org.banque.entities.Client;

public interface ClientMetier {
	public Client getClient(Long codeClient);
	public Client saveClient(Client client);
	public List<Client> listClient();
	public boolean removeClient(Long codeClient);

}
