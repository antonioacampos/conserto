package com.example.conserto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;

    private String modelo;

    private String ano;

    private String cor;
    public Veiculo(DadosVeiculo dados){
        this.marca=dados.marca();
        this.modelo=dados.modelo();
        this.ano=dados.ano();
        this.cor=dados.cor();
    }


}
