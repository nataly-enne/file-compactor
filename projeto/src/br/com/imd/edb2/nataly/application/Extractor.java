package br.com.imd.edb2.nataly.application;

import java.io.*;
import java.util.*;

public class Extractor {
    private Map<String, Character> letter = new HashMap<>();
    private Map<Character, String> code = new HashMap<>();
    private String message, map, translation;

    public Extractor(String message, String map, String translation) throws IOException {
        this.message = message;
        this.map = map;
        this.translation = translation;
    }


    public Map<Character, String> getCode() {
        return code;
    }

    // Pegando a tabela
    public void retrievingTable() throws IOException {

        FileInputStream dictionary = new FileInputStream(map);
        BufferedInputStream reader = new BufferedInputStream(dictionary);

        byte line[] = reader.readAllBytes();

        String file = new String(line, "UTF8");

        String[] codes = file.split(String.valueOf((char) 351));
        int i = 0;
        while (i < codes.length) {
            letter.put(codes[i + 1], codes[i].charAt(0));
            code.put(codes[i].charAt(0), codes[i + 1]);
            i += 2;
        }
        dictionary.close();
    }

    // Decodificando o texto
    public void decodeText() throws IOException {

        FileInputStream m = new FileInputStream(message);

        byte[] bytes = m.readAllBytes();
        String str = "";
        String aux;
        // Esse código foi baseado no que se encontra no seguinte site: https://stackoverflow.com/questions/12310017/how-to-convert-a-byte-to-its-binary-string-representation
        for (int i = 0; i < bytes.length; i++) {
            aux = String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(" ", "0");

            for (int j = (aux.length() -1) ; j >=  0 ;j--){
                str+=aux.charAt(j);
            }

        }
        String comparator = "";
        FileWriter latest = new FileWriter(translation); // latest' é um sinonimo para 'new'

        for (int j = 0; j < str.length(); j++) {
            comparator += str.charAt(j);
            if (code.containsValue(comparator)) {
                    latest.write(letter.get(comparator));
                    comparator = "";
            }
        }
        latest.close();
    }
}






