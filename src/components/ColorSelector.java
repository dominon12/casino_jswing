package components;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ColorSelector extends DescriptionItemWithButtons {
	static JButton[] btns = {
		new JButton("Rojo"),
		new JButton("Verde"),
		new JButton("Negro")
	};
	static JLabel valueLabelRef;
	
	public ColorSelector() {
		super("Color seleccionado:", "Rojo", btns, new ColorChangeListener());
		valueLabelRef = this.valueLabel;
	}
	
	static class ColorChangeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton eventTarget = (JButton) e.getSource();
			String text = eventTarget.getText();
			valueLabelRef.setText(text);
		}
	}
}
