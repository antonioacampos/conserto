package com.example.conserto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "'data de entrada' deve estar no formato 'xx/xx/xxxx'")
    private String dataEntrada;

    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "'data de saída' deve estar no formato 'xx/xx/xxxx'")
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

