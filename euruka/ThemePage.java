package ad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThemePage {
	
	 JFrame theme = new JFrame("page de themes");
	 Button his = new Button("histoire");
	 Button san = new Button("sante");
	 Button cul = new Button("culture generale");
	 Button geo = new Button("geographie");
	 Button isl = new Button("islame");
	 JLabel af = new JLabel("choisi(e) un theme");
	 JLabel ag = new JLabel();
	 JLabel ar = new JLabel("votre score : ");
	 
	 JLabel img_geo = new JLabel();
	 JLabel lampe_th = new JLabel();
	 JLabel img_isl = new JLabel();
	 JLabel img_snt = new JLabel();
	 JLabel img_his = new JLabel();
	 JLabel img_clt = new JLabel();
	 
	
	ThemePage(final HashSet<Themejeu> themes_initialise , final Joueur j , final int num_partie)
	{
		//taille et parametres
		
		
		
		Font police = new Font("Arial",Font.BOLD,18);
		
		theme.setSize(900,520);
	    theme.getContentPane().setBackground(Color.black);
	    theme.setDefaultCloseOperation(theme.EXIT_ON_CLOSE);
	    
	   
		ImageIcon icon_geo = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\image_geo.jpg");
		img_geo.setIcon(icon_geo);
		img_geo.setBounds(0, 260, 380, 60);
		img_geo.setVisible(false);
		
		ImageIcon icon_his = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\image_his.jpg");
		img_his.setIcon(icon_his);
		img_his.setBounds(500, 260, 400, 60);
		img_his.setVisible(false);
		
		ImageIcon icon_isl = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\image_isl.jpg");
		img_isl.setIcon(icon_isl);
		img_isl.setBounds(290, 345, 265, 60);
		img_isl.setVisible(false);
		
		ImageIcon icon_snt = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\image_snt.jpg");
		img_snt.setIcon(icon_snt);
		img_snt.setBounds(0, 150, 305, 60);
		img_snt.setVisible(false);
		
		ImageIcon icon_clt = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\image_clt.jpg");
		img_clt.setIcon(icon_clt);
		img_clt.setBounds(582, 150, 312, 60);
		img_clt.setVisible(false);
		
		ImageIcon icon_lampe = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\lampe_th.jpg");
		lampe_th.setIcon(icon_lampe);
		lampe_th.setBounds(380, 90, 200, 200);
	    
	    
	    //button d'histoir
	   
	    his.setBounds(500,270,260,30);
	    his.setFont(police);
	    
	    his.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				img_his.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				img_his.setVisible(false);
			}
			
		});

	    his.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Themejeu th = new Themejeu("histoire");
				th.questions=j.getQuestions("histoire",themes_initialise);
				
				//affichage des niveaux
				theme.dispose();
				PageNiveaux page_niveaux = new PageNiveaux(th,j,num_partie,themes_initialise);
			
				
			
				}
		});
	    
	    
	    //button de sante
	    
	    san.setBounds(45,150,260,30);
	    san.setFont(police);
	    
	    san.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				img_snt.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				img_snt.setVisible(false);
			}
			
		});
	    
	    san.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//recuperer le theme et les qst 
				Themejeu th = new Themejeu("sante");
				th.questions=j.getQuestions("sante",themes_initialise);
				
				//affichage des niveaux
				theme.dispose();
				PageNiveaux page_niveaux = new PageNiveaux(th,j,num_partie,themes_initialise);
			
			 
			}
		});
	    
	    //buton de culture general
	    
	    
	    
	    
	    cul.setBounds(582,150,260,30);
	    cul.setFont(police);
	    cul.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				img_clt.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				img_clt.setVisible(false);
			}
			
		});
	    cul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				Themejeu th = new Themejeu("culture generale");
				th.questions=j.getQuestions("culture generale",themes_initialise);
				
				//affichage des niveaux
				theme.dispose();
				PageNiveaux page_niveaux = new PageNiveaux(th,j,num_partie,themes_initialise);
				
			 
			}
		});
	    
	    //button de geographie
	    
	    geo.setBounds(120,270,260,30);
	    geo.setFont(police);
	    geo.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				img_geo.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				img_geo.setVisible(false);
			}
			
		});
	    
	    geo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//recuperer le theme et les questions
				
				
				Themejeu th = new Themejeu("geographie");
				th.questions=j.getQuestions("geographie",themes_initialise);
				
				//affichage des niveaux
				
				PageNiveaux page_niveaux = new PageNiveaux(th,j,num_partie,themes_initialise);
				theme.dispose();
				
				
				
			}
		});
	    
	    //button d'islame
	    
		   isl.setBounds(295,350,260,30);
		   isl.setFont(police);
		   isl.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					img_isl.setVisible(true);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					img_isl.setVisible(false);
				}
				
			});
	   
	       isl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Themejeu th = new Themejeu("islame");
				th.questions=j.getQuestions("islame",themes_initialise);
				
				//affichage des niveaux
				
				PageNiveaux page_niveaux = new PageNiveaux(th,j,num_partie,themes_initialise);
				theme.dispose();
			 
			}
		});

	   // ajouter un lable
	   
	  
	   af.setBounds(340,60,260,30);
	   af.setForeground(Color.white);
	  af.setFont(police);
	   
	  int d=j.getTotalScore();
	   ag.setText(""+d);
	  ag.setBounds(134,440,30,30);
	  ag.setForeground(Color.white);
	  ag.setFont(police);
	 
	   ar.setBounds(1,440,130,30);
	   ar.setForeground(Color.white);
	   ar.setFont(police);
	   
	   //injection d'elements et affichage de la page 
	   
	   theme.add(lampe_th);
	   theme.add(img_geo);
	   theme.add(img_isl);
	   theme.add(img_snt);
	   theme.add(img_his);
	   theme.add(img_clt);
	    theme.add(af);
	    theme.add(isl);
	    theme.add(geo);
	    theme.add(cul);
	    theme.add(san);
	    theme.add(his);
	    theme.add(ag);
	    theme.add(ar);
	    theme.setLayout(new BorderLayout());
	    theme.setResizable(false);
	    theme.setLocationRelativeTo(null);
	    theme.setVisible(true);
	    
	}


}
