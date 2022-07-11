package dev.local.guruck.calc.visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.local.guruck.calc.model.Memoria;
import dev.local.guruck.calc.model.MemoriaObservador;

public class Display extends JPanel implements MemoriaObservador{

	private static final long serialVersionUID = -1742031543531909782L;
	private final Color CINZA_MAIS_ESCURO = new Color(48,48,48);
	private final JLabel label;
	
	public Display() {
		Memoria.getInstancia().addObservador(this);
		
		label = new JLabel(Memoria.getInstancia().getTextoAtual());
		setPreferredSize(new Dimension(232,60));
		setBackground(CINZA_MAIS_ESCURO);
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Script",Font.PLAIN,30));
		setLayout(new FlowLayout(FlowLayout.RIGHT,10,25));
		add(label);
	}

	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
	}

}
