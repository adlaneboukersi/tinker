package ad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.DimensionUIResource;
public class  Partie extends JFrame {
	
	JFrame th = new JFrame();
	
	JPanel p = new JPanel();
	JPanel img = new JPanel();
	JPanel info = new JPanel();
	
	
	
	JButton ad4 = new JButton("chec");
	
	JTextField ad2 = new JTextField();
	
	JLabel ad3 = new JLabel("entrer un caracter");
	JLabel ad = new JLabel();
	JLabel ad5 = new JLabel();

	Partie(final PartieJeu partie_lancer,final Joueur j,final Mere q,final HashSet<Themejeu> themes_initialise){
		 Font police = new Font("Arial",Font.BOLD,18);
		 
		 
			//initialisation de la fenetre de jeu
			th.setTitle("pot");	
		     th.setSize(900,520);
		     th.setLayout(null);
		    
		     th.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     
		     th.setLayout(new BorderLayout());
		     //////////////////////////////
		     
		     //emplacement et initialisation  du panel de la potence 
		     p.setPreferredSize(new Dimension(200,200));
		   
		     p.setBackground(Color.black);
		     p.setLayout(new BorderLayout());
		    
		    
		     
		     final Potenc pot = new Potenc();
		     pot.etat = 0;
		    
		     p.add(pot,BorderLayout.CENTER);  //ajout de la potence au panel 
		     th.add(p,BorderLayout.WEST);     // ajout du panel a la fenetre de jeu
		     
		     //////////////////////////////////
				
		     //initialisation d'un panel pour l'image de la question 
				img.setBackground(Color.black);
				img.setPreferredSize(new DimensionUIResource(450,420));
				img.setLayout(new BorderLayout());
			    ImageIcon icon = new ImageIcon("C://Users//ADMIN//Desktop//Nouveau dossier//eureka.jpg");
			    JLabel label = new JLabel(icon);
			    img.add(label,BorderLayout.CENTER);
			      ////////////////////////////////////
			   // ajout du panel qui contien le bouton et lible de la repence en cour et l'espace de saisie 
					info.setBackground(Color.black);
					info.setPreferredSize(new DimensionUIResource(200,150));
					info.setLayout(new BorderLayout());
		
			      ////////////////////////////////////
			      ad.setText(q.libellé);
			      ad.setBounds(10,40,160,25);
			      ad.setFont(police);
			      //////////////////////////////////////////
			      
			    
			      ad2.setBounds(175,80,20,25);
			      
			      ad2.getDocument().addDocumentListener(new DocumentListener() {

					@Override
					public void insertUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						if(ad2.getText().length()==1)
						{
							ad4.setEnabled(true);
						}else {
							ad4.setEnabled(false);
						}
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						if(ad2.getText().length()==1)
						{
							ad4.setEnabled(true);
						}else {
							ad4.setEnabled(false);
						}
						
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						if(ad2.getText().length()==1)
						{
							ad4.setEnabled(true);
						}else {
							ad4.setEnabled(false);
						}
						
					}
			    	  
			      });
			    	  
			      
			      
			      ad2.addKeyListener(new KeyListener() {

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
						if(e.getKeyChar()=='\n' && ad2.getText().length()>0 && ad2.getText().length()<2) {
							
							String rec=ad2.getText();
							if(!partie_lancer.checkCaractère(rec.charAt(0),q))
							{
								//System.out.println(partie_lancer.checkCaractère(rec.charAt(0), q));
								pot.incrémentEtat();
								if(pot.etat<=8) {
									pot.repaint();
								 if(pot.etat==8) {
								
									ObjectOutputStream oos;
									try {
										partie_lancer.score=0;
										
										j.getPartiejeu().add(partie_lancer);
										
										
										Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).partiejeu=j.getPartiejeu();
										
										oos = new ObjectOutputStream(new FileOutputStream("C://Users//ADMIN//Desktop//euruka//utilisateurs.ser"));
										oos.writeObject(Euruka.dictionaire_de_joueur);
										oos.close(); 
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									
									//affichage d'une fenetre si le joueur perd 
									 JFrame page_dechec= new JFrame("oups..");
								    	page_dechec.setSize(280,200);
								    	page_dechec.getContentPane().setBackground(Color.black);
								       
								        
								        JButton ressayer = new JButton("ressayer");
								        ressayer.setBounds(60, 120, 150, 25);
								        ressayer.setBackground(Color.black);
								        ressayer.setBorder(BorderFactory.createLineBorder(Color.gray));
								        ressayer.setForeground(Color.white);
								        ressayer.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												
												//si le joueur perd il revien a la page des niveaux pour relancer une nouvelle partie 
												PageNiveaux x = new PageNiveaux(partie_lancer.theme_partie,j,partie_lancer.numero_partie+1,themes_initialise);
											}
										});
								        
								        JLabel domage = new JLabel("domage.. une autre fois");
								        domage.setForeground(Color.white);
								        domage.setBounds(25,20, 200, 25);
								        
								    	page_dechec.add(ressayer);
								    	page_dechec.add(domage);
								        
								    	page_dechec.setLayout(new BorderLayout());
								    	page_dechec.setResizable(false);
								    	page_dechec.setVisible(true);
								    	page_dechec.setLocationRelativeTo(null);
								 }
								}
								
							}else
							{
								ad5.setText(partie_lancer.reponse_en_cour.toString());
								if(partie_lancer.reponse_en_cour.toString().equals(q.reponse))
								{
									System.out.println(partie_lancer.numero_partie);
									//Ameliorer le niveau
									
									//changer le score de la partie
									partie_lancer.score=q.getNBPoints();
									
									//recuperer la partie 
									j.getPartiejeu().add(partie_lancer);
									System.out.println(j.getTotalScore());
									
									try {
										
										
											Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).partiejeu=j.getPartiejeu();
											if(q.niveau==Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().get(partie_lancer.theme_partie.type));
											{
												Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().replace(partie_lancer.theme_partie.type, 
														Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().get(partie_lancer.theme_partie.type), 
														Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().get(partie_lancer.theme_partie.type)+1);
											}
											Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).decrisToi();
											ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://Users//ADMIN//Desktop//euruka//utilisateurs.ser"));
											oos.writeObject(Euruka.dictionaire_de_joueur);
											oos.close();
							
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									
									//affichage de la fenetre bravoo !
									final JFrame ok = new JFrame("termine");
							    	ok.setSize(500,300);
							        ok.getContentPane().setBackground(Color.RED);
							   
							        
							        JButton pas = new JButton("prochain niveau");
							        pas.setBounds(60, 120, 150, 25);
							        pas.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											// TODO Auto-generated method stub
											ok.dispose();
											PageNiveaux x = new PageNiveaux(partie_lancer.theme_partie,j,partie_lancer.numero_partie+1,themes_initialise);
										}
									});
							        JLabel dej = new JLabel("bravo chompion.. vous avez reuisie");
							        dej.setBounds(25,20, 200, 25);
							        ok.add(pas);
							        ok.add(dej);
							        ok.setLayout(new BorderLayout());
							        ok.setResizable(false);
							        ok.setVisible(true);
							        ok.setLocationRelativeTo(null);
								}
								
						}
							ad2.setText("");
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
			      ////////////////////////////////////
			     
			      ad3.setBounds(10,10,200,25);  
			      ad3.setFont(police);
			      /////////////////////////////////
				   //  JLabel ad5 = new JLabel(partie_lancer.reponse_en_cour.toString());
				      ad5.setText(partie_lancer.reponse_en_cour.toString());
				   	ad5.setBounds(10,80, 100, 25);  
			      //////////////////////////////////////
			      
			      ad4.setBounds(40,100, 45, 25);
			      ad4.setEnabled(false);
			      
			      
                  ad4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String rec=ad2.getText();
			if(!partie_lancer.checkCaractère(rec.charAt(0),q))
			{
				//System.out.println(partie_lancer.checkCaractère(rec.charAt(0), q));
				pot.incrémentEtat();
				if(pot.etat<=8) {
					pot.repaint();
				 if(pot.etat==8) {
				
					ObjectOutputStream oos;
					try {
						partie_lancer.score=0;
						
						j.getPartiejeu().add(partie_lancer);
						
						
						Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).partiejeu=j.getPartiejeu();
						
						oos = new ObjectOutputStream(new FileOutputStream("C://Users//ADMIN//Desktop//euruka//utilisateurs.ser"));
						oos.writeObject(Euruka.dictionaire_de_joueur);
						oos.close(); 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					//affichage d'une fenetre si le joueur perd 
					 JFrame page_dechec= new JFrame("oups..");
				    	page_dechec.setSize(280,200);
				    	page_dechec.getContentPane().setBackground(Color.black);
				       
				        
				        JButton ressayer = new JButton("ressayer");
				        ressayer.setBounds(60, 120, 150, 25);
				        ressayer.setBackground(Color.black);
				        ressayer.setBorder(BorderFactory.createLineBorder(Color.gray));
				        ressayer.setForeground(Color.white);
				        ressayer.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
								//si le joueur perd il revien a la page des niveaux pour relancer une nouvelle partie 
								PageNiveaux x = new PageNiveaux(partie_lancer.theme_partie,j,partie_lancer.numero_partie+1,themes_initialise);
							}
						});
				        
				        JLabel domage = new JLabel("domage.. une autre fois");
				        domage.setForeground(Color.white);
				        domage.setBounds(25,20, 200, 25);
				        
				    	page_dechec.add(ressayer);
				    	page_dechec.add(domage);
				        
				    	page_dechec.setLayout(new BorderLayout());
				    	page_dechec.setResizable(false);
				    	page_dechec.setVisible(true);
				    	page_dechec.setLocationRelativeTo(null);
				 }
				}
				
			}else
			{
				ad5.setText(partie_lancer.reponse_en_cour.toString());
				if(partie_lancer.reponse_en_cour.toString().equals(q.reponse))
				{
					System.out.println(partie_lancer.numero_partie);
					//Ameliorer le niveau
					
					//changer le score de la partie
					partie_lancer.score=q.getNBPoints();
					
					//recuperer la partie 
					j.getPartiejeu().add(partie_lancer);
					System.out.println(j.getTotalScore());
					
					try {
						
						
							Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).partiejeu=j.getPartiejeu();
							if(q.niveau==Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().get(partie_lancer.theme_partie.type));
							{
								Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().replace(partie_lancer.theme_partie.type, 
										Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().get(partie_lancer.theme_partie.type), 
										Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).getNiv_atteint().get(partie_lancer.theme_partie.type)+1);
							}
							Euruka.dictionaire_de_joueur.get(j.getNumero_joueur()).decrisToi();
							ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://Users//ADMIN//Desktop//euruka//utilisateurs.ser"));
							oos.writeObject(Euruka.dictionaire_de_joueur);
							oos.close();
			
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					//affichage de la fenetre bravoo !
					final JFrame ok = new JFrame("termine");
			    	ok.setSize(500,300);
			        ok.getContentPane().setBackground(Color.RED);
			   
			        
			        JButton pas = new JButton("prochain niveau");
			        pas.setBounds(60, 120, 150, 25);
			        pas.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							ok.dispose();
							PageNiveaux x = new PageNiveaux(partie_lancer.theme_partie,j,partie_lancer.numero_partie+1,themes_initialise);
						}
					});
			        JLabel dej = new JLabel("bravo chompion.. vous avez reuisie");
			        dej.setBounds(25,20, 200, 25);
			        ok.add(pas);
			        ok.add(dej);
			        ok.setLayout(new BorderLayout());
			        ok.setResizable(false);
			        ok.setVisible(true);
			        ok.setLocationRelativeTo(null);
				}
				
		}
		}
	});
      info.add(ad2,BorderLayout.AFTER_LAST_LINE);
      info.add(ad3,BorderLayout.AFTER_LAST_LINE);
      info.add(ad4,BorderLayout.AFTER_LAST_LINE);
      info.add(ad5,BorderLayout.LINE_END);
      info.setVisible(true);
      /////////////////////////////////
      img.add(ad,BorderLayout.NORTH);
    th.add(img,BorderLayout.EAST);
    th.add(info, BorderLayout.SOUTH) ; 
    th.add(p);
    th.setLocationRelativeTo(null);
    th.setVisible(true);
}
	
	
}