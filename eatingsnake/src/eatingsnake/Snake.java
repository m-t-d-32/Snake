package eatingsnake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public class Snake {
	private ArrayList<Node> nodes=new ArrayList<Node>();
	private int size;
	public Snake(int size)
	{
		this.size=size;
	}
	public void add(Node node)
	{
		nodes.add(node);
	}
	public Node[] getnode()
	{
		Node[] RetNode=new Node[nodes.size()];
		for (int i=0;i<nodes.size();i++)
		{
			RetNode[i]=nodes.get(i);
		}
		return RetNode;
	}
	public Node getHead()
	{
		return nodes.get(0);
	}
	public Node getTail()
	{
		return nodes.get(nodes.size()-1);
	}
	public void clear(Graphics g,int originX,int originY,int len,int wid)
	{
		g.clearRect(originX, originY, len, wid);
	}
	public void draw(Graphics g)
	{
		for (Node i:nodes)
		{
			g.setColor(i.getColor());
			i.draw(g);
		}
	}
	public void move(String m)
	{
		HashMap<String, Integer> movl=new HashMap<String,Integer>();
		HashMap<String, Integer> movu=new HashMap<String,Integer>();
		movl.put("left", -size);
		movl.put("right", size);
		movl.put("up", 0);
		movl.put("down", 0);
		movu.put("left", 0);
		movu.put("right", 0);
		movu.put("up", -size);
		movu.put("down", size);
		for (int i=nodes.size()-1;i>0;i--)
		{
			nodes.set(i, nodes.get(i-1));
		}
		Node head=new Node(nodes.get(0).getX()+movl.get(m),nodes.get(0).getY()+movu.get(m),size);
		nodes.set(0, head);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class View extends JPanel
{
	Snake snake;
	Food food;
	public View(Snake snake,Food food)
	{
		this.snake=snake;
		this.food=food;
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		snake.draw(g);
		food.draw(g);
	}
}