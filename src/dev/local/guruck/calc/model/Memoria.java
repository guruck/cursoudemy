package dev.local.guruck.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	private enum TipoComando{
		RESET, NUMERO, DIV, MLT, SUB, SOM, EQL, DEC, PRC, SINAL;
	};
	
	private static final Memoria instancia = new Memoria();
	private final List<MemoriaObservador> observadores = new ArrayList<>();
	
	private TipoComando ultimaOperacao = null;
	private Boolean substituir = false;
	private String textoAtual = "";
	private String textoBuffer = "";
	
	private Memoria() {}

	public static Memoria getInstancia() {
		return instancia;
	}

	public void addObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}
	
	public String getTextoAtual() {
		return this.textoAtual.isEmpty()? "0":this.textoAtual;
	}
	
	public void resetTextoAtual() {
		this.textoAtual = "";
		this.textoBuffer = "";
		this.substituir = false;
		this.ultimaOperacao = null;
	}
	
	public void processarComando(String textoRecebido) {
		TipoComando tipo = detectarTipoComando(textoRecebido);
		if (tipo==null) return;
		else if(tipo==TipoComando.RESET) resetTextoAtual();
		else if((tipo==TipoComando.NUMERO) || (tipo==TipoComando.DEC)) {
			this.textoAtual = substituir ? textoRecebido : this.textoAtual + textoRecebido;
			substituir = false;
		}else if(tipo==TipoComando.SINAL) {
			this.textoAtual = this.textoAtual.contains("-")? this.textoAtual.replace("-","") : "-" + this.textoAtual;
		}else {
			this.substituir = true;
			this.textoAtual = obterResultadoOperacao(tipo);
			this.textoBuffer = this.textoAtual;
			this.ultimaOperacao = tipo;
		}
		observadores.forEach(o -> o.valorAlterado(this.getTextoAtual()));
	}
	private String obterResultadoOperacao(TipoComando tipo) {
		if (this.ultimaOperacao == null || this.ultimaOperacao == TipoComando.EQL|| this.ultimaOperacao == TipoComando.PRC)return this.textoAtual;
		Double numeroBuffer = Double.parseDouble(this.textoBuffer.replace(",","."));
		Double numeroAtual = Double.parseDouble(this.textoAtual.replace(",","."));
		if(tipo==TipoComando.PRC) 
			numeroAtual = numeroBuffer * (numeroAtual/ 100);
		Double resultado = 0.0;
		if (this.ultimaOperacao == TipoComando.SOM) resultado = numeroBuffer + numeroAtual;
		else if (this.ultimaOperacao == TipoComando.SUB) resultado = numeroBuffer - numeroAtual;
		else if (this.ultimaOperacao == TipoComando.MLT) resultado = numeroBuffer * numeroAtual;
		else if (this.ultimaOperacao == TipoComando.DIV) resultado = numeroBuffer / numeroAtual;
		String retorno = String.valueOf(resultado).replace(".", ",");
		boolean inteiro = retorno.endsWith(",0");
		return inteiro ? retorno.replace(",0", "") : retorno; 
	}
	
	private TipoComando detectarTipoComando(String textoRecebido) {
		if (textoRecebido.equals("0") && this.textoAtual.isEmpty()) return null;
		try {
			Integer.parseInt(textoRecebido);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			
			if (textoRecebido.equals(",") && this.textoAtual.contains(",") && !this.substituir) return null;
			else if(textoRecebido.equals(",")){
				return TipoComando.DEC;
			}
			
			else if (textoRecebido.equals("AC")) return TipoComando.RESET;
			else if (textoRecebido.equals("+/-")) return TipoComando.SINAL;
			else if (textoRecebido.equals("%")) return TipoComando.PRC;
			else if (textoRecebido.equals("÷")) return TipoComando.DIV;
			else if (textoRecebido.equals("x")) return TipoComando.MLT;
			else if (textoRecebido.equals("+")) return TipoComando.SOM;
			else if (textoRecebido.equals("-")) return TipoComando.SUB;
			else if (textoRecebido.equals("=")) return TipoComando.EQL;
		}
		return null;
	};
	
	
}
