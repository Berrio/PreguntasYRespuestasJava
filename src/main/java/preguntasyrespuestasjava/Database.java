package preguntasyrespuestasjava;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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

    public List<Database> preguntasList = new ArrayList<>();
    public List<String> historicoList = new ArrayList<>();

    public Database() throws IOException {
        crearPreguntas();
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

    public void guardarPregunta(){

    }

    public void consultarTodasPreguntas(){

    }
    public void consultarPreguntasParaJuego(){

    }

    public void crearPreguntas() throws IOException {

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

    public void guardarJuego(){

    }

    public void consultarHistoricoJuegos(){

    }
}
