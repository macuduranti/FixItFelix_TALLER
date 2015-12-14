package juego;

import java.io.Serializable;
import java.util.Comparator;

public class Puntaje implements Serializable{
	public int puntos;
	public String nombre;
	
	public Puntaje(){
		this.setPuntos(000000);
		this.setNombre(null);
	}
	
	public Puntaje(int n, String s){
		this.setNombre(s);
		this.setPuntos(n);
	}
	
	
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
	
	/* @Override
    public int compareTo(Puntaje p) {
        if (puntos < p.puntos) {
            return -1;
        }
        if (puntos > p.puntos) {
            return 1;
        }
        return 0;
    }
    */

	public static Comparator<Puntaje> getCompartor() {
		// TODO Auto-generated method stub
		return new Comparator<Puntaje>(){
			public int compare(Puntaje p1, Puntaje p2) {
				
				return new Integer(p2.getPuntos()).compareTo(new Integer(p1.getPuntos()));
			}
		};
	}
}
