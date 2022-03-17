import javax.swing.JPanel;

public class StatsPanel extends JPanel {
	Section container = new Section();
	Title title = new Title("Stats");
	DescriptionItem saldoPanel = new DescriptionItem("Saldo", "1000");
	DescriptionItem highestPrize = new DescriptionItem("Max ganado", "No data");
	DescriptionItem highestLost = new DescriptionItem("Max perdido", "No data");
	DepositHandler depositHandler = new DepositHandler(saldoPanel);
	
	public StatsPanel() {
		container.add(title);
		container.add(saldoPanel);
		container.add(highestPrize);
		container.add(highestLost);
		container.add(depositHandler);
		add(container);
	}
}
