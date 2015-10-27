package game.math;

public class Collision {
	private Collidable a;
	private Collidable b;
	
	private Vector collisionPoint;
	
	public Collision(Collidable a, Collidable b) {
		this.a = a;
		this.b = b;
		
		this.collisionPoint = calculateCollisionPoint();
	}

	public Collidable getA() {
		return a;
	}

	public void setA(Collidable a) {
		this.a = a;
	}

	public Collidable getB() {
		return b;
	}

	public void setB(Collidable b) {
		this.b = b;
	}
	
	public Vector getCollisionPoint() {		
		return collisionPoint;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Collision between {");
		s.append(a.getObject().getClass().getSimpleName());
		s.append(", " + b.getObject().getClass().getSimpleName());
		s.append("} @ " + collisionPoint.toString());
		return s.toString();
	}
	
	private Vector calculateCollisionPoint() {
		Vector aTob = b.position.minus(a.position);	
		Vector cPoint = aTob.unit();
		
		if (a instanceof CollidableCircle) {
			cPoint = cPoint.times(((CollidableCircle)a).getRadius());
		}
		cPoint = a.position.plus(cPoint);		
		return cPoint;
	}
	
}