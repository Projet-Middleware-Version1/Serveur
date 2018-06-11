package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import entites.Agence;
import entites.Client;
import entites.Compte;
import entites.Operation;


public class IBanqueDaoImpl implements IBanqueDao {

	private EntityManager em;
	public IBanqueDaoImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BANQUE");
		this.em = emf.createEntityManager();
	}
	
	public void addAgence(Agence ag) {
		// TODO Auto-generated method stub
		/*creation d'une transaction */
			EntityTransaction transaction = em.getTransaction();
		/* Demarage de la transaction */
			transaction.begin();
			try{
				/* Enregistrer l'agence dans la base de donnees */
					em.persist(ag);
					/* Validation de la transaction si ok */
					transaction.commit();
				}
				catch(Exception e){
					/* Annulation de la transaction si KO */
					transaction.rollback();
					e.printStackTrace();
					
				}
	}

	@SuppressWarnings("unchecked")
	public List<Agence> listAgences() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select ag from Agence ag");
		return query.getResultList();
	}

	public void addClient(Client cli) {
		// TODO Auto-generated method stub
			/*creation d'une transaction */
				EntityTransaction transaction = em.getTransaction();
			/* Demarage de la transaction */
				transaction.begin();
				try{
						/* Enregistrer l'agence dans la base de donnees */
						em.persist(cli);
						/* Validation de la transaction si ok */
						transaction.commit();
					}
					catch(Exception e){
						/* Annulation de la transaction si KO */
						transaction.rollback();
						e.printStackTrace();
						
					}
	 }

	@SuppressWarnings("unchecked")
	public List<Client> listClientsParAgence() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Select cli, ag from Client cli, Agence ag Where cli.numag = ag.numag GROUP BY ag.numag ");
		return query.getResultList();
	}

	public void addCompte(Compte comp) {
		// TODO Auto-generated method stub
		/*creation d'une transaction */
		EntityTransaction transaction = em.getTransaction();
		/* Demarage de la transaction */
		transaction.begin();
		try{
			/* Enregistrer le compte dans la base de donnees */
			em.persist(comp);
			/* Validation de la transaction si ok */
			transaction.commit();
		}
		catch(Exception e){
			/* Annulation de la transaction si KO */
			transaction.rollback();
			e.printStackTrace();
			
		}
		
		
	}

	@SuppressWarnings("unchecked")
	public List<Compte> listComptesClient(int num) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select cmpt from Compte cmpt where cmpt.numCli like :x");
		query.setParameter("x", num);
		return query.getResultList();
	}

	public void addOperation(Operation op) {
		// TODO Auto-generated method stub
		/*creation d'une transaction */
		EntityTransaction transaction = em.getTransaction();
		/* Demarage de la transaction */
		transaction.begin();
		try{
			/* Enregistrer l'operation dans la base de donnees */
			em.persist(op);
			/* Validation de la transaction si ok */
			transaction.commit();
		}
		catch(Exception e){
			/* Annulation de la transaction si KO */
			transaction.rollback();
			e.printStackTrace();
			
		}
		
		
	}

	public List<Operation> listReleve() {
		// TODO Auto-generated method stub
		Query query  = em.createQuery("select op, cmpt.sens,cmpt.solde from Operation op,Compte cmpt where op.numCpt = cmpt.numCpt ");
		return query.getResultList();
	}

}
