package com.example.conserto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizaConserto(
        @NotNull
        Long id,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "'data de saída' deve estar no formato 'xx/xx/xxxx'")
        String dataSaida,
        String nomeMecanico,
        String anosExperiencia

) {
}
