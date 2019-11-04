package sistema;

import java.util.Scanner;

public class Aluno extends Usuario {

	private int matricula;
	private int periodo;
	private String[] disciplinas;
	private Scanner entrada;
	
	public Aluno() {
		super();
		disciplinas = new String[8];
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
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
		entrada = new Scanner(System.in);
		System.out.print("\nNumero de matricula: ");
		this.matricula = entrada.nextInt();
		System.out.print("\nPeriodo atual: ");
		this.periodo = entrada.nextInt();
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
	}
	
	
}
