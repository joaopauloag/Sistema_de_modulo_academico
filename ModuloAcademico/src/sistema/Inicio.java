package sistema;

import java.util.Scanner;

public class Inicio {

	private static Scanner entrada;
	Sistema sistema = new Sistema();
	
	public static void menuPrincipal() {
		
		int opcao;
		
		Sistema sistema = new Sistema();
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n\n*****************");
			System.out.println("MODULO ACADEMICO\n");
			System.out.println("(1) Criar conta");
			System.out.println("(2) Login");
			System.out.println("(0) SAIR");
			System.out.println("*****************");
			
			opcao = entrada.nextInt();
			
			if(opcao == 1) {
				sistema.criarConta();
			} else if(opcao == 2) {
				sistema.fazerLogin();
			} else if(opcao == 0) {
				return;
			} else {
				System.out.println("\nOpcao invalida!");
			}
		}
	}
	
	
}
