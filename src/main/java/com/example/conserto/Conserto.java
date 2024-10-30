package com.example.conserto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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
    @NotNull
    private boolean ativo;

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
        this.veiculo=new Veiculo(dados.veiculo());
        this.mecanico=new Mecanico(dados.mecanico());
        this.ativo=true;
    }

    public void update(DadosAtualizaConserto dados) {
        if(dados.nomeMecanico()!=null){
            this.mecanico.setNome(dados.nomeMecanico());
        }

        if(dados.anosExperiencia()!=null){
            this.mecanico.setAnosDeExperiencia(Integer.parseInt(dados.anosExperiencia()));
        }
        if(dados.dataSaida()!=null){
            this.dataSaida=dados.dataSaida();
        }

    }

    public void delete() {
        this.ativo=false;
    }
}

