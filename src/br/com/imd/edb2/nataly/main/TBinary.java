package br.com.imd.edb2.nataly.main;

import br.com.imd.edb2.nataly.tree.Node;

public class TBinary {

    private static String tableCode = "";

    public static String[] LBinary(Node no, boolean chave) {
        if(chave == true){
            tableCode = LBinary(no, "");
            return tableCode.split("=");
        }
        else{
            tableCode += "258"+"=0";
            return tableCode.split("=");
        }

    }

    private static String LBinary(Node no, String codigo) {
        if (no.getLeft() == no.getRight()) {
            tableCode+= no.getValue().getCharacter() + "=" + codigo + "=" ;
            return tableCode;
        } 
        else {
            LBinary(no.getRight(), codigo + Integer.toString(no.getRight().getBit()));
            LBinary(no.getLeft(), codigo + Integer.toString(no.getLeft().getBit()));
        }
        return tableCode;

    }

}
