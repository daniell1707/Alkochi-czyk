package Alko;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AlkoNGGraf extends JPanel {
	private BufferedImage tlo;

	AlkoNGGraf(){
		File imageFile = new File("img/wybor.png");

		try {
			tlo = ImageIO.read(imageFile);
		} 
		catch (IOException e) {
			System.err.println("Blad odczytu planszy");
			e.printStackTrace();
		}
		this.setSize(500, 400);
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g){//funkcja rysuj¹ca
		super.paintComponent(g);
		g.drawImage(tlo,0,0,null);
		
	}

}
