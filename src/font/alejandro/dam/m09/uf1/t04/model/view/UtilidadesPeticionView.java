package font.alejandro.dam.m09.uf1.t04.model.view;

import java.util.Scanner;

public class UtilidadesPeticionView {
    int getInt(String mensajePeticion) {
        System.out.println(mensajePeticion);
        Scanner scanner = new Scanner(System.in);
        int valor = scanner.nextInt();
        return valor;
    }

    String getString(String mensajePeticion) {
        System.out.println(mensajePeticion);
        Scanner scanner = new Scanner(System.in);
        String valor = scanner.next();
        return valor;
    }

    byte getByte(String mensajePeticion) {
        System.out.println(mensajePeticion);
        Scanner scanner = new Scanner(System.in);
        byte valor = scanner.nextByte();
        return valor;
    }
}
