package Usos;

public class Edificio implements Runnable {

    public Portero cola; //INSTANCIAMOS UNA COLA

    public Edificio(Portero cola) { //SE LA METEMOS AL CONSTRUCTOR

        this.cola = cola;

    }

    @Override
    public void run() {
        
        try {
            
            cola.getItem(); //LLAMO AL METODO DEL PORTERO PARA QUE HAGA TODAS LAS OPERACIONES

        } catch (Exception e) {
            
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();

        }

    }
    
}
