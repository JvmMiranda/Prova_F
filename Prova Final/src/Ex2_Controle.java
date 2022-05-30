import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;
public class Ex2_Controle {

	 Filme[] fil = new Filme[10];
	 int po = 0;
	 
	public void menu() {
		int op;
		String aux = "Escolha uma opção: \n";
		aux += "1. Registrar um Filme\n";
		aux += "2. Pesquisar Filme\n";
		aux += "3. Listar Filmes\n";
		aux += "4. Finalizar";
		
		do {
			op = parseInt(showInputDialog(aux));
			if ( op < 1 || op > 4) {
				showMessageDialog(null,"Opção Invalida");
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
			fil[po].titulo = showInputDialog("Título:");
			int indice = -1;
			for(int i =  0; i < po; i++) {
				if(fil[i].titulo.equalsIgnoreCase(fil[po].titulo)) {
					indice = i;
				}
			}
			if(indice != -1) {
				showMessageDialog(null," Título já cadastrado");
				return;
			}else {
			fil[po].genero = showInputDialog("Gênero:");
			fil[po].ano = parseInt(showInputDialog("Ano de lançamento:"));
			fil[po].pontuacao = parseInt(showInputDialog("Pontuação (0 - 5):"));
			if(fil[po].pontuacao>5) {
				showMessageDialog(null,"Pontuação atribuida 5 (max)");
				fil[po].pontuacao = 5;
			}
			if(fil[po].pontuacao<0) {
				showMessageDialog(null,"Pontuação atribuida 0 (min)");
				fil[po].pontuacao = 0;
			}
			po++;
			}
		}
	}
	
	public void pesquisarFilme() {
		int indice = pesquisar();
		if(indice == -1) {
			showMessageDialog(null," Título não encontrado");
		}else {
		String aux = "";

		aux += "Título: " + fil[indice].titulo + "\n";
		aux += "Gênero: " + fil[indice].genero + "\n";
		aux += "Ano: " + fil[indice].ano + "\n";
		aux += "Pontuação: " + fil[indice].pontuacao + "\n";
		aux += "\n";
		
		showMessageDialog(null, aux);
		}
	}
	
	public void listarFilmes() {
		String aux = "";
		for(int i =  0; i < po; i++) {
		aux += "Título: " + fil[i].titulo + "\n";
		aux += "Gênero: " + fil[i].genero + "\n";
		aux += "Ano: " + fil[i].ano + "\n";
		aux += "Pontuação: " + fil[i].pontuacao + "\n";
		aux += "\n";
		}
		showMessageDialog(null, aux);
	}
	
	public int pesquisar() {
		int indice = -1;
		String titulo = showInputDialog("Título para pesquisa");
		for(int i =  0; i < po; i++) {
			if(fil[i].titulo.equalsIgnoreCase(titulo)) {
				indice = i;
			}
		}
		return indice;
	}
}
