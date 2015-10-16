package personajes;

import personajes.Personaje;
import juego.direccion.*;

public class Pajaro extends Personaje {
	private static final double velocidad=20; // Debe usarse para el mover // Hay que darle un valor
	private static boolean enJuego;
	public Direccion direccion;
	
	/*
	public obtnerProximaPosicion(Posicion p)
	return p.getX -1...
	
	s
	
	
	
	};

	direccion d;*/ // DE VANESSA
	//----------------CREAR-------------------
	public Pajaro (){
		setEnJuego(true);//Pone un nuevo pajaro
		setAleatorio(Math.random()*100);//Sortea para ver si sale de la izquierda o la derecha
		if (getAleatorio() < 50){
			Pajaro.setX(0);//Pajaro empieza en la izquierda
			d = direccion.DERECHA;
			System.out.print("Salio un pajaro desde la izquierda");
		}else{
			Pajaro.setX(4);//Pajaro empieza en la derecha
			d = direccion.IZQUIERDA;
			System.out.print("Salio un pajaro desde la derecha");
		}
		
		setAleatorio(Math.random()*100);//Sortea en que fila sale
		if (getAleatorio() < 33)
			Pajaro.setY(2 + (Juego.getSeccion() * 3));
			System.out.println(" en el piso 3");
		if (getAleatorio() > 33 && getAleatorio() < 66)
			Pajaro.setY(1 + (Juego.getSeccion() * 3));
			System.out.println(" en el piso 2");
		if (getAleatorio() > 66 && getAleatorio() < 100)
			Pajaro.setY(0 + (Juego.getSeccion() * 3));
			System.out.println(" en el piso 1");
		}

	//--------------ATENDER-----------------
	
	public void atender(int nivel){
		if(enJuego){
			this.mover();
		}else{
			if(Juego.getSeccion() != 0){ //En la primer seccion no salen pajaros
			setAleatorio(Math.random()*100); //Le da un numero double de 1 a 100
			if (getAleatorio() > 70);//Sortea que salga un pajaro (30% de posibilidades)
					Pajaro Pajaro1 = new Pajaro(); //Crea el pajaro (clase aparte)
		
			}
		}
	}


	//-------------MOVER---------------
	
	public  void mover(){
		if (d == direccion.DERECHA){ //PREGUNTAR USO DE ENUMERATIVO PARA IF (!!!)
			if (Pajaro.getX() < 4)
				Pajaro.setX(getX() + 1);
			if (Pajaro.getX() == 4)
				setEnJuego(false); //Si el pajaro tiene direccion para la derecha va sumando uno sobre x hasta que salga del edif
		}else{
			if (Pajaro.getX() > 0)
				Pajaro.setX(getX() - 1);
			if (Pajaro.getX() == 0)
				setEnJuego(false);
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
	

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public boolean isEnJuego() {
		return enJuego;
	}

	public static void setEnJuego(boolean enJuego) {
		enJuego = enJuego;
	}

	public static double getAleatorio() {
		return aleatorio;
	}

	public static void setAleatorio(double d) {
		aleatorio = d;
	}
	
}
