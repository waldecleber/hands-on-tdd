package br.com.waldecleber.tdd.service;

import br.com.waldecleber.tdd.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraService {


    public int somar(int a, int b) {
        return a + b;
    }

    public int dividir(int a, int b) throws NaoPodeDividirPorZeroException {
        if (b == 0) {
            throw new NaoPodeDividirPorZeroException("Nao pode dividir valor por zero!");
        }
        return a / b;
    }
}
