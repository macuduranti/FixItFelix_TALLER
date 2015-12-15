package controller;

public class ExceptionLength extends Exception{ // Excepcion propia 2
	public static String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExceptionLength (int n){
		if (n == 20){
			setMensaje("Debe ingresar menos de 20 caracteres.");
		}else if (n == 2){
			setMensaje("Debe ingresar al menos 2 caracteres.");
		}
	}

	public static String getMensaje() {
		return ExceptionLength.message;
	}

	public static void setMensaje(String message) {
		ExceptionLength.message = message;
	}
}
