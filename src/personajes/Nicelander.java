package personajes;

import java.util.Random;

import juego.Juego;

public class Nicelander extends Personaje {
	private boolean enJuego;
	private int posLista;
	private int oportunidades = 3;

	public Nicelander(int posX, int posY) { 
		this.setEnJuego(true);
		this.setX(posX);
		this.setY(posY);
	}

	private boolean sortearPastel() {
		Random random = new Random();
		if ((int) random.nextDouble() * 10 > 5) {
			Pastel pastel = new Pastel(this.getX(), this.getY());
			Juego.getInstance().listaPasteles.add(pastel);
			pastel.setPosLista(Juego.getInstance().listaPasteles.size());
			System.out.println("Y se porto el chabon, dejo un pastel!!");
			return true;
		} else
			return false;
	}

	@Override
	public void atender() {
		while (this.getOportunidades() > 0) {
			if (this.sortearPastel())
				this.eliminar();
			else
				this.setOportunidades(this.getOportunidades() - 1);
		}
		if (this.getOportunidades() == 0){
			this.eliminar();
		}
	}
	
	public void eliminar(){
		this.setEnJuego(false);
		Juego.getInstance().listaPajaros.remove(this.getPosLista());
	}

	@Override
	public void proxSeccion() {
		this.eliminar();
	}

	public int getPosLista() {
		return posLista;
	}

	public void setPosLista(int posLista) {
		this.posLista = posLista;
	}

	public int getOportunidades() {
		return oportunidades;
	}

	public void setOportunidades(int oportunidades) {
		this.oportunidades = oportunidades;
	}

	public boolean isEnJuego() {
		return enJuego;
	}

	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}

}