package MVC.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;
import MVC.vbhitModel;
import MVC.player.KeyMap;

public class LeftPanel extends JPanel{
	private BufferedImage image;
	private PlayerPanel playertop, playerbottom;
	private KeyMap	player1,player4;
	private vbhitController controller;
	public LeftPanel(vbhitController controller){
		this.controller=controller;
		this.setLayout(new GridLayout(2,0,10,10));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		try {
			image= ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\leftblackhole.jpg"));
		} catch (IOException e) {
			System.err.println("leftpanel image input fail");
		}
		playertop=new PlayerPanel(this.controller.getModel().getPlayer(0));
		playerbottom=new PlayerPanel(this.controller.getModel().getPlayer(3));
		player1 = new KeyMap(playertop.getPlayer());
		player4= new KeyMap (playerbottom.getPlayer());
		
		/*this.add(player[0]);
		this.add(player[1]);*/
		/*this.add(keymap[0]);
		this.add(keymap[1]);*/
		
	}
	public void update(){
		playertop.update();
		playerbottom.update();
	}
	
	public void showPlayer(){
		this.remove(player1);
		this.remove(player4);
		this.add(playertop);
		this.add(playerbottom);
	}
	
	public void showPlayerkey(){
		this.remove(playertop);
		this.remove(playerbottom);
		this.add(player1);
		this.add(player4);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, -200,0,null);
	}
	

}
