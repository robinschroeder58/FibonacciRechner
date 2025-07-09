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

        System.out.println("Hello World!");
            // Methode zur Eingabevalidierung
            public static boolean eingabeIstGueltig(int eingabe) {
                return eingabe > 0;
            }






    }
}