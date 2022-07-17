package org.example;

import entity.Cliente;
import entity.Conta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Conta> contaBancarias;

    public static void main(String[] args) {

        contaBancarias = new ArrayList<Conta>();
        operacoes();

    }

    public static void operacoes( ){

        System.out.println("--------------------BEM VINDO--------------------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("--------------------Escolha uma opção------------------------");
        System.out.println("-----OPÇÃO  1---------------Criar conta----------------------");
        System.out.println("-----OPÇÃO  2---------------Depositar------------------------");
        System.out.println("-----OPÇÃO  3---------------Sacar----------------------------");
        System.out.println("-----OPÇÃO  4---------------Transferir-----------------------");
        System.out.println("-----OPÇÃO  5---------------Listar---------------------------");
        System.out.println("-----OPÇÃO  6---------------Sair-----------------------------");

        int operacoes = sc.nextInt();

        switch(operacoes){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado");;
                System.exit(0);
            default:
                System.out.println("Opção invalida");
                operacoes();
                break;

        }


    }

    public static void criarConta() {

        System.out.println("Nome");
        String nome = sc.next();

        System.out.println("cpf");
        String cpf = sc.next();

        System.out.println("email");
        String email = sc.next();

        Cliente cliente = new Cliente(nome, cpf, email);

        Conta conta = new Conta(cliente);

        contaBancarias.add(conta);
        System.out.println("Conta criada com sucesso");

        operacoes();

    }

    private static Conta encontrarConta(int numConta) {
        Conta conta = null;
        if (contaBancarias.size() > 0) {
            for (Conta c : contaBancarias) {
                if (c.getNumConta() == numConta)
                    conta = c;
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Numero conta de deposito");
        int x = sc.nextInt();

        Conta conta = encontrarConta(x);

        if (conta != null) {
            System.out.println("Qual valor do deposito?");
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado");
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Numero conta de saque");
        int x = sc.nextInt();

        Conta conta = encontrarConta(x);

        if (conta != null) {
            System.out.println("Qual valor do saque?");
            double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("Valor saque");
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Numero da conta remetente");
        int Remetente = sc.nextInt();

        System.out.println("Numero da conta remetente");
        int Destinatario = sc.nextInt();

        Conta contaRemetente = encontrarConta(Remetente);

        Conta contaDestinatario = encontrarConta(Destinatario);

        if (contaRemetente != null && contaDestinatario != null) {

            System.out.println("Qual valor da transferencia?");
            double valorTrasn = sc.nextDouble();

            contaRemetente.transferir(valorTrasn,contaDestinatario );

            System.out.println("Transferencia realizada");


        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();


    }

    public static void listarContas(){
        if(contaBancarias.size() > 0){
            for (Conta conta : contaBancarias) {
                System.out.println(conta);
            }
        }else{
            System.out.println("Sem contas cadastradas");
        }
    }
}