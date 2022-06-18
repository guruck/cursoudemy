package inicial.arrays;

public class Arrays {
	public static void main(String[] args) {
		String[] s = new String[4];
		System.out.println(java.util.Arrays.toString(s));
		
		s[0] = "Primeiro elemento";
		s[1] = "Segundo elemento";
		s[2] = "Terceiro elemento";
		s[3] = "Ultimo elemento";
		
		for (int i =0; i<s.length; i++) {
			System.out.println(s[i]);
		}
		int count = 1;
		int[][] kube = new int[3][5];
		for (int i=0; i<kube.length; i++) {
			for (int j=0; j<kube[i].length; j++) {
				kube[i][j] = count++; 
			}
		}
		for (int i=0; i<kube.length; i++) {
			for (int j=0; j<kube[i].length; j++) {
				System.out.print(zeroPadLeft(kube[i][j]) + "|");
			}
			System.out.println();
		}
		System.out.println("==============");
		for(int[] k : kube) {
			System.out.println(java.util.Arrays.toString(k));
		}

		System.out.println("==============");
		int [] naturais = {1,2,3,4,5,6};
		for (int i : naturais) {
			System.out.print(i + ", ");
		}
	}
	
	public static String zeroPadLeft(int num) {
		return num < 10 ? "0"+num : ""+num;
	}
}
