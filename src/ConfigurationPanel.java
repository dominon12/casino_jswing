import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel {
	Section container = new Section();
	Title title = new Title("Configuracion");
	ColorSelector colorSelector = new ColorSelector();
	OddEvenSelector oddEvenSelector = new OddEvenSelector();
	SpecificNumberSelector numberSelector = new SpecificNumberSelector(); 
	BetSelector betSelector = new BetSelector();
	
	public ConfigurationPanel() {
		setBounds(50, 50, 50, 50);
		container.add(title);
		container.add(colorSelector);
		container.add(oddEvenSelector);
		container.add(numberSelector);
		container.add(betSelector);
		
		add(container);
		
	}
}
