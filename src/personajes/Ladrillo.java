package personajes;


public class Ladrillo extends Personaje {

		private double velocidad;
		public static boolean enJuego;
		
		
		public Ladrillo(int x, int y){
			setEnJuego(true);
			setX(x);
			setY(y); //Crea el ladrillo en el mismo lugar donde se encuentra ralph
		}
	
		
		
		public void Mover(){
			 if(getY() > 0)
				 this.moverAbajo();	 
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



		@Override
		public void Atender() {
			// TODO Auto-generated method stub
			
		}
}
