package dev.local.guruck.calc.visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dev.local.guruck.calc.model.Memoria;

public class Teclado extends JPanel implements ActionListener{

	private static final long serialVersionUID = 5417166244050320108L;

	private final Color CINZA_ESCURO = new Color(68,68,68);
	private final Color LARANJA = new Color(242,163,60);
	public Teclado() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 0, 0, 0);
		c.weightx=1;
		c.weighty=1;
		c.fill=GridBagConstraints.BOTH;
		setBackground(Color.DARK_GRAY);
		setLayout(layout);
		//teste comit
		addBotao("AC",CINZA_ESCURO,c,0,0);
		addBotao("+/-",CINZA_ESCURO,c,1,0);
		addBotao("%",CINZA_ESCURO,c,2,0);
		addBotao("÷",LARANJA,c,3,0);
		addBotao("7",Color.GRAY,c,0,1);
		addBotao("8",Color.GRAY,c,1,1);
		addBotao("9",Color.GRAY,c,2,1);
		addBotao("x",LARANJA,c,3,1);
		addBotao("4",Color.GRAY,c,0,2);
		addBotao("5",Color.GRAY,c,1,2);
		addBotao("6",Color.GRAY,c,2,2);
		addBotao("-",LARANJA,c,3,2);
		addBotao("1",Color.GRAY,c,0,3);
		addBotao("2",Color.GRAY,c,1,3);
		addBotao("3",Color.GRAY,c,2,3);
		addBotao("+",LARANJA,c,3,3);
		c.gridwidth=2;
		addBotao("0",Color.GRAY,c,0,4);
		c.gridwidth=1;
		addBotao(",",Color.GRAY,c,2,4);
		addBotao("=",LARANJA,c,3,4);
	}
	private void addBotao(String label, Color cor, GridBagConstraints c, int x, int y) {
		c.gridy =y;
		c.gridx =x;
		Botao b = new Botao(label,cor);
		b.setPreferredSize(new Dimension(30,30));
		b.addActionListener(this);
		add(b,c);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton botao = (JButton)e.getSource();
			Memoria.getInstancia().processarComando(botao.getText());
		}
	}

}
