package com.goodcompany.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ConsoleUtil {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static String readInput() {
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException ex) {
            System.out.println("IO Errors occurs, terminated!");
            System.exit(1);
        }
        return line;
    }

}
