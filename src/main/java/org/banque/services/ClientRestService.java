package org.banque.services;

import java.util.List;

import org.banque.entities.Client;
import org.banque.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestService {

	@Autowired
	private ClientMetier clientMetier;

	@RequestMapping(value = "/clients/{codeClient}", method = RequestMethod.GET)
	public Client getClient(@PathVariable("codeClient") Long codeClient) {
		return clientMetier.getClient(codeClient);
	}

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		return clientMetier.saveClient(client);
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> listClient() {
		return clientMetier.listClient();
	}

	@RequestMapping(value = "/clients/{codeClient}", method = RequestMethod.DELETE)
	public boolean removeClient(@PathVariable("codeClient") Long codeClient) {
		return clientMetier.removeClient(codeClient);
	}

}
