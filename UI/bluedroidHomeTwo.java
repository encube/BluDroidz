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
import javax.swing.JTextArea;
import javax.swing.Painter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

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
	private JPanel jPanel1;
	private JButton aboutUs;
	private JButton settings;
	private JButton contacts;
	private JButton inbox;
	private JPanel jPanel3;
	private JPanel jPanel2;

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
			this.setPreferredSize(new java.awt.Dimension(564, 398));
			{
				jPanel3 = new JPanel();
				AnchorLayout jPanel3Layout = new AnchorLayout();
				jPanel3.setLayout(jPanel3Layout);
				getContentPane().add(jPanel3, BorderLayout.CENTER);
				jPanel3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				{
					jPanel1 = new JPanel();
					jPanel3.add(jPanel1, new AnchorConstraint(106, 231, 667, 22, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jPanel1.setPreferredSize(new java.awt.Dimension(116, 208));
					jPanel1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					{
						inbox = new JButton();
						jPanel1.add(inbox);
						inbox.setName("inbox");
						inbox.setPreferredSize(new java.awt.Dimension(89, 43));
					}
					{
						contacts = new JButton();
						jPanel1.add(contacts);
						contacts.setName("contacts");
						contacts.setPreferredSize(new java.awt.Dimension(89, 43));
					}
					{
						settings = new JButton();
						jPanel1.add(settings);
						settings.setName("settings");
						settings.setPreferredSize(new java.awt.Dimension(89, 43));
					}
					{
						aboutUs = new JButton();
						jPanel1.add(aboutUs);
						aboutUs.setName("aboutUs");
						aboutUs.setPreferredSize(new java.awt.Dimension(89, 43));
					}
				}
				{
					jPanel2 = new JPanel();
					jPanel3.add(jPanel2, new AnchorConstraint(36, 990, 985, 252, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jPanel2.setPreferredSize(new java.awt.Dimension(410, 352));
					jPanel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					jPanel2.setName("jPanel2");
				}
			}
			pack();
			this.setSize(564, 398);
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		
			
		
		} 
			catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
