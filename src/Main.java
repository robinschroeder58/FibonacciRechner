import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                System.out.println("Wilkommen beim Fibonacci Rechner");
                System.out.println("Bitte gebe eine positive ganze Zahl ein: ");

                int eingabe = 0;

                while (true) {
                    try {
                        String eingabeText = sc.nextLine().trim();

                        // Überprüfe, ob die Eingabe eine ganze Zahl ist
                        if (istGanzZahl(eingabeText)) {
                            eingabe = Integer.parseInt(eingabeText);

                            if (eingabeIstGueltig(eingabe)) {
                                System.out.println("Die Eingabe ist gültig.");
                                berechneFibonacci(eingabe);
                                break;
                            } else {
                                System.out.println("Die Eingabe ist ungültig! Die Zahl muss größer als 0 sein.");
                            }
                        } else {
                            System.out.println("Die Eingabe ist keine gültige ganze Zahl! Bitte versuche es erneut.");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR bei der Eingabe.");
                        e.printStackTrace();
                    }
                }

                System.out.println("Möchten Sie die Date als CSV Datei speicher? (y/n)");

                //geändert auf nextLine
                String dateiSpeicher = sc.nextLine();

                if (Objects.equals(dateiSpeicher, "y")) {
                    System.out.println("Datei wird als CSV gespeichert.");
                    speicherAlsCSV(berechneFibonacci(eingabe));

                    //Erweiterung zum Beenden des programmes
                    System.out.println("Programm wird beenden.");
                    System.exit(0);
                } else {
                    System.out.println("Programm wird beenden.");
                    System.exit(0);
                }
            }


            // Methode, um zu überprüfen, ob die Eingabe eine ganze Zahl ist
            public static boolean istGanzZahl(String eingabeText) {
                try {
                    Double zahl = Double.parseDouble(eingabeText);
                    // Überprüfe, ob die Zahl eine ganze Zahl ist (kein Dezimalteil)
                    return zahl == Math.floor(zahl) && !Double.isInfinite(zahl);
                } catch (NumberFormatException e) {
                    return false;
                }
            }

            // Methode zur Eingabevalidierung
            public static boolean eingabeIstGueltig(int eingabe) {
                return eingabe > 0;
            }

            // Fibonacci Berechnung
            public static List<Integer> berechneFibonacci(int schritte) {

                List<Integer> ergebnisListe = new ArrayList<>();

                int zahl1 = 0;
                int zahl2 = 1;
                int zahl3;

                for (int i = 1; i < schritte + 1; i++) {

                    zahl3 = zahl1 + zahl2;

                    System.out.println("Schrittnummer " + i + " : " + zahl1 + " + " + zahl2 + " = " + zahl3);

                    zahl1 = zahl2;
                    zahl2 = zahl3;

                    ergebnisListe.add(zahl3);
                }
                return ergebnisListe;
            }

            // Methode zum Speichern der Fibonacci Zahlen in einer CSV-Datei
            public static void speicherAlsCSV(List<Integer> ergebnisListe) {

                try {
                    FileWriter writer = new FileWriter("CSV_Test_File.csv");

                    //For Each
            /*
            for (Integer integer : ergebnisListe) {
                writer.write(integer.toString());
                writer.write(",");
            }
             */

                    // oder for-Schleife
                    for (int i = 0; i < ergebnisListe.size(); i++) {
                        writer.write(ergebnisListe.get(i).toString());
                        // zum Vermeiden des letzten Kommas
                        if (i < ergebnisListe.size() - 1) {
                            writer.write(",");
                        }
                    }
                    writer.close();
                    System.out.println("SCV Datei wurde erfolgreich gespeicher.");
                } catch (IOException e) {
                    System.out.println("Fehler beim Speichern der CSV-Datei.");
                    e.printStackTrace();
                }
            }
        }
