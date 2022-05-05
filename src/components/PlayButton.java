package components;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PlayButton extends JButton {
	public PlayButton(ActionListener clickHandler) {
		setText("Jugar");
		addActionListener(clickHandler);
	}
	
	
}
