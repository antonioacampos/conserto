package com.example.conserto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(
        Long id,
        @NotNull boolean ativo,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "'data de entrada' deve estar no formato 'xx/xx/xxxx'")
        String dataEntrada,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "'data de saída' deve estar no formato 'xx/xx/xxxx'")
        String dataSaida,
        DadosMecanico mecanico,
        DadosVeiculo veiculo) {

    public DadosConserto(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.isAtivo(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                new DadosMecanico(conserto.getMecanico()),
                new DadosVeiculo(conserto.getVeiculo())
        );
    }
}
