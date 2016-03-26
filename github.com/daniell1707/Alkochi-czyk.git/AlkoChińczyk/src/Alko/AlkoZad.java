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
		JFrame frame1 = new JFrame("ZADANIE");
		frame1.setSize(300, 400);
		frame1.setLocationRelativeTo(null);
		frame1.setResizable(true);
		frame1.setLayout(null);
		frame1.setVisible(true);
		AlkoZadGraf g = new AlkoZadGraf();
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JButton Wyjscie= new JButton("Wyjscie");
		Wyjscie.setBounds(80, 300, 120, 40);
		Wyjscie.setBackground(Color.WHITE);
		frame1.add(Wyjscie);
		Wyjscie.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				frame1.dispose();
			 }});
		
		frame1.add(area);
		frame1.add(label1);
		frame1.add(g);
		
	}

}


