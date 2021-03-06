package game.core;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.Controls;
import game.components.item.Item;
import game.math.structures.Vector;

public class Player {
	private int playerstatus;//0 not play, 2 play, 1 give up.
	private int playernumber;//0 left, 1 right, 2 top, 3 bottom
	private String name;
	private Paddle paddle;
	private Score score;
	private ArrayList<Item> item;
	private Ball ballholded;
	private char keyhole;
	private boolean keyholepress;
	private char keydecrease;
	private char keyincrease;
	private int keydecreasepress;//the value is 0 or -1
	private int keyincreasepress;//the value is 0 or 1
	private ArrayList<BufferedImage> ballimage;
	private ArrayList<BufferedImage> paddleimage;
	private ArrayList<BufferedImage> ballshadow;
	private char motionAxis; // X is for Top and Bottom Players,  Y is for Side Players
	
	public Player(String name, Paddle paddle,char keydecrease, char keyincrease,char keyhold, char motionAxis) {
		this.ballshadow = new ArrayList<BufferedImage>();
		this.name = name;
		this.paddle = paddle;
		this.item = new ArrayList<Item>();
		this.score = new Score(0,0);
		this.keydecrease=keydecrease;
		this.keyincrease=keyincrease;
		this.keyhole=keyhold;
		this.keyholepress=false;
		this.ballholded=null;
		this.keyincreasepress=0;
		this.keydecreasepress=0;
		this.keyholepress=false;
		this.motionAxis = motionAxis;
		this.paddle = paddle;
		this.ballimage = new ArrayList<BufferedImage>();
		this.paddleimage = new ArrayList<BufferedImage>();
		this.playerstatus=Controls.PLAYER_NOT_PLAY;
	}
	public void setBallShaddow(ArrayList<BufferedImage> image){
		this.ballshadow=image;
	}
	
	public ArrayList<BufferedImage> getBallShaddow(){
		return this.ballshadow;
	}
	public void resetPlayer(){
		
		this.score.reset();
		this.setPlayerstatus(Controls.PLAYER_NOT_PLAY);
		this.ballholded=null;
		this.keyincreasepress=0;
		this.keydecreasepress=0;
		this.keyholepress=false;
		this.resetPaddle();
	}
	
	public void resetkey(){
		if(this.playernumber==0){
			this.keydecrease=Controls.P1_KEY_DECREASE;
			this.keyincrease=Controls.P1_KEY_INCREASE;
			this.keyhole=Controls.P1_KEY_HOLE;
			
		}else if(this.playernumber==1){
			this.keydecrease=Controls.P2_KEY_DECREASE;
			this.keyincrease=Controls.P2_KEY_INCREASE;
			this.keyhole=Controls.P2_KEY_HOLE;
			
		}else if(this.playernumber==2){
			this.keydecrease=Controls.P3_KEY_DECREASE;
			this.keyincrease=Controls.P3_KEY_INCREASE;
			this.keyhole=Controls.P3_KEY_HOLE;
			
		}else if(this.playernumber==3){
			this.keydecrease=Controls.P4_KEY_DECREASE;
			this.keyincrease=Controls.P4_KEY_INCREASE;
			this.keyhole=Controls.P4_KEY_HOLE;
		}
	}
	//getter setter
	
	public int getPlayernumber() {
		return playernumber;
	}

	public Ball getBallholded() {
		return ballholded;
	}

	public void setBallholded(Ball ballholded) {
		this.ballholded = ballholded;
	}

	public void setPlayernumber(int playernumber) {
		this.playernumber = playernumber;
	}

	public char getKeyincrease() {
		return keyincrease;
	}

	public void setKeyincrease(char keyincrease) {
		this.keyincrease = keyincrease;
	}

	public char getKeydecrease() {
		return keydecrease;
	}

	public void setkeydecrease(char keydecrease) {
		this.keydecrease = keydecrease;
	}

	public int getkeydecreasepress() {
		return keydecreasepress;
	}

	public void setkeydecreasepress(int keydecreasepress) {
		this.keydecreasepress = keydecreasepress;
	}

	public int getKeyincreasepress() {
		return keyincreasepress;
	}
	
	public void setKeyincreasepress(int keyincreasepress) {
		this.keyincreasepress = keyincreasepress;
	}
	
	public char getKeyhole() {
		return keyhole;
	}

	public void setKeyhole(char keyhole) {
		this.keyhole = keyhole;
	}

	public boolean isKeyholepress() {
		return keyholepress;
	}

	public void setKeyholepress(boolean keyholepress) {
		this.keyholepress = keyholepress;
		this.paddle.setSticky(keyholepress);
		if(keyholepress==false && this.ballholded!=null){
			this.ballholded.release();
			this.ballholded=null;
			
		}
	}

	public char getMotionAxis() {
		return motionAxis;
	}

	public void setMotionAxis(char axis) {
		this.motionAxis = axis;
	}
	public ArrayList<BufferedImage> getBallimage() {
		return ballimage;
	}

	public void addBallimage(BufferedImage ballimage) {
		this.ballimage.add(ballimage);
	}
	public void setBallimage(ArrayList<BufferedImage> paddleimage){
		this.paddleimage=paddleimage;
	}

	public ArrayList<BufferedImage> getPaddleimage() {
		return paddleimage;
	}

	public void setPaddleimage(ArrayList<BufferedImage> paddleimage) {
		this.paddleimage = paddleimage;
	}
	public void addpaddleimage(BufferedImage paddleimage){
		this.paddleimage.add(paddleimage);
	}
	
	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
	public void increaseScore(){
		this.score.setScore(this.score.getScore()+1);
	}
	public void increaseMiss(){
		this.score.setMiss(this.score.getMiss()+1);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Paddle getPaddle() {
		return paddle;
	}
	public ArrayList<Item> getItem() {
		return item;
	}
	public void addItem(Item i) {
		// TODO Item Validation
		this.item.add(i);
	}
	public int getPlayerStatus() {
		return this.playerstatus;
	}

	public void setPlayerstatus(int playerstatus) {
		this.playerstatus=playerstatus;
		if(playerstatus==Controls.PLAYER_PLAY){
			this.paddle.setLength(Controls.PADDLE_DEFAULT_LENGTH);
		}
		this.playerstatus = playerstatus;
		if(playerstatus==Controls.PLAYER_GIVE_UP || playerstatus== Controls.PLAYER_NOT_PLAY){
			this.paddle.setLength(Controls.PADDLE_MAX_LENGTH);
			this.resetPaddle();
			 

			
		}
	}
	
	public void movePaddle() {
		try {
				paddle.move(motionAxis,this.keydecreasepress+this.keyincreasepress);
			
		} catch (Exception e) {
			System.err.println("fail to movePaddle in player");
		}
	}

	public void enlargePaddle(int amount) /*throws Exception*/ {
		this.paddle.ExpandPaddle(amount);
		
	}

	public void shrinkPaddle(int amount) /*throws Exception*/ {
		this.paddle.ShrinkPaddle(amount);	
	}
	public void IncreasePaddleSpeed(int amount){
		this.paddle.SpeedIncreasement(amount);
	}
	public void DecreasePaddleSpeed(int amount){
		this.paddle.SpeedDecreasement(amount);
	}
	public void resetPaddle() {
		switch (motionAxis) {
		case 'X':
		case 'x':
			this.paddle.setPosition(new Vector(Controls.MODEL_WIDTH/2, paddle.getPosition().cartesian(1)));
			break;
		case 'Y':
		case 'y':
			this.paddle.setPosition(new Vector(paddle.getPosition().cartesian(0), Controls.MODEL_HEIGHT/2));
			break;
		}
		
	}
}
