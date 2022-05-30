import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;
public class Ex2_Controle {

	 Filme[] fil = new Filme[10];
	 int po = 0;
	 
	public void menu() {
		int op;
		String aux = "Escolha uma op��o: \n";
		aux += "1. Registrar um Filme\n";
		aux += "2. Pesquisar Filme\n";
		aux += "3. Listar Filmes\n";
		aux += "4. Finalizar";
		
		do {
			op = parseInt(showInputDialog(aux));
			if ( op < 1 || op > 4) {
				showMessageDialog(null,"Op��o Invalida");
			}else {
				switch(op) {
					case 1:
						registrarFilme();
						break;
					case 2:
						pesquisarFilme();
						break;
					case 3:
						listarFilmes();
						break;

				}
			}
		}while( op != 4);
	}
	public void registrarFilme() {
		if(po < fil.length) {
			fil[po] = new Filme();
			fil[po].titulo = showInputDialog("T�tulo:");
			int indice = -1;
			for(int i =  0; i < po; i++) {
				if(fil[i].titulo.equalsIgnoreCase(fil[po].titulo)) {
					indice = i;
				}
			}
			if(indice != -1) {
				showMessageDialog(null," T�tulo j� cadastrado");
				return;
			}else {
			fil[po].genero = showInputDialog("G�nero:");
			fil[po].ano = parseInt(showInputDialog("Ano de lan�amento:"));
			fil[po].pontuacao = parseInt(showInputDialog("Pontua��o (0 - 5):"));
			if(fil[po].pontuacao>5) {
				showMessageDialog(null,"Pontua��o atribuida 5 (max)");
				fil[po].pontuacao = 5;
			}
			if(fil[po].pontuacao<0) {
				showMessageDialog(null,"Pontua��o atribuida 0 (min)");
				fil[po].pontuacao = 0;
			}
			po++;
			}
		}
	}
	
	public void pesquisarFilme() {
		int indice = pesquisar();
		if(indice == -1) {
			showMessageDialog(null," T�tulo n�o encontrado");
		}else {
		String aux = "";

		aux += "T�tulo: " + fil[indice].titulo + "\n";
		aux += "G�nero: " + fil[indice].genero + "\n";
		aux += "Ano: " + fil[indice].ano + "\n";
		aux += "Pontua��o: " + fil[indice].pontuacao + "\n";
		aux += "\n";
		
		showMessageDialog(null, aux);
		}
	}
	
	public void listarFilmes() {
		String aux = "";
		for(int i =  0; i < po; i++) {
		aux += "T�tulo: " + fil[i].titulo + "\n";
		aux += "G�nero: " + fil[i].genero + "\n";
		aux += "Ano: " + fil[i].ano + "\n";
		aux += "Pontua��o: " + fil[i].pontuacao + "\n";
		aux += "\n";
		}
		showMessageDialog(null, aux);
	}
	
	public int pesquisar() {
		int indice = -1;
		String titulo = showInputDialog("T�tulo para pesquisa");
		for(int i =  0; i < po; i++) {
			if(fil[i].titulo.equalsIgnoreCase(titulo)) {
				indice = i;
			}
		}
		return indice;
	}
}
