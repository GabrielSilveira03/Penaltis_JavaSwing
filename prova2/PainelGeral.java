package prova2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PainelGeral extends JPanel {

	private JPanel painelgol;
	private JPanel painelcabecario;
	
	public PainelGeral(JPanel painelgol,JPanel painelcabecario) {
		this.painelgol = painelgol;
		this.painelcabecario = painelcabecario;
		
		setLayout(new BorderLayout());
		add(this.painelcabecario, BorderLayout.NORTH);
		add(this.painelgol, BorderLayout.CENTER);
		
		
	}
	
	public PainelGeral() {
		
	}
}
