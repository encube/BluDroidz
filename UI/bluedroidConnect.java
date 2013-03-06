package bluedroid;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


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
public class bluedroidConnect extends javax.swing.JInternalFrame {
	private JButton jButton1;
	private JTextField jTextField1;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this 
	* JInternalFrame inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		bluedroidConnect inst = new bluedroidConnect();
		JDesktopPane jdp = new JDesktopPane();
		jdp.add(inst);
		jdp.setPreferredSize(inst.getPreferredSize());
		frame.setContentPane(jdp);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public bluedroidConnect() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(350, 202));
			this.setBounds(0, 0, 350, 202);
			setVisible(true);
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, BorderLayout.SOUTH);
				jButton1.setText("jButton1");
				jButton1.setPreferredSize(new java.awt.Dimension(388, 48));
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1, BorderLayout.CENTER);
				jTextField1.setText("jTextField1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
