import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Program extends JFrame {

	 JLabel loading;
	Program()
	{
		setSize(64, 64);
		setUndecorated(true); 
		setLocation(670, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		 
		loading = new JLabel();
		loading.setFont(new Font("Tahoma", Font.BOLD, 40));
		loading.setIcon(new javax.swing.ImageIcon("C:\\Users\\Aahil Seemab\\Downloads\\7.gif"));
		loading.setBounds(0, 0, 64, 64);
		getContentPane().setBackground(new Color(0,0,0,0));
		getContentPane().add(loading);
		
 
	}
	public static void main(String[] args) {
		
		Program cf=new Program();
		cf.setVisible(true);
		try {
			for(int i=0;i<=100;i++)
			{
				Thread.sleep(15);
				Login h=new Login();
				Program c=new Program();
				if(i==100)
				{
					cf.setVisible(false);
					h.setVisible(true);
					
				}
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	
	
	
}
