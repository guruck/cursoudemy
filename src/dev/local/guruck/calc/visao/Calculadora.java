package dev.local.guruck.calc.visao;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = -6332018638151953590L;
	//private static final Color BG_PURPLE = new Color(128,0,247);
	
	public Calculadora() {
		organizarLayout();
//		setUndecorated(true);
 		setTitle("Calculadora");
		setSize(232,322);
		setLocationRelativeTo(null); //Centralizar
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private void organizarLayout() {
		setLayout(new BorderLayout());
		Display display = new Display();
		
		add(display,BorderLayout.NORTH);
		
		Teclado teclado = new Teclado();
		add(teclado,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new Calculadora();
	}

}
