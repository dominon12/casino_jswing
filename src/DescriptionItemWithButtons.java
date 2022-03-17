import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DescriptionItemWithButtons extends DescriptionItem {
	public DescriptionItemWithButtons(String title, String value, JButton[] btns, ActionListener clickListener) {
		super(title, value);
		
		for (JButton btn : btns) {
			btn.addActionListener(clickListener);
			add(btn);
		}
	}
	
	public String getSelectedValue() {
		return this.valueLabel.getText();
	}
}
