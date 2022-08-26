package br.com.waldecleber.tdd.service;

import br.com.waldecleber.tdd.exceptions.ClienteDuplicadoException;
import br.com.waldecleber.tdd.model.Cliente;
import br.com.waldecleber.tdd.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) throws ClienteDuplicadoException {
        Optional<Cliente> clienteEncontrado = clienteRepository.findByCpf(cliente.getCpf());

        if (clienteEncontrado.isPresent()) {
            throw new ClienteDuplicadoException("Ja existe um cliente com este CPF");
        }

        //repositorio
        return clienteRepository.save(cliente);
    }
}
