package bluedroid;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import org.jdesktop.application.Application;
import javax.swing.ImageIcon;

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
public class bluedroidHome extends javax.swing.JApplet {
	private JButton connect;
	private JPanel jPanel1;
	private JButton settings;
	private JButton inbox;
	private JButton contacts;

	/**
	* Auto-generated main method to display this 
	* JApplet inside a new JFrame.
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				bluedroidHome inst = new bluedroidHome();
				frame.getContentPane().add(inst);
				((JComponent)frame.getContentPane()).setPreferredSize(inst.getSize());
				frame.pack();
				frame.setVisible(true);
			}
		});

	}
	
	public bluedroidHome() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setSize(247, 228);
			this.setName("BlueDroid");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setPreferredSize(new java.awt.Dimension(232, 233));
				{
					ImageIcon connectImage = new ImageIcon("src/bluedroid/Connect.jpg");
					connect = new JButton(connectImage);
					jPanel1.add(connect);
					connect.setPreferredSize(new java.awt.Dimension(103, 103));
					connect.setBorderPainted(false);
					connect.setFocusPainted(false);
					//connect.setContentAreaFilled(false);
				
				}
				{
					ImageIcon contactsImage = new ImageIcon("src/bluedroid/contacts2.png");
					contacts = new JButton(contactsImage);
					jPanel1.add(contacts);
					contacts.setPreferredSize(new java.awt.Dimension(100, 100));
					contacts.setBorderPainted(false);
					contacts.setFocusPainted(false);
					//contacts.setContentAreaFilled(false);
					contacts.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									bluedroidContacts bluedroidContacts = new bluedroidContacts();
									//bluedroidInbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									bluedroidContacts.setVisible(true);
									
								}
							}
						);

					
				}
				{
					ImageIcon inboxImage = new ImageIcon("src/bluedroid/inbox.png");
					inbox = new JButton(inboxImage);
					jPanel1.add(inbox);
					inbox.setSize(100, 100);
					inbox.setPreferredSize(new java.awt.Dimension(100, 100));
					inbox.setBorderPainted(false);
					inbox.setFocusPainted(false);
					//inbox.setContentAreaFilled(false);
				
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
				{
					ImageIcon settingsImage = new ImageIcon("src/bluedroid/settings.png");
					settings = new JButton(settingsImage);
					jPanel1.add(settings);
					settings.setSize(100, 100);
					settings.setPreferredSize(new java.awt.Dimension(100, 100));
					settings.setBorderPainted(false);
					settings.setFocusPainted(false);
					//settings.setContentAreaFilled(false);
				}
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
