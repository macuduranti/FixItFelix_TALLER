package personajes;

import java.util.Random;
import java.util.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import juego.Juego;
import personajes.felix.EstadoDeFelix;
import personajes.felix.FelixJR;

public class Pajaro extends Personaje {

	public enum EstadoDePajaro {
		E1, E2
	}

	public enum DireccionPajaro {
		DERECHA, IZQUIERDA
	}

	public DireccionPajaro d;
	public EstadoDePajaro estado;

	// public int height = 22;
	// public int width = 34;
	public double xdouble;
	public double ydouble;

	// ----------------CREAR-------------------
	public Pajaro() {
		this.setHeight(22);
		this.setWidth(34);
		this.setEstado(EstadoDePajaro.E1);
		Random random = new Random(); // Sortea para ver si sale de la izquierda
										// o la derecha

		if ((int) ((random.nextDouble() * 10)) > 5) {
			this.setXdouble(0); // Pajaro empieza en la derecha
			this.setD(DireccionPajaro.DERECHA);
			System.out.print("Salio un pajaro desde la derecha");
		} else {
			this.setXdouble(4); // Pajaro empieza en la izquierda
			this.setD(DireccionPajaro.IZQUIERDA);
			System.out.print("Salio un pajaro desde la izquierda");
		}

		int rnd = (int) (random.nextDouble() * 3);// Sortea en que fila sale
		switch (rnd) {
		case 0:
			this.setYdouble(340);
			System.out.println(" en el piso 3");
			break;
		case 1:
			this.setYdouble(270);
			System.out.println(" en el piso 2");
			break;
		case 2:
			this.setYdouble(200);
			System.out.println(" en el piso 1");
			break;
		}
	}

	@Override
	public void moverDerecha() {
		this.setXdouble(this.getXdouble() + 0.04);
	}

	@Override
	public void moverIzquierda() {
		this.setXdouble(this.getXdouble() - 0.04);
	}

	@Override
	public void atender() {
		Timer timer = new Timer("Volando");
		TaskE1Pajaro e1 = new TaskE1Pajaro(this);
		TaskE2Pajaro e2 = new TaskE2Pajaro(this);
		if (d == DireccionPajaro.DERECHA) {
			if (getXdouble() < 4) {
				if (this.isE1()) {
					timer.schedule(e2, 300);
				} else if (this.isE2()) {
					timer.schedule(e1, 300);
				}
				this.moverDerecha();
			} else {
				this.eliminar();
				if (this.getXdouble() == 4) {
					timer.cancel();
				}
			}

		} else {
			if (getXdouble() > 0) {
				if (this.isE1()) {
					timer.schedule(e2, 300);
				} else if (this.isE2()) {
					timer.schedule(e1, 300);
				}
				this.moverIzquierda();
			} else {
				this.eliminar();
				if (getXdouble() == 0) {
					timer.cancel();
				}
			}

		}
		if (!Juego.getInstance().felix.isInmune() && !Juego.getInstance().felix.isMuerto() && !Juego.getInstance().felix.isTomandoPastel()) {
			if (Juego.getInstance().felix.colision(this)) {
				try {
					Clip clip = AudioSystem.getClip();
			        AudioInputStream ais = AudioSystem.getAudioInputStream(FelixJR.class.getResourceAsStream("/res/sonidos/moriste.wav"));
			        clip.open(ais);
			        clip.loop(0);
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				Juego.getInstance().felix.setEstado(EstadoDeFelix.MUERTO);
				System.out.println("Felix choco con un pajaro");
				this.eliminar();
			}
		}
	}

	@Override
	public void proxSeccion() {
		this.eliminar();
	}

	public void eliminar() {
		Juego.getInstance().listaPersonajes.remove(this);
	}

	@Override
	public void reset() {
		this.eliminar();
	}

	public DireccionPajaro getD() {
		return d;
	}

	public void setD(DireccionPajaro d) {
		this.d = d;
	}

	public EstadoDePajaro getEstado() {
		return estado;
	}

	public void setEstado(EstadoDePajaro estado) {
		this.estado = estado;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getXdouble() {
		return xdouble;
	}

	public void setXdouble(double xdouble) {
		this.xdouble = xdouble;
	}

	public double getYdouble() {
		return ydouble;
	}

	public void setYdouble(double ydouble) {
		this.ydouble = ydouble;
	}

	public boolean isE1() {
		if (this.getEstado() == EstadoDePajaro.E1)
			return true;
		else
			return false;
	}

	public boolean isE2() {
		if (this.getEstado() == EstadoDePajaro.E2)
			return true;
		else
			return false;
	}

	public boolean isDerecho() {
		if (this.getD() == DireccionPajaro.DERECHA)
			return true;
		else
			return false;
	}

	public boolean isIzquierdo() {
		if (this.getD() == DireccionPajaro.IZQUIERDA)
			return true;
		else
			return false;
	}

}
