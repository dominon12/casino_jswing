import java.awt.GridLayout;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DescriptionItem extends JPanel {
	private JLabel titleLabel;
	protected JLabel valueLabel;
	private NumberFormat nf = NumberFormat.getInstance();
	
	public DescriptionItem(String title, String value) {
		setLayout(new GridLayout(1, 0, 10, 10));
		titleLabel = new JLabel(title);
		valueLabel = new JLabel(value);
		
		add(titleLabel);
		add(valueLabel);
	}
	
	public void setValue(String value) {
		this.valueLabel.setText(value);
	}
	
	public int getValue() {
		int value = 0;
		String text = valueLabel.getText();
		if (text != null) {
			Number n = null;
			try {
				n = (Number) nf.parse(text);
				value = n.intValue();
			} catch (ParseException ex) {
				value = 0;
			}
		}
		return value;
	}
}
