package com.example.conserto;

public record DadosConserto (Long id,boolean ativo  , String dataEntrada, String dataSaida, DadosMecanico mecanico, DadosVeiculo veiculo) {
    public DadosConserto(Conserto conserto){
        this(conserto.getId(),
                conserto.isAtivo(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                new DadosMecanico(conserto.getMecanico()),
                new DadosVeiculo(conserto.getVeiculo())

        );

    }
}
