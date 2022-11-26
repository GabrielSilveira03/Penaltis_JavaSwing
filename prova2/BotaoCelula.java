package prova2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotaoCelula extends JButton {

	private CelulaGol celula;
	private int gols;
	private int naogols;
	
	
	public BotaoCelula(CelulaGol celula) {
		this.celula = celula;
		setPreferredSize(new Dimension(50,50));
		determinarIcon();
	}

	public CelulaGol getCelula() {
		return celula;
	}

	public void determinarIcon() {
		if(celula.getDentroGol()==true) {
			setIcon(new ImageIcon(new ImageIcon("src/imagens/rede.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
			setBackground(Color.GREEN);
		} else if(celula.getForaGol()==true) {
			setIcon(new ImageIcon(new ImageIcon("src/imagens/fora.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
			setBackground(Color.RED);
		} else if(celula.getTrave()==true) {
			setIcon(new ImageIcon(new ImageIcon("src/imagens/trave.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
			setBackground(Color.GRAY);
		} else if(celula.getTravessao()==true) {
			setIcon(new ImageIcon(new ImageIcon("src/imagens/travessao.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
			setBackground(Color.GRAY);
		}
	}
	
	public void mostrarAreaAtuacao() {
		if(celula.getGoleiro()==true) {
			setIcon(new ImageIcon(new ImageIcon("src/imagens/iconegoleiro.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		} else if(celula.getMaoDireita()==true) {
			setIcon(new ImageIcon(new ImageIcon("src/imagens/luvadireita.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		} else if(celula.getMaoEsquerda()==true) {
			setIcon(new ImageIcon(new ImageIcon("src/imagens/luvaesquerda.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		}
		if(celula.getAreaAtuacao()==true) {
			setBackground(Color.ORANGE);
		}
	}
	
	public void mostrarResultados() {
		if(gols>naogols) {
			setIcon(new ImageIcon(new ImageIcon("src/imagens/bola.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		} else if(gols<naogols) {
			setIcon(new ImageIcon(new ImageIcon("src/imagens/naogol.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
			setBackground(Color.ORANGE);
		}
	}
	
	public void iconeGol() {
		setIcon(new ImageIcon(new ImageIcon("src/imagens/bola.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
	}
	
	public void iconeNaoGol() {
		setIcon(new ImageIcon(new ImageIcon("src/imagens/naogol.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
	}
	
	public void addGol() {
		gols++;
	}
	
	public void addNaoGol() {
		naogols++;
	}
}
