package components;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Roulette extends JPanel {
	private int itemsCount = 10;
	private String[] colors = { "Rojo", "Verde", "Negro" };
	private RouletteItem[] items = new RouletteItem[itemsCount];
	
	public Roulette() {
		setLayout(new GridLayout(1, itemsCount, 10, 10));
		setBorder(new EmptyBorder(15, 15, 15, 15));
		addItems();
	}
	
	public RouletteItem roll() {
		addItems();
		return items[0];
	}
	
	void addItems() {
		removeAll();
		for (int i = 0; i < itemsCount; i++) {
			String color = getRandomColor();
			int number =  getRandomInt();
			RouletteItem item = new RouletteItem(color, number);
			RouletteItemBlock itemBlock = new RouletteItemBlock(item);
			items[i] = item;
			add(itemBlock);
		}
	}
	
	int getRandomInt() {
		return new Random().nextInt(1, 50);
	}
	
	String getRandomColor() {
		int randomIndex = new Random().nextInt(colors.length);
		return colors[randomIndex];
	}
}










