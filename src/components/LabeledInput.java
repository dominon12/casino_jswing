package components;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabeledInput extends JPanel {
	JLabel titleLabel;
	JTextField textField;
	
	public LabeledInput(String title, String value) {
		titleLabel = new JLabel(title);
		textField = new JTextField(value);
	
		add(titleLabel);
		add(textField);
	}
}
