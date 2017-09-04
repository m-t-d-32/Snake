package eatingsnake;

import java.awt.Color;
import java.awt.Graphics;

public class Food {

	private Node node;
	private int maxX;
	private int maxY;
	private int size;
	@Override
	public boolean equals(Object obj) {
		if (node.equals((Node)obj)==true)
			return true;
		return false;
	}
	public Food(int maxX,int maxY,int size)
	{
		this.size=size;
		this.maxX=maxX-size;
		this.maxY=maxY-size;
	}
	public void draw(Graphics g)
	{
		g.setColor(new Color(144,23,99));
		node.draw(g);
	}
	public void recreate()
	{
		node=new Node(((int)(Math.random()*maxX))/size*size,((int)(Math.random()*maxY))/size*size,size);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
