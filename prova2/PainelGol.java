package prova2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelGol extends JPanel{

	private ArrayList <BotaoCelula> listaBotoes = new ArrayList<>();
	private String jogador;
	private int pontuacaoJogador;
	private int pontuacaoMaquina;
	private int defesasMaoDireita;
	private int defesasMaoEsquerda;
	private int defesasBaseGoleiro;
	
	
	public PainelGol() {
		setPreferredSize(new Dimension(950,450));
		setVisible(false);
	}
	
	public JPanel criarBotoes() {
		JPanel p = new JPanel();
		
		
		Botao botao = new Botao(this);
		
		p.setLayout(new GridLayout(9,17));
		for (int linha = 0; linha < 9; linha++) {
			for (int coluna = 0; coluna < 17; coluna++) {
				listaBotoes.add(botao.criarBotao(new CelulaGol(linha,coluna)));
			}
		}
		for (JButton botaolista : listaBotoes) {
			p.add(botaolista);
		}
		
		return p;
	}
	
	
	public void carregarPosicoesGoleiro() {
		Random aleatorio = new Random();
		
		int xGoleiro = 8;
		int yGoleiro = aleatorio.nextInt(17);
		int xMaoEsquerda = aleatorio.nextInt(9); 
		int yMaoEsquerda = aleatorio.nextInt(16)+1;
		while(yMaoEsquerda == yGoleiro && xMaoEsquerda == 8) {
			yMaoEsquerda = aleatorio.nextInt(16)+1;
		}
		int xMaoDireita = aleatorio.nextInt(9);
		int yMaoDireita = aleatorio.nextInt(yMaoEsquerda);
		while(yMaoDireita == yGoleiro && xMaoDireita == 8) {
			yMaoDireita = aleatorio.nextInt(16)+1;
		}
		
		CelulaGol celulaGoleiro = new CelulaGol(xGoleiro,yGoleiro);
		CelulaGol celulaMaoEsquerda = new CelulaGol(xMaoEsquerda,yMaoEsquerda);
		CelulaGol celulaMaoDireita = new CelulaGol(xMaoDireita,yMaoDireita);
		
		for (BotaoCelula botaoLista : listaBotoes) {
			if(botaoLista.getCelula().getX() == xGoleiro && botaoLista.getCelula().getY() == yGoleiro) {
				botaoLista.getCelula().setGoleiro(true);
			} else if(botaoLista.getCelula().getX() == xMaoEsquerda && botaoLista.getCelula().getY() == yMaoEsquerda) {
				botaoLista.getCelula().setMaoEsquerda(true);
			} else if(botaoLista.getCelula().getX() == xMaoDireita && botaoLista.getCelula().getY() == yMaoDireita) {
				botaoLista.getCelula().setMaoDireita(true);
			}	
		}
		
		for (BotaoCelula botaoLista : listaBotoes) {
			if(verificarAreaAtuacao(botaoLista.getCelula(), celulaGoleiro, celulaMaoEsquerda, celulaMaoDireita)==true) {
				botaoLista.getCelula().setAreaAtuacao(true);
			}
		}
		
	}
	
	public boolean verificarAreaAtuacao(CelulaGol cAux,CelulaGol c1,CelulaGol c2,CelulaGol c3) {
		double distancia1,distancia2,distancia3;
		boolean Neg,Pos;
		
		distancia1 = calculoDistancia(cAux, c1, c2);
		distancia2 = calculoDistancia(cAux, c2, c3);
		distancia3 = calculoDistancia(cAux, c3, c1);
		
		Neg = (distancia1<0) || (distancia2<0) || (distancia3<0);
		Pos = (distancia1>0) || (distancia2>0) || (distancia3>0);
		
		return !(Neg && Pos);
	}
	
	public double calculoDistancia(CelulaGol cAux,CelulaGol c2,CelulaGol c3) {
		double aux = (cAux.getX()-c3.getX())*(c2.getY()-c3.getY())-(c2.getX()-c3.getX())*(cAux.getY()-c3.getY());
		
		return aux;
	}
	
	public ArrayList<BotaoCelula> getListaBotoes() {
		return listaBotoes;
	}
	
	public String getNomeJogador() {
		return jogador;
	}
	
	public int getPontuacaoJogador() {
		return pontuacaoJogador;
	}
	
	public int getPontuacaoMaquina() {
		return pontuacaoMaquina;
	}
	
	public int getDefesasMaoDireita() {
		return defesasMaoDireita;
	}
	
	public int getDefesasMaoEsquerda() {
		return defesasMaoEsquerda;
	}
	
	public int getDefesasBaseGoleiro() {
		return defesasBaseGoleiro;
	}
	
	public void setNomeJogador(String nome) {
		jogador = nome;
	}
	
	public void addPontoJogador() {
		pontuacaoJogador++;
	}
	
	public void addPontoMaquina() {
		pontuacaoMaquina++;
	}
	
	public void addDefesaMaoDireita() {
		defesasMaoDireita++;
	}
	
	public void addDefesaMaoEsquerda() {
		defesasMaoEsquerda++;
	}
	
	public void addDefesaGoleiro() {
		defesasBaseGoleiro++;
	}
	
}
