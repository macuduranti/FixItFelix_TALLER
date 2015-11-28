package test;

import grafica.PantallaPrincipal;

public class Test{

	public static void main(String[] args) {
		
		try {
			PantallaPrincipal frame = new PantallaPrincipal();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
