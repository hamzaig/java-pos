import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class Login extends JFrame implements ActionListener,KeyListener
{
	JPanel panel1,panel2,panel3;
	JLabel PointOfSale,userLabel,passLabel,textLabel,textLabel1,textLabel2,textLabel3,times;
	JButton loginMain,login,clear,cancel,forgotpass,forgotpass1,exit;
	JTextField textField1;
	JPasswordField jpf1;
	PreparedStatement pst;
	ResultSet rs;
	public static String cname;
	Login()
	{
		setSize(1600, 900); 
		setUndecorated(true);
//		setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		 
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 1600, 180);
		panel2.setBackground(SystemColor.desktop);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
		times = new JLabel();
		times.setFont(new Font("Tahoma", Font.BOLD, 20));
		times.setForeground(Color.WHITE);
		times.setBounds(0, 0, 387, 46);
		panel2.add(times);
		
		time();
		
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
		loginMain.setBackground(SystemColor.textHighlight);
		panel1.add(loginMain);
		
		forgotpass1 = new JButton("Forgot Password");
		forgotpass1.setBounds(0, 320, 471, 58);
		forgotpass1.setFont(new Font("Tahoma", Font.BOLD, 26));
		forgotpass1.setForeground(Color.white);
		forgotpass1.setBackground(SystemColor.black);
		panel1.add(forgotpass1);
		
		exit = new JButton("EXIT");
		exit.setBounds(0, 390, 471, 58);
		exit.setFont(new Font("Tahoma", Font.BOLD, 26));
		exit.setForeground(Color.white);
		exit.setBackground(SystemColor.black);
		panel1.add(exit);
		
		panel3 = new JPanel();
		panel3.setBounds(530, 230, 1015, 599);
		TitledBorder tb=new TitledBorder(null, "LOGIN", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight);
		tb.setTitleFont(new Font("Tahoma", Font.PLAIN, 80));
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
		 
		 
		userLabel = new JLabel("Username");
		userLabel.setBounds(294, 220, 150, 60);
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel3.add(userLabel);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(294, 280, 150, 60);
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel3.add(passLabel);
		
		textField1 = new JTextField(10);
		textField1.setBounds(470, 237, 230, 35);
		panel3.add(textField1);
		
		jpf1 = new JPasswordField(); 
		jpf1.setBounds(470, 292, 230, 35);
		panel3.add(jpf1);
		
		login = new JButton("LOGIN");
		login.setFont(new Font("Tahoma", Font.BOLD, 14));
		login.setForeground(Color.white);
		login.setBackground(Color.black);
		login.setBounds(50, 380, 299, 54);//(94, 160, 299, 34);
		panel3.add(login);
		
		clear = new JButton("CLEAR");
		clear.setFont(new Font("Tahoma", Font.BOLD, 14));
		clear.setForeground(Color.white);
		clear.setBackground(Color.black);
		clear.setBounds(355, 380, 299, 54);
		panel3.add(clear);
		
		cancel = new JButton("CANCEL");
		cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.setBounds(660, 380, 299, 54);
		panel3.add(cancel);
		
		forgotpass = new JButton("Forgot Password?");
		forgotpass.setFont(new Font("Tahoma", Font.BOLD, 14));
		forgotpass.setForeground(Color.white);
		forgotpass.setBackground(Color.black);
		forgotpass.setBounds(355, 450, 299, 54);
		panel3.add(forgotpass);
		
		
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
		
		
		textField1.addKeyListener(this);
		jpf1.addKeyListener(this);
		exit.addActionListener(this);
		cancel.addActionListener(this);
		clear.addActionListener(this);
		forgotpass.addActionListener(this);
		forgotpass1.addActionListener(this);
		login.addActionListener(this);
		loginMain.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==loginMain)
		{
			new Login().setVisible(true);
			this.setVisible(false);
		}
		
		if(e.getSource()==login)
		{
			if(textField1.getText().equals("")||jpf1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Complete All Information");
			}
			else
			{
				DbConnection dbc=new DbConnection();
				try {
					pst=dbc.c.prepareStatement("Select * from cashier where username=? AND password=?");
					pst.setString(1, textField1.getText());
					pst.setString(2, jpf1.getText());
					rs=pst.executeQuery();
					
					if(rs.next())
					{
						this.cname=textField1.getText();
						new Pos().setVisible(true);;
						this.hide();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username & Password Does Not Match");
						textField1.setText("");
						jpf1.setText("");
						textField1.requestFocus();
					}
					
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
		
		if(e.getSource()==forgotpass||e.getSource()==forgotpass1)
		{
			new ForgotPassword().setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==clear)
		{
			textField1.setText("");
			jpf1.setText("");
			
		}
		if(e.getSource()==cancel||e.getSource()==exit)
		{
			loginMain.setBackground(SystemColor.black);
			forgotpass1.setBackground(SystemColor.black);
			exit.setBackground(SystemColor.textHighlight);
			int diallogresult=JOptionPane.showConfirmDialog(null, "Do You Want to EXIT","Warning",JOptionPane.YES_NO_OPTION);
			if(diallogresult==JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
				
		}
	}
	public static void main(String[] args) 
	{
		new Login().setVisible(true);
	}
	
	void time()
	{
		DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM//dd");
		LocalDateTime ldt=LocalDateTime.now();
		String date=dt.format(ldt);
	
		
		times.setText("Date:  "+date);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		if(e.getSource()==textField1||e.getSource()==jpf1)
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				if(textField1.getText().equals("")||jpf1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Complete All Information");
				}
				else
				{
					DbConnection dbc=new DbConnection();
					try {
						pst=dbc.c.prepareStatement("Select * from cashier where username=? AND password=?");
						pst.setString(1, textField1.getText());
						pst.setString(2, jpf1.getText());
						rs=pst.executeQuery();
						
						if(rs.next())
						{
							this.cname=textField1.getText();
							new Pos().setVisible(true);;
							this.hide();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Username & Password Does Not Match");
							textField1.setText("");
							jpf1.setText("");
							textField1.requestFocus();
						}
						
					} 
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
		
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
