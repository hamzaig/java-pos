import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import net.proteanit.sql.DbUtils;
public class ForgotPassword extends JFrame implements ActionListener
{
	JPanel panel1,panel2,panel3;
	JLabel PointOfSale,usernameLabel,emailLabel,dobLabel,textLabel,textLabel1,textLabel2,textLabel3;
	JButton loginMain,clear,cancel,retrivepassword,forgotpass1,exit;
	JTextField textField1,textField2,textField3;
	PreparedStatement pst;
	ResultSet rs;
	ForgotPassword()
	{
		setSize(1600, 900);
		setUndecorated(true);
		setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 1600, 180);
		panel2.setBackground(SystemColor.desktop);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
		PointOfSale = new JLabel("POINT OF SALE SYSTEM");
		PointOfSale.setFont(new Font("Tahoma", Font.BOLD, 40));
		PointOfSale.setForeground(Color.WHITE);
		PointOfSale.setBounds(578, 54, 487, 66);
		panel2.add(PointOfSale);
		
		panel1 = new JPanel();
		panel1.setBounds(0, 180, 471, 720);
		panel1.setBackground(Color.GRAY);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		loginMain = new JButton("LOGIN");
		loginMain.setBounds(0, 250, 471, 58);
		loginMain.setFont(new Font("Tahoma", Font.BOLD, 26));
		loginMain.setForeground(Color.white);
		loginMain.setBackground(SystemColor.black);
		panel1.add(loginMain);
		
		forgotpass1 = new JButton("Forgot Password");
		forgotpass1.setBounds(0, 320, 471, 58);
		forgotpass1.setFont(new Font("Tahoma", Font.BOLD, 26));
		forgotpass1.setForeground(Color.white);
		forgotpass1.setBackground(SystemColor.textHighlight);
		panel1.add(forgotpass1);
		
		exit = new JButton("EXIT");
		exit.setBounds(0, 390, 471, 58);
		exit.setFont(new Font("Tahoma", Font.BOLD, 26));
		exit.setForeground(Color.white);
		exit.setBackground(SystemColor.black);
		panel1.add(exit);
		
		panel3 = new JPanel();
		panel3.setBounds(530, 230, 1015, 599);
		TitledBorder tb=new TitledBorder(null, "Forgot Password", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight);
		tb.setTitleFont(new Font("Tahoma", Font.PLAIN, 50));
		panel3.setBorder(tb);
		getContentPane().add(panel3);
		panel3.setLayout(null);
		
		 textLabel= new JLabel("Point of Sale & Inventory System Makes Managing");
		 textLabel.setBounds(290, 100, 750, 60);
		 textLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		 textLabel.setForeground(Color.DARK_GRAY);
		panel3.add(textLabel);
		
		
		textLabel1= new JLabel("Inventory & Sales Faster & Easier Than Ever Before.");
		textLabel1.setBounds(290, 130, 550, 60);
		textLabel1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		textLabel1.setForeground(Color.DARK_GRAY);
		 panel3.add(textLabel1);
		 
		 
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(294, 218, 150, 60);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel3.add(usernameLabel);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(294, 280, 150, 60);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel3.add(emailLabel);
		
		dobLabel = new JLabel("DOB");
		dobLabel.setBounds(294, 340, 150, 60);
		dobLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel3.add(dobLabel);
		
		textField1 = new JTextField(10);
		textField1.setBounds(470, 235, 230, 35);
		panel3.add(textField1);
		
		textField2 = new JTextField(10);
		textField2.setBounds(470, 295, 230, 35);
		panel3.add(textField2);
		
		textField3 = new JTextField(10);
		textField3.setBounds(470, 355, 230, 35);
		panel3.add(textField3);
		
		retrivepassword = new JButton("Retrive Password");
		retrivepassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		retrivepassword.setForeground(Color.white);
		retrivepassword.setBackground(Color.black);
		retrivepassword.setBounds(50, 470, 299, 54);//(94, 160, 299, 34);
		panel3.add(retrivepassword);
		
		clear = new JButton("CLEAR");
		clear.setFont(new Font("Tahoma", Font.BOLD, 14));
		clear.setForeground(Color.white);
		clear.setBackground(Color.black);
		clear.setBounds(355, 470, 299, 54);
		panel3.add(clear);
		
		cancel = new JButton("CANCEL");
		cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.setBounds(660, 470, 299, 54);
		panel3.add(cancel);
		
		
		textLabel2= new JLabel("Need Help? Email us at");
		textLabel2.setBounds(290, 520, 550, 60);
		textLabel2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		textLabel2.setForeground(Color.DARK_GRAY);
		 panel3.add(textLabel2);
		 
		 textLabel3= new JLabel("hamzaig@yahoo.com");
		 textLabel3.setBounds(505, 520, 550, 60);
		 textLabel3.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 20));
		 textLabel3.setForeground(Color.DARK_GRAY);
		panel3.add(textLabel3);
		
//		loginMain.addActionListener(this);
		
		
		exit.addActionListener(this);
		loginMain.addActionListener(this);
		forgotpass1.addActionListener(this);
		retrivepassword.addActionListener(this);
		clear.addActionListener(this);
		cancel.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
	{
//		if(e.getSource()==loginMain)
//		{
//			new ForgotPassword().setVisible(true);
//			this.setVisible(false);
//		}
////		if(e.getSource()==loginMain)
//		{
//			new ForgotPassword().setVisible(true);
//			this.setVisible(false);
//		}
		
		if(e.getSource()==retrivepassword)
		{
			
			if(textField1.getText().equals("")||textField2.getText().equals("")||textField3.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Enter All Details");
			}
			else
			{
			DbConnection dbc=new DbConnection();
			try {
				pst=dbc.c.prepareStatement("Select password from cashier where username=? AND email=? AND dob=?");
				pst.setString(1, textField1.getText());
				pst.setString(2, textField2.getText());
				pst.setString(3, textField3.getText());
				rs=pst.executeQuery();
				
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null, "Your Password Is "+rs.getString("password"));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Username & Email & Date of Birth Does Not Match");
					textField1.setText("");
					textField2.setText("");
					textField3.setText("");
					textField1.requestFocus();
				}
				
			} 
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		}
		
		
		
		
		
		if(e.getSource()==clear)
		{
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
		}
		
		
		
		
		if(e.getSource()==cancel)
		{
			new Login().setVisible(true);
			this.setVisible(false);
		}
		
		if(e.getSource()==forgotpass1)
		{
			new ForgotPassword().setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==exit)
		{
			forgotpass1.setBackground(SystemColor.black);
			exit.setBackground(SystemColor.textHighlight);
			int diallogresult=JOptionPane.showConfirmDialog(null, "Do You Want to EXIT","Warning",JOptionPane.YES_NO_OPTION);
			if(diallogresult==JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
				
		}
		if(e.getSource()==loginMain)
		{
			new Login().setVisible(true);
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) 
	{
		new ForgotPassword().setVisible(true);
	}
}
