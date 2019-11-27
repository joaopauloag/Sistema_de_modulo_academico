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
		notasAlunos = new double[30][4];
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
	
	public int getAluno(int i) {
		return alunosMatriculados[i];
	}

	public void setAlunosMatriculados(int alunoMatriculado) {
		for(int i = 0; i < alunosMatriculados.length; i++) {
			if(alunosMatriculados[i] == 0) {
				alunosMatriculados[i] = alunoMatriculado;
				return;
			}
		}
	}

	public boolean alunosMatriculadosCheio() {
		return(alunosMatriculados[29] != 0);
	}
	
	public int[] getFaltasAlunos() {
		return faltasAlunos;
	}
	
	public int getFaltaAluno(int i) {
		return faltasAlunos[i];
	}

	public void setFaltasAlunos(int[] faltasAlunos) {
		this.faltasAlunos = faltasAlunos;
	}
	
	public void setFalta(int i) {
		this.faltasAlunos[i]++;
	}

	public double[][] getNotasAlunos() {
		return notasAlunos;
	}
	
	public double getNotaAluno(int aluno, int avaliacao) {
		return this.notasAlunos[aluno][avaliacao];
	}

	public void setNotasAlunos(double[][] notasAlunos) {
		this.notasAlunos = notasAlunos;
	}
	
	public void setNotaAluno(int aluno, int avaliacao, double nota) {
		this.notasAlunos[aluno][avaliacao] = nota;
	}
	
	public ArrayList<Integer> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(int solicitacao) {
		this.solicitacoes.add(solicitacao);
	}

	
}