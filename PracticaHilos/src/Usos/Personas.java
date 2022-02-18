package Usos;

public class Personas implements Runnable {

	private int numeroProducido = 1; //HAGO UNA VARIABLE QUE LA IGUALE AL CONTADOR DE PERSONAS
	private Portero cola; //INSTANCIO EL PORTERO

	public Personas(int i, Portero cola) { //Y SE LO PASO POR EL CONSTRUCTOR

		this.cola = cola;
		this.numeroProducido = 1;

	}

	@Override
	public void run() {

		System.out.println("Numero de producidos en la cola: " + numeroProducido); //AQUI SACA LAS PERSONAS QUE HAY EN LA COLA

		try {

			Thread.currentThread().sleep(100); //DUERMO EL HILO DURANTE 100MS, PARA QUE SE LLENE LA COLA MÁS RAPIDO
			cola.putItem(numeroProducido); //LLAMO AL METODO PUTITEM DE LA CLASE PORTERO PARA QUE LO HAGA, LE IGUALO EL NUMERO PRODUCIDO A LOS QUE HAY EN LA COLA

		} catch (Exception e) {

			e.printStackTrace();
		}

		numeroProducido = numeroProducido + 1; //ESTA LINEA VA SUMANDO DE UNO EN UNO EL NUMERO PRODUCIDO PARA QUE NO SALGA SIEMPRE 1 POR CONSOLA

	}

}
