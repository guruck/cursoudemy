package dev.local.guruck.cmswing.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import dev.local.guruck.cmswing.modelo.Tabuleiro;

public class MenuDificuldade extends JMenuBar implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3601740718786481474L;
	private Tabuleiro tabuleiro;
	
	public MenuDificuldade(Tabuleiro tabuleiro){
		this.tabuleiro = tabuleiro;
		JMenu fileMenu = new JMenu("Dificuldade");
	    JMenuItem facilAction = new JMenuItem("Facil 10");
	    JMenuItem medioAction = new JMenuItem("Medio 50");
	    JMenuItem dificilAction = new JMenuItem("Dificil 100");
	    JMenuItem insanoAction = new JMenuItem("Insano 240");
	    
	    facilAction.addActionListener(this);
	    medioAction.addActionListener(this);
	    dificilAction.addActionListener(this);
	    insanoAction.addActionListener(this);
	    
	    fileMenu.add(facilAction);
	    fileMenu.add(medioAction);
	    fileMenu.add(dificilAction);
	    fileMenu.add(insanoAction);
    
	    setName("Dificultade");
	    add(fileMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
}