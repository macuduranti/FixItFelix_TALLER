package ventana.panel;

public class Sano extends EstadoPanel{

	@Override
	public boolean puedoArreglar(Panel panel) {
		return false;
	}
	
	@Override
	public boolean puedoRomper(Panel panel) {
		panel.setEstado(new ParcRoto());
		return true;
	}

}
