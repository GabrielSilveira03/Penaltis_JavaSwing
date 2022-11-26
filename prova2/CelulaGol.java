package prova2;

public class CelulaGol {

	private int x;
	private int y;
	private boolean goleiro;
	private boolean maoDireita;
	private boolean maoEsquerda;
	private boolean areaAtuacao;
	private boolean dentroGol;
	private boolean foraGol;
	private boolean travessao;
	private boolean trave;
	
	public CelulaGol() {
	
	}
	
	public CelulaGol(int x,int y) {
		this.x = x;
		this.y = y;
		mapearPosicao();
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean getGoleiro() {
		return goleiro;
	}
	
	public boolean getMaoDireita() {
		return maoDireita;
	}
	
	public boolean getMaoEsquerda() {
		return maoEsquerda;
	}
	
	public boolean getAreaAtuacao() {
		return areaAtuacao;
	}
	
	public boolean getDentroGol() {
		return dentroGol;
	}
	
	public boolean getForaGol() {
		return foraGol;
	}
	
	public boolean getTrave() {
		return trave;
	}
	
	public boolean getTravessao() {
		return travessao;
	}
	
	public void setGoleiro(boolean modificador) {
		this.goleiro = modificador;
	}
	
	public void setMaoDireita(boolean modificador) {
		this.maoDireita = modificador;
	}
	
	public void setMaoEsquerda(boolean modificador) {
		this.maoEsquerda = modificador;
	}
	
	public void setAreaAtuacao(boolean modificador) {
		this.areaAtuacao = modificador;
	}
	
	public void setDentroGol(boolean modificador) {
		this.dentroGol = modificador;
	}
	
	public void setForaGol(boolean modificador) {
		this.foraGol = modificador;
	}
	
	public void setTravessao(boolean modificador) {
		this.travessao = modificador;
	}
	
	public void setTrave(boolean modificador) {
		this.trave = modificador;
	}
	
	public void mapearPosicao() {
		if(x==0 || y==16 || y==0) {
			setForaGol(true);
		} else if(x==1 && y!=0 && y!=16){
			setTravessao(true);
		} else if((y==1 || y==15) && x>1){
			setTrave(true);
		} else {
			setDentroGol(true);
		}
	}
	
	
}
