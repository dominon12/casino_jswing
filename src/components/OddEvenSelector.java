package components;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class OddEvenSelector extends DescriptionItemWithButtons {
	static JButton[] btns = {
		new JButton("Par"),
		new JButton("Impar"),
		new JButton("No seleccionado"),
	};
	static JLabel valueLabelRef;
	
	public OddEvenSelector() {
		super("Par / Impar", "No seleccionado", btns, new OddEvenChangeListener());
		valueLabelRef = this.valueLabel;
	}
	
	static class OddEvenChangeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton eventTarget = (JButton) e.getSource();
			String text = eventTarget.getText();
			valueLabelRef.setText(text);
		}
	}
}
