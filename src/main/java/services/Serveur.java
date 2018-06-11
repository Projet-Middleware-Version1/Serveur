package services;

import java.net.*;
import java.util.*;

import javax.swing.*;
import entites.*;
import dao.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Serveur extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea zonerecep;
	 private JButton qt;
	 private JPanel pan1,pan2;

	 public Serveur()
	 {
	     zonerecep=new JTextArea(15,40);
	    qt=new JButton("Quitter");
	    setTitle(" Serveur TCP Multiclients");
	    pan1=new JPanel();
	    pan2=new JPanel();
	    pan1.add(new JScrollPane(zonerecep));
	    qt.addActionListener(this);
	    pan2.add(qt);
	    add(pan1,BorderLayout.CENTER);
	    add(pan2,BorderLayout.SOUTH);
	    setSize(500,600);
	    setLocationRelativeTo(null);
	    setVisible(true);


	     try
	    {
	        ServerSocket serv = new ServerSocket(8000);
	        zonerecep.append("Le Serveur a demarre "+"\n");
	        int numclient=1;
	        while(true)
	        {
	            Socket socket=serv.accept();
	            InetAddress adr = socket.getInetAddress();
	            String ipclient = adr.getHostAddress();
	            String nomclient= adr.getHostName();
	            zonerecep.append("client n°:"+numclient+" adresse ip:"+ipclient+"\n");
	            zonerecep.append("nom machine cliente: "+nomclient+"\n");
	            Service s = new Service(socket);
	            s.start();
	            numclient++;
	        }

	    }
	    catch(IOException ex)
	    {
	        System.out.println(ex.getMessage());
	    }
	 }

	 //class interne
	    class Service extends Thread
	    {
	       private  Socket socket;
	       private  IBanqueDaoImpl bd;
	        public Service(Socket socket)
	        {
	        	bd = new IBanqueDaoImpl();
	            this.socket=socket;
	            	   
	        }
	        public void run()
	        {
	            try
	            {
	          
	        
	           ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
	           ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
	           DataOutputStream out = new DataOutputStream(socket.getOutputStream());
	           DataInputStream in = new DataInputStream(socket.getInputStream());
	       	
	           String mode;
	           do
	           {
	        	    
	            mode =(String)ois.readObject();
	             zonerecep.append("mode en cours d\'expoitation!!!: "+mode+"\n");
	             if (mode.equals("ajoutAgence"))
	             {
	                  
	                  Agence ag = (Agence) ois.readObject();
                      bd.addAgence(ag);
                          
	             }
	             else if (mode.equals("listerAgence"))
                 {
	       
	                 

	               	 ArrayList<Agence> liste = new ArrayList<Agence>();
	               	   liste=(ArrayList<Agence>) bd.listAgences(); 
	                    oos.writeObject(liste);
	                    oos.flush();
	               }
	             else if(mode.equals("ajoutCli"))
	             {
	            	 Client cli = (Client) ois.readObject();
	            	 bd.addClient(cli);
	             }
	             else if(mode.equals("listerClientParAgence"))
	             {
	            	 ArrayList<Client> listecli = new ArrayList<Client>();
	            	 listecli = (ArrayList<Client>) bd.listClientsParAgence();
	             }
	             else if(mode.equals("ajoutCompte"))
	             {
	            	 Compte cmpt = (Compte) ois.readObject();
	            	 bd.addCompte(cmpt);
	             }
	             else if(mode.equals("listerCompteParNum"))
	             {
	            	 ArrayList<Compte> listeComp = new ArrayList<Compte>();
	            	 int num = 0;
					listeComp = (ArrayList<Compte>) bd.listComptesClient(num);
	             }
	             else if(mode.equals("releve"))
	             {
	            	 ArrayList<Operation> releve = new ArrayList<Operation>();
	            	 releve = (ArrayList<Operation>) bd.listReleve();
	             }
	             else if (mode.equals("fin"))
	             {
	                      zonerecep.append("Connexion terminee!!! pour un client"+"\n");
	                      oos.flush();
	                     
	             }
	             }
	           
	             while(true);
	           
	            }
	            catch(Exception ex)
	            {
	                System.out.println("****"+ex.getMessage());
	            }
	          
	            

	    }
	 }//fin classe interne

	  public void actionPerformed(ActionEvent e)
	    {
	        dispose();
	        System.exit(0);
	    }



	    public static void main(String args[])
	    {
	        new Serveur();
	    }
	
}

