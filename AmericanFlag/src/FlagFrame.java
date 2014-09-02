import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ComponentEvent;

import javax.swing.*;

public class FlagFrame extends JFrame {
	
	//Sets the basic features of the JFrame adds FlagPanel
	public FlagFrame() {
		FlagPanel content = new FlagPanel();

		this.add(content);
		
		this.setBackground(Color.WHITE);
		repaint();
		content.repaint();
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}