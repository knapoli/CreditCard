package org.example;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        boolean controle = true;
        System.out.println("Digite o limite do cartão: ");
        Scanner entradaLimite = new Scanner(System.in);
        double limite = entradaLimite.nextDouble();
        double saldo = limite;
        double fatura = 0;

        ArrayList <Transacao> faturaDetalhada = new ArrayList<>();
        System.out.println("Seu limite é de: " + limite);

        while (controle == true) {
            System.out.println("******************************" );
            System.out.println("Saldo do Cartão R$ " + saldo);
            System.out.println("Saldo da próxima fatura R$ " + fatura);
            System.out.println("******************************" );


            System.out.println("1 Efetuar compra");
            System.out.println("");
            System.out.println("2 Fatura detalhada");
            System.out.println("");
            System.out.println("3 Aumento de limite ");
            System.out.println("");
            System.out.println("4 Pagar Fatura ");
            System.out.println("");
            System.out.println("5 Sair");
            System.out.println("");
            System.out.println("Digite a opção desejada:");
            Scanner entrada = new Scanner(System.in);
            int numero = entrada.nextInt();


            switch (numero){
                case 1:
                    System.out.println("Digite a descrição da compra: ");
                    Scanner pegaDescricao = new Scanner(System.in);
                    String descricaoCompra = pegaDescricao.next();
                    System.out.println("Descricao " + descricaoCompra);

                    System.out.println("Digite o valor da compra: R$ ");
                    Scanner pegaValor = new Scanner(System.in);
                    double valorCompra = pegaValor.nextDouble();
                    System.out.println("Valor " + valorCompra);

                    saldo = saldo - valorCompra;
                    fatura = fatura + valorCompra;

                    Transacao novaTransação = new Transacao();
                    novaTransação.descricao = descricaoCompra;
                    novaTransação.valor = valorCompra;

                    faturaDetalhada.add(novaTransação);
                    System.out.println("Transações: " + faturaDetalhada);

                    break;
                case 2:
                    System.out.println("Transações: " + faturaDetalhada);
                    for (Transacao item: faturaDetalhada) {
                        System.out.println(item.descricao);
                        System.out.println(item.valor);
                    }
                    break;
                case 3:
                    System.out.println("Qual o valor a ser acrescido de limite?");
                    Scanner novoLimite = new Scanner(System.in);
                    limite = limite + novoLimite.nextDouble();
                    saldo = limite - fatura;
                    System.out.println("Seu novo limite é de R$ " + limite);
                    break;
                case 4:
                    System.out.println("O valor da sua fatura é de R$ " + fatura);
                    System.out.println("Insira o valor a ser pago");
                    Scanner pagaFatura = new Scanner(System.in);
                    double valorPgtoFatura = pagaFatura.nextDouble();
                    
                    if(valorPgtoFatura > fatura) {
                        System.out.println("O valor deve ser inferior ao valor da fatura");
                        break;
                    }
                    fatura = fatura - valorPgtoFatura;
                    saldo = saldo + valorPgtoFatura;
                    System.out.println("Fatura paga com sucesso, obrigado");
                    break;

                case 5:
                    System.out.println("Obrigado por usar o banco XYZ");
                    controle = false;
                    break;
            }
        }


    }
}