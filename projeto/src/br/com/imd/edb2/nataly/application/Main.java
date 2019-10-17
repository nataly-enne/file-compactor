package br.com.imd.edb2.nataly.application;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // para comprimir: java -jav projeto.jar compress "local do aquivo de texto" "local e novo nome para aquivo binario" "local e novo nome para arquivo de chave"
        if (args[0].equals("compress")) {
            Compressor compressor = new Compressor(args[1], args[2], args[3]);

            compressor.createDictionary();
            compressor.createTable();
            compressor.textEncoded();

        }
        // para extract: java -jav projeto.jar compress "local aquivo binario" "local arquivo de chave" "local e novo nome aquivo de texto"
        else if (args[0].equals("extract")) {
            Extractor extractor = new Extractor(args[1], args[2], args[3]);

            extractor.retrievingTable();
            extractor.decodeText();
        }

    }
}
