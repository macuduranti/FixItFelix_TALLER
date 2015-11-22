package ventana.panel;


public class Panel {
	public EstadoPanel estado;

	public Panel(){
		this.setEstado(new Sano());
	}
	
	public EstadoPanel getEstado() {
		return estado;
	}

	public void setEstado(EstadoPanel estado) {
		this.estado = estado;
	}
	public boolean isSano(){
		if (this.getEstado() instanceof Sano){
			return true;
		}else return false;
	}
	public boolean isParcRoto(){
		if (this.getEstado() instanceof ParcRoto){
			return true;
		}else return false;
	}
	public boolean isRoto(){
		if (this.getEstado() instanceof Roto){
			return true;
		}else return false;
	}

	public boolean arreglar() {
		return this.estado.puedoArreglar(this);
		
	}

	public boolean romper() {
		return this.estado.puedoRomper(this);
	}
}
