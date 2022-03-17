import java.awt.Font;

import javax.swing.JLabel;

public class Title extends JLabel {
	public Title(String text) {
		setText(text);
		setFont(new Font("serif", Font.BOLD, 25));
	}
}
