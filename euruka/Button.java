package ad;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JButton;

public class Button extends JButton implements MouseListener{
	
	Button(String str)
	{
		super(str);
		
		this.setBackground(Color.white);
		this.addMouseListener(this);
		
	}
	
	
	

	public Button() {
		// TODO Auto-generated constructor stub
	}




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
		
		
			this.setBackground(new Color(255, 255, 0));
		
			
		/*else
			this.setBackground(Color.GREEN);*/
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setBackground(Color.WHITE);
	}






	

}
