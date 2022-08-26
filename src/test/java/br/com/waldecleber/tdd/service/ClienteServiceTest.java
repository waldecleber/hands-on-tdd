package br.com.waldecleber.tdd.service;

import br.com.waldecleber.tdd.exceptions.ClienteDuplicadoException;
import br.com.waldecleber.tdd.model.Cliente;
import br.com.waldecleber.tdd.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.mock;

public class ClienteServiceTest {

    private static ClienteService clienteService;
    private static ClienteRepository clienteRepository;

    @BeforeAll
    public static void setUp() {
        clienteRepository = mock(ClienteRepository.class);
        clienteService = new ClienteService(clienteRepository);
    }

    @Test
    public void deveSalvarNovoClienteSucesso() throws ClienteDuplicadoException {
        Cliente cliente = Cliente.builder()
                .name("Leandro")
                .cpf("111111")
                .email("leandro@pags.com.br")
                .cidade("Cotia")
                .build();

        Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente salvo = clienteService.salvar(cliente);
        Assertions.assertEquals(salvo, cliente);
    }

    @Test
    public void naoDeveSalvarClienteDuplicado() {
        ClienteDuplicadoException exception = Assertions.assertThrows(ClienteDuplicadoException.class, () -> {
            Cliente cliente = Cliente.builder()
                    .name("Leandro")
                    .cpf("111111")
                    .email("leandro@pags.com.br")
                    .cidade("Cotia")
                    .build();

            Mockito.when(clienteRepository.findByCpf("111111")).thenReturn(Optional.of(cliente));
            Cliente salvo = clienteService.salvar(cliente);

        });

        Assertions.assertEquals("Ja existe um cliente com este CPF", exception.getMensagem());
    }


}
