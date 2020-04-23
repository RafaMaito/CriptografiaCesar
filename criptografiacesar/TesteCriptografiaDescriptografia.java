package br.com.maito.codenation.desafios.criptografiacesar;

public class TesteCriptografiaDescriptografia {
    public static void main(String[] args) {

        Criptografia cript = new CriptografiaCesariana();

        String texto = "a ligeira raposa marrom saltou sobre o cachorro cansado";

        System.out.println("original	: "	+texto);
        System.out.println("cifrado		: "	+cript.criptografar(texto));
        System.out.println("descifra-orig	: "+cript.descriptografar( texto ));
        System.out.println("descifra-cifra	: "+cript.descriptografar( cript.criptografar(texto) ));
    }


}
