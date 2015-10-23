package test;

import javax.swing.*;

import game.core.Ball;
import game.math.Vector;

public class BallTester {

	public static void main(String[] args) {
		int t = 0;
		
		// 1 Dimension Collision Course
		Ball ball1 = new Ball(new Vector(5.0), new Vector(-1.0), 1);
		Ball ball2 = new Ball(new Vector(-5.0), new Vector(1.0), 1);
		
		while (!ball1.intersects(ball2) && t++ < 10) {
			ball1.move();
			ball2.move();
		}
		
		if (t < 10 && ball1.intersects(ball2))
			System.out.println("1D Collision Test: passed");
		
		// 2D Movement
		ball1 = new Ball(new Vector(1, 1), new Vector(1, 0), 2);
				
		// Move right 10 times to 11, 1
		for (int i = 0; i < 10; i++)
			ball1.move();
				
		// Move up 10 times to 11, 21
		ball1.setVelocity(new Vector(0, 2));
		for (int i = 0; i < 10; i++)
			ball1.move();
		
		if (ball1.getPosition().distanceTo(new Vector(11, 21)) == 0.0)		
			System.out.println("2D Movement Test: passed");
		
		
		// JFrame Simulation
		BTModel model = new BTModel();
		BTView view = new BTView(model);
		
		BTRepaintController repaintController = new BTRepaintController(model, view);
		
		new Timer(25, repaintController).start();
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 300);
		view.setVisible(true);
		

	}

}