package ad;

import java.io.Serializable;

public class PartieJeu implements Serializable {

	
	int numero_partie,score;
	String num_quest;
	StringBuffer reponse_en_cour;
	Themejeu theme_partie;
	//constructeur de la partie
	PartieJeu(int np,String nq,int s,Themejeu thp)
	{
		this.numero_partie=np;
		this.num_quest=nq;
		this.score=s;
		this.theme_partie=thp;
	}
	Boolean checkCaractère(char c,Mere qst) {
	   int i=0;
	   Boolean trouver=false;
	   while(i< this.reponse_en_cour.length())
	   {
		   if (c ==  qst.reponse.charAt(i)) {
			   this.reponse_en_cour.setCharAt(i,c);
			   trouver=true;
		   }
		   i++;
	   }
		return trouver;
	
	}
	
	
	
	
}