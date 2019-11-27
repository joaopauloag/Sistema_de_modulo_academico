package sistema;

import java.util.Scanner;

public class Coordenador extends Professor {

	public Coordenador() {
		super();
	}

	
	@Override
	public void criarConta() {
		// TODO Auto-generated method stub
		entrada = new Scanner(System.in);
		System.out.print("\nInforme o seu email: ");
		super.setEmail(entrada.nextLine());
		super.criarPerfil();
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
			System.out.println("(2) Adicionar Aluno/Professor ao sistema");
			System.out.println("(3) Abrir / Encerrar periodo de matricula");
			System.out.println("(4) Avaliar solicitacao de matricula");
			System.out.println("(5) Lancar notas");
			System.out.println("(6) Lancar frequencia");
			System.out.println("(7) Exibir relatorio de turmas");
			System.out.println("(8) Alterar senha");
			System.out.println("(0) SAIR");
			System.out.println("*****************************************");
	
			opcao = entrada.nextInt();
	
			if(opcao == 1) {
				Sistema.criarNovaTurma();
			} else if(opcao == 2) {
				Sistema.adicionarUsuarioAoSistema();
			} else if(opcao == 3) {
				Sistema.abrirEncerrarMatricula();
			} else if(opcao == 4) {
				Sistema.verSolicitacoes();
			} else if(opcao == 5) {
				super.escolherTurma(1);
			} else if(opcao == 6) {
				super.escolherTurma(2);
			} else if(opcao == 7) {
				Sistema.exibirRelatorioDeCoordenador();
			} else if(opcao == 8) {
				super.alterarSenha();
			} else if(opcao == 0) {
				return;
			} else {
				System.out.println("\nOpcao invalida!");
			}
		}
	}
	
}
