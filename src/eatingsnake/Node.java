package eatingsnake;

import java.awt.Color;
import java.awt.Graphics;

public class Node {

	private int x;
	private int y;
	private int size;
	private Node next;
	private Color color;
	@Override
	public boolean equals(Object obj) {
		if (x==((Node)obj).x && y==((Node)obj).y)
			return true;
		return false;
	}
	public Node(int x,int y,int size)
	{
		this.x=x;
		this.y=y;
		this.size=size;
		this.color=new Color((int)(Math.random()*200),(int)(Math.random()*200),(int)(Math.random()*200));
	}
	public Node(Node read) {
		this.x=read.x;
		this.y=read.y;
		this.size=read.size;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getSize()
	{
		return size;
	}
	public Color getColor()
	{
		return color;
	}
	public void setNext(Node next)
	{
		this.next=next;
	}
	public Node getNext()
	{
		return next;
	}
	public void ChangeValue(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void draw(Graphics g)
	{
		g.fillRect(x, y,size,size);
	}
}
