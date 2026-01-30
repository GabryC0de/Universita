// Scrivere una classe eseguibile che verifica se una stringa, fornita come parametro sulla riga di comando, e` palindroma. La verifica che una stringa sia o meno una palindroma deve essere realizzata con un algoritmo ricorsivo.
// Si ricordi che una stringa e` una palindrome se e` composta da una sequenza di caratteri (anche non alfabetici) che possa essere letta allo stesso identico modo anche al contrario (es. "radar", "anna", "inni", "xyz%u%zyx").

// Verificare il corretto funzionamento del programma con:

// - la stringa "omordotuanuoraoarounautodromo"
// - una stringa palindroma di lunghezza pari
// - una stringa palindroma di lunghezza dispari
// - una stringa non palindroma di lunghezza pari
// - una stringa non palindroma di lunghezza dispari
// - una stringa di lunghezza unitaria (che è ovviamente palindroma)
// - una stringa di lunghezza zero (che è ragionevole definire palindroma); per fornire come parametro sulla riga di comando una stringa di lunghezza zero si indica il parametro ""

public class Palindroma {

    public static String check(String stringa, int len, int offSet) {
        if (len == 1 || len == 0) {
            return "La stringa è palindroma!";
        } else {
            if (len % 2 == 0) {
                if (offSet > len / 2) {
                    return "La stringa e' Palindroma!";
                }else if (stringa.charAt(offSet) == (stringa.charAt(len - offSet - 1))) {
                    return check(stringa, len, offSet + 1);
                } else {
                    return "La stringa NON e' palindroma!";
                }
            } else if (len % 2 == 1) {
                if (offSet == (int)Math.floor(len / 2)) {
                    return "La stringa e' Palindroma!";
                }
                if (stringa.charAt(offSet) == (stringa.charAt(len - offSet - 1))) {
                    return check(stringa, len, offSet + 1);
                } else {
                    return "La stringa NON e' palindroma!";
                }
            }
        }
        return "La stringa è palindroma!";
    }

    public static void main(String[] args) {
        String frase;
        if (args.length > 0) {
            frase = args[0];
            System.out.println(check(frase.toLowerCase().trim(), frase.length(), 0));
        } else {
            System.out.println("Errore: fornire una stringa come parametro");
        }
    }
}
