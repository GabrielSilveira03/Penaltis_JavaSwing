package prova2;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {

	private JPanel painel;
	
	public Janela(JPanel painel) {
		setSize(1000,600);
		setLocation(10,50);
		this.painel = painel;
		add(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
