package ad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.LinkedList;

public class Themejeu implements Serializable {

	 String type,libellé;
	 int coéfficient;
	 LinkedList<Mere>  questions = new LinkedList<Mere>(); 
	 
	 
	
	public Themejeu(String t) {
		// TODO Auto-generated constructor stub
		 this.type=t;
		 this.libellé="";
		 switch (t) 
		 {
		 case "histoire" : this.coéfficient=2;
		 case "islame" : this.coéfficient=3;
		 case "geographie" : this.coéfficient=2;
		 case "sante" : this.coéfficient=3;
		 case "culture generale" : this.coéfficient=2;
		 break;
		 
		 }
		 
	} 
	LinkedList<Mere> chargerQuestion(String chemain) throws IOException
	{
			int i,j,cmp;
			LinkedList<Mere> list_de_qst = new LinkedList();
			String num_qst = new String();
			String rep_qst= new String();
			String lib_qst = new String();
			File fichier_de_question = new File(chemain);
			BufferedReader reader;
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fichier_de_question)));
			String line;
			line = reader.readLine();
			while(line!=null)
			{
				cmp = 0; i = 0;j = 0;
				while(cmp<3)
				{
					if(line.charAt(i)==',')
					{
						cmp++;
					}
					if(cmp==1)
					{
						num_qst=line.substring(j,i);
						j=i+1;
						cmp++;
					}
					if(cmp==3)
					{
						lib_qst=line.substring(j,i);
						rep_qst = line.substring(i+1);
						
					}
					i++;
				}
				if(Integer.parseInt(num_qst.substring(3))<6)
				{
					Mere question = new QuestionAdulte(num_qst,lib_qst,rep_qst);
					list_de_qst.add(question);
				}else
				{
					Mere question = new QuestionEnfant(num_qst,lib_qst,rep_qst);
					list_de_qst.add(question);
				}

				
				line=reader.readLine();
			}
			reader.close();
			return list_de_qst;
	}
}