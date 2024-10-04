package com.example.conserto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;
    public Conserto(DadosConserto dados){
        this.id=dados.id();
        this.dataEntrada= dados.dataEntrada();
        this.dataSaida=dados.dataSaida();
        this.veiculo=dados.veiculo();
        this.mecanico=dados.mecanico();
    }
}

