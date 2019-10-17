package br.com.imd.edb2.nataly.main;

import br.com.imd.edb2.nataly.application.*;;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args[0].equals("compress")) {
            Compressor compressor = new Compressor(args[1], args[2], args[3]);

            compressor.createDictionary();
            compressor.createTree();
            compressor.createTable();
            compressor.textEncoded();

        } 
        else if (args[0].equals("extract")) {
            Extractor extractor = new Extractor(args[1], args[2], args[3]);

            extractor.retrievingTable();
            extractor.decodeText();
        }

    }
}
