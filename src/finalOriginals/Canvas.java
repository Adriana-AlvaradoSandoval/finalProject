package finalOriginals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Canvas extends JComponent implements ActionListener, KeyAdaprter {
	// DEFAULT SERIAL NUMBER
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private Timer gameLoopTimer;
	private List<GameObject> gameObjectList;
	private int highlighted = 0; // for picking which object a,b,c,d

	public Canvas() {
		// TASK 1: CREATE A LIST OF CHARACTERS THAT WILL APPEAR ON THE CANVAS
		gameObjectList = new LinkedList<GameObject>();

		// TASK 2: CREATE A WINDOW FOR THE APPLICATION
		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		// TASK 3: CONSTRUCT A TIMER FOR GAME LOOP
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();

		setFocusTraversalKeysEnabled(true);

		this.addKeyListener(listener);

		// TASK 4: MAKE THE WINDOW VISIBLE
		frame.setVisible(true);

	}
	
	public int getHighlighted() {
		return highlighted;
	}

	public synchronized void addGameObject(GameObject sprite) {
		gameObjectList.add(sprite);
	}

	public synchronized void paint(Graphics g) {
		for (GameObject s : gameObjectList) {
			s.draw(this, g);
		}
	}

	// ****************************************************
	// Canvas must implement the inherited abstract method
	// ActionListener.actionPerformed(ActionEvent)
	public synchronized void actionPerformed(ActionEvent e) {
		for (GameObject gameObject : gameObjectList) {
			gameObject.move(this);
			gameObject.setImage();
		}
		repaint();
	}

	// ****************************************************
	// Canvas must implement the inherited abstract methods
	// for KeyListener


	KeyListener listener = new KeyAdapter() {

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_TAB) {
				for(GameObject each: gameObjectList) {
					System.out.println(each.isCont());
				}
				highlighted = highlighted + 1;
				if (highlighted == gameObjectList.size()) {
					highlighted = 0;
				}
				GameObject s = gameObjectList.get(highlighted);
				GameObject l;
				if(highlighted == 0) {
					l = gameObjectList.get(gameObjectList.size() - 1);
					l.setCont(true);
				} else {
					l = gameObjectList.get(highlighted - 1);
					l.setCont(true);
				}
				
				s.setCont(false);
				s.setVelocity(0);
			}
			}
	};

}