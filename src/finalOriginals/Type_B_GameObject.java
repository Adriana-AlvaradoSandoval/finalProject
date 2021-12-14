package finalOriginals;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_B_GameObject extends GameObject implements KeyListener {
	// moving in all directions continuously

	public Type_B_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.NONE);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_B_Up.png"));
		imageList.add(new ImageIcon("images/Type_B_Down.png"));
		imageList.add(new ImageIcon("images/Type_B_Left.png"));
		imageList.add(new ImageIcon("images/Type_B_Right.png"));

	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();

		int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasHeight = (int) c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();

		// MOVE BLUE GAME OBJECT
		if (isCont() == true) {
			setImage();

			if (getDirection() == Direction.UP) {
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.RIGHT);
					setImage();
				}
			} else if (getDirection() == Direction.DOWN) {
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.LEFT);
					setImage();
				} 
			} else if (getDirection() == Direction.LEFT) {
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.UP);
					setImage();
				}
			} else {
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.DOWN);
					setImage();
				}
			}

		} else {
		    switch (getDirection()) {
		      case Direction.UP:
		        setY(getY() - getVelocity());
		        if (getY() < 0) {
		          setY(0);
		        }
		        break;
		      case Direction.DOWN:
		        setY(getY() + getVelocity());
		        if (getY() + iconHeight > canvasHeight) {
		          setY((int)(canvasHeight - iconHeight));
		        }
		        break;
		      case Direction.LEFT:
		        setX(getX() + getVelocity());
		        if (getX() + iconWidth > canvasWidth) {
		          setX((int)(canvasWidth - iconWidth));
		        }
		        break;
		      case Direction.RIGHT:
		        setX(getX() - getVelocity());
		        if (getX() < 0) {
		          setX(0);
		        }
		        break;
			default:
				break;
		    }

		}
	}

	// SPECIFY THE IMAGE TO DISPLAY
	// USED FOR ANIMATION
	  public void setImage() {
		    switch (getDirection()) {
		      case Direction.NONE:
		        break;
		      case Direction.DOWN:
		        currentImage = 0;
		        break;
		      case Direction.UP:
		        currentImage = 1;
		        break;
		      case Direction.LEFT:
		        currentImage = 2;
		        break;
		      case Direction.RIGHT:
		        currentImage = 3;
		        break;
		    }
		  }

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_TAB) {
			setDirection(Direction.NONE);
			setVelocity(0);
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			setCont(!isCont());
			if (getVelocity() != 0 && isCont() == false)
				setVelocity(0);
			else
				setVelocity(7);
			setDirection(Direction.NONE);
		} else {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
		      setDirection(Direction.DOWN);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		      setDirection(Direction.UP);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		      setDirection(Direction.LEFT);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		      setDirection(Direction.RIGHT);
		    }
		    
		    setVelocity(7);
		}
	}

}
