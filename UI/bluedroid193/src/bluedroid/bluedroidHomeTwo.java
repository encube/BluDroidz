package bluedroid;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import org.jdesktop.application.Application;
import javax.swing.SwingUtilities;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.GrayFilter;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Painter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class bluedroidHomeTwo extends javax.swing.JFrame {
	private JPanel ButtonsBar;
	private JButton aboutUs;
	private JPanel inboxP;
	private JPanel contactsP;
	private JPanel aboutUsP;
	private JButton settings;
	private JTextField searchConText;
	private JTable contactstableModel;
	private JLabel bluetooth;
	private JToggleButton BluetoothOnOff;
	private JLabel aboutUsLabel;
	private JTable inboxTable;
	private JPanel createmessagePanel;
	private JButton sendBut;
	private JTextArea messageArea;
	private JTextField contactsend;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JSplitPane inboxjSplitPane1;
	private JPanel messageTablePanel;
	private JPanel jPanel4;
	private JButton saveButton;
	private JTextField newnum;
	private JTextField newNameCon;
	private JTabbedPane jTabbedPane1;
	private JPanel jPanel2;
	private JButton searchBut;
	private JButton contacts;
	private JButton inbox;
	private JPanel jPanel3;
	private JPanel settingsP;
	//private String[][] string1 = new String[100][100]; { { "Regina", "1234" }, { "Mae", "56789" },{"arven","12345"} };
	private Object [][] string1 = { {"Regina", "123"}, {"Mae", "678"}, {"Moso", "456"} };
	private String[][] contact;
	private String contactnum;
	private TableRowSorter<TableModel> sorter ;
	private String[] string2 = new String[] { "Name", "Number" };
	//private DefaultTableModel contactsTableModel;
	private String[][] string3 = new String[][] { { "Regina", "asgdhasgdajhgfjagfjaghsja" }, { "Maria", "Your love is my drug" } };
	private String[] string4 = new String[] { "Sender", "Message" };
	
	private boolean value = true;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				
				bluedroidHomeTwo inst = new bluedroidHomeTwo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public bluedroidHomeTwo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		
		
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setPreferredSize(new java.awt.Dimension(642, 419));
			{
				ButtonsBar = new JPanel();
				getContentPane().add(ButtonsBar, BorderLayout.WEST);
				ButtonsBar.setPreferredSize(new java.awt.Dimension(116, 208));
				ButtonsBar.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					inbox = new JButton();
					ButtonsBar.add(inbox);
					inbox.setName("inbox");
					inbox.setPreferredSize(new java.awt.Dimension(89, 43));
					
					inbox.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									//bluedroidInbox bluedroidInbox = new bluedroidInbox();
									//bluedroidInbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									//bluedroidInbox.setVisible(true);
									
									//inbox.setVisible(true);
									//contacts.setVisible(false);
									inboxP.setVisible(true);
									settingsP.setVisible(false);
									contactsP.setVisible(false);
									aboutUsP.setVisible(false);
								}
							}
							);
					
					
				
					
				}
				{
					contacts = new JButton();
					ButtonsBar.add(contacts);
					contacts.setName("contacts");
					contacts.setPreferredSize(new java.awt.Dimension(89, 43));
					
					contacts.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									//bluedroidContacts bluedroidContacts = new bluedroidContacts();
									//bluedroidInbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									//bluedroidContacts.setVisible(true);
									//contacts.setVisible(true);
									//inbox.setVisible(false);
									inboxP.setVisible(false);
									settingsP.setVisible(false);
									contactsP.setVisible(true);
									aboutUsP.setVisible(false);
								}
							}
							);
				}
				{
					settings = new JButton();
					ButtonsBar.add(settings);
					settings.setName("settings");
					settings.setPreferredSize(new java.awt.Dimension(89, 43));
					
					settings.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									//bluedroidSettings bluedroidSettings = new bluedroidSettings();
									//bluedroidInbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									//bluedroidSettings.setVisible(true);
									inboxP.setVisible(false);
									settingsP.setVisible(true);
									contactsP.setVisible(false);
									aboutUsP.setVisible(false);
									
									
								}
							}
							);
				}
				{
					aboutUs = new JButton();
					ButtonsBar.add(aboutUs);
					aboutUs.setName("aboutUs");
					aboutUs.setPreferredSize(new java.awt.Dimension(89, 43));
					
					aboutUs.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									//bluedroidAboutUs bluedroidAboutUs = new bluedroidAboutUs();
									//bluedroidInbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									//bluedroidAboutUs.setVisible(true);
									
																	}
							}
							);
					
				}
			}
			
			
			
			{
				jPanel3 = new JPanel();
				CardLayout jPanel3Layout = new CardLayout();
				jPanel3.setLayout(jPanel3Layout);
				getContentPane().add(jPanel3, BorderLayout.EAST);
				jPanel3.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				jPanel3.setPreferredSize(new java.awt.Dimension(504, 383));
				
				
				
				{
					contactsP = new JPanel();
					FlowLayout contactsPLayout = new FlowLayout();
					contactsP.setLayout(contactsPLayout);
					jPanel3.add(contactsP, "contactsP");
					contactsP.setPreferredSize(new java.awt.Dimension(404, 352));
					contactsP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					contactsP.setBounds(10, 8, 404, 352);
					{
						jTabbedPane1 = new JTabbedPane();
						contactsP.add(jTabbedPane1);
						jTabbedPane1.setPreferredSize(new java.awt.Dimension(342, 173));
						jTabbedPane1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						{
							jPanel2 = new JPanel();
							jTabbedPane1.addTab("Search", null, jPanel2, null);
							jPanel2.setPreferredSize(new java.awt.Dimension(332, 143));
							jPanel2.setName("search");
							{
								searchConText = new JTextField();
								jPanel2.add(searchConText);
								searchConText.setName("searchConText");
								searchConText.setPreferredSize(new java.awt.Dimension(259, 41));
								
								searchConText.addMouseListener(new MouseAdapter(){
									@Override
									public void mouseClicked(MouseEvent e){
										searchConText.setText("");
										
									}
									
								});
								
								
							}
							{
								searchBut = new JButton();
								jPanel2.add(searchBut);
								searchBut.setName("searchBut");
								searchBut.setPreferredSize(new java.awt.Dimension(96, 39));
								
								 searchBut.addActionListener(new ActionListener() {
								        public void actionPerformed(ActionEvent e) {
								          String text = searchConText.getText();
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
							jPanel4 = new JPanel();
							jTabbedPane1.addTab("Add", null, jPanel4, null);
							jPanel4.setPreferredSize(new java.awt.Dimension(299, 125));
							jPanel4.setName("Add");
							{
								newNameCon = new JTextField();
								jPanel4.add(newNameCon);
								newNameCon.setName("newNameCon");
								newNameCon.setPreferredSize(new java.awt.Dimension(261, 40));
								
								newNameCon.addMouseListener(new MouseAdapter(){
									@Override
									public void mouseClicked(MouseEvent e){
										newNameCon.setText("");
										
									}
									
								});
								
							
							}
							{
								newnum = new JTextField();
								jPanel4.add(newnum);
								newnum.setName("newnum");
								newnum.setPreferredSize(new java.awt.Dimension(256, 40));
								
								newnum.addMouseListener(new MouseAdapter(){
									@Override
									public void mouseClicked(MouseEvent e){
										newnum.setText("");
										
									}
									
								});
								
								
							}
							{
								saveButton = new JButton();
								jPanel4.add(saveButton);
								saveButton.setName("saveButton");
								saveButton.setPreferredSize(new java.awt.Dimension(85, 36));
								
								saveButton.addActionListener(
										new ActionListener(){
											public void actionPerformed(ActionEvent e)
											{
												//bluedroidAboutUs bluedroidAboutUs = new bluedroidAboutUs();
												//bluedroidInbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
												//bluedroidAboutUs.setVisible(true);
												//System.out.print("clicked");
												
												
												              
												
												
												
												
												
											
											}
											
										
										}
										);
							}
						}
					}
					{
						jScrollPane1 = new JScrollPane();
						contactsP.add(jScrollPane1);
						jScrollPane1.setPreferredSize(new java.awt.Dimension(362, 161));
						{
							//contactsTableModel = 
								//	new DefaultTableModel(string1,string2);
							//contactsTable = new JTable(contactsTableModel);
							
							//contactsTable = new JTable(contactsTableModel);
							//sorter= new TableRowSorter<TableModel>(contactsTableModel);
							//contactsTable.setRowSorter(sorter);	
						
						
							//Object rows[][] = { {"Regina", "123"}, {"Mae", "678"}, {"Moso", "456"}  };
							//String columns[] = { "Name", "Number" };
							
							TableModel contactstableModel = new DefaultTableModel(string1, string2) {
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
							contactstable.setPreferredSize(new java.awt.Dimension(341, 159));
							//contactstable.setName("contactstable");
							
						}
					}
				}
				/////
				
				
				
				
				
				
				
				
				{
					inboxP = new JPanel();
					FlowLayout inboxPLayout = new FlowLayout();
					jPanel3.add(inboxP, "inboxP");
					inboxP.setPreferredSize(new java.awt.Dimension(407, 348));
					inboxP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					inboxP.setName("Inbox");
					inboxP.setVisible(value);
					inboxP.setBounds(9, 365, 407, 348);
					inboxP.setLayout(inboxPLayout);
					{
						inboxjSplitPane1 = new JSplitPane();
						inboxP.add(inboxjSplitPane1);
						inboxjSplitPane1.setPreferredSize(new java.awt.Dimension(465, 354));
						{
							createmessagePanel = new JPanel();
							inboxjSplitPane1.add(createmessagePanel, JSplitPane.LEFT);
							createmessagePanel.setPreferredSize(new java.awt.Dimension(217, 352));
							{
								contactsend = new JTextField();
								createmessagePanel.add(contactsend);
								contactsend.setName("Contact Number");
								contactsend.setPreferredSize(new java.awt.Dimension(197, 36));
								
								contactsend.addMouseListener(new MouseAdapter(){
									@Override
									public void mouseClicked(MouseEvent e){
										contactsend.setText("");
										
									}
									
								});
								
							}
							{
								messageArea = new JTextArea();
								createmessagePanel.add(messageArea);
								messageArea.setName("Type your message");
								messageArea.setPreferredSize(new java.awt.Dimension(197, 252));
								String a = messageArea.getText();
								
								messageArea.addMouseListener(new MouseAdapter(){
									@Override
									public void mouseClicked(MouseEvent e){
										messageArea.setText("");
										
									}
									
								});
								
								
							}
							{
								sendBut = new JButton();
								createmessagePanel.add(sendBut);
								sendBut.setName("Send");
								sendBut.setPreferredSize(new java.awt.Dimension(107, 34));
								
								sendBut.addActionListener(
										new ActionListener(){
											public void actionPerformed(ActionEvent e)
											{
												//bluedroidAboutUs bluedroidAboutUs = new bluedroidAboutUs();
												//bluedroidInbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
												//bluedroidAboutUs.setVisible(true);
												
												
											}
										}
										);
							}
							
							
						}
						{
							messageTablePanel = new JPanel();
							FlowLayout jPanel6Layout = new FlowLayout();
							messageTablePanel.setLayout(jPanel6Layout);
							inboxjSplitPane1.add(messageTablePanel, JSplitPane.RIGHT);
							messageTablePanel.setPreferredSize(new java.awt.Dimension(229, 352));
							{
								jScrollPane2 = new JScrollPane();
								messageTablePanel.add(jScrollPane2);
								jScrollPane2.setPreferredSize(new java.awt.Dimension(205, 276));
								{
									TableModel jTable1Model = 
											new DefaultTableModel(
													string3,
													string4);
									inboxTable = new JTable();
									jScrollPane2.setViewportView(inboxTable);
									inboxTable.setModel(jTable1Model);
									inboxTable.setPreferredSize(new java.awt.Dimension(184, 262));
								}
							}
						}
					}

				}
				{
					settingsP = new JPanel();
					jPanel3.add(settingsP, "settingsP");
					settingsP.setPreferredSize(new java.awt.Dimension(405, 348));
					settingsP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					settingsP.setBounds(10, 718, 405, 348);
				}
				{
					aboutUsP = new JPanel();
					jPanel3.add(aboutUsP, "aboutUsP");
					aboutUsP.setPreferredSize(new java.awt.Dimension(405, 350));
					aboutUsP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					aboutUsP.setName("aboutUsP");
					aboutUsP.setBounds(10, 1071, 405, 350);
				}
			}
			pack();
			this.setSize(642, 419);
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		
			inboxP.setVisible(true);
			settingsP.setVisible(false);
			{
				bluetooth = new JLabel();
				settingsP.add(bluetooth);
				bluetooth.setName("bluetooth");
				bluetooth.setPreferredSize(new java.awt.Dimension(72, 30));
				bluetooth.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			}
			{
				BluetoothOnOff = new JToggleButton();
				settingsP.add(BluetoothOnOff);
				BluetoothOnOff.setName("BluetoothOnOff");
				BluetoothOnOff.setPreferredSize(new java.awt.Dimension(83, 42));
			}
			contactsP.setVisible(false);
			aboutUsP.setVisible(false);
			{
				aboutUsLabel = new JLabel();
				aboutUsP.add(aboutUsLabel);
				aboutUsLabel.setName("aboutUsLabel");
				aboutUsLabel.setPreferredSize(new java.awt.Dimension(235, 117));
			}

		} 
			catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
