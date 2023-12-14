package org.example;

import java.util.ArrayList;
import java.util.List;

public class CartaoCredito {
    private double limite;
    private double saldo;
    private double valorFatura;
    private List<Compra> fatura;

    public CartaoCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.fatura = new ArrayList<>();
    }

    public boolean lancaCompra(Compra compra) {
        if (this.saldo > compra.getValor()) {
            this.saldo -= compra.getValor();
            this.fatura.add(compra);
            this.valorFatura = valorFatura + compra.getValor();
            return true;
        } return false;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return fatura;
    }

    public double getValorFatura() {
        return valorFatura;
    }
}
