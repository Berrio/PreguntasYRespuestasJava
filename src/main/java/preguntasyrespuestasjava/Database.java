package preguntasyrespuestasjava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Database {

    protected String categoria;
    protected String nivel;
    protected String pregunta;
    protected String opcion1;
    protected String opcion2;
    protected String opcion3;
    protected String opcionCorrecta;
    protected Integer nivelJuego = 1;

    public List<Database> preguntasList = new ArrayList<>();

    //Contructor generico para inicilializar las preguntas desde el JSON
    public Database() throws IOException {
        leerPreguntas();
    }

    public Database(String categoria, String nivel, String pregunta, String opcion1,
                    String opcion2, String opcion3, String opcionCorrecta) {
        this.categoria = categoria;
        this.nivel = nivel;
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcionCorrecta = opcionCorrecta;
    }

    //Obtiene todas las preguntas y respuestas
    public List<Database> consultarTodasPreguntas(){
        return preguntasList;
    }

    //Consulta las preguntas para el juego
    public List<Database> consultarPreguntasParaJuego(){
        List<Database> list;
        list = crearPreguntasJuego();
        while (list.size()<5){
            list = crearPreguntasJuego();
        }
        return list;
    }

    //Crea las preguntas que el juego necesita
    public List<Database> crearPreguntasJuego(){
        List<Database> listPreguntas;
        listPreguntas = consultarTodasPreguntas();
        Collections.shuffle(listPreguntas);
        List<Database> preguntas = new ArrayList<>();
        for (Database i : listPreguntas) {
            if ((Integer.parseInt(i.nivel))==nivelJuego){
                preguntas.add(i);
                break;
            }
        }
        nivelJuego++;
        return preguntas;
    }

    //Leer preguntas desde el Json
    public void leerPreguntas() throws IOException {

            JSONParser jsonParser = new JSONParser();
            final String dir = System.getProperty("user.dir");
            try (FileReader reader = new FileReader (dir+"\\src\\main\\java\\preguntasyrespuestasjava\\preguntas.json"))
            {
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JSONArray preguntasList = (JSONArray) obj;

                //Iterate over song array
                preguntasList.forEach( emp -> parsePreguntas( (JSONObject) emp ) );

            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
    }

    //Agrega las preguntas del Json a un Array
    public void parsePreguntas(JSONObject preguntas) {
        JSONObject preguntaObject = (JSONObject) preguntas.get("pregunta");

        this.categoria = (String) preguntaObject.get("categoria");
        this.nivel = (String) preguntaObject.get("nivel");
        this.pregunta = (String) preguntaObject.get("pregunta");
        this.opcion1 = (String) preguntaObject.get("opcion1");
        this.opcion2 = (String) preguntaObject.get("opcion2");
        this.opcion3 = (String) preguntaObject.get("opcion3");
        this.opcionCorrecta = (String) preguntaObject.get("opcionCorrecta");

        preguntasList.add(new Database(categoria,nivel,pregunta,opcion1,opcion2,opcion3,opcionCorrecta));
    }

    // guardarJuego() se pasa a la clase Histotico jmedinr

    // consultarHistoricoJuegos() se pasa a la clase Historico jmedinr
}