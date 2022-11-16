package Utilidades;

import Model.Doenca;
import Model.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Dados {
    private LocalDate data= LocalDate.now();

    public static List<Paciente> pacientesList;

   /* public static List<Paciente> emulando_dados() {
        LocalDate data= LocalDate.now();
        Doenca d1 = new Doenca("Sarampo", "1575kk", "Bolinhas vermelhas pelo corpo");
        Doenca d2 = new Doenca("Gripe", "51651l", "Coriza, tosse, indisposição.");
        Paciente p1 = new Paciente("Jhuliane","465168416843546", data, data, false);
        Paciente p2 = new Paciente("Raiane","18716466115", data, data, true);

        pacientesList = new ArrayList<>();

        pacientesList.add(p1);
        pacientesList.add(p2);




        return pacientesList;

    }*/
}