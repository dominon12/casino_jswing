package windows;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import components.Popup;


public class Login extends JFrame {
	Dimension windowDimension = new Dimension(300, 150);
	GridLayout layout = new GridLayout(0, 1);
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Indica su nombre");
	JTextField input = new JTextField();
	JButton loginBtn = new JButton("Entrar");
	
	public Login() {
		setTitle("Roulette Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width - windowDimension.width) / 2;
		int y = (screenDimension.height - windowDimension.height) / 2;
		
		setLocation(x, y);
		setSize(windowDimension);
		setResizable(false);
		
		loginBtn.addActionListener(new LoginClickHandler());
		
		panel.setLayout(layout);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		panel.add(label);
		panel.add(input);
		panel.add(loginBtn);
		add(panel);
		
		setVisible(true);
	}
	
	class LoginClickHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = input.getText();
			
			if (name.isEmpty()) {
				new Popup("Hay que introducir el nombre");
			} else {
				setVisible(false);
				new Game(name);
			}
		}
	}
}
