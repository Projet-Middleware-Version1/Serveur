package entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int numCli;
	private String nom;
	private String prenom;
	@ManyToOne
	@JoinColumn(name="numag")
	private Agence numag;
	public Client(int numCli, String nom, String prenom, Agence numag) {
		super();
		this.numCli = numCli;
		this.nom = nom;
		this.prenom = prenom;
		this.numag = numag;
	}
	public Client() {
		super();
	}
	public int getNumCli() {
		return numCli;
	}
	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Agence getNumag() {
		return numag;
	}
	public void setNumag(Agence numag) {
		this.numag = numag;
	}
	
}
