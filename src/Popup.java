import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Popup extends JFrame {
	private Dimension windowDimension = new Dimension(250, 100);
	
	private JLabel label;
	private JButton closeBtn = new JButton("Cerrar");
	
	public Popup(String text) {
		setTitle("Reward info");
		setSize(windowDimension);
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width - windowDimension.width) / 2;
		int y = (screenDimension.height - windowDimension.height) / 2;
		
		setLocation(x, y);
		
		label = new JLabel(text);
		
		add(label, BorderLayout.CENTER);
		
		closeBtn.addActionListener(new ClosePopupActionListener(this));
		add(closeBtn, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	class ClosePopupActionListener implements ActionListener {
		private Popup popup;
		
		public ClosePopupActionListener(Popup popup) {
			this.popup = popup;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			this.popup.setVisible(false);
		}
	}
}
