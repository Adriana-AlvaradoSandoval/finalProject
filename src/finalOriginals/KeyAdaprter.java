package finalOriginals;

import java.awt.event.KeyEvent;

public interface KeyAdaprter {

	public default void keyTyped(KeyEvent e) {}
	public default void keyPressed(KeyEvent e) {}
	public default void keyReleased(KeyEvent e) {}
}
