package components;
import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel {
	Section container = new Section();
	Title title = new Title("Configuracion");
	public ColorSelector colorSelector = new ColorSelector();
	public OddEvenSelector oddEvenSelector = new OddEvenSelector();
	public SpecificNumberSelector numberSelector = new SpecificNumberSelector(); 
	public BetSelector betSelector = new BetSelector();
	
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
