package prova2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Botao extends JButton implements ActionListener{

	private PainelGol painelGol;
	
	public Botao(PainelGol painelGol) {
		this.painelGol = painelGol;
	}
	
	public BotaoCelula criarBotao(CelulaGol celula) {
		BotaoCelula botaoCelula = new BotaoCelula(celula);
		
		botaoCelula.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (BotaoCelula botaoLista : painelGol.getListaBotoes()) {
					if(botaoLista.getX()==botaoCelula.getX() && botaoLista.getY()==botaoCelula.getY()) {
						verificarGol(botaoCelula, painelGol);
					}
				}
				
			}
		});
		
		return botaoCelula;
	}
	
	public void verificarGol(BotaoCelula botaoCelula,PainelGol painelGol) {
		if(botaoCelula.getCelula().getAreaAtuacao() == false && botaoCelula.getCelula().getDentroGol()==true) {
			painelGol.addPontoJogador();
			botaoCelula.iconeGol();
			botaoCelula.addGol();
			for (BotaoCelula botaoLista : painelGol.getListaBotoes()) {
				botaoLista.mostrarAreaAtuacao();
			}
		} else {
			painelGol.addPontoMaquina();
			verificarPosicoesDefesa(botaoCelula, painelGol);
			botaoCelula.iconeNaoGol();
			botaoCelula.addNaoGol();
			for (BotaoCelula botaoLista : painelGol.getListaBotoes()) {
				botaoLista.mostrarAreaAtuacao();
			}
		}
	}
	
	public void verificarPosicoesDefesa(BotaoCelula botaoCelula,PainelGol painelGol) {
		if(botaoCelula.getCelula().getGoleiro() == true) {
			painelGol.addDefesaGoleiro();
		} else if(botaoCelula.getCelula().getMaoDireita() == true) {
			painelGol.addDefesaMaoDireita();
		} else if(botaoCelula.getCelula().getMaoEsquerda() == true) {
			painelGol.addDefesaMaoEsquerda();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
