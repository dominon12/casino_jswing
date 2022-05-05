package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import windows.Results;

public class MenuBar extends JMenuBar {
	JMenu menu = new JMenu("Opciones");
	JMenuItem showResultsItem = new JMenuItem("Mostrar resultados");
	
	public MenuBar() {
		showResultsItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Results();
            }
        });
		
		menu.add(showResultsItem);
		add(menu);
	}
}
