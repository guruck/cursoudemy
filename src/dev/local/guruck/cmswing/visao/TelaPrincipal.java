package dev.local.guruck.cmswing.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dev.local.guruck.cmswing.modelo.Tabuleiro;

public class TelaPrincipal extends JFrame implements ActionListener{

	/**
	 * Joginho Campo Minado
	 */
	private static final long serialVersionUID = 8854609353663370537L;
	private int bombas = 50;
	private Tabuleiro tabuleiro = new Tabuleiro(16,30,bombas);
	
	public TelaPrincipal() {
		
        setJMenuBar(new MenuDificuldade(tabuleiro));
		add(new PainelTabuleiro(tabuleiro));
		
 		setTitle("Campo Minado");
		setSize(690,438);
		setLocationRelativeTo(null); //Centralizar
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}
   public void actionPerformed( ActionEvent e ) {
	   if ("facil 10".equalsIgnoreCase(e.getActionCommand())) {
		   tabuleiro.setMinas(10);
		   tabuleiro.reiniciar();
	   }else if ("medio 50".equalsIgnoreCase(e.getActionCommand())) {
		   tabuleiro.setMinas(50);
		   tabuleiro.reiniciar();
	   }else if ("dificil 100".equalsIgnoreCase(e.getActionCommand())) {
		   tabuleiro.setMinas(100);
		   tabuleiro.reiniciar();
	   }else if("insano 240".equalsIgnoreCase(e.getActionCommand())) {
		   tabuleiro.setMinas(240);
		   tabuleiro.reiniciar();
	   }
   }
	public static void main(String[] args) {
		new TelaPrincipal();
	}

	
}
