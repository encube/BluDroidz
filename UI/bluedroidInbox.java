package bluedroid;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


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
public class bluedroidInbox extends javax.swing.JFrame {
	private JTable messageTable;
	private JPanel jPanel1;
	private JButton send;
	private JScrollPane jScrollPane1;
	private JPanel jPanel2;
	private JTextArea messageBox;
	private JTextField contactNum;
	private JSplitPane jSplitPane1;

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
		
	public bluedroidInbox() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jSplitPane1 = new JSplitPane();
				getContentPane().add(jSplitPane1, BorderLayout.WEST);
				jSplitPane1.setPreferredSize(new java.awt.Dimension(556, 331));
				{
					jPanel1 = new JPanel();
					jSplitPane1.add(jPanel1, JSplitPane.LEFT);
					jPanel1.setPreferredSize(new java.awt.Dimension(288, 329));
					{
						contactNum = new JTextField();
						jPanel1.add(contactNum);
						contactNum.setText("Contact Number");
						contactNum.setPreferredSize(new java.awt.Dimension(252, 35));
					}
					{
						messageBox = new JTextArea();
						jPanel1.add(messageBox);
						messageBox.setText("Type your message");
						messageBox.setPreferredSize(new java.awt.Dimension(249, 239));
					}
					{
						send = new JButton();
						jPanel1.add(send);
						send.setText("Send");
						send.setPreferredSize(new java.awt.Dimension(98, 30));
					}
				}
				{
					jPanel2 = new JPanel();
					jSplitPane1.add(jPanel2, JSplitPane.RIGHT);
					jPanel2.setPreferredSize(new java.awt.Dimension(256, 329));
					{
						jScrollPane1 = new JScrollPane();
						jPanel2.add(jScrollPane1);
						jScrollPane1.setPreferredSize(new java.awt.Dimension(242, 329));
						{
							TableModel jTable1Model = 
									new DefaultTableModel(
											new String[][] { { "One", "Two" }, { "Three", "Four" } },
											new String[] { "Column 1", "Column 2" });
							messageTable = new JTable();
							jScrollPane1.setViewportView(messageTable);
							messageTable.setModel(jTable1Model);
							messageTable.setPreferredSize(new java.awt.Dimension(221, 302));
						}
					}
				}
			}
			pack();
			this.setSize(583, 385);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
