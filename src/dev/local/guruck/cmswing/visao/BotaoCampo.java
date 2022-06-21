package dev.local.guruck.cmswing.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import dev.local.guruck.cmswing.modelo.Campo;
import dev.local.guruck.cmswing.modelo.EventoCampo;
import dev.local.guruck.cmswing.modelo.ObservadorCampo;

public class BotaoCampo extends JButton implements ObservadorCampo, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 927369196259320633L;
	private static final Color BG_PADRAO = new Color(184,184,184);
	private static final Color BG_MARCAR = new Color(8,179,247);
	private static final Color BG_EXPLODIR = new Color(189,66,68);
	private static final Color TEXTO_VERDE = new Color(0,100,0);
	
	private Campo campo;
	
	public BotaoCampo(Campo campo) {
		this.campo = campo;
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		setOpaque(true);
		addMouseListener(this);
		campo.registrarObservador(this);
	}

	@Override
	public void eventoOcorreu(Campo campo, EventoCampo evento) {
		
		switch (evento) {
		case ABRIR:
			aplicarEstiloAbrir();
			break;
		case MARCAR:
			aplicarEstiloMarcar();
			break;
		case EXPLODIR:
			aplicarEstiloExplodir();
			break;
		default:
			aplicarEstiloPadrao();
			break;
		}
		SwingUtilities.invokeLater(() -> {
			repaint();
			validate();
		});
		
	}

	private void aplicarEstiloExplodir() {
		setBackground(BG_EXPLODIR);
		setText("X");
	}

	private void aplicarEstiloPadrao() {
		setBorder(BorderFactory.createBevelBorder(0));
		setBackground(BG_PADRAO);
		setText("");
	}

	private void aplicarEstiloMarcar() {
		setBackground(BG_MARCAR);
		setForeground(Color.BLACK);
		setText("!");
	}

	private void aplicarEstiloAbrir() {
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		setBackground(BG_PADRAO);
		switch (campo.minasNaVizinhanca()) {
		case 1:
			setForeground(TEXTO_VERDE);
			break;
		case 2:
			setForeground(Color.BLUE);
			break;
		case 3:
			setForeground(Color.YELLOW);
			break;
		case 4:
		case 5:
		case 6:
			setForeground(Color.RED);
			break;
		default:
			setForeground(Color.PINK);
			break;
		}
		
		String valor = !campo.vizinhancaSegura() ? Integer.toString(campo.minasNaVizinhanca()) : "" ;
		setText(valor);
		if (campo.isMinado()&&campo.isMarcado()) {
			setBackground(Color.WHITE);
			setForeground(BG_EXPLODIR);
			setText("@");
		}else if (campo.isMinado()&&!campo.isMarcado()) {
			setBackground(BG_EXPLODIR);
			setForeground(Color.WHITE);
			setText("*");
		};
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==1) {
			campo.abrir();
		}else{
			campo.alternarMarcacao();
		}
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	


}
