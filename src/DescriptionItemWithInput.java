import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JTextField;

public class DescriptionItemWithInput extends DescriptionItem {
	private JTextField input;
	private NumberFormat nf = NumberFormat.getInstance();
	
	public DescriptionItemWithInput(String title, String initialValue) {
		super(title, null);
		input = new JTextField(initialValue);
		add(input);
	}
	
	public int getInputValue() {
		int value = -1;
		String text = input.getText();
		if (!text.isEmpty()) {
			Number n = null;
			try {
				n = (Number) nf.parse(text);
				value = n.intValue();
			} catch (ParseException ex) {
				value = -1;
			}
		}
		return value;
	}
}
