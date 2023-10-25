package edu.pw2.superloja.model.endereco;

public record CepDTO(
                    String cep, 
                    String logradouro,
                    String complemento,
                    String bairro,
                    String localidade,
                    String uf) {
}
