public class Main {
    public static void main(String[] args) {

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





    }
}