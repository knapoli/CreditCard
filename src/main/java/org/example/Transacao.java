package org.example;

public class Transacao {
    double valor;
    String descricao;

    public String toString() {
        return "Descrição: " + this.descricao + " Valor: R$ " + this.valor;
    }
}
