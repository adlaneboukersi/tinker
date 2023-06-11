package jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Connexion extends JFrame {
	// File file = new File("C://Users//ADMIN//Desktop//euruka//utilisateurs.txt");
	 String nom_util,m;
     char[] mot_de_passe_util;
     
     JFrame th = new JFrame();
     
     Font police = new Font("Arial",Font.BOLD,18);
     
     JPasswordField mdpff = new JPasswordField();
     JTextField nomfield = new JTextField();
     JLabel lampe = new JLabel();
     

	Connexion(){
		
		
		
		th.setTitle("page de connexion");
		th.setSize(700,520);
		
		
        
        th.getContentPane().setBackground(Color.black);
        
        ImageIcon icone_lampe = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\lampe.jpg");
        lampe.setIcon(icone_lampe);
        lampe.setBounds(500, 0, 200, 200);
        
       
        mdpff.setBounds(250,320,160,40);
        mdpff.setBackground(new Color(0,0,0));
        mdpff.setForeground(Color.white);
        mdpff.setBorder(BorderFactory.createLineBorder(Color.white));
        mdpff.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomfield.setFont(police);
       

        mdpff.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getKeyChar()=='\n') {
					nom_util=nomfield.getText();
					mot_de_passe_util=mdpff.getPassword();
					m= new String(mot_de_passe_util);
					
					try {
						int i,np=0;
						Euruka page = new Euruka();
						HashSet<Themejeu> theme_recup = page.Initialisation();
						Joueur joueur_connecte = page.connexion(nom_util,m);
						for(i=0;i<page.dictionaire_de_joueur.size();i++)
						{
							
							np+=page.dictionaire_de_joueur.get(i+1).partiejeu.size();
						}
						
						
						if(joueur_connecte!=null)
						{
							th.dispose();
							ThemePage page_de_theme = new ThemePage(theme_recup,joueur_connecte,np+1);
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        JLabel nom1 = new JLabel();
        ImageIcon icone = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\aaahrabani.jpg");
        nom1.setIcon(icone);
       
        nom1.setBounds(20,190,250,100);
      
        nomfield .setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomfield.setBounds(250,190,160,40);
        nomfield.setBackground(new Color(0,0,0));
        nomfield.setBorder(BorderFactory.createLineBorder(Color.white));
      
        nomfield.setFont(police);
        nomfield.setForeground(Color.white);
       

        nomfield.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getKeyChar()=='\n') {
					nom_util=nomfield.getText();
					mot_de_passe_util=mdpff.getPassword();
					m= new String(mot_de_passe_util);
					
					try {
						int i,np=0;
						Euruka page = new Euruka();
						HashSet<Themejeu> theme_recup = page.Initialisation();
						Joueur joueur_connecte = page.connexion(nom_util,m);
						for(i=0;i<page.dictionaire_de_joueur.size();i++)
						{
							
							np+=page.dictionaire_de_joueur.get(i+1).partiejeu.size();
						}
						
						
						if(joueur_connecte!=null)
						{
							th.dispose();
							ThemePage page_de_theme = new ThemePage(theme_recup,joueur_connecte,np+1);
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        JLabel motdepasse = new JLabel();
        ImageIcon icone_mdp = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\3yit.jpg");
        motdepasse.setIcon(icone_mdp);
        motdepasse.setBounds(30,255,300,100);
        
        
        JButton inscriver = new JButton("cree un compt");
        inscriver.setBounds(270, 420, 150, 25);
        inscriver.setBackground(new Color(0,0,0));
        inscriver.setBorderPainted(false);
        inscriver.setForeground(Color.white);
        inscriver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				th.dispose();
				Inscription page_inscription = new Inscription();
				
				
			}
		});
        Button lancer = new Button();
        ImageIcon icone_cnx = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\lancer.jpg");
        lancer.setIcon(icone_cnx);
        lancer.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lancer.setBounds(450,250,150,50);
        
     
        lancer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nom_util=nomfield.getText();
				mot_de_passe_util=mdpff.getPassword();
				m= new String(mot_de_passe_util);
				
				try {
					int i,np=0;
					Euruka page = new Euruka();
					HashSet<Themejeu> theme_recup = page.Initialisation();
					Joueur joueur_connecte = page.connexion(nom_util,m);
					for(i=0;i<page.dictionaire_de_joueur.size();i++)
					{
						
						np+=page.dictionaire_de_joueur.get(i+1).partiejeu.size();
					}
					
					
					if(joueur_connecte!=null)
					{
						
						ThemePage page_de_theme = new ThemePage(theme_recup,joueur_connecte,np+1);
						th.dispose();
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
        	
        });
           
        
        
        
     
        th.add(lampe);
        th.add(lancer);
        th.add(nom1);
        th.add(nomfield);
        th.add(motdepasse);
        th.add(mdpff);
        th.add(inscriver);
        th.setResizable(false);
        th.setLayout(null);
        th.setLocationRelativeTo(null);
        th.setVisible(true);
        
	}



	
	



}
