package components;
import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Header extends JPanel {
	public StatsPanel stats = new StatsPanel();
	public ConfigurationPanel configuration = new ConfigurationPanel();
	
	public Header() {
		add(stats, BorderLayout.WEST);
		add(configuration, BorderLayout.EAST);
	}
}
