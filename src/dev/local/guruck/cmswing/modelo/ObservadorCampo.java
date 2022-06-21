package dev.local.guruck.cmswing.modelo;

@FunctionalInterface
public interface ObservadorCampo{

	public void eventoOcorreu(Campo campo,EventoCampo  evento); 
	
}
