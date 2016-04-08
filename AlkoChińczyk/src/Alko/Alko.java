package Alko;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Alko{
	static JFrame window = new JFrame("Sztuka Pijanego Mistrza");
	static GrafAlko g=new GrafAlko();
	String fileQuest;
	static String[] quests;
	static AlkoG[] alkoG= new AlkoG[4];
	static int nr_gracza=0;
	Timer timer=new Timer(true); 
	static boolean jeszcze=true;
	static int kostka;
	static JLabel label = new JLabel();
	static Random generator = new Random();
	static int kost;
	static JButton ruchButton;
	public Alko(){
		window.setSize(700, 700);
		window.setLocationRelativeTo(null);
		window.setResizable(true);
		window.setLayout(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.add(g);
		g.repaint();
		timer.schedule(new refresh(), 1,1);
		ruchButton= new JButton("Ruch");
		ruchButton.setBounds(8, 350, 100, 40);
		ruchButton.setBackground(Color.WHITE);
		g.add(ruchButton);
		ruchButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				kostka=generator.nextInt(6)+1;
				kost=kostka;
				ruchButton.setEnabled(false);
				ruchPionka();
				
			 }});
		
		JButton MenuG³ówne= new JButton("Menu");
		MenuG³ówne.setBounds(8, 400, 100, 40);
		MenuG³ówne.setBackground(Color.WHITE);
		g.add(MenuG³ówne);
		MenuG³ówne.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				
			 }});
		
		JButton Wyjscie= new JButton("Wyjscie");
		Wyjscie.setBounds(8, 450, 100, 40);
		Wyjscie.setBackground(Color.WHITE);
		g.add(Wyjscie);
		Wyjscie.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				System.exit(1);
			 }});
		
		for(int i=0;i<alkoG.length;i++){
			alkoG[i]=new AlkoG();
		}
		label = new JLabel("GRACZ CZERWONY");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Serif", Font.BOLD, 11));
		label.setBounds(9,300,120,40);
		
		g.add(label);
		g.repaint();
		
	}
	void loadQuest() throws IOException{//³aduje zadania
		
		LineNumberReader lineReader = new LineNumberReader(new FileReader("zadania/"+fileQuest));
		lineReader.skip(Long.MAX_VALUE);
		int lines = lineReader.getLineNumber()+1;
		quests=new String[lines];
		lineReader.close();
		
		FileReader fr = new FileReader("zadania/"+fileQuest);
		BufferedReader bfr = new BufferedReader(fr);
		String linia = "";
		int i = 0;
		try {
		     while((linia = bfr.readLine()) != null){
		    	quests[i]=linia;
		    	i++;
		     }
		    } catch (IOException e) {
		        System.out.println("B£¥D ODCZYTU Z PLIKU!");
		        System.exit(2);
		   }
		
	}

	public static void ruchPionka(){
		
		if(alkoG[nr_gracza].getPole()<7||alkoG[nr_gracza].getPole()>=27&&alkoG[nr_gracza].getPole()<33||alkoG[nr_gracza].getPole()>=47&&alkoG[nr_gracza].getPole()<51||alkoG[nr_gracza].getPole()>=59&&alkoG[nr_gracza].getPole()<61){
			alkoG[nr_gracza].poleNast();
			g.ruchPrawo(nr_gracza);
		}
		else if(alkoG[nr_gracza].getPole()>=7&&alkoG[nr_gracza].getPole()<14||alkoG[nr_gracza].getPole()>=33&&alkoG[nr_gracza].getPole()<38||alkoG[nr_gracza].getPole()>=51&&alkoG[nr_gracza].getPole()<54||alkoG[nr_gracza].getPole()>=61&&alkoG[nr_gracza].getPole()<62){
			alkoG[nr_gracza].poleNast();
			g.ruchGora(nr_gracza);
		}
		else if(alkoG[nr_gracza].getPole()>=14&&alkoG[nr_gracza].getPole()<21||alkoG[nr_gracza].getPole()>=38&&alkoG[nr_gracza].getPole()<43||alkoG[nr_gracza].getPole()>=54&&alkoG[nr_gracza].getPole()<57||alkoG[nr_gracza].getPole()>=62&&alkoG[nr_gracza].getPole()<63){
			alkoG[nr_gracza].poleNast();
			g.ruchLewo(nr_gracza);
		}
		else if(alkoG[nr_gracza].getPole()>=21&&alkoG[nr_gracza].getPole()<27||alkoG[nr_gracza].getPole()>=43&&alkoG[nr_gracza].getPole()<47||alkoG[nr_gracza].getPole()>=57&&alkoG[nr_gracza].getPole()<59){
			alkoG[nr_gracza].poleNast();
			g.ruchDol(nr_gracza);
		}
		if(alkoG[nr_gracza].getPole()==63){
			window.dispose();
			//Koniec k = new Koniec(nr_gracza);
		}
		if(kostka==1){
			if (alkoG[nr_gracza].getPole()!=63){
				AlkoZad a = new AlkoZad(quests[generator.nextInt(quests.length-2)],kost);
				ruchButton.setEnabled(true);
			}
			
			nr_gracza++;
			if(nr_gracza==4){
				nr_gracza=0;
			}
		}
		
		labelZmien();
	}
	static void labelZmien(){
		if(nr_gracza==0){
			label.setText("GRACZ CZEROWNY");
		}
		else if(nr_gracza==1){
			label.setText("GRACZ NIEBIESKI");
		}
		else if(nr_gracza==2){
			label.setText("GRACZ ZIELONY");
		}
		else if(nr_gracza==3){
			label.setText("GRACZ ¯Ó£TY");
		}
		label.repaint();
	}
	class refresh extends TimerTask {
		int piksele = 0;
	    public void run() {
	    	g.repaint();
	    }
	}	
	
}
