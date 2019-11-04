package sistema;

import java.util.ArrayList;;

public class Disciplina {

	private String nomeDisciplina;
	private String nomeProfessor;
	private int[] alunosMatriculados;
	private int[] faltasAlunos;
	private double[][] notasAlunos;
	private ArrayList<Integer> solicitacoes;
	
	public Disciplina() {
		alunosMatriculados = new int[30];
		faltasAlunos = new int[30];
		notasAlunos = new double[30][5];
		solicitacoes = new ArrayList<Integer>();
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public int[] getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(int[] matriculasAlunos) {
		this.alunosMatriculados = matriculasAlunos;
	}

	public int[] getFaltasAlunos() {
		return faltasAlunos;
	}

	public void setFaltasAlunos(int[] faltasAlunos) {
		this.faltasAlunos = faltasAlunos;
	}

	public double[][] getNotasAlunos() {
		return notasAlunos;
	}

	public void setNotasAlunos(double[][] notasAlunos) {
		this.notasAlunos = notasAlunos;
	}

	
	public ArrayList<Integer> getSolicitacoes() {
		return solicitacoes;
	}
	

	public void setSolicitacoes(int solicitacao) {
		this.solicitacoes.add(solicitacao);
	}

	


	
}