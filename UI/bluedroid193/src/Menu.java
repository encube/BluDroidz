import javax.swing.*;
import java.awt.event.*;
public class Menu extends JFrame{
	public Menu()
	{
		super("BlueDroid");
		
		JMenu file = new JMenu("Menu");
		file.setMnemonic('M');
		JMenuItem connect = new JMenuItem("Connect");
		connect.setMnemonic('C');
		file.add(connect);
		JMenuItem contacts = new JMenuItem("Contacts");
		contacts.setMnemonic('O');
		file.add(contacts);	
		JMenuItem inbox = new JMenuItem("Inbox");
		inbox.setMnemonic('I');
		file.add(inbox);
		
		//adding action listener to menu items
		connect.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("New is pressed");
				}
			}
		);
		contacts.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Open is pressed");
				}
			}
		);
		inbox.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Exit is pressed");
				}
			}
		);						
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(file);
		
		getContentPane();
		setSize(200, 200);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Menu app = new Menu();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}