package sistema;

import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
	
	private static ArrayList <Usuario> usuarios;
	private static ArrayList <Disciplina> disciplinas;
	private static Scanner entrada;
	private static boolean ePeriodoDeMatricula;
	
	public Sistema () {
		usuarios = new ArrayList<Usuario>();
		disciplinas = new ArrayList<Disciplina>();
		ePeriodoDeMatricula = false;
	}
	
	
	public void criarConta() {
		
		int opcao;
		Usuario novoUsuario = null;
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n(1) Aluno");
			System.out.println("(2) Professor");
			System.out.println("(3) Coordenador");
			System.out.println("(0) VOLTAR");
			opcao = entrada.nextInt();
			
			if(opcao == 1) {
				novoUsuario = new Aluno();
			} else if(opcao == 2) {
				novoUsuario = new Professor();
			} else if(opcao == 3) {
				if(procurarCoordenador()) {
					novoUsuario = new Coordenador();
				} else {
					System.out.println("\nO coordenador ja esta cadastrado!");
					continue;
				}
			} else if(opcao == 0) {
				return;
			} else {
				System.out.println("\nOpcao invalida!");
				continue;
			}
			novoUsuario.criarConta();
			usuarios.add(novoUsuario);
			break;
		}
	}
	
	public boolean procurarCoordenador() {
		
		for(Usuario u : usuarios) {
			if(u instanceof Coordenador) {
				return false;
			}
		}
		return true;
	}
	
	public void fazerLogin() {
		
		String email;
		String senha;
		
		entrada = new Scanner(System.in);
		
		System.out.print("\nEmail: ");
		email = entrada.nextLine();
		
		for(Usuario u : usuarios) {
			if(u.getEmail().equals(email)) {
				while(true) {
					System.out.print("\nSenha: ");
					senha = entrada.nextLine();
					if(u.getSenha().equals(senha)) {
						u.menu();
						return;
					}
					System.out.println("\nSenha incorreta!");
				}
			}
		}
		System.out.println("\nUsuario nao encontrado!");		
	}
	
	
	public static void criarNovaTurma() {
		
		String nome;
		boolean encontrouProfessor = false;
		boolean alocouProfessor = false;
		Disciplina novaDisciplina = new Disciplina();
		entrada = new Scanner(System.in);
		
		System.out.print("\nNome da disciplina: ");
		novaDisciplina.setNomeDisciplina(entrada.nextLine());
		while(true) {
			System.out.println("\nProfessores disponiveis:\n");
			for(Usuario u : usuarios) {
				if(u instanceof Professor) {
					if(((Professor) u).getQtdDisciplinas() < 4) {
						System.out.println(u.getNome());
						encontrouProfessor = true;
					}
				}
			}
			if(!encontrouProfessor) {
				System.out.println("\nNao ha professores disponiveis. A turma nao pode ser criada!");
				return;
			}
			System.out.print("\nEscolha o professor: ");
			nome = entrada.nextLine();
			for(Usuario u : usuarios) {
				if(u instanceof Professor) {
					if(u.getNome().equalsIgnoreCase(nome)) {
						novaDisciplina.setNomeProfessor(nome);
						((Professor) u).setQtdDisciplinas(((Professor) u).getQtdDisciplinas() + 1);
						alocouProfessor = true;
						break;
					}
				}
			}
			if(alocouProfessor) {
				break;
			}
			System.out.println("\nProfessor nao encontrado!");
		}
		disciplinas.add(novaDisciplina);
		System.out.println("\nTurma criada!");
	}
	
	public static void abrirEncerrarMatricula() {
		
		entrada = new Scanner(System.in);
		
		System.out.print("\nStatus de matricula: ");
		System.out.println((ePeriodoDeMatricula)?  "Aberto" : "Fechado");
		System.out.print("\n(S) para mudar status, qualquer outra tecla para manter: ");
		
		if(entrada.next().equalsIgnoreCase("s")) {
			if(ePeriodoDeMatricula) {
				ePeriodoDeMatricula = false;
			} else {
				ePeriodoDeMatricula = true;
			}
		}
		System.out.print("\nStatus de matricula: ");
		System.out.println((ePeriodoDeMatricula)?  "Aberto" : "Fechado");
	}
	
	public static void verSolicitacoes() {
		
		int i;
		String nomeDisciplina;
		
		for(Disciplina d : disciplinas) {
			if(d.getSolicitacoes() != null) {
				ArrayList<Integer> solicitacoes = d.getSolicitacoes();
				nomeDisciplina = d.getNomeDisciplina();
				System.out.println("\n\n\nDisciplina: " + d.getNomeDisciplina());
				for (i = 0; i < solicitacoes.size(); i++) {
					avaliarSolicitacao(solicitacoes.get(i), nomeDisciplina);
					solicitacoes.remove(i);
					i--;
				}
				if(i == 0) {
					System.out.println("\nNenhuma solicitacao.");
				}
			}
		}
	}
	
	private static void avaliarSolicitacao(int i, String nomeDisciplina) {
		
		String opcao;
		entrada = new Scanner(System.in);
		
		for(Usuario u : usuarios) {
			if(u instanceof Aluno) {
				if(((Aluno) u).getMatricula() == i) {
					System.out.println("\nPeriodo: " + ((Aluno) u).getPeriodo() + "\tAluno: " + u.getNome());
					System.out.print("(S) para aceitar, qualquer outra tecla para recusar: ");
					opcao = entrada.nextLine();
					if(opcao.equalsIgnoreCase("s")) {
						((Aluno) u).setDisciplinas(nomeDisciplina);
						((Aluno) u).setQtdDisciplina(((Aluno) u).getQtdDisciplina() + 1);
						System.out.println("\nPedido aceito.\n");
						return;
					}
					System.out.println("\nPedido recusado.\n");
					return;
				}
			}
		}
	}
	
	public static void lancarNota() {
		System.out.println("chamou");
	}
	
	public static void lancarFrequencia() {
		System.out.println("chamou");
	}
	
	public static void solicitarMatricula(int matricula, int qtdDisciplinas) {
		
		String disciplina;
		entrada = new Scanner(System.in);

		if(!ePeriodoDeMatricula) {
			System.out.println("\nSem direito a matricula.");
			return;
		} else if(qtdDisciplinas == 8) {
			System.out.println("\nVoce ja esta com a carga horaria maxima!");
			return;
		}
		System.out.println("\nListando disciplinas:\n");
		for(Disciplina d : disciplinas) {
			System.out.println(d.getNomeDisciplina());
		}
		System.out.print("\nEntre com o nome da disciplina: ");
		disciplina = entrada.nextLine();
		for(Disciplina d : disciplinas) {
			if(d.getNomeDisciplina().equalsIgnoreCase(disciplina)) {
				d.setSolicitacoes(matricula);
				System.out.println("\nSolicitacao enviada! Aguarde a avaliacao do coordenador.");
				return;
			}
		}
		System.out.println("\nDisciplina nao encontrada!");
	}
	
	public static void exibirBoletim(int matricula) {
		System.out.println("chamou");
	}
}
