package MVC.view.menu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;

public class PauseMenu extends JPanel {
	
	private JButton button;
	private vbhitController control;
	public PauseMenu(vbhitController control){
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(4,0,10,10));
		this.control=control;
		//this.setBorder(BorderFactory.createEtchedBorder(Color.green, Color.blue));
		
		// 1st button, 1st item
		button = new JButton("Full Screen");
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		//button.setBorderPainted(false);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(this.control);
		button.setFocusable(false);
		this.add(button);
		
		// 2nd button, 2nd item
		button = new JButton("Main Menu");
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		//button.setBorderPainted(false);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(this.control);
		button.setFocusable(false);
		this.add(button);
		
		// 3rd button, 3rd item
		button = new JButton("Resume");
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		//button.setBorderPainted(false);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(this.control);
		button.setFocusable(false);
		this.add(button);
		
		// 4th button, 4th item
		button = new JButton("Quit");
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		//button.setBorderPainted(false);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(this.control);
		button.setFocusable(false);
		this.add(button);
	}
}
