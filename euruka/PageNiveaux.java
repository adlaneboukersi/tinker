package ad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PageNiveaux {
	
	 JFrame niv = new JFrame("choix de niveaux");
	
	 Button re = new Button("revenir au choix de themes");
	 Button niv1 = new Button();
	 Button niv2 = new Button();
	 Button niv3 = new Button();
	 Button niv4 = new Button();
	 Button niv5 = new Button();
	 
	 JLabel ni = new JLabel("choisi(e) un niveaux de deficulte");
	
	 Font police = new Font("Arial",Font.BOLD,18);
	
	public PageNiveaux(final Themejeu th,final Joueur j,final int num_partie,final HashSet<Themejeu> themes_initialise)
	{
		

	 	niv.setSize(900,520);
	     niv.getContentPane().setBackground(Color.black);
	     
	     ImageIcon icon_niv1 = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\niv1.jpg");
	     ImageIcon icon_niv2 = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\niv2.jpg");
	     ImageIcon icon_niv3 = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\niv3.jpg");
	     ImageIcon icon_niv4 = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\niv4.jpg");
	     ImageIcon icon_niv5 = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\niv5.jpg");
			
	    
		   re.setBounds(250,440,320,32);
		   re.setFont(police);
		    re.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ThemePage n = new ThemePage(themes_initialise, j,num_partie);
					niv.dispose();
				}
			});
		    niv.add(re);

	 	
	    
		    
		     niv1.setBounds(420,90,280,32);
		     niv1.setBorder(BorderFactory.createLineBorder(Color.black));
		     niv1.setIcon(icon_niv1);
		     niv1.setFont(police);

	     niv1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					// TODO Auto-generated method stub
					
					lancer(1,th,num_partie,themes_initialise,j);
					
					}
				
			});
	    
	    
	     niv2.setBounds(70,170,280,32);
	     niv2.setIcon(icon_niv2);
	     niv2.setBorder(BorderFactory.createLineBorder(Color.black));
	     niv2.setFont(police);
	     niv2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				
					lancer(2,th,num_partie,themes_initialise,j);
						
					
				}
			});
	     
	     
	     niv3.setBounds(420,240,280,32);
	     niv3.setIcon(icon_niv3);
	     niv3.setFont(police);
	     niv3.setBorder(BorderFactory.createLineBorder(Color.black));
	     niv3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					lancer(3,th,num_partie,themes_initialise,j);
					
				}
			});
	     
	     niv4.setBounds(70,310,280,32);
	     niv4.setIcon(icon_niv4);
	     niv4.setFont(police);
	     niv4.setBorder(BorderFactory.createLineBorder(Color.black));
	     niv4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					lancer(4,th,num_partie,themes_initialise,j);
					
				}
			});
	     
	     niv5.setBounds (420,370,280,32);
	     niv5.setIcon(icon_niv5);
	     niv5.setBorder(BorderFactory.createLineBorder(Color.black));
	     niv5.setFont(police);
	     niv5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					lancer(5,th,num_partie,themes_initialise,j);
					
				}
			});
	     if(Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().get(th.type)<2)
	     {
	    	 niv2.setEnabled(false);
	    	 niv3.setEnabled(false);
	    	 niv4.setEnabled(false);
	    	 niv5.setEnabled(false);
	     }else
	     {
	    	 if(Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().get(th.type)<3)
	    	 {
	    		 niv3.setEnabled(false);
		    	 niv4.setEnabled(false);
		    	 niv5.setEnabled(false);
	    	 }else
	    	 {
	    		 if(Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().get(th.type)<4)
	    		 {
	    			 niv4.setEnabled(false);
			    	 niv5.setEnabled(false);
	    		 }else
	    			 if(Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().get(th.type)<5)
	    			 {
	    				 niv5.setEnabled(false);
	    			 }
	    	 }
	     }
	    
	    
		    ni.setBounds(250,20,320,32);
		    ni.setFont(police);
		    ni.setForeground(Color.white);
		    
	    niv.add(ni);
	    niv.add(niv5);
	    niv.add(niv4);
	    niv.add(niv3);
	    niv.add(niv2);
	    niv.add(niv1);
	   
	         
	     niv.setLayout(new BorderLayout());
	     niv.setResizable(false);
	     niv.setLocationRelativeTo(null);
	     niv.setVisible(true); 
	 
	}
	
	
	void lancer(int niv, Themejeu th,int num_partie, HashSet<Themejeu> themes_initialise,Joueur j)
	{
		th.questions.get(niv-1).niveau=niv;
		int i=0;StringBuffer tmp = new StringBuffer(th.questions.get(niv-1).reponse);
		while(i<th.questions.get(niv-1).reponse.length())
		{
			tmp.setCharAt(i, '*');
			i++;
		}
		
		
		
		PartieJeu partie_lancer= new PartieJeu(num_partie,th.questions.get(niv-1).numéro,0,th);
		//System.out.println(partie_lancer.num_quest+"  "+partie_lancer.numero_partie);
		partie_lancer.reponse_en_cour=tmp;
		
		Partie pot = new Partie(partie_lancer,j,th.questions.get(niv-1),themes_initialise);
	}

}
