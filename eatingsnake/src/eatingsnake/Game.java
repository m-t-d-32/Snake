package eatingsnake;


import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Game {

	private final int maxX=800,maxY=600,size=20;
	private Food food=new Food(maxX,maxY-2*size,size);
	private Snake snake=new Snake(size);
	private JFrame frame=new JFrame();
	private View view=new View(snake,food);
	private String lasttime="up";
	private int score=0;
	private HashMap<Integer, String> key=new HashMap<Integer,String>();
	private HashMap<String,String> checklast=new HashMap<String, String>();
	public Game()
	{
		key.put(KeyEvent.VK_UP, "up");
		key.put(KeyEvent.VK_DOWN, "down");
		key.put(KeyEvent.VK_LEFT, "left");
		key.put(KeyEvent.VK_RIGHT, "right");
		checklast.put("up", "down");
		checklast.put("down", "up");
		checklast.put("left", "right");
		checklast.put("right", "left");
		Node node1=new Node((int)(Math.random()*160)/20*20,(int)(Math.random()*160)/20*20,size);
		Node node2=new Node(node1.getX()+20,node1.getY(),size);
		Node node3=new Node(node1.getX(),node1.getY()+20,size);
		Node node4=new Node(node1.getX()+20,node1.getY()+20,size);
		snake.add(node1);
		snake.add(node2);
		snake.add(node3);
		snake.add(node4);
		createFood();
		frame.setTitle("Ã∞≥‘…ﬂ");
		frame.setBounds(400,100, maxX,maxY);
		frame.add(view);
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {

			}
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (checklast.get(key.get(e.getExtendedKeyCode()))!=lasttime && key.get(e.getExtendedKeyCode())!=lasttime)
				{
					doMove(key.get(e.getExtendedKeyCode()));
					lasttime=key.get(e.getExtendedKeyCode());
				}
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public void createFood()
	{
		while (true)
		{
			food.recreate();
			Node []testsnake=snake.getnode();
			for (Node i:testsnake)
			{
				if (food.equals(i))
					continue;
			}
			frame.repaint();
			break;
		}
	}
	public boolean JudgeEatFood()
	{
		Node i=snake.getHead();
		if (food.equals(i))
		{
			score++;
			return true;
		}			
		else
			return false;
	}
	public void doMove(String as)
	{
		Node addnode=new Node(snake.getTail());
		snake.move(as);
		if (JudgeEatFood()==true)
		{	
			snake.add(addnode);
			createFood();
		}
		frame.repaint();
	}
	public void play() throws InterruptedException
	{
		while (true)
		{
			Thread.sleep(200);
			doMove(lasttime);
			if (judgedie())
			{
				JLabel lbl=new JLabel("<html>Game Over<br><br><br>You Got "+score+" Scores<html>", null, SwingConstants.CENTER);  				
				lbl.setFont(new Font("ÀŒÃÂ",Font.PLAIN, 50));
				lbl.setBounds(400,100, maxX,maxY);
				frame.remove(view);
				frame.add(lbl);
				frame.repaint();
				frame.setVisible(true);
				Thread.sleep(3000);
				System.exit(0);
			}
		}
	}
	public boolean judgedie()
	{
		Node []nodes=snake.getnode();
		for (int i=1;i<nodes.length;i++)
		{
			if (nodes[i].equals(nodes[0])==true)
				return true;
		}
		for (Node it:nodes)
		{
			if (it.getX()<0 || it.getY()<0 || it.getX()>=maxX || it.getY()>=maxY-2*size)
				return true;
		}
		return false;
	}
	public static void main(String[] args) throws InterruptedException
	{
		Game game=new Game();
		game.play();
	}

}
