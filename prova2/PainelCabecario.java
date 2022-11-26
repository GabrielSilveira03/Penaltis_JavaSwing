package prova2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelCabecario extends JPanel {

	private JPanel label;
	private PainelGol painelGol; 
	
	public PainelCabecario(PainelGol painelGol) {
		this.painelGol = painelGol;
		setPreferredSize(new Dimension(900,100));
		label = new JPanel();
		label.setLayout(new GridLayout(3,2));
		label.setVisible(false);
		
		setLayout(new FlowLayout());
		add(botaoIniciar());
		add(botaoFinalizar());
		add(botaoProximaRodada());
		add(label);
	}
	
	public PainelCabecario() {
		
	}
	
	public JButton botaoIniciar() {
		JButton iniciar = new JButton();
		iniciar.setText("Iniciar Jogo");
		iniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelGol.add(painelGol.criarBotoes());
				painelGol.carregarPosicoesGoleiro();
				painelGol.setVisible(true);
			}
		});
		
		return iniciar;
	}
	
	public JButton botaoFinalizar() {
		JButton finalizar = new JButton();
		finalizar.setText("Finalizar Jogo");
		finalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionarLabels(painelGol);
				label.setVisible(true);
				for (BotaoCelula botaoLista : painelGol.getListaBotoes()) {
					desabilitarIcons(botaoLista);
					botaoLista.determinarIcon();
				}
				for (BotaoCelula botaoLista : painelGol.getListaBotoes()) {
					botaoLista.mostrarResultados();
				}
			}
		});
		
		return finalizar;
	}
	
	public JButton botaoProximaRodada() {
		JButton proximaRodada = new JButton();
		proximaRodada.setText("Próxima Rodada");
		proximaRodada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (BotaoCelula botaoLista : painelGol.getListaBotoes()) {
					desabilitarIcons(botaoLista);
					botaoLista.determinarIcon();
				}
				painelGol.carregarPosicoesGoleiro();
				
			}
		});
		
		return proximaRodada;
	}
	
	public void adicionarLabels(PainelGol painelGol) {
		label.add(addTextLabelNome(painelGol));
		label.add(addTextLabelPontoJogador(painelGol));
		label.add(addTextLabelPontoMaquina(painelGol));
		label.add(addTextLabelDefesaGoleiro(painelGol));
		label.add(addTextLabelDefesaDireita(painelGol));
		label.add(addTextLabelDefesaEsquerda(painelGol));
	}
	
	public void desabilitarIcons(BotaoCelula botaoCelula) {
		if(botaoCelula.getCelula().getGoleiro()==true) {
			botaoCelula.getCelula().setGoleiro(false);
		} else if(botaoCelula.getCelula().getMaoDireita()==true) {
			botaoCelula.getCelula().setMaoDireita(false);
		} else if(botaoCelula.getCelula().getMaoEsquerda()==true) {
			botaoCelula.getCelula().setMaoEsquerda(false);
		}
		if(botaoCelula.getCelula().getAreaAtuacao()==true) {
			botaoCelula.determinarIcon();
			botaoCelula.getCelula().setAreaAtuacao(false);
		}
	}
	
	public JLabel addTextLabelNome(PainelGol painelGol) {
		String saida = "Nome Jogador: " + painelGol.getNomeJogador();
		JLabel labelaux = new JLabel();
		labelaux.setText(saida);
		
		return labelaux;
	}
	
	public JLabel addTextLabelPontoJogador(PainelGol painelGol) {
		String saida = "Pontuacao Jogador: " + painelGol.getPontuacaoJogador();
		JLabel labelaux = new JLabel();
		labelaux.setText(saida);
		
		return labelaux;
	}
	
	public JLabel addTextLabelPontoMaquina(PainelGol painelGol) {
		String saida =  "Pontuacao Maquina: " + painelGol.getPontuacaoMaquina();
		JLabel labelaux = new JLabel();
		labelaux.setText(saida);
		
		return labelaux;
	}
	
	public JLabel addTextLabelDefesaGoleiro(PainelGol painelGol) {
		String saida = "Defesas em cima da Base do Goleiro: " + painelGol.getDefesasBaseGoleiro();
		JLabel labelaux = new JLabel();
		labelaux.setText(saida);
		
		return labelaux;
	}
	
	public JLabel addTextLabelDefesaDireita(PainelGol painelGol) {
		String saida = "Defesas em cima da Mao Direita: " + painelGol.getDefesasMaoDireita();
		JLabel labelaux = new JLabel();
		labelaux.setText(saida);
		
		return labelaux;
	}
	
	public JLabel addTextLabelDefesaEsquerda(PainelGol painelGol) {
		String saida =  "Defesas em cima da Mao Esquerda: " + painelGol.getDefesasMaoEsquerda();
		JLabel labelaux = new JLabel();
		labelaux.setText(saida);
		
		return labelaux;
	}
	
}
