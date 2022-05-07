package windows;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.User;
import utils.UserService;


public class Results extends JFrame {
	Dimension windowDimension = new Dimension(150, 150);
	GridLayout layout = new GridLayout(0, 1);
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Resultados");
	UserService userService = new UserService();
	
	public Results() {
		setTitle("Resultados");
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width - windowDimension.width) / 2;
		int y = (screenDimension.height - windowDimension.height) / 2;
		
		setLocation(x, y);
		setSize(windowDimension);
		setResizable(false);
		
		panel.setLayout(layout);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		panel.add(label);
		
		// get results
		List<User> results = this.userService.getResults();
		
		// sort results in descending order
		results.sort(new Comparator<User>() {
			  public int compare(User a, User b) {
			     return b.getResult() - a.getResult();
			  }
		});

		// limit results length to 3 items
		List<User> resultsToShow = new ArrayList<User>();
		for (int i = 0; i < results.size(); i++) {
			if (i > 2) break;
			resultsToShow.add(results.get(i));
		}
		
		// render first 3 one by one
		for (User user : resultsToShow) {
			JLabel userResult = new JLabel(user.toString());
			panel.add(userResult);
		}
		
		add(panel);
		
		setVisible(true);
	}
}
