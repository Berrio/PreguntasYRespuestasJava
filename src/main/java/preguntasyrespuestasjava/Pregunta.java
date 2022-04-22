import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Pregunta {

    private String categoria;
    private int nivel;
    private String pregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcionCorrecta;

    public void crearNueva(){
        while (true){
            Scanner leerDatos=new Scanner(System.in);
            System.out.println("Escribe la categoria: ");
            categoria=leerDatos.nextLine();
            System.out.println("Escribe el nivel de la pregunta, de 1 a 5: ");
            nivel=Integer.parseInt(leerDatos.nextLine());
            System.out.println("Escribe la pregunta: ");
            pregunta=leerDatos.nextLine();
            System.out.println("Escribe la primera opcion de respuesta incorrecta: ");
            opcion1=leerDatos.nextLine();
            System.out.println("Escribe la segunda opcion de respuesta incorrecta: ");
            opcion2=leerDatos.nextLine();
            System.out.println("Escribe la tercera opcion de respuesta incorrecta: ");
            opcion3=leerDatos.nextLine();
            System.out.println("Escribe la opcion de respuesta correcta: ");
            opcionCorrecta=leerDatos.nextLine();
            if(esValida()){
                System.out.println("Pregunta con datos vacios o no validos");
                break;
            }
            System.out.println("Pregunta guardada exitofffsamente");
            guardar();


        }
    }
    public boolean esValida(){
        try{
            return (this.categoria != "" && this.nivel >= 1 && this.nivel <= 5 && this.pregunta != "" && this.opcion1 != "" && this.opcion2 != "" && this.opcion3 != "" && this.opcionCorrecta != "");
        }
        catch(Exception e)
        {
            return false;
        }

    }

    public void guardar(){
        //Database database=new Database();
        //database.guardar();
    }

    public void peguntar(){
       /*ArrayList lista = new ArrayList();
        lista.add(this.opcion1);
        lista.add(this.opcion2);
        lista.add(this.opcion3);*/

        int min_val = 1;
        int max_val = 3;
        Random rand = new Random();
        int randomNum = min_val + rand.nextInt((max_val - min_val) + 1);
        System.out.println("Random Number: "+randomNum);


    }
}