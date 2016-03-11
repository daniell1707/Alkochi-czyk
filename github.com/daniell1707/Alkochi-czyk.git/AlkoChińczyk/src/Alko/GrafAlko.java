package Alko;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GrafAlko extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage plansza;
	public static int pionki[][]=new int[4][2];
	Timer timer;
	int aktywnyGracz;
	private BufferedImage czerowny;
	private BufferedImage niebieski;
	private BufferedImage zielony;
	private BufferedImage zolty;
	GrafAlko(){
		//³adowanie planszy
		File imageFile = new File("img/plansza.png");

			try {
				plansza = ImageIO.read(imageFile);
			} 
			catch (IOException e) {
				System.err.println("Blad odczytu planszy");
				e.printStackTrace();
			}
		//³adowanie pionka czerwonego
		imageFile = new File("img/czerwony.png");

			try {
				czerowny = ImageIO.read(imageFile);
			} 
			catch (IOException e) {
				System.err.println("Blad odczytu pionka czerwonego");
				e.printStackTrace();
			}
			//³adowanie pionka niebiekiego
		imageFile = new File("img/niebieski.png");

			try {
				niebieski = ImageIO.read(imageFile);
			} 
			catch (IOException e) {
				System.err.println("Blad odczytu pionka niebieskiego");
				e.printStackTrace();
			}
			//³adowanie pionka zielonego
		imageFile = new File("img/zielony.png");

				try {
					zielony = ImageIO.read(imageFile);
				} 
				catch (IOException e) {
					System.err.println("Blad odczytu pionka zielonego");
					e.printStackTrace();
				}
				//³adowanie pionka ¿ó³tego
		imageFile = new File("img/zolty.png");

				try {
					zolty = ImageIO.read(imageFile);
					} 
				catch (IOException e) {
					System.err.println("Blad odczytu pionka zoltego");
					e.printStackTrace();
				}
		this.setSize(900, 900);
		this.setLayout(null);
		
		pionki[0][0]=150;
		pionki[0][1]=670;
		pionki[1][0]=190;
		pionki[1][1]=670;
		pionki[2][0]=150;
		pionki[2][1]=710;
		pionki[3][0]=190;
		pionki[3][1]=710;
	}
	public void ruchPrawo(int a){
		aktywnyGracz=a;
		timer = new Timer();
		timer.schedule(new Prawo(),1,5);
		
	}
	public void ruchLewo(int a){
		aktywnyGracz=a;
		timer = new Timer();
		timer.schedule(new Lewo(),1,5);
	}
	public void ruchGora(int a){
		aktywnyGracz=a;
		timer = new Timer();
		timer.schedule(new Gora(),1,5);
		
	}
	public void ruchDol(int a){
		aktywnyGracz=a;
		timer = new Timer();
		timer.schedule(new Dol(),1,5);
	}
	public void paintComponent(Graphics g){//funkcja rysuj¹ca
		super.paintComponent(g);
		g.drawImage(plansza, 0, 0,null);
		g.drawImage(czerowny,pionki[0][0], pionki[0][1], null);
		g.drawImage(niebieski,pionki[1][0], pionki[1][1], null);
		g.drawImage(zielony,pionki[2][0], pionki[2][1], null);
		g.drawImage(zolty,pionki[3][0], pionki[3][1], null);
	}
	class Prawo extends TimerTask {
		int piksele = 0;
	    public void run() {
	    	pionki[aktywnyGracz][0]++;
	    	piksele++;
	    	AlkoNG.alko.g.repaint();
	    	if (piksele==75){
	    		Alko.kostka--;
	    		if(Alko.kostka>0){
	    			Alko.ruchPionka();
	    			
	    		}
	    		else{
	    			Alko.kostka=5;
	    		}
	    		this.cancel();
	    		
	    	}
	    }
	}
	class Dol extends TimerTask {
		int piksele = 0;
	    public void run() {
	    	pionki[aktywnyGracz][1]++;
	    	piksele++;
	    	Alko.g.repaint();
	    	if (piksele==75){
	    		Alko.kostka--;
	    		if(Alko.kostka>0){
	    			Alko.ruchPionka();
	    			
	    		}
	    		else{
	    			Alko.kostka=5;
	    		}
	    		this.cancel();
	    		
	    	}
	    }
	}	
	class Lewo extends TimerTask {
		int piksele = 0;
	    public void run() {
	    	pionki[aktywnyGracz][0]--;
	    	piksele++;
	    	AlkoNG.alko.g.repaint();
	    	if (piksele==75){
	    		Alko.kostka--;
	    		if(Alko.kostka>0){
	    			Alko.ruchPionka();
	    		}
	    		else{
	    			Alko.kostka=5;
	    		}
	    		this.cancel();
	    		
	    	}
	    }
	}	
	class Gora extends TimerTask {
		int piksele = 0;
	    public void run() {
	    	pionki[aktywnyGracz][1]--;
	    	piksele++;
	    	Alko.g.repaint();
	    	if (piksele==75){
	    		Alko.kostka--;
	    		if(Alko.kostka>0){
	    			Alko.ruchPionka();
	    		}
	    		else{
	    			Alko.kostka=5;
	    		}
	    		this.cancel();
	    		
	    	}
	    }
	}	
}

