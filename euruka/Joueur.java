package ad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

abstract  class Joueur implements Serializable {
	protected int numero_joueur;
	protected String nom_joueur,prenom_joueur,dat_de_naissance_joueur,mot_de_passe_joueur;
    LinkedList<PartieJeu>  partiejeu =  new LinkedList<PartieJeu>();
    protected HashMap<String,Integer> niv_atteint = new HashMap<String,Integer>();
    
    Joueur(int ns,String mdp,String n,String p,String ddn,LinkedList<PartieJeu> lj){
    	this.numero_joueur=ns+1;
    	this.mot_de_passe_joueur=mdp;
    	this.nom_joueur=n;
    	this.prenom_joueur=p;
    	this.dat_de_naissance_joueur=ddn;
    	this.partiejeu=lj;
    	this.niv_atteint.put("histoire",1);
    	this.niv_atteint.put("sante",1);
    	this.niv_atteint.put("islame",1);
    	this.niv_atteint.put("geographie", 1);
    	this.niv_atteint.put("culture generale",1);
     }
    
    
    public int getNumero_joueur() {
		return numero_joueur;
	}


	public void setNumero_joueur(int numero_joueur) {
		this.numero_joueur = numero_joueur;
	}


	public String getNom_joueur() {
		return nom_joueur;
	}


	public void setNom_joueur(String nom_joueur) {
		this.nom_joueur = nom_joueur;
	}


	public String getPrenom_joueur() {
		return prenom_joueur;
	}


	public void setPrenom_joueur(String prenom_joueur) {
		this.prenom_joueur = prenom_joueur;
	}


	public String getDat_de_naissance_joueur() {
		return dat_de_naissance_joueur;
	}


	public void setDat_de_naissance_joueur(String dat_de_naissance_joueur) {
		this.dat_de_naissance_joueur = dat_de_naissance_joueur;
	}


	public String getMot_de_passe_joueur() {
		return mot_de_passe_joueur;
	}


	public void setMot_de_passe_joueur(String mot_de_passe_joueur) {
		this.mot_de_passe_joueur = mot_de_passe_joueur;
	}


	public LinkedList<PartieJeu> getPartiejeu() {
		return partiejeu;
	}


	public void setPartiejeu(LinkedList<PartieJeu> partiejeu) {
		this.partiejeu = partiejeu;
	}


	public HashMap<String, Integer> getNiv_atteint() {
		return niv_atteint;
	}


	public void setNiv_atteint(HashMap<String, Integer> niv_atteint) {
		this.niv_atteint = niv_atteint;
	}


	abstract void decrisToi();
   

	int getTotalScore() {
    	int t=0;
    	for(int i=0 ; i<partiejeu.size();i++) 
    	{
    		t= t+partiejeu.get(i).score;
    	}
    	return t;
    }


	abstract LinkedList<Mere> getQuestions(String thème, HashSet<Themejeu> themes_initialise);

}