package cifrando;

import java.io.FileWriter;
import java.util.Scanner;


public class Criptografia {
    
    public static String TxT, Seed;
    public static String Charset = "abcdefghijklmnopqrstuvwxyz+=,.-0123456789@#%$&()/:;!<>?ABCDEFGHIJKLMNOPQRSTUVWXYZ'[]{}^~";

    public Criptografia(String TxT, String Seed) {
        this.Seed = Desn(Seed);
        this.TxT = TxT;
    }

    public static String Criptografar() {
        String cripto = "", a = TxT;
        for (int n = 0, c = 0; n < TxT.length(); n++, c = (c + 1) % Seed.length()) {
            if (Charset.indexOf(a.charAt(n)) != -1) {
                int tmp = (Charset.indexOf(a.charAt(n)) + Charset.indexOf(Seed.charAt(c))) % Charset.length();
                cripto += (Charset.indexOf(TxT.charAt(n)) != -1) ? Charset.charAt(tmp) : String.valueOf(Charset.charAt(tmp)).toUpperCase();
            } else {
                c -= 1;
                cripto += TxT.charAt(n);
            }
        }
        return cripto;
    }

    public static String Decriptografar() {
        String Decripto = "";
        String a = TxT;
        for (int n = 0, c = 0; n < a.length(); n++, c = (c + 1) % Seed.length()) {
            if (Charset.indexOf(a.charAt(n)) != -1) {
                int tmp = (Charset.indexOf(a.charAt(n)) - Charset.indexOf(Seed.charAt(c)));
                tmp = (tmp < 0) ? (tmp + Charset.length()) : tmp;
                Decripto += (Charset.indexOf(TxT.charAt(n)) != -1) ? Charset.charAt(tmp) : String.valueOf(Charset.charAt(tmp)).toUpperCase();
            } else {
                c -= 1;
                Decripto += TxT.charAt(n);
            }
        }
        return Decripto;
    }

    public static String Desn(String a) {
        String b = "";
        for (int n = 0; n < a.length(); n++) {
            if ((Charset.indexOf(a.charAt(n)) != -1) || (Charset.indexOf(String.valueOf(a.charAt(n)).toLowerCase()) != -1)) {
                b += a.charAt(n);
            }
        }
        return b;
    }
}
