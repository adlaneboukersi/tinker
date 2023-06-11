package ad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Potenc extends Component {
		
		int etat;
		boolean trouve;
		Dimension dimension;
		
		void incrémentEtat() {
			etat = etat+1;
		}
		public void paint (Graphics g)
		{
			
			// Le dessin s'adapte à l'espace attribué
			dimension = getSize(); // de Component
			//g.clearRect(0, 0, 	dimension.width-1, 	dimension.height-1); //effacer
			g.drawRect(0, 0, 	dimension.width-1, 	dimension.height-1); //tracer le cadre
			// s'adapter à l'espace du composant
			 dimension = new Dimension(320,320);
			int taille = 12*(dimension.width/140);
			if (taille <8) taille = 8;
			g.setFont (new Font("TimesRoman", Font.PLAIN, taille));
			if (etat >= 1) {g.setColor(Color.green); g.drawLine(l(30), h(120), l(90), h(120));}
			if (etat >= 2) {g.drawLine(l(30), h(120), l(30), h(40));g.setColor(Color.yellow);}
			if (etat >= 3) { g.drawLine(l(60), h(120), l(30), h(90));g.setColor(Color.yellow);}
			if (etat >= 4) {g.drawLine(l(30), h(40), l(80), h(40));g.setColor(new Color(255, 123, 0));}
			if (etat >= 5) g.drawLine(l(30), h(60), l(50), h(40));g.setColor(new Color(255, 123, 0));
			if (etat >= 6) g.drawLine(l(70), h(40), l(70), h(60));g.setColor(Color.red);
			if (etat >= 7) g.drawOval(l(65), h(60), l(10), h(10));g.setColor(Color.red); // tête
			if (etat >= 8)
				{
				g.drawLine(l(70), h(70), l(70), h(85)); // corps
				g.drawLine(l(70), h(70), l(65), h(75)); // corps
				g.drawLine(l(70), h(70), l(75), h(75)); // corps
				g.drawLine(l(70), h(85), l(65), h(95)); // corps
				g.drawLine(l(70), h(85), l(75), h(95)); // corps
				}
			
			else if (etat == 7)
			{
				g.setColor(Color.white);
				g.drawString("Reste un coup à jouer !", l(10), h(150));
			 }
			else// (etat >=0 && etat <7)
			{
				 g.setColor(Color.white);
				 g.drawString("Reste "+(8-etat)+"coups à jouer", l(10), h(150));
			}
		}
		/*private Dimension getSize()
		{
			// TODO Auto-generated method stub
			return null;
		}*/
		// Mise à l'échelle en largeur de v
		int l (int v)
		{
			double k = Math.min(dimension.width/140., dimension.height/160);
			return (int)(v*k);
		}
		// Mise à l'échelle en hauteur de v
		int h (int v)
		{
			double k = Math.min(dimension.width/140.,dimension.height/160);
			return (int)(v*k);
		}
}