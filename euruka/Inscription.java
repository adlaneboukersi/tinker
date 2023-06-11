package jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Inscription {
	
	// TODO Auto-generated method stub
			String Mois[] = { "janvier", "février", "mars", "arvil",
	                "mai", "juin", "juillet", "août", "septembre",
	                "octobre", "novembre", "décembre" };

	        //Vecteur des années pour le combo box des années
	        String Annees[] = { "1995", "1996", "1997", "1998",
	                "1999", "2000", "2001", "2002",
	                "2003", "2004", "2005", "2006",
	                "2007", "2008", "2009", "2010",
	                "2011", "2012", "2013", "2014",
	                "2015", "2016", "2017", "2018",
	                "2019", "2020" };
	        String Jours[] = { "1", "2", "3", "4", "5",
	                "6", "7", "8", "9", "10",
	                "11", "12", "13", "14", "15",
	                "16", "17", "18", "19", "20",
	                "21", "22", "23", "24", "25",
	                "26", "27", "28", "29", "30",
	                "31" };
	        String nom_util,prenom_util,date_util,mot;
	        char[] mot_de_passe_util;			
	        char[] conf_mot_de_passe;
	        
	        
	        JFrame thi = new JFrame();
	        
	        JLabel nom = new JLabel("Nom:");
	        JLabel prenom = new JLabel("Prenom:");
	        JLabel dateNaissance = new JLabel("Date de naissance:");
	        JLabel mdp = new JLabel("Ajouter un mot de passe:");
	        JLabel rmdp = new JLabel("Confirmer le mot de passe:");
	        JLabel deja = new JLabel("Avez vous déja un compte?");
	        JLabel err_nom = new JLabel("pas moin de 5 car");
	        JLabel err_mdp = new JLabel("pas moin de 5 car");
	    	
	        
	        JTextField nomtf = new JTextField();
	        JTextField prenomtf = new JTextField();
	        JPasswordField mdptf = new JPasswordField();
	        JPasswordField rmdptf = new JPasswordField();
	        JComboBox jour = new JComboBox(Jours); 
	        JComboBox mois = new JComboBox(Mois);
	        JComboBox annee = new JComboBox(Annees);
	        
	        Button ressayer = new Button("ressayer");
	        JButton sinscrit = new JButton("S'inscrire");
	        Button SeConnecter = new Button("Se connecter");
	        Button annuler = new Button("Annuler");
	        
	        Font police = new Font("Arial",Font.BOLD,15);
	        
	       
	       
	Inscription(){
		
		    thi.setSize(700,520);
	        thi.getContentPane().setBackground(new Color(0,0,0));
	        thi.setDefaultCloseOperation(thi.EXIT_ON_CLOSE);
	        thi.setTitle("page d'inscription");
	       //JLabel nom = new JLabel("Nom:");
	        nom.setBounds(100, 50, 80, 25);
	        nom.setForeground(Color.white);
	        nom.setFont(police);
	        
	        err_nom.setForeground(Color.white);
     	        
	       // JLabel prenom = new JLabel("Prenom:");
	        prenom.setBounds(100, 120, 80, 25);
	        prenom.setForeground(Color.white);
	        prenom.setFont(police);
	        
	       // JLabel dateNaissance = new JLabel("Date de naissance:");
	        dateNaissance.setBounds(100, 190, 150, 25);
	        dateNaissance.setForeground(Color.white);
	        dateNaissance.setFont(police);

	       // JLabel mdp = new JLabel("Ajouter un mot de passe:");
	        mdp.setBounds(100, 260, 200, 25);
	        mdp.setForeground(Color.white);
	        mdp.setFont(police);
	        err_mdp.setForeground(Color.white);
	        

	       // JLabel rmdp = new JLabel("Confirmer le mot de passe:");
	        rmdp.setBounds(100, 330, 200, 25);
	        rmdp.setForeground(Color.white);
	        rmdp.setFont(police);

	        //JLabel deja = new JLabel("Avez vous déja un compte?");
	        //deja.setBounds(25, 385, 160, 25);
	        

	        //TextFields pour insérer les informations.
	        
	        nomtf.setBounds(320, 50, 300, 40);
	        nomtf.setBackground(new Color(0,0,0));
	        nomtf.setForeground(Color.white);
	        nomtf.setFont(police);
	        nomtf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
				
				
	        nomtf.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}
				 public void warn() {
					 mot_de_passe_util= mdptf.getPassword();
						String s= new String(mot_de_passe_util);
						conf_mot_de_passe=rmdptf.getPassword();
		                 String ss=new String(conf_mot_de_passe);
						if(nomtf.getText().length()>4 && !prenomtf.equals("") && s.length()>4 && s.equals(ss))
						{
							sinscrit.setEnabled(true);
						}else
						{
							sinscrit.setEnabled(false);
						}
	        	     if (nomtf.getText().length()<=4) 
	        	     {
	        	    	 nomtf.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
	        	    	 err_nom.setBounds(195, 70, 165, 25);
	        	    	 err_nom.setForeground(Color.red);
	        	    	 
	        	     }
	        	    	
	        	     else
	        	     {
	        	    	 nomtf.setBorder(BorderFactory.createLineBorder(new Color(0,255,0)));
	        	    	 err_nom.setForeground(Color.white);
	        	     }
	        	     
	        	  }
	        	  
				
	        	});

	        //final JTextField prenomtf = new JTextField();
	        prenomtf.setBounds(320, 120, 300, 40);
	        prenomtf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
	        prenomtf.setForeground(Color.white);
	        prenomtf.setBorder(BorderFactory.createLineBorder(Color.white));
	        prenomtf.setBackground(Color.black);
	        prenomtf.setFont(police);
	        prenomtf.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}
				 public void warn() {
					 mot_de_passe_util= mdptf.getPassword();
						String s= new String(mot_de_passe_util);
						conf_mot_de_passe=rmdptf.getPassword();
		                 String ss=new String(conf_mot_de_passe);
						if(nomtf.getText().length()>4 && !prenomtf.equals("") && s.length()>4 && s.equals(ss))
						{
							sinscrit.setEnabled(true);
						}else
						{
							sinscrit.setEnabled(false);
						}
	        	     if (prenomtf.getText().length()<1) 
	        	     {
	        	    	 prenomtf.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
	        	    	 JLabel err_nom = new JLabel("pas moin de 5 car");
	        	    	 err_nom.setBounds(195, 10, 165, 25);
	        	    	 
	        	     }
	        	    	
	        	     else
	        	    	 prenomtf.setBorder(BorderFactory.createLineBorder(new Color(0,255,0)));
	        	     
	        	  }
	        	  
				
	        	});

	        
	        mdptf.setBounds(320, 260,300, 40);
	        mdptf.setBackground(Color.black);
	        mdptf.setForeground(Color.white);
	        mdptf.setBorder(BorderFactory.createLineBorder(Color.white));
	        mdptf.setFont(police);
	        mdptf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
	        
	        mdptf.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
				
					warn();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}
				 public void warn() {
					 mot_de_passe_util= mdptf.getPassword();
						String s= new String(mot_de_passe_util);
						conf_mot_de_passe=rmdptf.getPassword();
		                 String ss=new String(conf_mot_de_passe);
						if(nomtf.getText().length()>4 && !prenomtf.equals("") && s.length()>4 && s.equals(ss))
						{
							sinscrit.setEnabled(true);
							sinscrit.setBorder(BorderFactory.createLineBorder(new Color(0,255,0)));
						}else
						{
							sinscrit.setEnabled(false);
							sinscrit.setBorder(BorderFactory.createLineBorder(Color.gray));
						}
					
	        	     if (s.length()<=4) 
	        	     {
	        	    	 mdptf.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
	        	    	 err_mdp.setBounds(195, 20, 165, 25);
	        	    	 err_mdp.setForeground(Color.red);
	        	    	 
	        	     }
	        	    	
	        	     else
	        	    	 mdptf.setBorder(BorderFactory.createLineBorder(new Color(0,255,0)));
	        	         err_mdp.setForeground(Color.white);
	        	  }
	        	  
				
	        	});

	        
	        rmdptf.setBounds(320, 330, 300, 40);
	        rmdptf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
	        rmdptf.setBackground(Color.black);
	        rmdptf.setForeground(Color.white);
	        rmdptf.setFont(police);
	        rmdptf.setBorder(BorderFactory.createLineBorder(Color.white));
	        
	        rmdptf.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
					warn();
				}
				
				 public void warn() {
					 mot_de_passe_util= mdptf.getPassword();
						String s= new String(mot_de_passe_util);
						conf_mot_de_passe=rmdptf.getPassword();
		                 String ss=new String(conf_mot_de_passe);
						if(nomtf.getText().length()>4 && !prenomtf.equals("") && s.length()>4 && s.equals(ss))
						{
							sinscrit.setEnabled(true);
							sinscrit.setBorder(BorderFactory.createLineBorder(new Color(0,255,0)));
						}else
						{
							sinscrit.setEnabled(false);
							sinscrit.setBorder(BorderFactory.createLineBorder(Color.gray));
						}
					 
		               
		                conf_mot_de_passe=rmdptf.getPassword();
		                
	        	     if (!s.equals(ss)) 
	        	     {
	        	    	 rmdptf.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
	        	    	 
	        	    	 
	        	     }
	        	    	
	        	     else
	        	    	 rmdptf.setBorder(BorderFactory.createLineBorder(new Color(0,255,0)));
	        	     
	        	  }
	        	  
				
	        	});

	        //ComboBox de la date de naissance
	        
	        jour.setBounds(320, 190, 40, 25);

	       
	        mois.setBounds(365, 190, 90, 25);

	       
	        annee.setBounds(465, 190, 60, 25);
	        //pour les bouton 
	        
	        //ressayer si y'a problem
	        
	        
	        ressayer.setBounds(220, 320, 110, 25);
	        ressayer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					thi.dispose();
					Inscription page_inscription = new Inscription();
				}
	        	
	        });
	        
	        //bouton d'inscription
	       
	        sinscrit.setBounds(200, 400, 300, 40);
	        sinscrit.setBackground(new Color(0,0,0));
	        sinscrit.setForeground(Color.white);
	        sinscrit.setBorder(BorderFactory.createLineBorder(Color.gray));
	        sinscrit.setEnabled(false);
	       
	        sinscrit.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	 //stockage des données dans un fichier utilisateurs
	            	
	    	        nom_util=nomtf.getText();
	                prenom_util=prenomtf.getText();
	                date_util=annee.getSelectedItem()+":"+mois.getSelectedItem()+":"+jour.getSelectedItem();
	                mot_de_passe_util=mdptf.getPassword();
	                final String s= new String(mot_de_passe_util);
	                conf_mot_de_passe=rmdptf.getPassword();
	                final String ss=new String(conf_mot_de_passe);
	               
	                try {
	                	int i,np=0;
						Euruka page = new Euruka();
						HashSet<Themejeu> theme_recup = page.Initialisation();
						Joueur joueur_connecte = page.inscription(nom_util, prenom_util, date_util, s,ss);
						for(i=0;i<Euruka.dictionaire_de_joueur.size();i++)
						{
							np+=Euruka.dictionaire_de_joueur.get(i+1).partiejeu.size();
						}
						//joueur_connecte.decrisToi();
						
						if(joueur_connecte!=null)
						{
							ThemePage page_de_theme = new ThemePage(theme_recup,joueur_connecte,np+1);
							thi.dispose();
						}
						
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	               
	                
	                
	               
                }
            });
	        
	        
	        SeConnecter.setBounds(220, 385, 110, 25);
	        SeConnecter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Connexion page_de_connexion = new Connexion();
					thi.dispose();
				}
	        	
	        });

	       
	        annuler.setBounds(50, 285, 110, 25);
	        annuler.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });
       
	        
        thi.add(nom);thi.add(prenom);thi.add(dateNaissance);thi.add(mdp);thi.add(rmdp);
         thi.add(nomtf);  thi.add(prenomtf);
          thi.add(jour); 
        thi.add(mois); thi.add(annee);
         thi.add(mdptf);  thi.add(rmdptf);
         thi.add(sinscrit);
       // thi.add(err_nom);
        
        thi.setLayout(new BorderLayout());
        thi.setResizable(false);
        thi.setVisible(true);
        thi.setLocationRelativeTo(null);
       
        
       
        
        
	}
	
}
