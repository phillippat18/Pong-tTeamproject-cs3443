package game.math;

import java.util.ArrayList;

public abstract class Collidable {
	protected Object obj;
	protected Vector position;
	
	public Collidable(Object object) {
		this.obj = object;
	}
	
	public Object getObject() {
		return obj;
	}
	
	public Vector getPosition() {
		return position;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(obj.getClass().getSimpleName());
		s.append(": Position " + position.toString());
		return s.toString();
	}
	
	public Collision intersects(Collidable object) {		
		if (object == null) {
			System.err.println("Object no Valid");
			return null;
		}
		
		ArrayList<Bound> myB = this.getBounds();
		ArrayList<Bound> otherB = object.getBounds();
		
		if (myB.size() != otherB.size()) {
			System.err.println("Objects of Different Dimensions");
			return null;
		} else {
			for (int i = 0; i < myB.size(); i++) {
				if (!myB.get(i).intersects(otherB.get(i))) 
					return null;
			}
			// If the Method gets to here it means all bounds intersected meaning the 2 objects collided
			return new Collision(this, object);
		}
	}
	public abstract ArrayList<Bound> getBounds();
}