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
			System.out.println("\n\nMODULO ACADEMICO\n");
			System.out.println("(1) Criar conta");
			System.out.println("(2) Login");
			System.out.println("(0) SAIR");
			
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
