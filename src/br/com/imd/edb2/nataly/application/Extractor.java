package br.com.imd.edb2.nataly.application;

import java.io.*;
import java.util.*;

public class Extractor {
    private Map <String, Character> letter = new HashMap<>();
    private Map <Character, String> code = new HashMap<>();
    private String message, map, translation;

    public Extractor(String message, String map, String translation) throws IOException {
        this.message = message;
        this.map = map;
        this.translation = translation;
        retrievingTable();
        decodeText();
    }

    public Extractor(String map) throws IOException {
        this.message = null;
        this.map = map;
        this.translation = null;
        
        retrievingTable();
    }

    public Map <Character, String> getCode() {
        return code;
    }

    public void retrievingTable() throws IOException {
        
        FileInputStream dictionary = new FileInputStream(map);
        BufferedInputStream reader = new BufferedInputStream(dictionary);
        
        byte line[] = reader.readAllBytes();
        
        String file = new String(line, "UTF8");
        String []codes = file.split(String.valueOf((char)-1));

        for (int i = 0; i < codes.length; ) {
            letter.put(codes[i + 1], codes[i].charAt(0));
            code.put(codes[i].charAt(0), codes[i + 1]);
            i += 2;
        }

        dictionary.close();
    }

    public void decodeText() throws IOException {
        
        FileInputStream m = new FileInputStream(message);

        byte[] bytes = m.readAllBytes();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            str.append(new StringBuilder(String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(" ", "0")).reverse());
        }

        String comparator = "";
        FileWriter latest = new FileWriter(translation); // latest' é um sinonimo para 'new

        for (int j = 0; j < str.length(); j++) {
            comparator += str.charAt(j);
            if (code.containsValue(comparator)) {
                if (comparator.equals(code.get((char) 258))) {

                        latest.close();


                } 
                else {
                    latest.write(letter.get(comparator));
                    comparator = "";
                }


            }
        }
    }
}






