package org.banque.metier;

import java.util.List;

import org.banque.dao.ClientRepository;
import org.banque.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMetierImpl implements ClientMetier{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public List<Client> listClient() {
		return clientRepository.findAll();
	}

	@Override
	public boolean removeClient(Long codeClient) {
		clientRepository.delete(codeClient);
		return true;
	}

	@Override
	public Client getClient(Long codeClient) {
		return clientRepository.findOne(codeClient);
	}
	
	
	

}
