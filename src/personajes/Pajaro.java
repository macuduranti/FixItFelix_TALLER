package personajes;


public class Pajaro extends Personaje {
	private static boolean enJuego;
	private enum direccion {DERECHA, IZQUIERDA}
	private double aleatorio;
		
	direccion d;
	//----------------CREAR-------------------
	public Pajaro (int seccion){
		setEnJuego(true);	//Pone un nuevo pajaro
		setAleatorio(Math.random()*100);	//Sortea para ver si sale de la izquierda o la derecha
		if (getAleatorio() < 50){
			setX(0);	//Pajaro empieza en la izquierda
			d = direccion.DERECHA;
			System.out.print("Salio un pajaro desde la izquierda");
		}else{
			setX(4);	//Pajaro empieza en la derecha
			d = direccion.IZQUIERDA;
			System.out.print("Salio un pajaro desde la derecha");
		}
		
		setAleatorio(Math.random()*100);//Sortea en que fila sale
		if (getAleatorio() < 33)
			this.setY(2 + (seccion * 3));
			System.out.println(" en el piso 3");
		if (getAleatorio() > 33 && getAleatorio() < 66)
			this.setY(1 + (seccion * 3));
			System.out.println(" en el piso 2");
		if (getAleatorio() > 66 && getAleatorio() < 100)
			this.setY(0 + (seccion * 3));
			System.out.println(" en el piso 1");
		}

	//--------------SORTEAR-----------------
	
	public boolean sortear(int nivel, int seccion){	
		if(seccion != 0){ 	//En la primer seccion no salen pajaros
			setAleatorio(Math.random()*100); //Le da un numero double de 1 a 100
			if (getAleatorio() > 70);//Sortea que salga un pajaro (30% de posibilidades)
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
		return enJuego;
	}

	public static void setEnJuego(boolean juego) {
		enJuego = juego;
	}

	public double getAleatorio() {
		return aleatorio;
	}


	public void setAleatorio(double aleatorio) {
		this.aleatorio = aleatorio;
	}

	@Override
	public void atender(int nivel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void proxSeccion(int seccion) {
		Pajaro.setEnJuego(false);
		
	}

}
