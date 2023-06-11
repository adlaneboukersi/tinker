package ad;

import java.io.Serializable;

public class Mere implements Serializable{
	int niveau;
	String numéro;
	String libellé;
    String reponse;
	String image;
	
	Mere(String num, String lib,String rep )
	{
		
		this.libellé=lib;
		this.numéro=num;
		this.reponse=rep;
		
	}
 
 
	int getNBPoints()
	{
		switch (this.niveau)
		{
	    	case 1: return 5; 
	    	case 2: return 10;   
    		case 3: return 18;   
    		case 4: return 28; 
			case 5: return 40;
			default: return 0;
		}
	}
}