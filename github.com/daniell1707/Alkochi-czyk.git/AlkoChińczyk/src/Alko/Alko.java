package Alko;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class Alko{
	JFrame window = new JFrame("Sztuka Pijanego Mistrza");
	static GrafAlko g=new GrafAlko();
	String fileQuest;
	String[] quests;
	static AlkoG[] alkoG= new AlkoG[4];
	static int nr_gracza=0;
	Timer timer=new Timer(true); 
	static int kostka;
	static JLabel label = new JLabel();
	Random generator = new Random();
	public Alko(){
		window.setSize(900, 900);
		window.setLocationRelativeTo(null);
		window.setResizable(true);
		window.setLayout(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.add(g);
		g.repaint();
		JButton ruchButton= new JButton("Ruch");
		ruchButton.setBounds(10, 450, 120, 40);
		ruchButton.setBackground(Color.WHITE);
		g.add(ruchButton);
		ruchButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				kostka=generator.nextInt(5)+1;
				AlkoZad a = new AlkoZad(quests[generator.nextInt(quests.length-2)],kostka);
				ruchPionka();
				
			 }});
		
		JButton MenuG³ówne= new JButton("Menu G³ówne");
		MenuG³ówne.setBounds(10, 500, 120, 40);
		MenuG³ówne.setBackground(Color.WHITE);
		g.add(MenuG³ówne);
		MenuG³ówne.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				window.dispose();
			 }});
		
		JButton Wyjscie= new JButton("Wyjscie");
		Wyjscie.setBounds(10, 550, 120, 40);
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
		label.setFont(new Font("Serif", Font.BOLD, 13));
		label.setBounds(10,395,120,40);
		
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
		if(kostka==1){
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
	
	
}
