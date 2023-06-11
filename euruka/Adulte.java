package ad;

import java.util.HashSet;
import java.util.LinkedList;

public class Adulte extends Joueur
{

	Adulte(int ns, String mdp, String n, String p, String ddn, LinkedList<PartieJeu> lj) {
		super(ns, mdp, n, p, ddn, lj);
		// TODO Auto-generated constructor stub
	}
	
	LinkedList<Mere> getQuestions(String theme, HashSet<Themejeu> themes_initialise)
	{
		System.out.println("qst 2");
		LinkedList<Mere> liste =new LinkedList<Mere>();
		Boolean trouver = false;
		java.util.Iterator<Themejeu> itr = themes_initialise.iterator();
		Themejeu theme_actuel = null;
		while(itr.hasNext() && trouver==false)
		{
			theme_actuel = itr.next();
			if(theme_actuel.type==theme)
			{
				trouver=true;
			}
		}
		for(int i=0;i<5;i++)
		{
			liste.add(theme_actuel.questions.get(i));
		}
		return liste;
		
	}
	void decrisToi()
	{
		System.out.println(this.getClass()+"2");
		
    	System.out.println("nom : "+this.nom_joueur+" , prenom : "+this.prenom_joueur+" , date de naissance : "+this.dat_de_naissance_joueur);
    	System.out.println("son numero est : "+this.numero_joueur);
	    	
		    
	}

}
