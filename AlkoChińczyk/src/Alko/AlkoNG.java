package Alko;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AlkoNG{
	private JFrame frame = new JFrame("Nowa Gra");
	private File file = new File("zadania");
	private File[] fileList;
	private String[] fileNames;
	JComboBox JCBquestList;
	static Alko alko;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public
	AlkoNG(){
		AlkoNGGraf g = new AlkoNGGraf();
		fileList = file.listFiles(new FilenameFilter() {
		    public boolean accept(File file, String name) {
		        if (name.endsWith(".txt")) {
		            // filters files whose extension is .txt
		            return true;
		        } else {
		            return false;
		        }
		    }
		});
		
		fileNames = new String[fileList.length];
		
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		for(int i=0;i<fileList.length;i++){
			fileNames[i]=fileList[i].getName();
		}
		
		
		JCBquestList = new JComboBox();
		JCBquestList.setBounds(125, 100, 150, 30);
		JCBquestList.layout();
		
		for(int i=0;i<fileNames.length;i++){
			JCBquestList.addItem(fileNames[i]);
		}
		
		g.add(JCBquestList);
		
		JButton bOK = new JButton("ok");
		bOK.setBounds(150, 180, 100, 50);
		bOK.setBackground(Color.WHITE);
		bOK.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 File filePom = new File("zadania/"+JCBquestList.getSelectedItem().toString());
				 if(filePom.length()>0){
					 frame.dispose();
					 alko = new Alko();
					 alko.fileQuest=JCBquestList.getSelectedItem().toString();
					 try {
							alko.loadQuest();
					 } catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						// TODO Auto-generated catch block
				}
				 else{
					 JOptionPane.showMessageDialog(null, "Plik jest pusty");
				 }
			}
		});
		g.add(bOK);
		frame.add(g);
		frame.repaint();
}	
	
	public static void main(String[]args){
		
		AlkoNG NG = new AlkoNG();
	}
	
}
