package Usos;

import java.util.concurrent.Semaphore;

public class Portero {

	private static final int MAXIMO_DISPONIBLE = 300; //LE METO UN MAXIMO DE 300 HUECOS PARA QUE HAGA TODAS LAS OPERACIONES SIN PROBLEMAS
	private final Semaphore sem = new Semaphore(MAXIMO_DISPONIBLE, true);//CREAMOS UN SEMAFORO PARA CONTROLAR LAS ENTRADAS Y SALIDAS

	private static int producidosDentro = 0;
	private static int porductoresEnCola = 0;	//VARIABLES DE DENTRO DEL EDIFICIO Y EN LA COLA INICIADAS A 0

	public int getItem() throws InterruptedException {

		sem.acquire(); //SI EL HILO LLEGA A 0 SE PAUSA HASTA QUE ENTRE OTRA OPERACION, NO DEJA QUE BAJE DE 0
		if (porductoresEnCola > 0) { //SI LOS PRODUCTORES QUE HAY EN LA COLA SON MAS DE CERO

			if (producidosDentro < 31) {//IRA METIENDO DENTRO DEL EDIFICIO SIN QUE PASE DE 31

				producidosDentro++;//VA METIENDO PRODUCTORES DENTRO DEL EDIFICIO
				porductoresEnCola--;//Y VA RESTANDO LOS QUE HAY EN LA COLA

				System.out.println("Productores en cola --> " + porductoresEnCola);//LOS SACAMOS POR PANTALLA
				System.out.println("Productores dentro del edificio --> " + producidosDentro);

			} else { //SI NO

				Thread.currentThread();
				Thread.sleep(1000);//DORMIMOS EL HILO 1s POR OPERACION
				producidosDentro--;//RESTA LOS QUE HAY DENTRO, PERO COMO SIGUE HABIENDO EN LA COLA, RESTA UNO Y METE OTRO

				System.out.println("\n ");
				System.out.println("Ha salido una persona");
				System.out.println("Productores dentro del edificio: " + producidosDentro);	//LO SACA POR PANTALLA
				System.out.println("\n");

			}

		} else if (producidosDentro > 0) { //SI LOS QUE HAY DENTRO SON MAYOR DE CERO, CUANDO EN LA COLA NO QUEDA NINGUNO

			Thread.currentThread();
			Thread.sleep(1000); //DORMIMOS EL HILO DURANTE UN SEGUNDO
			producidosDentro--;//Y VA RESTANDO YA QUE NO QUEDA NINGUNO EN LA COLA

			System.out.println("Producidos haciendo cola: " + porductoresEnCola);
			System.out.println("Producidos dentro del edificio: " + producidosDentro);	//LO SACAMOS POR PANTALLA
			System.out.println("Se ha consumido un producido");
			System.out.println("\n ");

		}

		return 0;

	}

	public void putItem(int x) throws InterruptedException {

		sem.acquire();
		porductoresEnCola = x;

	}

}
