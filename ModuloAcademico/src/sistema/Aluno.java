package sistema;

import java.util.Scanner;

public class Aluno extends Usuario {

	private int matricula;
	private int qtdDisciplinas;
	private String[] disciplinas;
	
	public Aluno() {
		super();
		qtdDisciplinas = 0;
		disciplinas = new String[8];
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public int getQtdDisciplina() {
		return qtdDisciplinas;
	}
	
	public void setQtdDisciplina(int qtdDisciplina) {
		this.qtdDisciplinas = qtdDisciplina;
	}

	public String[] getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(String disciplina) {
		this.disciplinas[this.qtdDisciplinas] = disciplina;
	}

	
	@Override
	public void criarConta() {
		// TODO Auto-generated method stub
		super.criarPerfil();
		System.out.println("");
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
		int opcao;
		
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n***********************");
			System.out.println("(1) Solicitar matricula");
			System.out.println("(2) Exibir boletim");
			System.out.println("(3) Alterar senha");
			System.out.println("(0) SAIR");
			System.out.println("***********************");
			
			opcao = entrada.nextInt();
			
			if(opcao == 1) {
				Sistema.solicitarMatricula(matricula, qtdDisciplinas);
			} else if(opcao == 2) {
				Sistema.exibirBoletim(matricula);
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
