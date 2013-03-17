package bluedroid;

import javax.swing.*;
import java.awt.*;

public class BackgroundSample {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Background Example");
    final ImageIcon imageIcon = new ImageIcon("src/bluedroid/background.png");
    JTextArea textArea = new JTextArea() {
      Image image = imageIcon.getImage();
      Image grayImage = GrayFilter.createDisabledImage(image);
      {setOpaque(false);}  // instance initializer
      public void paintComponent (Graphics g) {
        g.drawImage(grayImage, 0, 0, this);
        super.paintComponent(g);
      }
    };
    JScrollPane scrollPane = new JScrollPane(textArea);
    Container content = frame.getContentPane();
    content.add(scrollPane, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(3);
    frame.setSize(250, 250);
    frame.setVisible(true);
  }
}