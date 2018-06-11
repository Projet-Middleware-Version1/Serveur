package dao;

import java.util.List;

import entites.Agence;
import entites.Client;
import entites.Compte;
import entites.Operation;

public interface IBanqueDao {

	public void addAgence(Agence ag);
	public List<Agence> listAgences();
	public void addClient(Client cli);
	public List<Client> listClientsParAgence();
	public void addCompte(Compte comp);
	public List<Compte> listComptesClient(int num);
	public void addOperation(Operation op);
	public List<Operation> listReleve();
}
