
package com.example.conserto;

public record DadosListagemConserto(String dataEntrada, String dataSaida, String mecanico, String marca, String modelo) {
    public DadosListagemConserto(Conserto conserto){
       this(conserto.getDataEntrada(),
               conserto.getDataSaida(),
               conserto.getMecanico().getNome(),
               conserto.getVeiculo().getMarca(),
               conserto.getVeiculo().getModelo()
       );

    }
}
