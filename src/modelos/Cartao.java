package modelos;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cartao {

    private String nome;
    private int ID;
    private int limite;
    private int saldo;
    private List<Compra> compras;

    Random random = new Random();

    public Cartao(String nome, int ID, int limite, int saldo) {
        this.nome = nome;
        this.ID = ID;
        this.limite = limite;
        this.saldo = saldo;
        this.compras = new LinkedList<>();
    }

    public boolean lancaCompra(Compra compra) {
        if (this.saldo >= compra.getValor() && this.limite > compra.getValor()) {
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            System.out.println("Compra realizada com sucesso!");
            return true;
        } else if (this.limite < compra.getValor()) {
            System.out.println("A compra passa do seu limite");
            return false;
        } else if (this.saldo < compra.getValor()) {
            System.out.println("Saldo insuficiente");
            return false;
        }else{
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getID() {
        return ID;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    @Override
    public String toString() {
        return "Cartao[" +
                "nome='" + nome + '\'' +
                ", ID=" + ID +
                ", limite=" + limite +
                ", saldo=" + saldo +
                ", compras=" + compras +
                ']';
    }
}
