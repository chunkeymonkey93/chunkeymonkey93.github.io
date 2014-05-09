package com.example.model;

public class NodeLocation {

	public int SID;
	public int x;
	public int y;
	
	public NodeLocation(int sID, int X, int Y) {
		SID = sID;
		x = X;
		y = Y;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

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
	
}