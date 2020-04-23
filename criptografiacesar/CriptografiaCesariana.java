package br.com.maito.codenation.desafios.criptografiacesar;

public class CriptografiaCesariana implements Criptografia {

    private String texto;
    private int casas = 3;
    private static char[] alfabeto = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public static char[] getAlfabeto() {
        return alfabeto;
    }

    public static void setAlfabeto(char[] alfabeto) {
        CriptografiaCesariana.alfabeto = alfabeto;
    }
    @Override
    public String descriptografar(String texto){
        this.texto = texto.toLowerCase();
        if( "".equals(texto) ) {
            throw new  NullPointerException("Texto não pode ser vazio");
        }
        char[] textoDecifrada = texto.toLowerCase().toCharArray();//new char[this.texto.length()];
        for (int i = 0; i < this.texto.length(); i++) {
            if (this.texto.charAt(i) == ' ') {
                textoDecifrada[i] = this.texto.charAt(i);
            } else {
                for (int j = 0; j < getAlfabeto().length; j++) {
                    if (this.texto.charAt(i) == getAlfabeto()[j]) {
                        if (j < this.casas) {
                            textoDecifrada[i] = getAlfabeto()[(j - this.casas + getAlfabeto().length)
                                    % getAlfabeto().length];
                            j = getAlfabeto().length;
                        } else {
                            textoDecifrada[i] = getAlfabeto()[(j - this.casas) % getAlfabeto().length];
                            j = getAlfabeto().length;
                        }
                    } else {
                        textoDecifrada[i] = this.texto.charAt(i);
                    }
                }
            }
        }
        return String.valueOf(textoDecifrada);
    }

    @Override
    public String criptografar(String texto) {
        this.texto = texto.toLowerCase();
        if( "".equals(texto) ) {
            throw new  NullPointerException("Texto não pode ser vazio");
        }
        char[] textoDecifrada = texto.toLowerCase().toCharArray();//new char[this.texto.length()];
        for (int i = 0; i < this.texto.length(); i++) {
            if (this.texto.charAt(i) == ' ') {
                textoDecifrada[i] = this.texto.charAt(i);
            } else {
                for (int j = 0; j < getAlfabeto().length; j++) {
                    if (this.texto.charAt(i) == getAlfabeto()[j] ){
                        if (j < 0) {
                            textoDecifrada[i] = getAlfabeto()[(j + this.casas + getAlfabeto().length)
                                    % getAlfabeto().length];
                            j = getAlfabeto().length;
                        } else {
                            textoDecifrada[i] = getAlfabeto()[(j + this.casas) % getAlfabeto().length];
                            j = getAlfabeto().length;
                        }
                    } else {
                        textoDecifrada[i] = this.texto.charAt(i);
                    }
                }
            }
        }
        return String.valueOf(textoDecifrada);
    }
}
