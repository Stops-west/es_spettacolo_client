package client;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
    try(
        Socket s = new Socket("localhost", 12345);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        Scanner scan = new Scanner(System.in);
    ){
        System.out.println("Connesso al server");
        while(true){
            System.out.println("Scegli una di queste opzioni, indicando il numero di quella selezionata");
            System.out.println("1. Consulta i posti disponibili");
            System.out.println("2. Prenota posti");
            System.out.println("3. Annulla prenotazione");
            System.out.println("4. Esci");

            String scelta = scan.nextLine().trim();
            switch(scelta){
                case "1":
                    out.println("DISPONIBILI");
                    String resp = in.readLine().trim();
                    System.out.println(resp);
                break;
                case "2":
                    System.out.println("Inserisci il numero di posti che si intende prenotare, ricorda che il massimo di posti è di 30");
                    String reqNum = scan.nextLine();
                    out.println("PRENOTA" + reqNum);
                    resp = in.readLine();
                    System.out.println(resp);
                break;
            }

        }
    }
}
