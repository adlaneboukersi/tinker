package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;



public class Enfants extends Joueur 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Enfants(int ns, String mdp, String n, String p, String ddn, LinkedList<PartieJeu> lj) {
		super(ns, mdp, n, p, ddn, lj);
		// TODO Auto-generated constructor stub
	}

	@Override
	LinkedList<Mere> getQuestions(String theme, HashSet<Themejeu> themes_initialise) {
		// TODO Auto-generated method stub
		System.out.println("qst 1");
		int i;
		LinkedList<Mere> liste =new LinkedList<Mere>();
		Boolean trouver = false;
		Iterator<Themejeu> itr = themes_initialise.iterator();
		Themejeu theme_actuel = null;
		while(itr.hasNext() && trouver==false)
		{
			theme_actuel = itr.next();
			if(theme_actuel.type==theme)
			{
				trouver=true;
			}
		}
		System.out.println(theme_actuel.type);
		for(i=5;i<10;i++)
		{
			liste.add(theme_actuel.questions.get(i));
		}
		return liste;
	}
	
	void decrisToi()
	{
		System.out.println(this.getClass());
		
    	System.out.println("nom : "+this.nom_joueur+" , prenom : "+this.prenom_joueur+" , date de naissance : "+this.dat_de_naissance_joueur);
    	System.out.println("son numero est : "+this.numero_joueur);
	    	
		    
	}
	
	

}
