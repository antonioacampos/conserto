package com.example.conserto;

public record DadosConserto (Long id, String dataEntrada, String dataSaida, Mecanico mecanico, Veiculo veiculo) {
}
