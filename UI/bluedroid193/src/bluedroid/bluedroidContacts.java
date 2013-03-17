package bluedroid;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.*;
//import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class bluedroidContacts extends javax.swing.JFrame {
	private JTable contactstable;
	private JScrollPane jScrollPane1;
	private JButton searchbutton;
	private JTextField newname;
	private JPanel jPanel3;
	private JButton addnumber;
	private JTextField newnumber;
	private JPanel jPanel2;
	private JTabbedPane addcontact;
	private JTabbedPane jTabbedPane1;
	private JPanel jPanel1;
	private JTextField search;
	private TableRowSorter<TableModel> sorter ;
	

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				bluedroidContacts inst = new bluedroidContacts();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public bluedroidContacts() {
		super();
		initGUI();
	}
	
	
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, BorderLayout.SOUTH);
				jScrollPane1.setPreferredSize(new java.awt.Dimension(15, 193));
				
				
				
				
				{
					//TableModel contactstableModel = 
						//	new DefaultTableModel(
							//		new String[][] { { "Regina", "234" }, { "Mae", "09234" } },
								//	new String[] { "Name", "Number" });
					
					Object rows[][] = { {"Regina", "123"}, {"Mae", "678"}, {"Moso", "456"}  };
					String columns[] = { "Name", "Number" };
					//contactstable = new JTable();
					
					TableModel contactstableModel = new DefaultTableModel(rows, columns) {
					      public Class getColumnClass(int column) {
					        Class returnValue;
					        if ((column >= 0) && (column < getColumnCount())) {
					          returnValue = getValueAt(0, column).getClass();
					        } else {
					          returnValue = Object.class;
					        }
					        return returnValue;
					      }
					    };
					
					    final JTable contactstable = new JTable(contactstableModel);
					    sorter= new TableRowSorter<TableModel>(contactstableModel);
					    contactstable.setRowSorter(sorter);	
					 
					    
					   
					    
					jScrollPane1.setViewportView(contactstable);
					contactstable.setModel(contactstableModel);
					contactstable.setPreferredSize(new java.awt.Dimension(287, 188));
				}
			}
			
			
			
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
				jTabbedPane1.setPreferredSize(new java.awt.Dimension(287, 217));
				{
					
					jPanel1 = new JPanel();
					jTabbedPane1.addTab("Search", null, jPanel1, null);
					jPanel1.setPreferredSize(new java.awt.Dimension(287, 143));
					{
						search = new JTextField();
						jPanel1.add(search);
						search.setText("Search Contact");
						search.setPreferredSize(new java.awt.Dimension(251, 39));
						
						search.addMouseListener(new MouseAdapter(){
							@Override
							public void mouseClicked(MouseEvent e){
								search.setText("");
								
							}
							
						});
						
					}
					{
						searchbutton = new JButton();
						jPanel1.add(searchbutton);
						searchbutton.setText("Search");
						searchbutton.setPreferredSize(new java.awt.Dimension(74, 34));
						
						 searchbutton.addActionListener(new ActionListener() {
						        public void actionPerformed(ActionEvent e) {
						          String text = search.getText();
						          if (text.length() == 0) {
						            sorter.setRowFilter(null);
						          } else {
						            sorter.setRowFilter(RowFilter.regexFilter(text));
						          }
						        }
						      });
						
						
					}
				}
				{
					jPanel2 = new JPanel();
					jTabbedPane1.addTab("Add", null, jPanel2, null);
					jPanel2.setPreferredSize(new java.awt.Dimension(282, 157));
					{
						addcontact = new JTabbedPane();
						jPanel2.add(addcontact);
					}
					{
						jPanel3 = new JPanel();
						jPanel2.add(jPanel3);
						jPanel3.setPreferredSize(new java.awt.Dimension(241, 102));
						{
							newname = new JTextField();
							jPanel3.add(newname);
							newname.setText("Name");
							newname.setPreferredSize(new java.awt.Dimension(238, 38));
							
							newname.addMouseListener(new MouseAdapter(){
								@Override
								public void mouseClicked(MouseEvent e){
									newname.setText("");
									
								}
								
							});
							
						}
						{
							newnumber = new JTextField();
							jPanel3.add(newnumber);
							newnumber.setText("Number");
							newnumber.setPreferredSize(new java.awt.Dimension(238, 38));
						
							newnumber.addMouseListener(new MouseAdapter(){
								@Override
								public void mouseClicked(MouseEvent e){
									newnumber.setText("");
									
								}
								
							});
						
						}
					}
					{
						addnumber = new JButton();
						jPanel2.add(addnumber);
						addnumber.setText("Save");
						addnumber.setPreferredSize(new java.awt.Dimension(95, 30));
						
						addnumber.addActionListener(
								new ActionListener(){
									public void actionPerformed(ActionEvent e)
									{
										String n1 = newname.getText();
										String n2 = newnumber.getText();
										
										
										
									}
								}
							);
						
						
					}
				}
			}
			pack();
			this.setSize(290, 407);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
