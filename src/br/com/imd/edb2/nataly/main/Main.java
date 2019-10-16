package br.com.imd.edb2.nataly.main;

import br.com.imd.edb2.nataly.application.*;;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args[0].equals("compress")) {
            new Compressor(args[1], args[2], args[3]);

        } 
        else if (args[0].equals("extract")) {
            new Extractor(args[1], args[2], args[3]);

        }

    }
}
