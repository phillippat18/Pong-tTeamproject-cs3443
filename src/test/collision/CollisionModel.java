package test.collision;

import java.util.ArrayList;

import game.core.Ball;
import game.math.*;

public class CollisionModel {
	private ArrayList<Ball> balls;
	
	// Panel Properties
	private int width, height;
	
	//private ArrayList<Collision> collisions;
	
	public CollisionModel() {
		// Environment Setup
		width = 0;
		height = 0;
		
		//collisions = new ArrayList<Collision>();
		balls = new ArrayList<Ball>();
		int radius = 10;
		int tolerance = 1;
		
		int redux = 2*(radius+tolerance);
		int ofst = radius + tolerance;
		
		for (int i = 0; i < 20; i++) {
			balls.add(new Ball(Vector.getRand(new int[]{1000-redux, ofst}, new int[]{800-redux, ofst}), Vector.getRand(10,10), radius));
		}
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void moveBalls() {
		if (height == 0) return;
		int posX, posY, radius;
		
		Collision collision;
		
		for (Ball b : balls) {
			b.move();
			
			posX = (int)b.getPosition().cartesian(0);
			posY = (int)b.getPosition().cartesian(1);
			radius = b.getRadius();
			
			// Check boundries
			// Checking X
			if (posX > width - radius || posX < radius) {
				b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
				//System.out.println("Pos: " + b.getPosition().toString() + " V: " + b.getVelocity().toString());
			}
			// Checking Y
			if (posY > height - radius || posY < radius) {
				b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
				//System.out.println("Pos: " + b.getPosition().toString() + " V: " + b.getVelocity().toString());
			}
			
			/*
			 * Checking for Collisions
			 */
			CollisionDetector.checkCollisions(this);
			
//			for (Ball c : balls) {
//				if (b.equals(c)) continue;
//				if (b.intersects(c)) {
//					// TODO Collision Detected
//					collision = new Collision(new CollidableCircle(b), new CollidableCircle(c));
//					System.out.println(b.getPosition().toString() + ":" + c.getPosition().toString() + "@" + collision.getCollisionPoint().toString());
//				}
//			}
			
			
		}
		
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

}
