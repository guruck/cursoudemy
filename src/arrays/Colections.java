package arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Colections {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		/**
		 * SET / SortedSet / TreeSet (aceita ordenação na ordem de inserção) / HashSet 
		 * 	-> não ordenado
		 * 	-> não indexado
		 * 	-> não aceita repetição
		 * 	-> pode ser ordenado
		 * 	-> pode ser heterogêneo (ruim) ou homogênio (preferível)
		 * 
		 * LIST
		 * 	-> indexada
		 * 	-> aceita repetição
		 *  -> é ordenado
		 *  -> é indexado
		 * 
		 * MAP
		 * 	-> chave/valor
		 * 	-> chave não aceita repetição
		 * 	-> valor aceita repetição
		 * 
		 * QUEUE
		 * 	-> implementa fila
		 * 	-> first in / first out (FIFO)
		 * 
		 * STACK
		 * 	-> implementa pilha
		 * 	-> Last in / First out (LIFO)
		 */
		
		System.out.println("--Set----------------------------------");
		// conjunto heterogenio
		HashSet conjunto = new HashSet();
		Set conjunto2 = new HashSet();
		conjunto.add(11);
		conjunto.add(true);
		conjunto.add("teste");
		conjunto.add('x');
		System.out.println("removendo: " + conjunto.remove("Teste"));
		System.out.println("esta contido? " + conjunto.contains("teste"));
		conjunto2.addAll(conjunto);
		System.out.println("A: "+ conjunto);
		
		// conjunto homogênio
		Set<Integer> cnjInteger = new HashSet<Integer>();
		cnjInteger.add(11);
		cnjInteger.add(1);
		cnjInteger.add(1);
		cnjInteger.add(3);
		cnjInteger.add(1);
		cnjInteger.add(18);
		
		// conjunto ordenado
		SortedSet<Integer> cnjInteger2 = new TreeSet<Integer>();
		for(Integer num: cnjInteger) {
			cnjInteger2.add(num);
		}

		System.out.println("B: "+ cnjInteger2);
		System.out.println("tamanho do conjunto é: " + cnjInteger.size());
		
		conjunto.addAll(cnjInteger);
		System.out.println("A UNION B: "+ conjunto);
		
		conjunto2.retainAll(cnjInteger);
		System.out.println("A INTERSECT B: "+ conjunto2);
		System.out.println("--Lista----------------------------------");
		
		List<Usuario> users = new ArrayList<>();
		users.add(new Usuario("Jonas"));
		users.add(new Usuario("Pedro"));
		users.add(new Usuario("Carlos"));
		users.add(new Usuario("Matias"));
		users.add(new Usuario("Ana"));
		
		System.out.println("id (2): " + users.get(2));
		System.out.println("removendo: " + users.remove(4));
		System.out.println("removendo2: " + users.remove(new Usuario("Pedro")));
		System.out.println("contido Carlos?: " + users.contains(new Usuario("Carlos")));
		for (Usuario user: users) {
			System.out.print(user.getNome()+"|");
		}
		System.out.println("");
		
		System.out.println("--Fila----------------------------------");
		Queue<String> fila = new LinkedList<>();
		fila.add("Jonas"); 	 //adiciona e gera exceção no caso de fila cheia
		fila.offer("Pedro"); // não adiciona, retornando false se a fila estiver cheia
		fila.add("Carlos");
		fila.offer("Matias");
		fila.add("Ana");
		fila.offer("Matias");
		
		System.out.println(fila.peek());	// não tira da fila e retorna false se não tiver ninguem
		System.out.println(fila.poll());	// remove o elemento da fila e retorna false se não tiver ninguem

		System.out.println(fila.element()); // não tira da fila e gera exceção no caso de fila vazia
		System.out.println(fila.remove());  // remove o elemento da fila, gera exceção no caso de fila vazia
		System.out.println(fila.size() + "|" + fila.isEmpty());
		// fila.clear(); fila.contains("XPTO");;;
		
		System.out.println("--Pilha----------------------------------");
		Deque<String> livros = new ArrayDeque<>();
		livros.add("O pequeno Principe");
		livros.push("Senhor dos Aneis");
		livros.add("Engenharia");
		
		System.out.println(livros.peek());
		System.out.println(livros.element());
		
		System.out.println(livros.poll());
		System.out.println(livros.remove());
		System.out.println(livros.pop());
		
		System.out.println("--Mapa----------------------------------");
		Map<Integer, String> mapa = new HashMap<Integer, String>();
		mapa.put(1, "mapa01");
		mapa.put(21, "mapa02");
		mapa.put(11, "mapa03");
		mapa.put(4, "mapa04");
		
		System.out.println(mapa.size());
		System.out.println(mapa.isEmpty());
		
		System.out.println(mapa.keySet());
		System.out.println(mapa.values());
		System.out.println(mapa.entrySet());
		
		System.out.println(mapa.containsValue("mapa03"));
		System.out.println(mapa.containsKey(21));
		
		System.out.println(mapa.get(4));
		
		for (int chave : mapa.keySet())
		{
			System.out.println(chave);
		}
		
		for (Entry <Integer, String> registro: mapa.entrySet()) {
			System.out.print(registro.getKey() + " |=>>> ");
			System.out.println(registro.getValue());
		};	
		
	}
}
