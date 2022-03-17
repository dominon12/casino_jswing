import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Section extends JPanel {
	
	
	public Section() {
		setLayout(new GridLayout(0, 1));
		setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	}
}
