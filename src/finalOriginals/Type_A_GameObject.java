package finalOriginals;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject implements KeyListener {
	// A moves up and down

	public Type_A_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.NONE);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
		
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();

		int iconHeight = icon.getIconHeight();
		int canvasHeight = (int) c.getSize().getHeight();

		// MOVE BLUE GAME OBJECT
		if (isCont() == true) {
			setImage();

			if (getDirection() == Direction.UP) {
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.DOWN);
					setImage();
				}
			} else {
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.UP);
					setImage();
				}
			}
		} else {
			switch (getDirection()) {
			case Direction.UP:
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
				}
				break;
			case Direction.DOWN:
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
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
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() != KeyEvent.VK_TAB) {
			setDirection(Direction.NONE);
		}
	}

	public void keyPressed(KeyEvent e) {
		if (isCont() == false) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.UP);
				setVelocity(7);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.DOWN);
				setVelocity(7);
			}

		} else {
			setVelocity(7);
			setDirection(Direction.DOWN);
		}
	}
}
