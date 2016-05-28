import java.awt.event.*;

public class InputHandler implements KeyListener {

	public InputHandler(PongAlpha pa) {
		pa.addKeyListener(this);
	}

	//if key is pressed and HELD
	public void keyPressed( KeyEvent ke ) {
		int keyCode = ke.getKeyCode();

		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			PongAlpha.player.up = true;
		} else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			PongAlpha.player.down = true;
		}
	}

	//if key is pressed and RELEASED
	public void keyReleased( KeyEvent ke ) {
		int keyCode = ke.getKeyCode();

		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			PongAlpha.player.up = false;
		} else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			PongAlpha.player.down = false;
		}
	}

	public void keyTyped( KeyEvent ke ) {

	}
}
