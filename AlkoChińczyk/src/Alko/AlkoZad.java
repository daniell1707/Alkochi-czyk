package Alko;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AlkoZad  {
	AlkoZad(String a,int kostka){
		JFrame frame = new JFrame("ZADANIE");
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setLayout(null);
		
		AlkoZadGraf g = new AlkoZadGraf();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel label1 = new JLabel(Integer.toString(kostka));
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Serif", Font.BOLD, 72));
		label1.setBounds(120,60,150,80);
		
		JTextArea area = new JTextArea();
		area.setEditable(false);  
		area.setCursor(null);  
		area.setOpaque(false);  
		area.setFocusable(false);  
		area.setFont(new Font("Serif", Font.BOLD, 18));
		area.setForeground(Color.WHITE);
		area.setWrapStyleWord(true);  
		area.setLineWrap(true);
		area.setBounds(10,250,270,180);
		area.setText(a);
		
		frame.add(area);
		frame.add(label1);
		frame.add(g);
		frame.setVisible(true);
		
	}

}


