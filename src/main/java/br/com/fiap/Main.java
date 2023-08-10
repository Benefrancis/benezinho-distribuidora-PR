package br.com.fiap;


import br.com.fiap.domain.entity.Deposito;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        Deposito depositoDaVilaMadalena = new Deposito();
        depositoDaVilaMadalena.setId(1L).setNome("Osasco");



    }
}