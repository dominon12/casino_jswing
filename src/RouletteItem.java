import java.awt.Color;

public class RouletteItem {
	private String color;
	private int value;
	
	public RouletteItem(String color, int value) {
		this.color = color;
		this.value = value;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Color getColorValue() {
		switch (this.color) {
			case "Rojo":
				return Color.RED;
			case "Verde":
				return new Color(0, 117, 0);
			case "Negro":
				return Color.BLACK;
			default:
				return Color.BLACK;
		}
	}
}
