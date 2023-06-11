package jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Euruka {


	static HashMap<Integer, Joueur > dictionaire_de_joueur = new HashMap<Integer, Joueur>();
	static HashSet<Themejeu> ensemble_de_theme = new HashSet<Themejeu> (); 
	
	
	
	
	//le constcructeur initialise les joueur
	public Euruka() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		
	

		File fichier = new File("C://Users//ADMIN//Desktop//euruka//utilisateurs.ser");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fichier)));
		String line = reader.readLine();
		if(line!=null)
		{	
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://Users//ADMIN//Desktop//euruka//utilisateurs.ser"));
			
			Euruka.dictionaire_de_joueur = (HashMap<Integer, Joueur>) ois.readObject();
			ois.close();
			System.out.println("laa taille est "+Euruka.dictionaire_de_joueur.size());
			
		
		}
	}
	

	
	public Joueur inscription(String nom,String prenom,String date,String mp,String comp) throws IOException, ClassNotFoundException
	{
		int i=0;
		Boolean trouver=false;
		Joueur joueur_connecte =null;
		LinkedList<PartieJeu> list_partie = new LinkedList<PartieJeu>();
		while(i<Euruka.dictionaire_de_joueur.size() && trouver==false)
		{
			if(nom.equals(Euruka.dictionaire_de_joueur.get(i+1).getNom_joueur()))
			{
				trouver=true;
			}
			else {
				i++;
			}
		}
		if(trouver==false)
		{
			Joueur joueur;
			System.out.println("hey");
			int x = Integer.parseInt(date.substring(0,4));
			System.out.println("date de naissance "+x);
			if(2020-x>16) 
			{
				joueur = new Adulte( Euruka.dictionaire_de_joueur.size(),mp,nom,prenom,date,list_partie);
				System.out.println("adulte");
			}
			else
			{
		      	 joueur = new Enfants( Euruka.dictionaire_de_joueur.size(),mp,nom,prenom,date,list_partie);
		      	System.out.println("enfant");
			}
			Euruka.dictionaire_de_joueur.put(joueur.getNumero_joueur(),joueur );
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://Users//ADMIN//Desktop//euruka//utilisateurs.ser"));
			oos.writeObject(Euruka.dictionaire_de_joueur);
			oos.close();
			
			
			joueur_connecte = joueur;
		}
		return joueur_connecte;
		
	}


	private LinkedList<Joueur> extracted(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		return (LinkedList<Joueur>) ois.readObject();
	}
	
	//methode de connexion 
	public Joueur connexion(String n,String mm) throws FileNotFoundException, IOException, ClassNotFoundException
		{ 
		 
		System.out.println(Euruka.dictionaire_de_joueur.size());
		Euruka.dictionaire_de_joueur.get(1).decrisToi();
		Joueur joueur_connecte = null;
		Boolean trouver=false,correct=false;
		int i=0;
		
		while(trouver==false && i<Euruka.dictionaire_de_joueur.size())
		{
			if(Euruka.dictionaire_de_joueur.get(i+1).getNom_joueur().equals(n))
			{
				trouver=true;
				if(Euruka.dictionaire_de_joueur.get(i+1).getMot_de_passe_joueur().equals(mm))
				{
					correct=true;
				    joueur_connecte = Euruka.dictionaire_de_joueur.get(i+1);
				}
			}
			i++;
		}
		if(trouver==false )
		{
			 JFrame wrong= new JFrame("erreur");
			 	wrong.setSize(265,200);
			     wrong.getContentPane().setBackground(Color.black);
			   
			     
			     JLabel falsnom = new JLabel("nom utilistaeur introuvable");
			     falsnom.setBounds(38,60, 200, 25);
			     falsnom.setForeground(Color.white);
			      
			     wrong.add(falsnom);
			     
			     wrong.setLayout(new BorderLayout());
			     wrong.setResizable(false);
			     wrong.setVisible(true);
			     wrong.setLocationRelativeTo(null);
			
		}else
		{
			if(correct==false)
			{
				JFrame faux= new JFrame("erreure");
			 	faux.setSize(265,200);
			     faux.getContentPane().setBackground(Color.black);
			   
			     
			     JLabel falsmot = new JLabel("mot de passe incorrect :( ");
			     falsmot.setForeground(Color.white);
			     falsmot.setBounds(40,60, 200, 25);
			      
			     faux.add(falsmot);
			     
			     faux.setLayout(new BorderLayout());
			     faux.setResizable(false);
			     faux.setVisible(true);
			     faux.setLocationRelativeTo(null);
			}
		}
		
		return joueur_connecte;
	}
	
	
	
	////////
	
	HashSet<Themejeu> Initialisation() throws IOException
	{
		
		
		
		Themejeu h = new Themejeu("histoire");
		h.questions=h.chargerQuestion("C://Users//ADMIN//Desktop//euruka//HISTOIRE.txt");
		//h.questions.add(e);
		ensemble_de_theme.add(h);
		
		
		Themejeu g = new Themejeu("geographie");
		g.questions=g.chargerQuestion("C://Users//ADMIN//Desktop//euruka//GEOGRAPHIE.txt");
		ensemble_de_theme.add(g);
		//g.questions.add(e1);
		
		Themejeu c = new Themejeu("culture generale");
		c.questions=c.chargerQuestion("C://Users//ADMIN//Desktop//euruka//CULTUREGENERALE.txt");
		ensemble_de_theme.add(c);
		//c.questions.add(e2);
		
		Themejeu s = new Themejeu("sante");
		s.questions=s.chargerQuestion("C://Users//ADMIN//Desktop//euruka//SANTE.txt");
		ensemble_de_theme.add(s);
		//s.questions.add(e3);
		
		Themejeu i = new Themejeu("islame");
		i.questions=i.chargerQuestion("C://Users//ADMIN//Desktop//euruka//ISLAM.txt");
		ensemble_de_theme.add(i);
		//i.questions.add(e4);
		
		return ensemble_de_theme;
		
	}
	
	//methode qui renvoi le score d'un joueur connecté
	
	int getScoreCourant(Joueur j)
	{
		return j.getTotalScore();
	}
	
}
