package com.example.conserto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    @NotBlank(message = "A marca do veículo é obrigatória")
    private String marca;

    @NotBlank(message = "o modelo do veículo é obrigatório")
    private String modelo;

    @Pattern(regexp = "\\d{4}", message = "O ano do veículo deve estar no formato 'xxxx'")
    private String ano;

    private String cor;
    public Veiculo(DadosVeiculo dados){
        this.marca=dados.marca();
        this.modelo=dados.modelo();
        this.ano=dados.ano();
        this.cor=dados.cor();
    }


}
