import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;
//*******Made Exception????????>>>?///////////////////////
//1. empty brand etc added
//2. empty status add error
//3. auto detect category from brand
//4. select * for the data retrival from database
public class Product extends JFrame implements ActionListener,MouseListener
{
	JPanel panel1,panel2,panel3;
	JLabel PointOfSale,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton category,brand,product,pos,cashier,exit,add,update,delete;
	JTable table_1;
	JTextField textField1,textField2,textField3,textField4,textField5;
	JComboBox<CategoryItem> comboBox1,comboBox2;
	JComboBox<BrandItem> comboBox3;
	JScrollPane scrollPane,scrollPane1;
	JTextArea ta1;
	Product()
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
		brand.setBackground(Color.BLACK);
		panel1.add(brand);
		
		product = new JButton("PRODUCT");
		product.setBounds(0, 276, 471, 58);
		product.setFont(new Font("Tahoma", Font.BOLD, 26));
		product.setForeground(Color.WHITE);
		product.setBackground(SystemColor.textHighlight);
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
		cashier.setBackground(Color.BLACK);
		panel1.add(cashier);
		
		exit= new JButton("EXIT");
		exit.setBounds(0, 576, 471, 58);
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Tahoma", Font.BOLD, 26));
		exit.setBackground(Color.BLACK);
		panel1.add(exit);
		
		panel3 = new JPanel();
		panel3.setBounds(530, 200, 1022, 399);
		panel3.setBorder(new TitledBorder(null, "PRODUCT", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		getContentPane().add(panel3);
		panel3.setLayout(null);
		
		
		
		l1 = new JLabel("Product");
		l1.setBounds(94, 63, 105, 26);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l1);
		
		l2 = new JLabel("Description");
		l2.setBounds(94, 103, 100, 25);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l2);
		
		l3 = new JLabel("Category");
		l3.setBounds(94, 200, 100, 25);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l3);
		
		l4 = new JLabel("Brand");
		l4.setBounds(94, 240, 100, 25);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l4);
		
		l5 = new JLabel("Cost Price");
		l5.setBounds(494, 63, 100, 25);
		l5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l5);
		
		l6 = new JLabel("Retail Price");
		l6.setBounds(494, 115, 100, 25);
		l6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l6);
		
		l7 = new JLabel("Quantity");
		l7.setBounds(494, 159, 100, 25);
		l7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l7);
		
		l8 = new JLabel("Barcode");
		l8.setBounds(494, 199, 100, 25);
		l8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l8);
		
		l9 = new JLabel("Status");
		l9.setBounds(494, 239, 100, 25);
		l9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel3.add(l9);
		
		textField1 = new JTextField(10);
		textField1.setBounds(235, 61, 180, 25);
		panel3.add(textField1);
		
		ta1 = new JTextArea();
		scrollPane1 = new JScrollPane(ta1);
		scrollPane1.setBounds(235, 100, 180, 75);
		panel3.add(scrollPane1);
		
		textField2 = new JTextField(10);
		textField2.setBounds(650, 63, 180, 25);
		panel3.add(textField2);

		textField3 = new JTextField(10);
		textField3.setBounds(650, 115, 180, 25);
		panel3.add(textField3);
		
		textField4 = new JTextField(10);
		textField4.setBounds(650, 159, 180, 25);
		panel3.add(textField4);
		
		textField5 = new JTextField(10);
		textField5.setBounds(650, 199, 180, 25);
		panel3.add(textField5);
		
		String comboBox1string[]= {"Active","Deactive"};
		comboBox1 = new JComboBox(comboBox1string);
		comboBox1.setBounds(650, 240, 180, 25);
		panel3.add(comboBox1);
		
		
		comboBox2 = new JComboBox();
		comboBox2.setBounds(235, 200, 180, 25);
		panel3.add(comboBox2);
		
		comboBox3 = new JComboBox();
		comboBox3.setBounds(235, 240, 180, 25);
		panel3.add(comboBox3);
		
		add = new JButton("Add");//(494, 239, 100, 25);
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setForeground(Color.white);
		add.setBackground(Color.black);
		add.setBounds(594, 290, 299, 30);
		panel3.add(add);
		
		update = new JButton("Update");
		update.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.setForeground(Color.white);
		update.setBackground(Color.black);
		update.setBounds(594, 325, 299, 30);
		panel3.add(update);
		
		delete = new JButton("Delete");
		delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		delete.setForeground(Color.white);
		delete.setBackground(Color.black);
		delete.setBounds(594, 360, 299, 30);
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
		
		
		
		////////////Table////////////////////////////
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(530, 620, 1022, 260);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		scrollPane.setViewportView(table_1);
		
		 table_1.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {

		            },
		            new String [] {
		                "Id", "Product", "Description", "Category", "Brand", "CostPrice", "RetailPrice", "Quantity", "Barcode", "Status"
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
		categoryItemfun();
		brandItemfun();
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
			String productString=textField1.getText();
			String descriptionString= ta1.getText();
			CategoryItem categoryItem=(CategoryItem) comboBox2.getSelectedItem();
			BrandItem brandItem=(BrandItem) comboBox3.getSelectedItem();
			String costPriceString= textField2.getText();
			String retailPriceString= textField3.getText();
			String quantityPriceString= textField4.getText();
			String barCodeString= textField5.getText();
			String statusString=comboBox1.getSelectedItem().toString();
			
			DbConnection co=new DbConnection();
			try 
			{
PreparedStatement pst=co.c.prepareStatement("INSERT INTO product(product,description,category_id,brand_id,cost_price,retail_price,quantity,barcode,status) VALUES (?,?,?,?,?,?,?,?,?)");
				
				pst.setString(1, productString);
				pst.setString(2, descriptionString);
				pst.setInt(3, categoryItem.id);
				pst.setInt(4, brandItem.id);
				pst.setString(5, costPriceString);
				pst.setString(6, retailPriceString);
				pst.setString(7, quantityPriceString);
				pst.setString(8, barCodeString);
				pst.setString(9, statusString);
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Product Added");
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText("");
				ta1.setText("");
				comboBox1.setSelectedIndex(-1);
				comboBox2.setSelectedIndex(-1);
				comboBox3.setSelectedIndex(-1);
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
			
			String productString=textField1.getText();
			String descriptionString= ta1.getText();
			CategoryItem categoryItem=(CategoryItem) comboBox2.getSelectedItem();
			BrandItem brandItem=(BrandItem) comboBox3.getSelectedItem();
			String costPriceString= textField2.getText();
			String retailPriceString= textField3.getText();
			String quantityPriceString= textField4.getText();
			String barCodeString= textField5.getText();
			String statusString=comboBox1.getSelectedItem().toString();
			
			try 
			{
				DbConnection co=new DbConnection();
				PreparedStatement pst=co.c.prepareStatement("UPDATE product SET product=?,description=?,category_id=?,brand_id=?,cost_price=?,retail_price=?,quantity=?,barcode=?,status=? WHERE id=?");
				//product,description,category_id,brand_id,cost_price,retail_price,quantity,barcode,status
				pst.setString(1, productString);
				pst.setString(2, descriptionString);
				pst.setInt(3, categoryItem.id);
				pst.setInt(4, brandItem.id);
				pst.setString(5, costPriceString);
				pst.setString(6, retailPriceString);
				pst.setString(7, quantityPriceString);
				pst.setString(8, barCodeString);
				pst.setString(9, statusString);
				
				
				pst.setInt(10, id);
				
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Product Is Updated");
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText("");
				ta1.setText("");
				comboBox1.setSelectedIndex(-1);
				comboBox2.setSelectedIndex(-1);
				comboBox3.setSelectedIndex(-1);
				
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
					PreparedStatement pst=co.c.prepareStatement("DELETE FROM product WHERE id=?");
					pst.setInt(1, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Product Is Deleted");
					textField1.setText("");
					textField2.setText("");
					textField3.setText("");
					textField4.setText("");
					textField5.setText("");
					ta1.setText("");
					comboBox1.setSelectedIndex(-1);
					comboBox2.setSelectedIndex(-1);
					comboBox3.setSelectedIndex(-1);
					
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
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText("");
				ta1.setText("");
				comboBox1.setSelectedIndex(-1);
				comboBox2.setSelectedIndex(-1);
				comboBox3.setSelectedIndex(-1);
				
				textField1.requestFocus();
				table_update();
			}
			
		}
	}
	void categoryItemfun()
	{
		DbConnection co=new DbConnection();
		try 
		{
			PreparedStatement pst=co.c.prepareStatement("Select * From category");
			ResultSet rs=pst.executeQuery();
			comboBox2.removeAllItems();
			
			while(rs.next())
			{
				comboBox2.addItem(new CategoryItem(rs.getInt(1), rs.getString(2)));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	void brandItemfun()
	{
		DbConnection co=new DbConnection();
		try 
		{
			PreparedStatement pst=co.c.prepareStatement("Select * From brand");
			ResultSet rs=pst.executeQuery();
			comboBox3.removeAllItems();
			
			while(rs.next())
			{
				comboBox3.addItem(new BrandItem(rs.getInt(1), rs.getString(3)));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	void brandItemselect()
	{
//		DbConnection co=new DbConnection();
//		try 
//		{
//			PreparedStatement pst=co.c.prepareStatement("Select * From brand");
//			ResultSet rs=pst.executeQuery();
//				comboBox3.addItem(new BrandItem(rs.getInt(1), rs.getString(3)));
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
		
	}
	
	
	
	void table_update()
	{
		int count;
		try 
		{
			DbConnection co=new DbConnection();
			String query="Select p.id, p.product,p.description, c.category,b.brand,p.cost_price,p.retail_price,p.quantity,p.barcode,p.status\r\n" + 
					"From product p,category c,brand b \r\n" + 
					"WHERE p.category_id=c.id AND p.brand_id=b.id";                                                                       
			PreparedStatement pst=co.c.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			java.sql.ResultSetMetaData rsmd=rs.getMetaData();
			count=rsmd.getColumnCount();
//			
//			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			DefaultTableModel d=(DefaultTableModel) table_1.getModel();
			d.setRowCount(0);
			while(rs.next())
			{
				Vector vec=new Vector();
				for(int i=1;i<=count;i++)
				{
					vec.add(rs.getString("id"));
					vec.add(rs.getString("product"));
					vec.add(rs.getString("description"));
					vec.add(rs.getString("category"));
					vec.add(rs.getString("brand"));
					vec.add(rs.getString("cost_price"));
					vec.add(rs.getString("retail_price"));
					vec.add(rs.getString("quantity"));
					vec.add(rs.getString("barcode"));
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
		new Product().setVisible(true);
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table_1)
		{
			DefaultTableModel d1=(DefaultTableModel) table_1.getModel();
			int selectIndex=table_1.getSelectedRow();
			
			textField1.setText(d1.getValueAt(selectIndex,1).toString());
			ta1.setText(d1.getValueAt(selectIndex,2).toString());
			comboBox2.setSelectedItem(d1.getValueAt(selectIndex,3).toString());
			comboBox3.setSelectedItem(d1.getValueAt(selectIndex,4).toString());
			textField2.setText(d1.getValueAt(selectIndex,5).toString());
			textField3.setText(d1.getValueAt(selectIndex,6).toString());
 			textField4.setText(d1.getValueAt(selectIndex,7).toString());
			textField5.setText(d1.getValueAt(selectIndex,8).toString());
			comboBox1.setSelectedItem(d1.getValueAt(selectIndex,9).toString());
//			comboBox2.setSelectedIndex(-1);
//			comboBox3.setSelectedIndex(-1);
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
