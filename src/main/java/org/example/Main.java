package org.example;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        boolean controle = true;
        System.out.println("Digite o limite do cartão: ");
        Scanner leitura = new Scanner(System.in);

        double limite = leitura.nextDouble();
        CartaoCredito cartaoCredito = new CartaoCredito(limite);

        while (controle == true) {
            System.out.println("#####################");
            System.out.println("1 Efetuar compra");
            System.out.println("");
            System.out.println("2 Fatura detalhada");
            System.out.println("");
            System.out.println("3 Pagar Fatura ");
            System.out.println("");
            System.out.println("4 Sair");
            System.out.println("");
            System.out.println("Digite a opção desejada:");
            System.out.println("#####################");
            Scanner entrada = new Scanner(System.in);
            int numero = entrada.nextInt();


            switch (numero){
                case 1:

                    int sair = 1;
                    while(sair != 0) {
                        System.out.println("Digite a descrição da compra: ");
                        String descricaoCompra = leitura.next();

                        System.out.println("Digite o valor da compra: R$ ");
                        double valorCompra = leitura.nextDouble();

                        Compra compra = new Compra(descricaoCompra, valorCompra);
                        boolean compraRealizada = cartaoCredito.lancaCompra(compra);

                        if (compraRealizada) {
                            System.out.println("Compra realizada!");
                            System.out.println("Digite 0 para sair ou 1 para continuar a compra");
                            sair = leitura.nextInt();
                        } else {
                            System.out.println("Saldo insuficiente!");
                            sair = 0;
                        }
                    }
                    break;
                case 2:
                    for (Compra item: cartaoCredito.getCompras()) {
                        System.out.println("item: " + item.getDescricao() + " Valor R$ " + item.getValor());
                    }
                    System.out.println("\n***********************");
                    System.out.println("Valor da fatura R$ " + cartaoCredito.getValorFatura());

                    System.out.println("\nSaldo do cartão: " + cartaoCredito.getSaldo());

                    break;
                case 3:
//                    System.out.println("O valor da sua fatura é de R$ " + fatura);
//                    System.out.println("Insira o valor a ser pago");
//                    Scanner pagaFatura = new Scanner(System.in);
//                    double valorPgtoFatura = pagaFatura.nextDouble();
//
//                    if(valorPgtoFatura > fatura) {
//                        System.out.println("O valor deve ser inferior ao valor da fatura");
//                        break;
//                    }
//                    fatura = fatura - valorPgtoFatura;
//                    saldo = saldo + valorPgtoFatura;
//                    System.out.println("Fatura paga com sucesso, obrigado");
//                    break;

                case 4:
                    System.out.println("Obrigado por usar o banco XYZ");
                    controle = false;
                    break;
            }
        }
    }
}