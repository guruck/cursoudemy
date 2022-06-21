package dev.local.guruck.cmswing.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dev.local.guruck.cmswing.modelo.Tabuleiro;

public class PainelTabuleiro extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7758009414376116665L;

	public PainelTabuleiro(Tabuleiro tabuleiro) {

		setLayout(new GridLayout(tabuleiro.getLinhas(),tabuleiro.getColunas()));
		
		tabuleiro.forEachCampo(c -> add(new BotaoCampo(c)));
		tabuleiro.registrarObservador(e -> {
		
			SwingUtilities.invokeLater(() -> {
				if (e == true) {
					JOptionPane.showMessageDialog(this, "Vitoria");
				}else {
					JOptionPane.showMessageDialog(this,"Tente Novamente");
				}
				tabuleiro.reiniciar();
			});
			
		});
	}

}
