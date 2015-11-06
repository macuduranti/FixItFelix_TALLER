package personajes;

import java.util.Random;

import juego.Juego;

public class Pajaro extends Personaje {
	private boolean enJuego;
	private enum direccion {DERECHA, IZQUIERDA}
	private int posLista;
		
	direccion d;
	//----------------CREAR-------------------
	public Pajaro (){
		setEnJuego(true);	//Pone un nuevo pajaro
		Random random = new Random();	//Sortea para ver si sale de la izquierda o la derecha
		if ((int) random.nextDouble()*10 > 5){
			setX(0);	//Pajaro empieza en la izquierda
			d = direccion.DERECHA;
			System.out.print("Salio un pajaro desde la izquierda");
		}else{
			setX(4);	//Pajaro empieza en la derecha
			d = direccion.IZQUIERDA;
			System.out.print("Salio un pajaro desde la derecha");
		}
		
		int rnd = (int) random.nextDouble()*3;//Sortea en que fila sale
		switch (rnd) {
		case 0:
			this.setY(2 + (Juego.getInstance().getSeccion() * 3));
			System.out.println(" en el piso 3");
			break;
		case 1:
			this.setY(1 + (Juego.getInstance().getSeccion() * 3));
			System.out.println(" en el piso 2");
			break;
		case 2:
			this.setY(0 + (Juego.getInstance().getSeccion() * 3));
			System.out.println(" en el piso 1");
			break;
		default:
			break;
		}
		}

	//--------------SORTEAR-----------------
@Deprecated
	public boolean sortear(int nivel, int seccion){	
		Random random = new Random();
		if(seccion != 0){ 	//En la primer seccion no salen pajaros
			if ((int) random.nextDouble()*100 > 70);//Sortea que salga un pajaro (30% de posibilidades)
					return true;
		}
		return false;
}


	//-------------MOVER---------------
	
	public  void mover(){
		if (d == direccion.DERECHA){ 
			if (getX() < 4)
				this.moverDerecha();
			if (getX() == 4)
				setEnJuego(false); //Si el pajaro tiene direccion para la derecha va sumando uno sobre x hasta que salga del edif
		}else{
			if (getX() > 0)
				this.moverIzquierda();
			if (getX() == 0)
				setEnJuego(false);
		}
	}

	public boolean isEnJuego() {
		return this.enJuego;
	}

	public void setEnJuego(boolean juego) {
		this.enJuego = juego;
	}

	@Override
	public void atender() {
		// TODO Auto-generated method stub
	}

	@Override
	public void proxSeccion() {
		this.eliminar();		
	}
	
	public void eliminar(){
		this.setEnJuego(false);
		Juego.getInstance().listaPajaros.remove(this.getPosLista());
	}

	public int getPosLista() {
		return posLista;
	}

	public void setPosLista(int posLista) {
		this.posLista = posLista;
	}

}
