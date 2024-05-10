import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PrintPos extends JFrame implements ActionListener
{
	
	private JLabel lblTotalBalance,lblPayment,lblBalance,lblThanksForComing,lblTotal,lblProductName,lblPrice,lblQuantity,PointOfSale,bal,pay,tamount;
	private JTable table;
	private JPanel panel2,panel3,panel0;
	private JTextArea textAreaproductName,textAreaQuantity,textAreaPrice,textAreatotal;
	JButton exit;
	
	String totalAmount;
	String payment;
	String balance;
	
//	PrintPos()
//	{
//	}
	
	
	
	PrintPos(String totalAmount,String payment,String balance,TableModel tableModel)
	{
		setForeground(Color.LIGHT_GRAY);
		setBackground(SystemColor.inactiveCaption);
		
		setSize(470, 640); 
		setLocation(450, 100);
		setUndecorated(true);
//		setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel0 = new JPanel();
		 panel0.setBounds(0, 0, 470, 640);
		 getContentPane().add(panel0);
		 panel0.setLayout(null);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 470, 94);
		panel2.setBackground(SystemColor.activeCaption);
		panel0.add(panel2);
		panel2.setLayout(null);
		
		PointOfSale = new JLabel("POINT OF SALE SYSTEM");
		PointOfSale.setBounds(41, 19, 382, 59);
		PointOfSale.setFont(new Font("Tahoma", Font.BOLD, 30));
		PointOfSale.setForeground(SystemColor.textHighlight);
		panel2.add(PointOfSale);
		
		exit = new JButton("Exit");
		exit.setBounds(381, 0, 89, 23);
		panel2.add(exit);
		
		exit.addActionListener(this);
		
		panel3 = new JPanel();
		panel3.setBounds(22, 110, 411, 472);
		panel3.setBackground(SystemColor.window);
		panel3.setBorder(new TitledBorder(null, "Print Receipt", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel0.add(panel3);
		panel3.setLayout(null);
		
		lblTotalBalance = new JLabel("Total Amount");
		lblTotalBalance.setBounds(150, 334, 105, 33);
		lblTotalBalance.setForeground(SystemColor.textHighlight);
		lblTotalBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel3.add(lblTotalBalance);
		
		lblPayment = new JLabel("Payment");
		lblPayment.setBounds(172, 357, 105, 33);
		lblPayment.setForeground(SystemColor.textHighlight);
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel3.add(lblPayment);
		
		lblBalance = new JLabel("Balance");
		lblBalance.setBounds(172, 383, 105, 33);
		lblBalance.setForeground(SystemColor.textHighlight);
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel3.add(lblBalance);
		
		lblThanksForComing = new JLabel("Thanks For Coming");
		lblThanksForComing.setBounds(131, 439, 186, 33);
		lblThanksForComing.setForeground(SystemColor.windowText);
		lblThanksForComing.setFont(new Font("Yu Gothic Medium", Font.ITALIC, 14));
		panel3.add(lblThanksForComing);
		
		tamount = new JLabel("New label");
		tamount.setBounds(265, 345, 78, 14);
		tamount.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel3.add(tamount);
		
		pay = new JLabel("New label");
		pay.setBounds(265, 368, 78, 14);
		pay.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel3.add(pay);
		
		 bal = new JLabel("New label");
		 bal.setBounds(265, 394, 78, 14);
		 bal.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel3.add(bal);
		
		
		this.totalAmount=totalAmount;
		this.payment=payment;
		this.balance=balance;
		
		tamount.setText(totalAmount);
		pay.setText(payment);
		bal.setText(balance);
		
		lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProductName.setForeground(SystemColor.textHighlight);
		lblProductName.setBounds(22, 26, 97, 20);
		panel3.add(lblProductName);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantity.setForeground(SystemColor.textHighlight);
		lblQuantity.setBounds(170, 26, 65, 20);
		panel3.add(lblQuantity);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice.setForeground(SystemColor.textHighlight);
		lblPrice.setBounds(245, 26, 49, 20);
		panel3.add(lblPrice);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotal.setForeground(SystemColor.textHighlight);
		lblTotal.setBounds(304, 26, 97, 20);
		panel3.add(lblTotal);
		
		textAreaproductName = new JTextArea();
		textAreaproductName.setEditable(false);
		textAreaproductName.setBounds(22, 45, 138, 289);
		panel3.add(textAreaproductName);
		
		textAreaQuantity = new JTextArea();
		textAreaQuantity.setBounds(172, 45, 60, 289);
		textAreaQuantity.setEditable(false);
		panel3.add(textAreaQuantity);
		
		
		textAreaPrice = new JTextArea();
		textAreaPrice.setBounds(245, 45, 49, 289);
		textAreaPrice.setEditable(false);
		panel3.add(textAreaPrice);
		
		textAreatotal = new JTextArea();
		textAreatotal.setBounds(304, 45, 49, 289);
		textAreatotal.setEditable(false);
		panel3.add(textAreatotal);
		
//		
//		
//		
//		
//		 
//		
//		
////		JScrollPane scrollPane0 = new JScrollPane();
////		scrollPane0.setBounds(20, 21, 365, 313);
////		panel3.add(scrollPane0);
////		table = new JTable();
////		table.setFont(new Font("Tahoma", Font.BOLD, 12));
////		scrollPane0.setViewportView(table);
////		table.setModel(new javax.swing.table.DefaultTableModel(
////		            new Object [][] {
////
////		            },
////		            new String [] {
////		            		"Product Name","Quantity","Price","Total"
////		            }
////		        ));
////		scrollPane0.add(table);
//		
//		
//		
////		panel = new JPanel();
////		panel.setBounds(20, 21, 365, 313);
////		panel3.add(panel);
////		panel.setLayout(null);
//		
//		
////		table = new JTable();
////		table.setBounds(0, 0, 363, 0);
////		panel.add(table);
////		table.setShowHorizontalLines(false);
////		table.setShowGrid(false);
////		table.setColumnSelectionAllowed(true);
////		table.setCellSelectionEnabled(false);
////		
////		table.setModel(new javax.swing.table.DefaultTableModel(
////		            new Object [][] {
////
////		            },
////		            new String [] {
////		               "Product Name","Quantity","Price","Total"
////		            }
////		        ));
////		
////		 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
////		 table.getColumnModel().getColumn(0).setPreferredWidth(140);
////		 table.getColumnModel().getColumn(1).setPreferredWidth(20);
////		 table.getColumnModel().getColumn(2).setPreferredWidth(20);
////		 table.getColumnModel().getColumn(3).setPreferredWidth(20);
		 
		
		for(int i=0;i<tableModel.getRowCount();i++)
		{
			String productt=(String) tableModel.getValueAt(i, 1);
			String quantityy=(String)tableModel.getValueAt(i, 3);
			String pricee=(String)tableModel.getValueAt(i, 2);
			int totall=(int)tableModel.getValueAt(i, 4);
		
			
			
			
			textAreaproductName.setText(textAreaproductName.getText()+productt+"\n");
			textAreaQuantity.setText(textAreaQuantity.getText()+quantityy+"\n");
			textAreaPrice.setText(textAreaPrice.getText()+pricee+"\n");
			textAreatotal.setText(textAreatotal.getText()+totall+"\n");

//			textArea.setText(textArea.getText()+"\t"+aproduct+""+aquString+"Rs."+aprice+"Rs."+totall+"\n");
		}
		
		
		
		PrinterJob job=PrinterJob.getPrinterJob();
		job.setJobName("Receipt");
		
		job.setPrintable(new Printable() {
			
			@Override
			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException 
			{
				if (pageIndex>0)
				{
					return Printable.NO_SUCH_PAGE;
				}
				
				Graphics2D g2=(Graphics2D) graphics;
				g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
				g2.scale(1	, 1);
				
//				JPanel x=panel2,panel3;
				
				panel0.paint(g2);
				
				return Printable.PAGE_EXISTS;
			}
		});
		
		boolean done=job.printDialog();
		
		if(done)
		{
			try 
			{
				job.print();
				JOptionPane.showMessageDialog(this, "Transaction Done");
				
				
			} 
			catch (PrinterException e) 
			{
//				System.out.println("Print Done");
			}
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==exit)
		{
			this.setVisible(false);
			
		}
	}
}
