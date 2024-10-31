package com.example.conserto;

public record DetalhamentoConserto(long id, boolean ativo, String dataEntrada, String dataSaida, Mecanico mecanico, Veiculo veiculo) {
    public DetalhamentoConserto(Conserto conserto){
        this(conserto.getId(),
                conserto.isAtivo(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico(),
                conserto.getVeiculo()

        );

    }
}
