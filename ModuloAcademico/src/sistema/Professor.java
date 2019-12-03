package sistema;

import java.util.Scanner;

public class Professor extends Usuario {

	private int qtdDisciplinas;
	private String[] disciplinas;
	
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
	
	public void setDisciplina(String disciplina) {
		for(int i = 0; i < 4; i++) {
			if(disciplinas[i] == null) {
				disciplinas[i] = disciplina;
				break;
			}
		}
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
			System.out.println("\n*********************");
			System.out.println("(1) Lancar notas");
			System.out.println("(2) Lancar frequencia");
			System.out.println("(3) Alterar senha");
			System.out.println("(0) SAIR");
			System.out.println("*********************");
			
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				}
				break;
			}
			
			if(opcao == 1) {
				escolherTurma(1);
			} else if(opcao == 2) {
				escolherTurma(2);
			} else if(opcao == 3) {
				super.alterarSenha();
			} else if(opcao == 0) {
				return;
			} else {
				System.out.println("\nOpcao invalida!");
			}
		}
	}
	
	public void escolherTurma(int j) {
		
		String disciplina;
		entrada = new Scanner(System.in);
		
		if(qtdDisciplinas == 0) {
			System.out.println("\nVoce ainda nao possui uma turma.");
			return;
		}
		System.out.println("\nSuas turmas:");
		for(int i = 0; i < 4; i++) {
			if(disciplinas[i] != null) {
				System.out.println(disciplinas[i]);
			}
		}
		System.out.print("\nEscolha uma turma: ");
		disciplina = entrada.nextLine();
		for(int i = 0; i < 4; i++) {
			if(disciplinas[i] != null) {
				if(disciplina.equalsIgnoreCase(disciplinas[i]) && j == 1) {
					Sistema.lancarNota(disciplina);
					return;
				}
				if(disciplina.equalsIgnoreCase(disciplinas[i]) && j == 2) {
					Sistema.lancarFrequencia(disciplina);
					return;
				}
			}
		}
		System.out.println("\nTurma nao encontrada!");
		return;
	}

	
}
