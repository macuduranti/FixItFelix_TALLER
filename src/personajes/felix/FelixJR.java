package personajes.felix;

import personajes.Personaje;


public class FelixJR extends Personaje {
	
	public EstadoDeFelix estado;
	
	//Constructor de FelixJR
	public FelixJR (){
		
	}
	
	public static void Atender(int nivel) {
		// TODO Auto-generated method stub
		
	}

	public EstadoDeFelix getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeFelix estado) {
		this.estado = estado;
	}
	
	public boolean isMuerto(){
		if (this.getEstado() instanceof Muerto){
			return true;
		}else return false;
	}
	
	public boolean isNormal(){
		if (this.getEstado() instanceof Normal){
			return true;
		}else return false;
	}
	
	public boolean isInmune(){
		if (this.getEstado() instanceof Inmune){
			return true;
		}else return false;
	}
}