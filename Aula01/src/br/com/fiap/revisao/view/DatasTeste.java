package br.com.fiap.revisao.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatasTeste {

    public static void main(String[] args) {
        //Datas com Calendar
        Calendar hoje = Calendar.getInstance(); //Obtem uma instancia com a data atual
        Calendar checkpoint1 = new GregorianCalendar(2024, Calendar.FEBRUARY, 29); //Obtem uma instancia com uma data especifica

        //Formatador de datas
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        //Imprimir as datas
        System.out.println(dateFormat.format(hoje.getTime()));
        System.out.println(dateFormat.format(checkpoint1.getTime()));

        //TAREFA: Criar um objeto com a data de nascimento,
        //Outro com o horario de inicio da aula,
        //Outro objeto com a data e hora da reuniao de abertura do challenge
        //Exibir os dados

    }
}
