package br.com.waldecleber.tdd.service;

import br.com.waldecleber.tdd.exceptions.NaoPodeDividirPorZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculadoraServiceTest {

    private static CalculadoraService calc;

    @BeforeAll
    public static void setup() {
        calc = new CalculadoraService();
    }

    @Test
    public void deveSomarDoisValores() {

        // cenario
        int a = 5;
        int b = 3;

        // acoes
        int resultado = calc.somar(a,b);


        // verificacao
        Assertions.assertEquals(8, resultado);
    }


    @Test
    public void deveDividirComSucessoDoisValores() throws NaoPodeDividirPorZeroException {
        // cenario
        int a = 9;
        int b = 3;

        // acoes
        int resultado = calc.dividir(a,b);


        // verificacao
        Assertions.assertEquals(3, resultado);
    }


    @Test
    public void deveLancarExcecaoAoDividirPorZero() {
        NaoPodeDividirPorZeroException exception = Assertions.assertThrows(NaoPodeDividirPorZeroException.class, () -> {
            // cenario
            int a = 9;
            int b = 0;

            // acoes
            int resultado = calc.dividir(a,b);
        }) ;

        // verificacao
        Assertions.assertEquals("Nao pode dividir valor por zero!", exception.getMensagem());
    }

}
