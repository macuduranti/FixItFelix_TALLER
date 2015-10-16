package personajes;

import Personajes.Juego;
import Personajes.Ralph;
import Personajes.personaje;

public class Ladrillo extends personaje {

		private double velocidad;
		public static boolean enJuego;
		
		
		public Ladrillo(){
			setEnJuego(true);
			setX(Ralph.getX());
			setY(Ralph.getY()); //Crea el ladrillo en el mismo lugar donde se encuentra ralph
		}
	
		public static void Atender(int nivel){

			if(enJuego){
				Ladrillo.mover();
			}else{
				setAleatorio(Math.random()*100); //Le da un numero double de 1 a 100
				if (Juego.getNivel() == 1){
					if (getAleatorio() > 80);//Si el nivel es uno las probabilidades de que salga un ladrillo son del 20%
					Ladrillo Ladrillo1 = new Ladrillo(); //Crea el ladrillo
				}
				if (Juego.getNivel() == 2){
					if (getAleatorio() > 70);//Probabilidad del 30%
					Ladrillo Ladrillo1 = new Ladrillo(); //Crea el ladrillo 
				}
				if (Juego.getNivel() == 3){
					if (getAleatorio() > 50);//Si el nivel es uno las probabilidades de que salga un ladrillo son del 50%
					Ladrillo Ladrillo1 = new Ladrillo(); //Crea el ladrillo
			}
		}
	}	
		
		public static void Mover(){
			 if(getY() < 4)
				 setY(getY() + 1);	 
			 else{
				 setEnJuego(false); //Llego al final y hay que sacarlo del juego
			 }
		}
		
	

		public double getVelocidad() {

			return velocidad;
		}
	
		public void setVelocidad(double velocidad) {
			this.velocidad = velocidad;
		}

		public boolean isEnJuego() {
			return enJuego;
		}

		public static void setEnJuego(boolean enJuego) {
			Ladrillo.enJuego = enJuego;
		}
}
