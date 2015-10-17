package juego;

public class Puntaje implements Comparable<Puntaje>{
	public int puntos;
	public String nombre;
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
    @Override
    public int compareTo(Puntaje p) {
        if (puntos < p.puntos) {
            return -1;
        }
        if (puntos > p.puntos) {
            return 1;
        }
        return 0;
    }
}
