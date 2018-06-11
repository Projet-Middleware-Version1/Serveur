package entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length=10)
	private String numCpt;
	private String libelle;
	private String sens;
	public enum sens
	{
		CR,
		DB
	};
	private double solde;
	@ManyToOne
	@JoinColumn(name="numCli")
	private Client numCli;
	

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(String numCpt, String libelle, String sens, double solde, Client numCli) {
		super();
		this.numCpt = numCpt;
		this.libelle = libelle;
		this.sens = sens;
		this.solde = solde;
		this.numCli = numCli;
	}

	public String getNumCpt() {
		return numCpt;
	}

	public void setNumCpt(String numCpt) {
		this.numCpt = numCpt;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Enumerated(EnumType.STRING)
	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getNumCli() {
		return numCli;
	}

	public void setNumCli(Client numCli) {
		this.numCli = numCli;
	}
	
}
