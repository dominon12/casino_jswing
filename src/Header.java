import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Header extends JPanel {
	StatsPanel stats = new StatsPanel();
	ConfigurationPanel configuration = new ConfigurationPanel();
	
	public Header() {
//		setLayout(new GridLayout(1, 2));

		add(stats, BorderLayout.WEST);
		add(configuration, BorderLayout.EAST);
	}
}
