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
//*******Made Exception????????>>>?///////////////////////
//1. empty brand etc added
//2. empty status add error
public class Cashier extends JFrame implements ActionListener,MouseListener
{
	JPanel panel1,panel2,panel3;
	JLabel PointOfSale,status,categorylbl;
	JButton category,brand,product,pos,cashier,exit,add,update,delete;
	JTable table_1;
	JTextField textField1,tfname,tfemail,tfdob;
	JComboBox comboBox1;
	JScrollPane scrollPane;
	JPasswordField jpf1;
	Cashier()
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
//		panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1.setBackground(Color.GRAY);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		category = new JButton("CATEGORY");
		category.setBounds(0, 76, 471, 58);
		category.setFont(new Font("Tahoma", Font.BOLD, 26));
		category.setForeground(Color.white);
		category.setBackground(Color.black);
		panel1.add(category);
		
		brand = new JButton("BRAND");
		brand.setBounds(0, 175, 471, 58);
		brand.setFont(new Font("Tahoma", Font.BOLD, 26));
		brand.setForeground(Color.WHITE);
		brand.setBackground(SystemColor.textHighlight);
		panel1.add(brand);
		
		product = new JButton("PRODUCT");
		product.setBounds(0, 276, 471, 58);
		product.setFont(new Font("Tahoma", Font.BOLD, 26));
		product.setForeground(Color.WHITE);
		product.setBackground(Color.BLACK);
		panel1.add(product);
		
		pos = new JButton("POS");
		pos.setBounds(0, 376, 471, 58);
		pos.setFont(new Font("Tahoma", Font.BOLD, 26));
		pos.setForeground(Color.WHITE);
		pos.setBackground(Color.BLACK);
		panel1.add(pos);
		
		cashier = new JButton("CASHIER");
		cashier.setBounds(0, 476, 471, 58);
		cashier.setForeground(Color.WHITE);
		cashier.setFont(new Font("Tahoma", Font.BOLD, 26));
		cashier.setBackground(SystemColor.textHighlight);
		panel1.add(cashier);
		
		exit= new JButton("EXIT");
		exit.setBounds(0, 576, 471, 58);
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Tahoma", Font.BOLD, 26));
		exit.setBackground(Color.BLACK);
		panel1.add(exit);
		
		panel3 = new JPanel();
		panel3.setBounds(530, 218, 982, 299);
		panel3.setBorder(new TitledBorder(null, "CASHIER", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		getContentPane().add(panel3);
		panel3.setLayout(null);
		
		
		categorylbl = new JLabel("Full Name");
		categorylbl.setBounds(94, 40, 105, 26);
		categorylbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(categorylbl);
		
		categorylbl = new JLabel("Email");
		categorylbl.setBounds(94, 80, 105, 26);
		categorylbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(categorylbl); 
		
		categorylbl = new JLabel("Username");
		categorylbl.setBounds(94, 120, 105, 26);
		categorylbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(categorylbl);
		
		categorylbl = new JLabel("Password");
		categorylbl.setBounds(94, 160, 105, 15);
		categorylbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(categorylbl);
		
		categorylbl = new JLabel("DOB");
		categorylbl.setBounds(94, 200, 105, 26);
		categorylbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(categorylbl);
		
		status = new JLabel("Status");
		status.setBounds(94, 240, 105, 15);
		status.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(status);
		
		
		
		tfname = new JTextField();
		tfname.setBounds(235, 40, 200, 25);
		panel3.add(tfname);
		
		tfemail = new JTextField();
		tfemail.setBounds(235, 80, 200, 25);
		panel3.add(tfemail);
		
		textField1 = new JTextField(10);
		textField1.setBounds(235, 120, 200, 25);
		panel3.add(textField1);
		
		jpf1 = new JPasswordField();
		jpf1.setBounds(235, 160, 200, 25);
		panel3.add(jpf1);
		
		tfdob = new JTextField();
		tfdob.setBounds(235, 200, 200, 25);
		panel3.add(tfdob);
		
		String comboBoxstring[]= {"Active","Deactive"};
		comboBox1 = new JComboBox(comboBoxstring);
		comboBox1.setBounds(235, 237, 200, 22);
		panel3.add(comboBox1);
		
		
		
		
		
		
		
		
		
		
		add = new JButton("Add");
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setForeground(Color.white);
		add.setBackground(Color.black);
		add.setBounds(594, 84, 299, 34);//(94, 160, 299, 34);
		panel3.add(add);
		
		update = new JButton("Update");
		update.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.setForeground(Color.white);
		update.setBackground(Color.black);
		update.setBounds(594, 130, 299, 34);
		panel3.add(update);
		
		delete = new JButton("Delete");
		delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		delete.setForeground(Color.white);
		delete.setBackground(Color.black);
		delete.setBounds(594, 176, 299, 34);
		panel3.add(delete);
		
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(1052, 204, 516, 667);
//		getContentPane().add(scrollPane);
//		
////		String data[][]={ {"101","Amit","670000"},    
////                {"102","Jai","780000"},    
////                {"101","Sachin","700000"}};    
////String column[]={"ID","NAME","SALARY"};   
//		
//		table_1 = new JTable();
//		table_1.setFont(new Font("Tahoma", Font.BOLD, 16));
//		table_1.setForeground(Color.white);
//		table_1.setBackground(Color.GRAY);
//		
//		scrollPane.setViewportView(table_1);
		
		
//		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(530, 550, 982, 299);
		getContentPane().add(scrollPane);
		
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		scrollPane.setViewportView(table_1);
		
		 table_1.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {

		            },
		            new String [] {
		                "Id","Full Name","E-mail","Username","Date Of Bith","Status"
		            }
		        ));
		 scrollPane.setViewportView(table_1);
		

		
		
		
		
		
		
		
		
		 category.addActionListener(this);
			brand.addActionListener(this);
			product.addActionListener(this);
			pos.addActionListener(this);
			cashier.addActionListener(this);
			exit.addActionListener(this);
		table_1.addMouseListener(this);
		add.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		table_update();
		
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==category)
		{
			new Category().setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==brand)
		{
			new Brand().setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==product)
		{
			new Product().setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==pos)
		{
			JOptionPane.showMessageDialog(null, "Hello");
			Pos a=new Pos();
			a.setVisible(true);
		}
		if(e.getSource()==cashier)
		{
			new Cashier().setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==exit)
		{
			pos.setBackground(Color.black);
			exit.setBackground(SystemColor.textHighlight);
			new Login().setVisible(true);
			this.setVisible(false);
		}
		
		
		if(e.getSource()==add)
		{
			String fullnameString=tfname.getText();
			String emailString=tfemail.getText();
			String usernameString=textField1.getText();
			String passString=jpf1.getText();
			String dobString=tfdob.getText();
			String activeString=comboBox1.getSelectedItem().toString();
			
			DbConnection co=new DbConnection();
			try 
			{
				PreparedStatement pst=co.c.prepareStatement("INSERT INTO cashier (fullname,email,username,password,dob,status) VALUES (?,?,?,?,?,?)");
				pst.setString(1, fullnameString);
				pst.setString(2, emailString);
				pst.setString(3, usernameString);
				pst.setString(4, passString);
				pst.setString(5, dobString);
				pst.setString(6, activeString);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cashier Added");
				textField1.setText("");
				tfname.setText("");
				tfemail.setText("");
				tfdob.setText("");
				jpf1.setText("");
				comboBox1.setSelectedIndex(-1);
				textField1.requestFocus();
				table_update();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource()==update)
		{
			DefaultTableModel d1=(DefaultTableModel) table_1.getModel();
			int selectIndex=table_1.getSelectedRow();
			int id=Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
			
			String fullnameString=tfname.getText();
			String emailString=tfemail.getText();
			String usernameString=textField1.getText();
			String passString=jpf1.getText();
			String dobString=tfdob.getText();
			String activeString=comboBox1.getSelectedItem().toString();
			
			try 
			{
				DbConnection co=new DbConnection();
				PreparedStatement pst=co.c.prepareStatement("UPDATE cashier SET fullname=?,email=?,username=?,dob=?,status=? WHERE id=?");
				pst.setString(1, fullnameString);
				pst.setString(2, emailString);
				pst.setString(3, usernameString);
				pst.setString(4, dobString);
				pst.setString(5, activeString);
				pst.setInt(6, id);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Updated But !password not changed");
				textField1.setText("");
				tfname.setText("");
				tfemail.setText("");
				tfdob.setText("");
				jpf1.setText("");
				comboBox1.setSelectedIndex(-1);
				textField1.requestFocus();
				table_update();
				
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==delete)
		{
			DefaultTableModel d1=(DefaultTableModel) table_1.getModel();
			int selectIndex=table_1.getSelectedRow();
			int id=Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
			
			int diallogresult=JOptionPane.showConfirmDialog(null, "Do You Want to Delete the Record","Warning",JOptionPane.YES_NO_OPTION);
			
			if(diallogresult==JOptionPane.YES_OPTION)
			{
				DbConnection co=new DbConnection();
				
				try {
					PreparedStatement pst=co.c.prepareStatement("DELETE FROM cashier WHERE id=?");
					pst.setInt(1, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Cashier Is Deleted");
					textField1.setText("");
					tfname.setText("");
					tfemail.setText("");
					tfdob.setText("");
					jpf1.setText("");
					comboBox1.setSelectedIndex(-1);
					textField1.requestFocus();
					table_update();
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				textField1.setText("");
				tfname.setText("");
				tfemail.setText("");
				tfdob.setText("");
				jpf1.setText("");
				comboBox1.setSelectedIndex(-1);
				textField1.requestFocus();
			}
			
		}
	}
	
	
	void table_update()
	{
		int count;
		
		try 
		{
			DbConnection co=new DbConnection();
			String query="Select * From cashier";
			PreparedStatement pst=co.c.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			java.sql.ResultSetMetaData rsmd=rs.getMetaData();
			count=rsmd.getColumnCount();
			
//			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			DefaultTableModel d=(DefaultTableModel) table_1.getModel();
			d.setRowCount(0);
			while(rs.next())
			{
				Vector vec=new Vector();
				for(int i=1;i<=count;i++)
				{
					vec.add(rs.getString("id"));
					vec.add(rs.getString("fullname"));
					vec.add(rs.getString("email"));
					vec.add(rs.getString("username"));
					vec.add(rs.getString("dob"));
					vec.add(rs.getString("status"));
				}
				d.addRow(vec);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Cashier().setVisible(true);
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table_1)
		{
			DefaultTableModel d1=(DefaultTableModel) table_1.getModel();
			int selectIndex=table_1.getSelectedRow();
			
			tfname.setText(d1.getValueAt(selectIndex,1).toString());
			tfemail.setText(d1.getValueAt(selectIndex,2).toString());
			textField1.setText(d1.getValueAt(selectIndex,3).toString());
			tfdob.setText(d1.getValueAt(selectIndex,4).toString());
			comboBox1.setSelectedItem(d1.getValueAt(selectIndex,5).toString());
			
			jpf1.hide();
			
		}
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
