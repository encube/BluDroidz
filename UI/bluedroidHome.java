package bluedroid;

import javax.swing.*;

import java.awt.event.*;
import bluedroid.bluedroidContacts;


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
public class bluedroidHome extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuBar jMenuBar1;
	private JMenu help;
	private JMenuItem setting;
	private JMenuItem inbox;
	private JMenuItem contact;
	private JMenuItem connects;
	private JMenu menu;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		});
	}
	
	public bluedroidHome() {
		super();
		initGUI();
		
		
	}
	
	private void initGUI() {
		try {
			this.setSize(310, 285);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					menu = new JMenu();
					jMenuBar1.add(menu);
					menu.setText("Menu");
					menu.setFont(new java.awt.Font("Arial",1,16));
					{
						connects = new JMenuItem();
						menu.add(connects);
						connects.setText("Connect");
						connects.setFont(new java.awt.Font("Arial",0,14));
						
						//adding action listener to menu items
						connects.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									test test = new test();
									//bluedroidContacts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									test.setVisible(true);
								}
							}
						);
						
						
					}
					{
						contact = new JMenuItem();
						menu.add(contact);
						contact.setText("Contacts");
						
						//adding action listener to menu items
						contact.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									bluedroidContacts bluedroidContacts = new bluedroidContacts();
									//bluedroidContacts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									bluedroidContacts.setVisible(true);
									
									
								}
							}
						);
						
						
					}
					{
						inbox = new JMenuItem();
						menu.add(inbox);
						inbox.setText("Inbox");
						
						
						//adding action listener to menu items
						inbox.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									bluedroidInbox bluedroidInbox = new bluedroidInbox();
									//bluedroidInbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									bluedroidInbox.setVisible(true);
								}
							}
						);
						
						
						
					}
				}
				{
					help = new JMenu();
					jMenuBar1.add(help);
					help.setText("Help");
					help.setFont(new java.awt.Font("Arial",1,16));
					{
						setting = new JMenuItem();
						help.add(setting);
						setting.setText("Settings");
						setting.setFont(new java.awt.Font("Arial",0,14));
						
						//adding action listener to menu items
						setting.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									bluedroidSettings bluedroidSettings = new bluedroidSettings();
									//bluedroidInbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									bluedroidSettings.setVisible(true);
								}
							}
						);
						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
