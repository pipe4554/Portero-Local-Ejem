package Usos;

public class Lanzador {

	public static Portero cola = new Portero();
	public static Personas productor = new Personas(1, cola); //INSTANCIAMOS UN SEMAFORO, UN PRODUCTOR Y UN CONSUMIDOR
	public static Edificio consumidor = new Edificio(cola);

	public Lanzador() {}
	
	public static void main(String[] args) throws InterruptedException {

		Thread hiloProductor = new Thread(productor); //CREAMOS UN HILO PRODUCTOR PASANDOLE LA INSTANCIA
		Thread hiloConsumidor = new Thread(consumidor); //CREAMOS UN HILO CONSUMIDOR PASANDOLE LA 

		System.out.println("Los productores se ponen a la cola"); 

		for (int i = 0; i < 100; i++) { //CREO UN FOR CON 100 PRODUCTORES

			hiloProductor.run();
			hiloProductor.join();

		}

		for (int r = 0; r < 200; r++) { //CREO UN FOR CON 200 CONSUMIDORES PARA QUE NO SE QUEDE NINGUNO COLGADOd 

			hiloConsumidor.run();
			hiloConsumidor.join();

		}

	}

}
