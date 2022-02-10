package kioskDemo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;


public class kioskDemo extends JFrame
{
	   /**
	    * 
	    */
 	    private static final long serialVersionUID = 1L;
 	    
		/**
		 * 
		 */
		double total        = 0.0;
		int    numOfItems   = 0;
		
		int    numOfApples  = 0;
		int    numOfPears   = 0;
		int    numOfOranges = 0;
		int    numOfGrapes  = 0;
		
		String idNumStr=null;
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args)
		{
			kioskDemo frame = new kioskDemo();
			
			frame.setVisible(true);
		}

		/**
		 * Create the frame.
		 */
		public kioskDemo() 
		{
			//
			// Frame title display current time
			//
			Date  date = new Date();
			String str = String.format("%tc", date);
			   
       	   
			String titleString = "--- Food Truck Kiosk --- " + str; 				    
			setTitle(titleString);
			
			NumberFormat formatter = new DecimalFormat("#0.00");
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			// size of the frame
			//
			setSize(970,670);
			
			//
			// panel title
			//
			JPanel contentPane = new JPanel();
			contentPane.setBorder(new TitledBorder(new EtchedBorder(), 
					              "Display Area - Food Truck #1      Rev. 1.0"));;
			setContentPane(contentPane);
			
			//
			//  create a label ID#, Truck#, Credit Card#, etc...
			//
			JLabel cartLabel = new JLabel("Shopping Cart : ");
			cartLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cartLabel.setBounds(650, 20, 150, 23);
			contentPane.add(cartLabel);
			
			
			
			
			//
			//  create a label ID#, Truck#, Credit Card#, etc...
			//
			JLabel idNumLabel = new JLabel("ID#, Truck#, Credit Card# : ");
			idNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			idNumLabel.setBounds(30, 525, 200, 23);
			contentPane.add(idNumLabel);
			
			//
			// field where user puts in ID#, Truck#, etc.
			//
			JTextField idNum = new JTextField();
			idNum.setEditable(true);
			idNum.setBounds(200, 525, 150, 34);
			contentPane.add(idNum);
			idNum.setColumns(20);
			
			
			
			//
			//  create a label for status
			//
			JLabel statusLabel = new JLabel("Status : ");
			statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			statusLabel.setBounds(650, 525, 100, 23);
			contentPane.add(statusLabel);
			
			//
			// field where to see status information
			//
			JTextField status = new JTextField();
			status.setEditable(false);
			status.setBounds(700, 525, 200, 34);
			contentPane.add(status);
			status.setColumns(40);
			status.setBackground(Color.LIGHT_GRAY);
			
			
			//
			// list of items that are being bought
			//
			JTextArea textArea = new JTextArea();
			textArea.setBounds(763, 11, 168, 382);
			textArea.setEditable(false);
			contentPane.add(textArea);
			
			
			//
			// field where total accumulating price is being displayed
			//
			JTextField textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(807, 420, 124, 34);
			contentPane.add(textField);
			textField.setColumns(10);
			
			
			//
			// Orange Button
			//
			JButton btnNewButton = new JButton("Oranges");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					numOfItems++;
					numOfOranges++;
					
					textArea.append("Oranges         .59\r\n");
					total = total + .59;
					
					textField.setText(formatter.format(total));
					textField.repaint();
					
					status.setText("");
					status.setBackground(Color.LIGHT_GRAY);
				}
			});
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\nkounavelis\\Desktop\\Kiosk-Oranges.jpg"));
			btnNewButton.setBounds(10, 41, 231, 200);
			contentPane.add(btnNewButton);
			
			
			//
     		// Apple Button
			//
			JButton btnNewButton_1 = new JButton("Apples");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					numOfItems++;
					numOfApples++;
					
					textArea.append("Apples          .49\r\n");
					total = total + .49;
					
					textField.setText(formatter.format(total));
					textArea.repaint();
					
					status.setText("");
					status.setBackground(Color.LIGHT_GRAY);
				}
			});
			btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\nkounavelis\\Desktop\\Kiosk-Apples.jpg"));
			btnNewButton_1.setBounds(10, 290, 231, 200);
			contentPane.add(btnNewButton_1);

			
			//
			// Pear Button
			//
			JButton btnNewButton_2 = new JButton("Pears");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					numOfItems++;
					numOfPears++;
					
					textArea.append("Pears           .39\r\n");
					total = total + .39;
					
					textField.setText(formatter.format(total));
					textArea.repaint();
					
					status.setText("");
					status.setBackground(Color.LIGHT_GRAY);
				}
			});
			btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\nkounavelis\\Desktop\\Kiosk-Pears.jpg"));
			btnNewButton_2.setBounds(250, 41, 187, 200);
			contentPane.add(btnNewButton_2);
			
			
			//
			// Grape Button
			//
			JButton btnNewButton_4 = new JButton("Grapes");
			btnNewButton_4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					numOfItems++;
					numOfGrapes++;
					
					textArea.append("Grapes           .89\r\n");
					total = total + .89;
										
					textField.setText(formatter.format(total));
					textArea.repaint();
					
					status.setText("");
					status.setBackground(Color.LIGHT_GRAY);
				}
			});
			btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\nkounavelis\\Desktop\\Kiosk-Grapes.jpg"));
			btnNewButton_4.setBounds(250, 290, 187, 200);
			contentPane.add(btnNewButton_4);
			
			
			//
			//  create a label for total price
			//
			JLabel lblNewLabel = new JLabel("    Total Price   $");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(697, 424, 100, 23);
			contentPane.add(lblNewLabel);
			
			
			//
			// EXIT Button
			//
			JButton btnNewButton_3 = new JButton("EXIT");
			btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton_3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{				
					int result = JOptionPane.showConfirmDialog(null,
	                             "Do you really want to exit the Food Truck Client Screen?",
	                             "Food Truck",
		                         JOptionPane.INFORMATION_MESSAGE);

					
	                if (result == JOptionPane.OK_OPTION)
	                {   
	                    //
	                    //close shop :-(
	                    //
					    dispose();
					    System.exit(0);
			     	}
				}
				
			});
			btnNewButton_3.setBounds(30, 570, 133, 34);
			contentPane.add(btnNewButton_3);
			
			
			
			//
			// SUBMIT Button
			//
			JButton submit = new JButton("SUBMIT");
			submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
			submit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (numOfItems != 0)
					{
						idNumStr= idNum.getText();
						idNumStr = idNumStr.trim();
						
						if (idNumStr == "" || idNumStr == null || idNumStr.length() == 0)
						{
							JOptionPane.showMessageDialog(null, 
					                   "Sorry! ID# string field is empty!",
					                   "Food Truck",
					                   JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						   String dataStr = null;
						
						   dataStr=idNumStr + ",A=" + numOfApples + ",G=" + numOfGrapes + ",O=" + numOfOranges + ",P=" + numOfPears + "," + numOfItems + "," + total; 
						
						   fileIO fio = new fileIO();
						   fio.wrTransactionData(dataStr);
						
						   numOfItems = 0;
						
						   numOfApples  = 0;
						   numOfPears   = 0;
						   numOfOranges = 0;
						   numOfGrapes  = 0;
				
						   textArea.setText("");
						   textField.setText("");
						   idNum.setText("");
						   
						   status.setText("Success!");
						   status.setBackground(Color.GREEN);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, 
				                   "Sorry! Your shopping cart is empty now!",
				                   "Food Truck",
				                   JOptionPane.WARNING_MESSAGE);
					}	
				}
			});
			submit.setBounds(200, 570, 133, 34);
			contentPane.add(submit);
			
			
			
			
			//
			// COUPONS Button
			//
			JButton coupons = new JButton("COUPONS");
			coupons.setFont(new Font("Tahoma", Font.PLAIN, 16));
			coupons.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					coupons coup = new coupons();
					coup.setVisible(true);
				}
			});
			coupons.setBounds(400, 570, 133, 34);
			contentPane.add(coupons);
			
			

			
			//
			// CLEAR Button
			//
			JButton clear = new JButton("CLEAR");
			clear.setFont(new Font("Tahoma", Font.PLAIN, 16));
			clear.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (numOfItems != 0)
					{
					    int result = JOptionPane.showConfirmDialog(null,
                            "Do you really want to clear all items in your cart?",
                            "Food Truck",
	                         JOptionPane.INFORMATION_MESSAGE);

				
                        if (result == JOptionPane.OK_OPTION)
                        {   
                    	   numOfItems = 0;
 						
						   numOfApples  = 0;
						   numOfPears   = 0;
						   numOfOranges = 0;
						   numOfGrapes  = 0;
				
						   textArea.setText("");
						   textField.setText("");
						   idNum.setText("");
                      }
		           }	
				}
			});
			clear.setBounds(600, 570, 133, 34);
			contentPane.add(clear);
			
			
			
			
			//
			// HELP Button
			//
			JButton help = new JButton("HELP");
			help.setFont(new Font("Tahoma", Font.PLAIN, 16));
			help.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
						
				}
			});
			help.setBounds(800, 570, 133, 34);
			contentPane.add(help);
			
			

			
			
			
			
			//
			// labels for each product button
			//
			JLabel lblNewLabel_1 = new JLabel("Click for Oranges : .59 each");
			lblNewLabel_1.setBounds(39, 260, 194, 14);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Click for Pears : .39 each");
			lblNewLabel_2.setBounds(282, 260, 177, 14);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Click for Apples : .49 each");
			lblNewLabel_3.setBounds(39, 500, 202, 14);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Click for Grapes : .89 each");
			lblNewLabel_4.setBounds(272, 500, 187, 14);
			contentPane.add(lblNewLabel_4);
		
            // 
			// call thread to update date and time
			//
			refreshTitleBar();
			
			
			// user will do the layout
			contentPane.setLayout(null);
			
			// position frame in the middle of the screen
			this.setLocationRelativeTo(null);
		}
		
		
	    //
	    // Thread to update TITLE BAR, date, and time     
	    //     
	    private void refreshTitleBar()
	    {	
		   Thread refreshAllTitleBar = new Thread()
		   {
			  public void run()
			  { 
				 while (true)
				 {
					 try 
					 {
					   //
					   // display current time
					   //
					   Date  date = new Date();
					   String str = String.format("%tc", date);
	              	   
					   String titleString = "--- Food Truck Kiosk --- " + str; 				 
					   
					   setTitle(titleString);
						 
					   sleep(5000L);                   // sleep for 5 seconds or 5,000 milliseconds
					   
	                 } // end try block
				  
			         catch (InterruptedException e) 
			         {
			        	 JOptionPane.showMessageDialog(null, 
	                              "ERROR. Interrupt Exception! Check Internet Connection!",
	                              "Title Top Bar",
	                              JOptionPane.WARNING_MESSAGE);
			        	 
			        	 continue;
				     }
			         finally
			         {
				   
			         }
				 } // end while true
		     }
		  };

	      refreshAllTitleBar.start();
	    }
}
