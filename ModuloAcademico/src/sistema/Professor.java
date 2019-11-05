package sistema;

import java.util.Scanner;

public class Professor extends Usuario {

	private int qtdDisciplinas;
	private String[] disciplinas;
	private Scanner entrada;
	
	public Professor() {
		super();
		qtdDisciplinas = 0;
		disciplinas = new String[4];
	}

	public int getQtdDisciplinas() {
		return qtdDisciplinas;
	}

	public void setQtdDisciplinas(int qtdDisciplinas) {
		this.qtdDisciplinas = qtdDisciplinas;
	}

	public String[] getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(String[] disciplinas) {
		this.disciplinas = disciplinas;
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
			System.out.println("\n*********************");
			System.out.println("(1) Lancar notas");
			System.out.println("(2) Lancar frequencia");
			System.out.println("(3) Alterar senha");
			System.out.println("(0) SAIR");
			System.out.println("*********************");
			
			opcao = entrada.nextInt();
			
			if(opcao == 1) {
				Sistema.lancarNota();
			} else if(opcao == 2) {
				Sistema.lancarFrequencia();
			} else if(opcao == 3) {
				super.alterarSenha();
			} else if(opcao == 0) {
				return;
			} else {
				System.out.println("\nOpcao invalida!");
			}
		}
	}

	
}
