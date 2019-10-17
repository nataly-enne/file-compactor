package br.com.imd.edb2.nataly.application;


import br.com.imd.edb2.nataly.datesStructure.Heap;
import br.com.imd.edb2.nataly.datesStructure.Node;

import java.io.*;
import java.util.*;

public class Compressor {

    private Heap heap = new Heap();
    private Map <Integer, Integer> map = new HashMap<>();
    private boolean key = true;
    private Node tree = new Node();
    private Map <Character, String> binary = new HashMap<>();
    private String text, message, dictionary;
    private static String tableCode = "";

    public Compressor(String text, String message, String dictionary) {
        this.text = text;
        this.message = message;
        this.dictionary = dictionary;
    }

    // Criação do dicionário com tratamento de exceção.
    public void  createDictionary() {

        try {
            FileInputStream f = new FileInputStream(text); // f remeta à 'file'

            BufferedInputStream reader = new BufferedInputStream(f);

            byte line[] = reader.readAllBytes();
            String file = new String(line, "UTF8");

            for (int i = 0; i < file.length(); i++) {
                if (map.containsKey((int) file.charAt(i))) {
                    int value = (map.get((int) file.charAt(i))) + 1;
                    map.put((int) file.charAt(i), value);
                } 
                else {
                    map.put((int) file.charAt(i), 1);
                }
            }

        } 
        catch (IOException e) {
            System.out.println("Invalid param" + e.getMessage());
        }


        for (Integer i : map.keySet()) {
            Node no = new Node(i, map.get(i));
            heap.insert(no);
        }

        do {
            if (heap.getSize() == 1) {
                key = false;
                break;
            }
            Node left = heap.peek();
            heap.remove();
            
            Node right = heap.peek();
            heap.remove();
            tree = new Node(left.getQuantity() + right.getQuantity(), left, right);
            
            heap.insert(tree);

        } while (heap.getSize() > 1);

    }

    // Criação da tabela
    public void createTable() throws IOException {

        String bit[] = returningBynary(tree, key);

        FileWriter encodedTable = new FileWriter(dictionary);

        for (int i = 0; i < bit.length;) {
            encodedTable.write((char) Integer.parseInt(bit[i]) + String.valueOf((char) 351) + bit[i + 1] + String.valueOf((char)351));
            binary.put((char) Integer.parseInt(bit[i]), bit[i + 1]);
            i += 2;
        }
        encodedTable.close();


    }

    // Codificando o texto
    public void textEncoded() throws IOException {
        
        FileOutputStream m = new FileOutputStream(message);
        FileInputStream f = new FileInputStream(text);
        BufferedInputStream reader = new BufferedInputStream(f);

        int cont = 0;

        BitSet bitSet = new BitSet();

        byte text[] = reader.readAllBytes();
        String file = new String(text, "UTF8");

        for (int i = 0; i < file.length(); i++) {

            if (binary.containsKey(file.charAt(i))) {
                for (int j = 0; j < binary.get(file.charAt(i)).length(); j++) {
                    if (binary.get(file.charAt(i)).charAt(j) == '1') {
                        bitSet.set(cont);
                    } 
                    else {
                        bitSet.set(cont, false);
                    }
                    cont += 1;
                }
            }

        }


        int rest = 0;

        if (cont % 8 == 0) {
            m.write(bitSet.toByteArray());
            m.close();
            f.close();
        }
        else {
            rest = (int) ((1 - (((float) cont / 8) - (cont / 8))) * 8);
            for (int i = 0; i < rest; i++) {
                bitSet.set(cont , false);
                cont += 1;

            }
            m.write(bitSet.toByteArray());
            m.close();
            f.close();
        }
    }

    public static String[] returningBynary(Node no, boolean key) {

            tableCode = returningBynary(no, "");
            return tableCode.split(" ");


    }

    private static String returningBynary(Node no, String codigo) {
        if (no.getLeft() == no.getRight()) {
            tableCode+= no.getCharacter() + " " + codigo + " " ;
            return tableCode;
        }
        else {
            returningBynary(no.getRight(), codigo + "1");
            returningBynary(no.getLeft(), codigo + "0");
        }
        return tableCode;

    }

}
