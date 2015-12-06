package personajes;
import java.util.Timer;
import ventana.DosPaneles;
import juego.Juego;
import juego.Niceland;
import juego.Posicion;

public class Nicelander extends Personaje {
	private boolean flag;
	
	public Nicelander(int x, int y) { 
		this.posicion=new Posicion(x,y);
		((DosPaneles)Niceland.getInstance().edificio[x][y]).setNicelander(true);
		this.flag = true;
	}

	@Override
	public void atender() {
		if (this.flag){
			Timer t = new Timer("Nicelandereando");
			TaskDejarPastel tdp = new TaskDejarPastel(this,t);
			t.schedule(tdp, 3000);
			this.flag=false;
		}
	}
	
	public void eliminar(){
		Juego.getInstance().listaPersonajes.remove(this);
	}

	@Override
	public void proxSeccion() {
		this.eliminar();
	}

	@Override
	public void reset() {
	}

}