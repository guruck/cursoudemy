package dev.local.guruck.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.local.guruck.cm.excecao.ExplosaoException;

public class TesteCampo {
	
	private Campo campo;
	private List<Campo> vizinhosDiagonal;
	private List<Campo> vizinhosHorizontalVertical;
	private List<Campo> naoVizinhos;
	
	BinaryOperator<Long> somatorio = (a,n) -> a+n;
	Function<Campo, Long> getMinas = a -> {
		long teste = a.minasNaVizinhanca();
//		System.out.println(a.getLinha() +","+a.getColuna()+" => "+teste);
		return teste;
	};
	private boolean resultado;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3,3);
		naoVizinhos = Arrays.asList(new Campo(1,1),new Campo(1,2),new Campo(1,4),new Campo(2,1),new Campo(4,5),new Campo(5,2));
		vizinhosDiagonal = Arrays.asList(new Campo(2,2),new Campo(2,4),new Campo(4,2),new Campo(4,4));
		vizinhosHorizontalVertical = Arrays.asList(new Campo(2,3),new Campo(3,2),new Campo(3,4),new Campo(4,3));
	}
	void adicionarVizinhos(List<Campo> listaA, List<Campo> listaB ) {
		for (int x = 0;x<listaA.size();x++) {
			for (int y = 0;y<listaB.size();y++) {
				listaA.get(x).adicionarVisinho(listaB.get(y));
				listaB.get(y).adicionarVisinho(listaA.get(x));
			}
		}
	}
	void adicionarVizinhos(List<Campo> listaA ) {
		for (int x = 0;x<listaA.size()-1;x++) {
			for (int y = x+1;y<listaA.size();y++) {
//				System.out.println("x = " + listaA.get(x).getLinha() +":" + listaA.get(x).getColuna() + "<<==>> y = " + listaA.get(y).getLinha() +":" + listaA.get(y).getColuna());
				
				listaA.get(x).adicionarVisinho(listaA.get(y));
				listaA.get(y).adicionarVisinho(listaA.get(x));
			}
		}
	}
	void adicionarVizinhos(Campo campo, List<Campo> listaB ) {
		for (int x = 0;x<listaB.size();x++) {
				listaB.get(x).adicionarVisinho(campo);
				campo.adicionarVisinho(listaB.get(x));
		}
	}
	void adicionaVizinhos() {
		
		adicionarVizinhos(naoVizinhos,vizinhosHorizontalVertical);
		adicionarVizinhos(naoVizinhos,vizinhosDiagonal);
		adicionarVizinhos(vizinhosHorizontalVertical,vizinhosDiagonal);
		
		adicionarVizinhos(naoVizinhos);
		adicionarVizinhos(vizinhosHorizontalVertical);
		adicionarVizinhos(vizinhosDiagonal);
		
		adicionarVizinhos(campo,vizinhosHorizontalVertical);
		adicionarVizinhos(campo,vizinhosDiagonal);
		adicionarVizinhos(campo,naoVizinhos);
	}

	@Test
	void testeVizinhoRealDistanciaHorizontalVertical() {
		resultado = true;
		for (Campo vizinho : vizinhosHorizontalVertical) {
			resultado = resultado && campo.adicionarVisinho(vizinho);
		}
		assertTrue(resultado);
	}
	@Test
	void testeVizinhoRealDistanciaDiagonal() {
		resultado = true;
		for (Campo vizinho : vizinhosDiagonal) {
			resultado = resultado && campo.adicionarVisinho(vizinho);
		}
		assertTrue(resultado);
	}
	@Test
	void testeNaoVizinho() {
		resultado = false;
		for (Campo vizinho : naoVizinhos) {
			resultado = resultado || campo.adicionarVisinho(vizinho);
		}
		assertFalse(resultado);
	}
	@Test
	void testeMarcacaoDefault() {
		assertFalse(campo.isMarcado());
	}
	@Test
	void testeReiniciarDefault() {
		campo.minar();
		campo.alternarMarcacao();
		campo.reiniciar();
		resultado = (campo.isMarcado() || campo.isAberto() || campo.isMinado());
		assertFalse(resultado);	
	}
	@Test
	void testeReiniciarDefault3() {
		campo.abrir();
		campo.reiniciar();
		resultado = campo.isMarcado() || campo.isAberto() || campo.isMinado();
		assertFalse(resultado);	
	}
	@Test
	void testeIsMinado() {
		campo.minar();
		assertTrue(campo.isMinado());	
	}
	@Test
	void testeIsFechado() {
		assertTrue(campo.isFechado());	
	}
	@Test
	void testeNotIsFechado() {
		campo.abrir();
		assertFalse(campo.isFechado());	
	}
	@Test
	void testeIsAberto() {
		assertFalse(campo.isAberto());	
	}
	@Test
	void testeNotIsMinado() {
		assertFalse(campo.isMinado());	
	}
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	@Test
	void testeAlternarMarcacaoDuasVezes() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	@Test
	void testeGetLinha() {
		assertTrue(campo.getLinha()==3);
	}
	@Test
	void testeGetColuna() {
		assertTrue(campo.getColuna()==3);
	}
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, ()->{
			campo.abrir();
		});
	}
	@Test
	void testeFechadosDefault() {

		adicionaVizinhos();
		resultado = false;
		for (Campo vizinho : naoVizinhos) {
			resultado = resultado || vizinho.isAberto();
		}
		for (Campo vizinho : vizinhosDiagonal) {
			resultado = resultado || vizinho.isAberto();
		}
		for (Campo vizinho : vizinhosHorizontalVertical) {
			resultado = resultado || vizinho.isAberto();
		}
		assertFalse(resultado);
	}
	@Test
	void testeAbrirComVizinhosDefault() {
		adicionaVizinhos();
		campo.abrir();
		resultado = true;
		for (Campo vizinho : naoVizinhos) {
			resultado = resultado && vizinho.isAberto();
		}
		for (Campo vizinho : vizinhosDiagonal) {
			resultado = resultado && vizinho.isAberto();
		}
		for (Campo vizinho : vizinhosHorizontalVertical) {
			resultado = resultado && vizinho.isAberto();
		}
		assertTrue(resultado);
	}

//	campo = (3,3);
//	naoVizinhos = {(1,1),(1,2),(1,4),(2,1),(4,5),(5,2)}
//	vizinhosDiagonal = {(2,2),(2,4),(4,2),(4,4)}
//	vizinhosHorizontalVertical = {(2,3),(3,2),(3,4),(4,3);

	@Test
	void testeAbrirComVizinhosMinado() {

		naoVizinhos.get(1).minar();
		adicionaVizinhos();
		campo.abrir();
		
		resultado = true;
		for (int i=2;i<naoVizinhos.size();i++) {
			resultado = resultado && naoVizinhos.get(i).isAberto();
		}
		resultado = resultado && naoVizinhos.get(0).isFechado();
		resultado = resultado && naoVizinhos.get(1).isFechado();
		for (Campo vizinho : vizinhosDiagonal) {
			resultado = resultado && vizinho.isAberto();
		}
		for (Campo vizinho : vizinhosHorizontalVertical) {
			resultado = resultado && vizinho.isAberto();
		}
		assertTrue(resultado);
		
	}
	
	@Test
	void testeQuantasMinasComVizinhosMinado() {
		naoVizinhos.get(1).minar();
		adicionaVizinhos();
		campo.abrir();

		long minasNaoVizinhos = naoVizinhos.stream().map(getMinas).reduce(somatorio).get();
		long minasVizinhosDiagonal = vizinhosDiagonal.stream().map(getMinas).reduce(somatorio).get();
		long minasVizinhosHorizontalVertical = vizinhosHorizontalVertical.stream().map(getMinas).reduce(somatorio).get();
		assertTrue((minasNaoVizinhos == 2)&&(minasVizinhosDiagonal==minasVizinhosHorizontalVertical));
		
	}
	@Test
	void testeQuantasMinasComVizinhosMinado2() {

		naoVizinhos.get(1).minar();
		vizinhosHorizontalVertical.get(1).minar();
		adicionaVizinhos();
		campo.abrir();

		long minasNaoVizinhos = naoVizinhos.stream().map(getMinas).reduce(somatorio).get();
		long minasVizinhosDiagonal = vizinhosDiagonal.stream().map(getMinas).reduce(somatorio).get();
		long minasVizinhosHorizontalVertical = vizinhosHorizontalVertical.stream().map(getMinas).reduce(somatorio).get();
		assertTrue((campo.minasNaVizinhanca()==1)&&((minasVizinhosHorizontalVertical==minasVizinhosDiagonal)&&(3==minasNaoVizinhos)));
		
	}
	@Test
	void testeObjetivoAlcancadoAberto() {
		campo.abrir();
		assertTrue(campo.ojetivoAlcancado());
	}
	@Test
	void testeObjetivoAlcancadoMinado() {
		campo.minar();
		campo.alternarMarcacao();
		assertTrue(campo.ojetivoAlcancado());
	}
	@Test
	void testeObjetivoNaoAlcancadoMinado() {
		campo.minar();
		assertFalse(campo.ojetivoAlcancado());
	}
	@Test
	void testeObjetivoNaoAlcancadoFechado() {
		assertFalse(campo.ojetivoAlcancado());
	}
	@Test
	void testeToStringDefault() {
		assertTrue(campo.toString().equals("?"));
	}
	@Test
	void testeToStringAberto() {
		campo.abrir();
		assertTrue(campo.toString().equals(" "));
	}
	@Test
	void testeToStringMarcado() {
		campo.alternarMarcacao();
		assertTrue(campo.toString().equals("§"));
	}
	@Test
	void testeToStringAbertoMinado() {
		campo.minar();
		try {
			campo.abrir();
		} catch (ExplosaoException e) {
			assertTrue(campo.toString().equals("*"));
		}
	}
	@Test
	void testeToStringAbertoVizinhoMinado() {
		vizinhosHorizontalVertical.get(1).minar();
		adicionaVizinhos();
		campo.abrir();
		assertTrue(campo.toString().equals("1"));
		
	}
}
