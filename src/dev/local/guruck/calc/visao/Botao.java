package dev.local.guruck.calc.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Botao extends JButton {

	private static final long serialVersionUID = -1621098989356445735L;
	private final Color QUASE_BRANCO = new Color(250,250,250);
	public Botao(String texto, Color cor) {
		setText(texto);
		setOpaque(true);
		setBackground(cor);
		setFont(new Font("Script",Font.PLAIN,20));
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		setForeground(QUASE_BRANCO);
	}
}
