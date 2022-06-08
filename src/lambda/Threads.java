package lambda;

public class Threads {

	public static void main(String[] args) {
		Runnable t01 = new Trabalho1();
		Runnable t23 = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("tarefa #23");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("tarefa #23 Finalizada!");
			}
		};

//		t01.run();
//		t23.run();
		Runnable t99 = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("tarefa #99");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("tarefa #99 Finalizada!");
		};
		Runnable t89 = Threads::trabalho;
		
		Thread t1 = new Thread(t01);
		Thread t2 = new Thread(t23);
		Thread t3 = new Thread(t99);
		Thread t4 = new Thread(t89);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	static void trabalho() {
		for (int i = 0; i < 10; i++) {
			System.out.println("tarefa #");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("tarefa # Finalizada!");
	}
}
