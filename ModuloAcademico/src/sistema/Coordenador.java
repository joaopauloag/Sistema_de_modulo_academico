package sistema;

import java.util.Scanner;

public class Coordenador extends Usuario {
	
	private Scanner entrada;

	public Coordenador() {
		super();
	}

	
	@Override
	public void criarConta() {
		// TODO Auto-generated method stub
		super.criarLogin();
		System.out.println("");
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
		int opcao;
		
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n*****************************************");
			System.out.println("(1) Criar nova turma");
			System.out.println("(2) Abrir / Encerrar periodo de matricula");
			System.out.println("(3) Avaliar solicitacao de matricula");
			System.out.println("(4) Alterar senha");
			System.out.println("(0) SAIR");
			System.out.println("*****************************************");
			opcao = entrada.nextInt();
			
			if(opcao == 1) {
				Sistema.criarNovaTurma();
			} else if(opcao == 2) {
				Sistema.abrirEncerrarMatricula();
			} else if(opcao == 3) {
				Sistema.verSolicitacoes();
			} else if(opcao == 4) {
				super.alterarSenha();
			} else if(opcao == 0) {
				return;
			} else {
				System.out.println("\nOpcao invalida!");
			}
		}
	}
	
}
