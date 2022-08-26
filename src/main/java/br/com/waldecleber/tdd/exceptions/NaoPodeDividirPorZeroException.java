package br.com.waldecleber.tdd.exceptions;

public class NaoPodeDividirPorZeroException extends Exception {

    public String getMensagem() {
        return mensagem;
    }

    private String mensagem;

    public NaoPodeDividirPorZeroException(String mensagem) {
        this.mensagem = mensagem;
    }

}
