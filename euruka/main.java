package ad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class main {

	public static void main(String[] args) throws IOException {
		Font police = new Font("Arial",Font.BOLD,30);
	    ImageIcon icon = new ImageIcon("C:\\Users\\ADMIN\\Desktop\\euruka\\lampe_th.jpg");
	    JLabel label = new JLabel(icon);
	  
	  
        try {
			Euruka page = new Euruka();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
        final JFrame eurek= new JFrame("");
		 eurek.setSize(700,500);
		 eurek.getContentPane().setBackground(Color.black);
		 JLabel faite = new JLabel("BIEN VENUE SUR EUREKA");
		 faite.setFont(police);
		 faite.setForeground(Color.white);
		 
	     faite.setBounds(150,60, 400, 60);
	     
	     JButton jouer = new JButton("jouer");
	     jouer.setBounds(97,350,100,25);
	     jouer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				eurek.dispose();
				Connexion page_de_connexion = new Connexion();
			}
		});		
	 
     JButton help = new JButton("helpe");
     help.setBounds(98,385, 100,25);
     help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			JFrame a = new JFrame();
			 a.setSize(800,600);
			 a.getContentPane().setBackground(Color.darkGray);
		
			 JTextArea helpTa = new JTextArea();
             helpTa.setOpaque(false);
             helpTa.setBackground(new Color(0, 0, 0, 0));
             helpTa.setBounds(5,20,800,600);
             helpTa.setFont(new Font("arial", Font.PLAIN, 20));
             helpTa.setForeground(Color.white);
             helpTa.setText("bienvenue a notre tout premier jeux au monde de programation notre jeux  vas \n vous cultiver et vous aprendre \nle concepte est simple repondez corectement et gagnger\n Regles du jeu : \n1- on a 5 themes pour chacun des themes 5 niveau \n2-pour passer au niveaux superieur vous avez 8 essay a deviner la reponse \n en entrant un carcter apratient au caractres de la reponse\n3-pour chque niveaux gagner vous recuperer des points qui vont etre ajouter \n a votre propre score totale du jeux\n\n\n\n\n Jeux realiser par : \n adlane boukersi \n mouhamed tidjani hamza \n\n\n le 30/04/2020");
             helpTa.setEditable(false);
              
            a.add(helpTa);
            a.setLayout(new BorderLayout());
            a.setResizable(false);
            a.setVisible(true);
			}
     
		});

 
		
		//eurek.setLayout(new BorderLayout());
		  eurek.add(faite);
		  eurek.add(jouer);
	      eurek.add(help);
	    
	    eurek.add(label);
	      eurek.setResizable(false);
	      eurek.setVisible(true);
	      eurek.setLocationRelativeTo(null);
	      while(true)
		    {
		    	label.setVisible(false);
		    	try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	label.setVisible(true);
		    	try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
	}

}