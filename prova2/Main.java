package prova2;

public class Main {

	public static void main(String[] args) {
		PainelGol painelGol = new PainelGol();
		PainelCabecario painelCabecario = new PainelCabecario(painelGol);
		PainelGeral painelGeral = new PainelGeral(painelGol,painelCabecario);
		Janela janela = new Janela(painelGeral);
	}

}
