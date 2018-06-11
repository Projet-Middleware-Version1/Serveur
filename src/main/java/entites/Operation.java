package entites;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Operation {

	@Id 
	@GeneratedValue
	private int numOp;
	private String libOp;
	private Date dateOp;
	private double montOp;
	@ManyToOne
	@JoinColumn(name="numCli")
	private Client numCli;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(int numOp, String libOp, Date dateOp, double montOp, Client numCli) {
		super();
		this.numOp = numOp;
		this.libOp = libOp;
		this.dateOp = dateOp;
		this.montOp = montOp;
		this.numCli = numCli;
	}
	public int getNumOp() {
		return numOp;
	}
	public void setNumOp(int numOp) {
		this.numOp = numOp;
	}
	public String getLibOp() {
		return libOp;
	}
	public void setLibOp(String libOp) {
		this.libOp = libOp;
	}
	public Date getDateOp() {
		return dateOp;
	}
	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}
	public double getMontOp() {
		return montOp;
	}
	public void setMontOp(double montOp) {
		this.montOp = montOp;
	}
	public Client getNumCli() {
		return numCli;
	}
	public void setNumCli(Client numCli) {
		this.numCli = numCli;
	}
	
}
