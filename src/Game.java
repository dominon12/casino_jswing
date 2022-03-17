import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Game extends JFrame {
	private Dimension windowDimension = new Dimension(1100, 330);
	private Roulette roulette = new Roulette();
	private JButton playButton = new JButton("Jugar");
	private Header header = new Header();
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		setTitle("Roulette Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width - windowDimension.width) / 2;
		int y = (screenDimension.height - windowDimension.height) / 2;
		
		setLocation(x, y);
		setSize(windowDimension);
		setResizable(false);
		
		add(header, BorderLayout.NORTH);
		add(roulette);
		
		playButton.addActionListener(new GameFlowHandler());
		add(playButton, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	class GameFlowHandler implements ActionListener {
		void playerLost(int bet, int balance) {
			balance -= bet;
			header.stats.saldoPanel.setValue(Integer.toString(balance));
			raiseHighestLost(bet);
			
			new Popup("Has perdido " + bet);
		}
		
		void raiseHighestLost(int newLost) {
			int highestLost = header.stats.highestLost.getValue();
			if (newLost > highestLost) {
				header.stats.highestLost.setValue(Integer.toString(newLost));
			}
		}
		
		void playerWon(int bet, int balance) {
			balance += bet;
			header.stats.saldoPanel.setValue(Integer.toString(balance));
			raiseHighestPrise(bet);
			
			new Popup("Has ganado " + bet);
		}
		
		void raiseHighestPrise(int newPrize) {
			int highestPrize = header.stats.highestPrize.getValue();
			if (newPrize > highestPrize) {
				header.stats.highestPrize.setValue(Integer.toString(newPrize));
			}
		}
		
		public void actionPerformed(ActionEvent e) {
			int balance = header.stats.saldoPanel.getValue();
			int bet = header.configuration.betSelector.getInputValue();

			boolean canPlay = checkCanPlay(bet, balance);
			if (!canPlay) return;

			String selectedColor = header.configuration.colorSelector.getSelectedValue();
			String oddOrEven = header.configuration.oddEvenSelector.getSelectedValue();
			int specificNumber = header.configuration.numberSelector.getInputValue();
			
			RouletteItem itemWinner = roulette.roll();
			
			boolean colorMatches = selectedColor == itemWinner.getColor();
			
			if (colorMatches) {
				if (oddOrEven != "No seleccionado" && specificNumber != -1) {
					boolean guessedOddOrEven = this.guessedOddOrEven(oddOrEven, itemWinner.getValue());
					boolean guessedSpecificNumber = this.guessedSpecificNumber(specificNumber, itemWinner.getValue());
					
					if (guessedOddOrEven && guessedSpecificNumber) playerWon(bet, balance);
					else playerLost(bet, balance);
				} else if (oddOrEven != "No seleccionado") {
					boolean guessedOddOrEven = this.guessedOddOrEven(oddOrEven, itemWinner.getValue());
					if (guessedOddOrEven) playerWon(bet, balance);
					else playerLost(bet, balance);
				} else if (specificNumber != -1) {
					boolean guessedSpecificNumber = this.guessedSpecificNumber(specificNumber, itemWinner.getValue());
					if (guessedSpecificNumber) playerWon(bet, balance);
					else  playerLost(bet, balance);
				} else {
					playerWon(bet, balance);
				}
			} else {
				playerLost(bet, balance);
			}
		}
		
		boolean checkCanPlay(int bet, int balance) {
			if (balance <= 0) {
				new Popup("No puedes jugar con saldo negativo");
				return false;
			} else if (bet > balance) {
				new Popup("No puedes apostar mas de lo que tienes");
				return false;
			} else if (bet == -1) {
				new Popup("Introduzca tu apuesta para jugar");
				return false;
			}
			return true;
		}
		
		boolean guessedOddOrEven(String guess, int itemValue) {
			switch (guess) {
				case "Par":
					return itemValue % 2 == 0;
				case "Impar":
					return itemValue % 2 != 0;
				default:
					return false;
			}
		}
		
		boolean guessedSpecificNumber(int guess, int itemValue) {
			return guess == itemValue;
		}
	}
}









