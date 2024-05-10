import java.awt.Color;
import java.awt.Font;
import java.awt.RadialGradientPaint;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import com.sun.jdi.event.EventQueue;
//*******Made Exception????????>>>?///////////////////////
//1. empty brand etc added
//2. empty status add error
//3. auto detect category from brand
//4. select * for the data retrival from database
public class Pos extends JFrame implements ActionListener,MouseListener,KeyListener
{
	ArrayList<String> autocomplete=new ArrayList<String>();
	
	DbConnection dbc;
	
	JPanel panel1,panel2,panel3;
	JLabel PointOfSale,l1,l3,l4,l5;
	JButton category,brand,product,pos,cashier,exit,add,deleteButton,payInvoice;
	JTable table_1;
	JTextField textField1,textField2,textField3,textField4;
	private JLabel lblSubtotal;
	private JLabel lblPay;
	private JLabel lblBalance; 
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JLabel cashirnamelabel;
	Pos()
	{
		setSize(1366, 768);
		setUndecorated(true);
		setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		 
		
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 1600, 180);
		panel2.setBackground(SystemColor.desktop);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
//		
		
		
		PointOfSale = new JLabel("POINT OF SALE SYSTEM");
		PointOfSale.setFont(new Font("Tahoma", Font.BOLD, 40));
		PointOfSale.setForeground(Color.WHITE);
		PointOfSale.setBounds(578, 54, 487, 66);
		panel2.add(PointOfSale);
		
		cashirnamelabel = new JLabel("CASHIER MR. ");
		cashirnamelabel.setForeground(Color.WHITE);
		cashirnamelabel.setBackground(Color.WHITE);
		cashirnamelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		cashirnamelabel.setBounds(1220, 124, 250, 75);
		panel2.add(cashirnamelabel);
		String a=(Login.cname).toUpperCase();
		cashirnamelabel.setText(cashirnamelabel.getText()+a);
		
		
		
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
		brand.setBackground(Color.BLACK);
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
		pos.setBackground(SystemColor.textHighlight);
		panel1.add(pos);
		
		cashier = new JButton("CASHIER");
		cashier.setBounds(0, 476, 471, 58);
		cashier.setForeground(Color.WHITE);
		cashier.setFont(new Font("Tahoma", Font.BOLD, 26));
		cashier.setBackground(Color.BLACK);
		panel1.add(cashier);
		
		exit= new JButton("EXIT");
		exit.setBounds(0, 576, 471, 58);
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Tahoma", Font.BOLD, 26));
		exit.setBackground(Color.BLACK);
		panel1.add(exit);
		
		panel3 = new JPanel();
		panel3.setBounds(530, 200, 1022, 180);
		panel3.setBorder(new TitledBorder(null, "PRODUCT", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		getContentPane().add(panel3);
		panel3.setLayout(null);
		
//		casheirName = new JLabel("hamza ali khalid");
//		casheirName.setBounds(0, 30, 230, 225);
//		casheirName.setFont(new Font("Tahoma", Font.PLAIN, 119));
//		casheirName.setBackground(Color.red);
//		.add(casheirName);
		
		
		
		l1 = new JLabel("Product Code");
		l1.setBounds(44, 34, 138, 26);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l1);
		
		l3 = new JLabel("Price");
		l3.setBounds(599, 35, 100, 25);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l3);
		
		l4 = new JLabel("Quantity");
		l4.setBounds(599, 79, 100, 25);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l4);
		
		l5 = new JLabel("Product Name");
		l5.setBounds(44, 79, 130, 25);
		l5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l5);
		
		
		
		textField1 = new JTextField(10);
		textField1.setBounds(228, 35, 190, 25);
		panel3.add(textField1);

		textField2 = new JTextField(10);
		textField2.setBounds(228, 79, 190, 25);
		panel3.add(textField2);
		
		textField3 = new JTextField(10);
		textField3.setBounds(747, 39, 190, 25);
		panel3.add(textField3);
		
		textField4 = new JTextField(10);
		textField4.setBounds(747, 83, 190, 25);
		panel3.add(textField4);
		
		String comboBox1string[]= {"Active","Deactive"};
		
		add = new JButton("Add");//(494, 239, 100, 25);
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setForeground(Color.white);
		add.setBackground(Color.black);  
		add.setBounds(328, 130, 298, 30);
		panel3.add(add);
		
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
		
		
		
		////////////Table////////////////////////////
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(530, 391, 1022, 355);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		scrollPane.setViewportView(table_1);
		
		 table_1.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {

		            },
		            new String [] {
		                "Product Code", "Product Name", "Price", "Quantity", "Total"
		            }
		        ));
		 scrollPane.setViewportView(table_1);
		 
		 deleteButton = new JButton("Delete Entry");
		 deleteButton.setForeground(Color.WHITE);
		 deleteButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		 deleteButton.setBackground(Color.BLACK);
		 deleteButton.setBounds(856, 757, 298, 30);
		 getContentPane().add(deleteButton);
		 
		 JPanel panel = new JPanel();
		 panel.setBounds(530, 797, 1022, 103);
		 getContentPane().add(panel);
		 panel.setLayout(null);
		 
		 lblSubtotal = new JLabel("Subtotal");
		 lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		 lblSubtotal.setBounds(21, 11, 138, 26);
		 panel.add(lblSubtotal);
		 
		 lblPay = new JLabel("Pay");
		 lblPay.setFont(new Font("Tahoma", Font.PLAIN, 19));
		 lblPay.setBounds(333, 11, 58, 26);
		 panel.add(lblPay);
		 
		 lblBalance = new JLabel("Balance");
		 lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 19));
		 lblBalance.setBounds(614, 11, 138, 26);
		 panel.add(lblBalance);
		 
		 textField5 = new JTextField(10);
		 textField5.setBounds(118, 11, 190, 25);
		 panel.add(textField5);
		 
		 textField6 = new JTextField(10);
		 textField6.setBounds(396, 11, 190, 25);
		 panel.add(textField6);
		 
		 textField7 = new JTextField(10);
		 textField7.setBounds(755, 12, 190, 25);
		 panel.add(textField7);
		 
		 payInvoice = new JButton("PayInvoice");
		 payInvoice.setForeground(Color.WHITE);
		 payInvoice.setFont(new Font("Tahoma", Font.BOLD, 14));
		 payInvoice.setBackground(Color.BLACK);
		 payInvoice.setBounds(325, 62, 298, 30);
		 panel.add(payInvoice);
		 
		 
		 
		 category.addActionListener(this);
			brand.addActionListener(this);
			product.addActionListener(this);
			pos.addActionListener(this);
			cashier.addActionListener(this);
			exit.addActionListener(this);
		 payInvoice.addActionListener(this);
		 deleteButton.addActionListener(this);
		 textField1.addKeyListener(this);
		 add.addActionListener(this);
		 textField2.addKeyListener(this);
		 databaseautocomplete();
		 
		 
	} 
	
	
	
	
	
private void posSale()
{
	DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM//dd");
	LocalDateTime ldt=LocalDateTime.now();
	String date=dt.format(ldt);
	
	String totalAmount=textField5.getText();
	String payAmount=textField6.getText();
	String balanceAmount=textField7.getText();
	
	dbc=new DbConnection();
	PreparedStatement pst;
	int lastinsetid=0;
	try 
	{
		String query="INSERT INTO sales(date,cashier,subtotal,pay,balance) VALUES (?,?,?,?,?)";
		pst=dbc.c.prepareStatement(query,new String[]{"USER_ID"});
		pst.setString(1, date);
		pst.setString(2, Login.cname);
		pst.setString(3, totalAmount);
		pst.setString(4, payAmount);
		pst.setString(5, balanceAmount);
		
		pst.executeUpdate();
		
		ResultSet rs=pst.getGeneratedKeys();
		
		if(rs.next())
		{
			lastinsetid=rs.getInt(1);
		}
		
		
		String query1="INSERT INTO sales_product(sales_id,product_id,sell_price,quantity,total) VALUES (?,?,?,?,?)";
		pst=dbc.c.prepareStatement(query1);
		String product_id="";
		String sell_price="";
		String quantity="";
		int total=0;
		
		for(int i=0;i<table_1.getRowCount();i++)
		{
			product_id=(String) table_1.getValueAt(i, 0);
			sell_price=(String) table_1.getValueAt(i, 2);
			quantity=(String) table_1.getValueAt(i, 3);
			total=(int) table_1.getValueAt(i, 4);
			
			pst.setInt(1, lastinsetid);
			pst.setString(2, product_id);
			pst.setString(3, sell_price);
			pst.setString(4, quantity);
			pst.setInt(5, total);
			
			pst.executeUpdate();
		}
		
		
		
		pst=dbc.c.prepareStatement("UPDATE product set quantity=quantity-? WHERE id=?");
		
		for(int i=0;i<table_1.getRowCount();i++)
		{
			product_id=(String) table_1.getValueAt(i, 0);
			quantity=(String) table_1.getValueAt(i, 3);
			
			pst.setString(1, quantity);
			pst.setString(2, product_id);

			
			pst.execute();
		}
		
		
		pst.addBatch();
		
		
		
		
		
		
		
		
		
		
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
}
	
	
	
public void printsposs()
{
	
	String totalAmount=textField5.getText();
	String payment=textField6.getText();
	String balance=textField7.getText();
	
	
	new PrintPos(totalAmount, payment, balance, table_1.getModel()).setVisible(true);
	new Pos().setVisible(true);
	
	
	
	
}

void databaseautocomplete()
{
	try
	{
		DbConnection con=new DbConnection();
		String query="Select * From product";
		ResultSet rs=con.s.executeQuery(query);
		while(rs.next())
		{
			String productName=rs.getString("product");
			autocomplete.add(productName);
		}
		rs.close();
		con.s.close();
		con.c.close();
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}
void autocomplete(String text)
{
	String complete="";
	int start=text.length();
	int last=text.length();
	
	for(int i=0;i<autocomplete.size();i++)
	{
		if(autocomplete.get(i).toString().startsWith(text))
		{
			complete=autocomplete.get(i).toString();
			last=complete.length();
			break;	
		}
	}
	if(last>start)
	{
		textField2.setText(complete);
		textField2.setCaretPosition(last);
		textField2.moveCaretPosition(start);
	}
	
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
		new Pos().setVisible(true);
		this.setVisible(false);
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
		String code=textField1.getText();
		DbConnection co=new DbConnection();
		try 
		{
			PreparedStatement insert=co.c.prepareStatement("SELECT * FROM product Where id=?");
			insert.setString(1, code);
			ResultSet rs=insert.executeQuery();
			if(rs.next())
			{
				int currentQuantity=rs.getInt("quantity");
				
				int price=Integer.parseInt(textField3.getText());
				int enterQuantity=Integer.parseInt(textField4.getText());
				
				int total=price*enterQuantity;
				
				if(enterQuantity>currentQuantity)
				{
					JOptionPane.showMessageDialog(null, "Quantity is Not Enough");
					JOptionPane.showMessageDialog(null, "Available Quantity = "+currentQuantity);
				}
				else
				{
					DefaultTableModel model=(DefaultTableModel) table_1.getModel();
					model.addRow(new Object[]
							{
									textField1.getText(),
									textField2.getText(),
									textField3.getText(),
									textField4.getText(),
									total
							});
					
					int sum=0;
					
					for(int i=0;i<table_1.getRowCount();i++)
					{
						
						sum=sum+Integer.parseInt(table_1.getValueAt(i, 4).toString());
					
					}
					
					textField5.setText(Integer.toString(sum));
					
					
					
					
					textField1.setText("");
					textField2.setText("");
					textField3.setText("");
					textField4.setText("");
					textField1.requestFocus();
				}
				
				
			}
			
			
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	
	}	
	if(e.getSource()==deleteButton)
	{
		
		DefaultTableModel model=(DefaultTableModel) table_1.getModel();
		model.removeRow(table_1.getSelectedRow());
		
		int sum=0;
		
		for(int i=0;i<table_1.getRowCount();i++)
		{
			
			sum=sum+Integer.parseInt(table_1.getValueAt(i, 4).toString());
		
		}
		
		textField5.setText(String.valueOf(sum));
		
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		textField4.setText("");
		textField1.requestFocus();
	}	
	
	if(e.getSource()==payInvoice)
	{
		
		int subTotal=Integer.parseInt(textField5.getText());
		int payment=Integer.parseInt(textField6.getText());
		
		int balance=subTotal-payment;
		
		textField7.setText(String.valueOf(balance));
		
		
		
		printsposs();
		posSale();
		
		
	}
	
	

}	

public static void main(String[] args) 
	{
		new Pos().setVisible(true);
	}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) 
{
	if(e.getSource()==textField1)
	{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			String code=textField1.getText();
			DbConnection co=new DbConnection();
			try 
			{
				PreparedStatement insert=co.c.prepareStatement("SELECT * FROM product Where id=?");
				insert.setString(1, code);
				ResultSet rs=insert.executeQuery();
				if(rs.next()==false)
				{
					JOptionPane.showMessageDialog(null, "Product Id Is Not Found");
				}
				else
				{
					String productName=rs.getString("product");
					String price_retail=rs.getString("retail_price");
				
					textField2.setText(productName.trim());
					textField3.setText(price_retail.trim());
					
					
				}
				
				
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
	
	if(e.getSource()==textField2)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_BACK_SPACE:
				break;
			case KeyEvent.VK_ENTER:
				textField2.setText(textField2.getText());
				break;
			default:
				java.awt.EventQueue.invokeLater(new Runnable() {
			        public void run() {
			        	String text=textField2.getText();
			        	autocomplete(text);
			        }
			    });
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			String productname=textField2.getText();
			DbConnection co=new DbConnection();
			try 
			{
				PreparedStatement insert=co.c.prepareStatement("SELECT * FROM product Where product=?");
				insert.setString(1, productname);
				ResultSet rs=insert.executeQuery();
				if(rs.next()==false)
				{
					JOptionPane.showMessageDialog(null, "Product Name Is Not Found");
				}
				else
				{
					String productName=rs.getString("id");
					String price_retail=rs.getString("retail_price");
				
					textField1.setText(productName.trim());
					textField3.setText(price_retail.trim());
					
					
				}
				
				
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
	
}
