package inicial.excecao;

public class Basico {

	public static void main(String[] args) {
		Aluno a1 = null;
		try {
			imprimirNomeAluno(a1); //java.lang.NullPointerException
		} catch (Exception e) {
			System.out.println("ERRO: "+e.getMessage());
			e.printStackTrace();
		}
		try {
			System.out.println(7/0); // java.lang.ArithmeticException
		} catch (ArithmeticException e1) {
			System.out.println("ERRO: "+e1.getMessage());
		} catch (Exception e2) {
			System.out.println("ERRO: "+e2.getMessage());
		}
		System.out.println("fim");
	}

	public static void imprimirNomeAluno(Aluno aluno) {
		System.out.println(aluno.nome);
	}
}
