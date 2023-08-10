package br.com.fiap.domain.entity;

import java.time.LocalDateTime;

public class ItemEstocado {

    private Long id;

    private Deposito deposito;

    private Produto produto;

    private LocalDateTime entrada;

    private LocalDateTime saida;


    private String numeroDeSerie;


    public ItemEstocado() {
    }

    public ItemEstocado(Long id, Deposito deposito, Produto produto, LocalDateTime entrada, LocalDateTime saida, String numeroDeSerie) {
        this.id = id;
        this.deposito = deposito;
        this.produto = produto;
        this.entrada = entrada;
        this.saida = saida;
        this.numeroDeSerie = numeroDeSerie;
    }

    public Long getId() {
        return id;
    }

    public ItemEstocado setId(Long id) {
        this.id = id;
        return this;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public ItemEstocado setDeposito(Deposito deposito) {
        this.deposito = deposito;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ItemEstocado setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public ItemEstocado setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
        return this;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public ItemEstocado setSaida(LocalDateTime saida) {
        this.saida = saida;
        return this;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public ItemEstocado setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
        return this;
    }


    @Override
    public String toString() {
        return "ItemEstocado{" +
                "id=" + id +
                ", deposito=" + deposito +
                ", produto=" + produto +
                ", entrada=" + entrada +
                ", saida=" + saida +
                ", numeroDeSerie='" + numeroDeSerie + '\'' +
                '}';
    }
}
