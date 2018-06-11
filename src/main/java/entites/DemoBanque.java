package entites;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IBanqueDaoImpl;

public class DemoBanque {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BANQUE");
		EntityManager em = emf.createEntityManager();
		IBanqueDaoImpl bd = new IBanqueDaoImpl();
		Agence ag = new Agence();
		//ag.setNumag(1);
		ag.setNomag("CBAO");
		ag.setAdresseag("Point E");
		bd.addAgence(ag);
		List<Agence> l = bd.listAgences();
		for(Agence a:l)
		{
			System.out.println(a.getNumag()+" "+a.getNomag()+" "+a.getAdresseag());
		}
		 Client cli = new Client();
		cli.setNom("Yero");
		cli.setPrenom("Diallo");
		cli.setNumag(ag);
		bd.addClient(cli);

	}

}
