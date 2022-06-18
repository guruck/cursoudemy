package inicial.streams;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public interface Utils {
		
		public final static Consumer<String> print = System.out::print;
		public final static UnaryOperator<String> maiuscula = n -> n.toUpperCase();
		public final static UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + " ";
		public static String grito(String n){
			 return n + "!!!";
		}
}

