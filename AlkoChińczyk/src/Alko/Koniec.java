package Alko;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Koniec {
	Koniec(int a){
		JFrame frame = new JFrame();
		frame.setSize(310, 200);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		KoGraf g = new KoGraf();
		frame.add(g);
		String b="";
		if(a==0){
			b="GRACZ CZERWONY";
		}
		else if(a==1){
			b="GRACZ NIEBIESKI";
		}
		else if(a==2){
			b="GRACZ ZIELONY";
		}
		else if(a==3){
			b="GRACZ ZӣTY";
		}
		JLabel label1 = new JLabel(b);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		label1.setBounds(60,70,200,100);
		g.add(label1);
		g.repaint();
		frame.repaint();
	}
	

}
