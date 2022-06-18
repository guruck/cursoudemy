package inicial.excecao;

public class Causa {

	public static void main(String[] args) {
		Aluno a1 = null;
		try {
			metodoA(a1);
		} catch (Exception e) {
			if(e.getCause() != null) {
				System.out.println(e.getCause().getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void metodoA(Aluno aluno) {
		try {
			metodoB(aluno);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static void metodoB(Aluno aluno) {
		if (aluno == null) {
			throw new NullPointerException("Aluno Esta NULOOOOOO");
		}
		System.out.println(aluno.nome);
	}
}
