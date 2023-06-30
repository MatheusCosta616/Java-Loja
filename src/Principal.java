import modelos.Cartao;
import modelos.Compra;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int newID = random.nextInt(100);
        System.out.println("Digite o nome do titular do cartão");
        String nome = scanner.nextLine();
        System.out.println("Digite o limite do cartão");
        int limite = scanner.nextInt();
        System.out.println("Digite o saldo do cartão");
        int saldo = scanner.nextInt();
        scanner.nextLine();
        Cartao cartao = new Cartao(nome, newID, limite, saldo);

        int sair = 0;

        System.out.println("""
                    ******************************************
                                 LOJA DE ROUPAS
                                SEJA BEM-VINDO(A)!
                    ******************************************
                    """);

        while (sair == 0){

            System.out.println("Seu saldo: " + cartao.getSaldo());
            System.out.println("Seu limite: " + cartao.getLimite());

            System.out.println("Você dejesa comprar algo? S/N");
            String resposta = scanner.nextLine().toLowerCase();
            if(resposta.equals("s")){
                System.out.println("Digite seu produto:");
                String produto = scanner.nextLine().toLowerCase();
                System.out.println("Digite o valor do produto");
                int valor = scanner.nextInt();
                Compra compra = new Compra(produto, valor);
                boolean compraRealizada = cartao.lancaCompra(compra);
                scanner.nextLine();

                if(cartao.getSaldo() == 0){
                    System.out.println("Você já não tem mais dinheiro na conta!");
                    break;
                }
            }else if (resposta.equals("n")){
                System.out.println("Obrigado por utilizar o produto!");
                break;
            }
        }
    }
}