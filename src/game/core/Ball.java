package game.core;

import java.awt.image.BufferedImage;

import game.Controls;
import game.math.structures.Vector;

public class Ball {
	// --- Ball Mechanics ---
	private Vector position;
	private Vector velocity;
	private final int radius;
	private boolean collided;
	private BufferedImage image;
	
	// --- Game Metrics ---
	private Player lastHit;
	
	// Constructor
	public Ball(Vector position, Vector velocity, int radius) {
		this.position = position;
		this.velocity = velocity;
		this.radius = radius;
		this.collided = false;
	}
	
	// Setters and Getters
	public Vector getPosition(){
		return position;
	}
	
	public Vector getVelocity() {
		return this.velocity;
	}
	
	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public void setCollided() {
		this.collided = true;
	}
	
	public boolean collided() {
		return this.collided;
	}
	
	public Player getLastHit() {
		return this.lastHit;
	}
	
	public void setLastHit(Player player) {
		this.lastHit = player;
	}
	public void move() {
		if (!collided)
			position = position.plus(velocity);
		collided = false;
	}
	

	public void setPosition(Vector position) {
		this.position = position;
	}
	
	public boolean intersects(Ball ball) {
		return ((double)position.distanceTo(ball.getPosition()) < (double)(radius + ball.getRadius()));
	}
	public void setimage(BufferedImage image){
		this.image=image;
	}
	public BufferedImage getimage(){
		return this.image;
	}
	//increase in percent
	public void IncreaseSpeed(double speedup){
		if(this.velocity.magnitude()<Controls.BALL_MAX_SPEED){
			this.velocity.PercentAdjust(1+speedup);
			//System.out.print(this.velocity.toString());
		}
	}
	//decrease in percent
	public void DecreaseSpeed(double slowdown){
		if(this.velocity.magnitude()>Controls.BALL_MIN_SPEED){
			this.velocity.PercentAdjust(1-slowdown);
		}
	}
	
	
	public Ball clone(){
		Ball b = new Ball(new Vector(this.getPosition().getData().clone()),
				Vector.getRand(new int[]{Controls.BALL_MAX_SPEED, -Controls.BALL_MIN_SPEED}, 
						   new int[]{Controls.BALL_MAX_SPEED, -Controls.BALL_MIN_SPEED}),Controls.BALL_DEFAULT_RADIUS);
		return b;
	}
	
	// Information Methods
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("{");		
		s.append("Position: " + position.toString());
		s.append(" Speed: " + velocity.magnitude());
		s.append(" Direction Vector: " + velocity.unit().toString());
		s.append(" Velocity Vector: " + velocity.toString());
		s.append("}");
		return s.toString();
	}
	
	
}
