package Game;

import java.awt.Graphics;

public abstract class GameObject {
	//Position for GameObjects 
	protected int x,y;
	//Object Id -> game.id 
	protected id id;
	//Speed in X or Y direction
	protected int velx,vely; //
	
	//Constructor 
	public GameObject(int x, int y, id id) {
		this.x=x;
		this.y=y;
		this.id = id;
	}
	
	public abstract void step();
	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public id getId() {
		return id;
	}

	public void setId(id id) {
		this.id = id;
	}

	public int getVelx() {
		return velx;
	}

	public void setVelx(int velx) {
		this.velx = velx;
	}

	public int getVely() {
		return vely;
	}

	public void setVely(int vely) {
		this.vely = vely;
	}
	
	
}
