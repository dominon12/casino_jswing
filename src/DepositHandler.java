import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepositHandler extends JPanel {
	private JTextField input = new JTextField();
	private JButton depositBtn = new JButton("Depositar");
	private DescriptionItem saldoPanel;
	private NumberFormat nf = NumberFormat.getInstance();
	
	public DepositHandler(DescriptionItem saldoPanel) {
		setLayout(new GridLayout(1, 2, 10, 10));
		
		depositBtn.addActionListener(new DepositClickHandler());
		this.saldoPanel = saldoPanel;
		
		add(input);
		add(depositBtn);
	}
	
	public int getInputValue() {
		int value = 0;
		String text = input.getText();
		if (!text.isEmpty()) {
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
	
	class DepositClickHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int valueToDeposit = getInputValue();
			
			if (valueToDeposit > 0) {
				int balance = saldoPanel.getValue();
				balance += valueToDeposit;
				saldoPanel.valueLabel.setText(Integer.toString(balance));
				new Popup(valueToDeposit + " se ha depositado correctamente");
			} else {
				new Popup("Introduzca cantidad para ingresar");
			}
		}
		
	}
}







