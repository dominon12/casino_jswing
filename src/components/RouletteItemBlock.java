package components;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RouletteItemBlock extends JPanel {
	private JLabel label;
	
	public RouletteItemBlock(RouletteItem data) {
		setSize(50, 50);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(data.getColorValue());
		
		label = new JLabel(Integer.toString(data.getValue()));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setForeground(Color.WHITE);
		
		add(label);
	}
}
