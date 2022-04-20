package preguntasyrespuestasjava;

import java.util.ArrayList;
import java.util.List;

public class Historico {

    String nickname;
    Integer ronda;
    Integer acumulado;

    public List<Historico> historicoList = new ArrayList<>();

    public Historico(String nickname, Integer ronda, Integer acumulado) {
        this.nickname = nickname;
        this.ronda = ronda;
        this.acumulado = acumulado;
    }

    public void mostrar(){
        List<Historico> list = consultarHistoricoJuegos();
        for (Historico i: list) {
            System.out.println("NickName: ");
            System.out.println(i.nickname);
            System.out.println("Ronda ");
            System.out.println(i.ronda);
            System.out.println("acumulado");
            System.out.println(i.acumulado);
        }
    }

    public List<Historico> consultarHistoricoJuegos(){
        return historicoList;
    }

    public void guardarJuego(String nickname, Integer ronda, Integer acumulado){
        historicoList.add(new Historico(nickname,ronda,acumulado));
    }
}
