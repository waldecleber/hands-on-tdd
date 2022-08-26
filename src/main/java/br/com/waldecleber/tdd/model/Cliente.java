package br.com.waldecleber.tdd.model;

public class Cliente {

    private String name;
    private String email;
    private String cidade;
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public static final class Builder {
        private String name;
        private String email;
        private String cidade;
        private String cpf;

        private Builder() {
        }

        public static Builder aCliente() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Cliente build() {
            Cliente cliente = new Cliente();
            cliente.setName(name);
            cliente.setEmail(email);
            cliente.setCidade(cidade);
            cliente.setCpf(cpf);
            return cliente;
        }


        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
