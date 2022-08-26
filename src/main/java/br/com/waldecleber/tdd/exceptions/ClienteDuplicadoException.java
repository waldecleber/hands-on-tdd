package br.com.waldecleber.tdd.exceptions;

public class ClienteDuplicadoException extends Exception {

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public ClienteDuplicadoException(String mensagem) {
        this.mensagem = mensagem;
    }
}
