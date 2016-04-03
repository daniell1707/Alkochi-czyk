package Alko;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AlkoZadGraf extends JPanel   {
	private BufferedImage tlo;

	AlkoZadGraf(){
		this.setSize(300,400);
		File imageFile = new File("img/zadania.png");

		try {
			tlo = ImageIO.read(imageFile);
		} 
		catch (IOException e) {
			System.err.println("Blad odczytu planszy");
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g){//funkcja rysuj¹ca
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0,null);
		
	}
}
