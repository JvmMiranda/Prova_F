import java.util.*;
public class Ex_1 {

	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		int val, aux = 2, som = 0;
		System.out.println("Informe um valor a ser inteiro e maior que 1 para a soma dos valores ímpares: ");
		val = tec.nextInt();
		System.out.println(calc(val, aux, som));
	}
	public static int calc(int val, int aux, int som) {
		if(aux == val) {
			return som;
		}else {
			if(aux % 2 == 0) {
				return calc(val, (aux+1), som);
			}else {
				som += aux;
				return calc(val, (aux+1), som);
			}
				
		}
	}
}
