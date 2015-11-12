package ventana;

import juego.Direccion;
import ventana.panel.Panel;

public abstract class Ventana {
		public Panel[] paneles;
		public abstract boolean arreglarVentana();
		public abstract boolean romperVentana();
		public abstract boolean puedoPasarDesde(Direccion d); // Se debe llamar con la proxima
		public abstract boolean puedoPasarHacia(Direccion d); // Se debe llamar con la actual
		public abstract boolean puedeAparecerNicelander();
}
