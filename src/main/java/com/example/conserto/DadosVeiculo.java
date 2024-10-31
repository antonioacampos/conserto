package com.example.conserto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotBlank(message = "A marca do veículo é obrigatória")
        String marca,
        @NotBlank(message = "o modelo do veículo é obrigatório")
        String modelo,
        @NotBlank
        @Pattern(regexp = "\\d{4}", message = "O ano do veículo deve estar no formato 'xxxx'")
        String ano,

        String cor
) {
        public DadosVeiculo(Veiculo veiculo){
                this(
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getAno(),
                        veiculo.getCor()
                );
        }

}
