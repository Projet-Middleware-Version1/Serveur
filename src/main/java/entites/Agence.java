package entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agence implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int numag;
	private String nomag;
	private String adresseag;
	public int getNumag() {
		return numag;
	}
	public void setNumag(int numag) {
		this.numag = numag;
	}
	public String getNomag() {
		return nomag;
	}
	public void setNomag(String nomag) {
		this.nomag = nomag;
	}
	public String getAdresseag() {
		return adresseag;
	}
	public void setAdresseag(String adresseag) {
		this.adresseag = adresseag;
	}
	public Agence(int numag, String nomag, String adresseag) {
		super();
		this.numag = numag;
		this.nomag = nomag;
		this.adresseag = adresseag;
	}
	public Agence() {
		super();
	}
}

