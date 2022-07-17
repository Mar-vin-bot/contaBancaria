package entity;

import utilitarios.Utils;

public class Conta {

    private static Integer countConta;


    private Integer numConta;
    private Cliente cliente;
    private Double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.numConta = countConta;
        this.cliente = cliente;
        countConta +=1;
    }


    public Integer getNumConta() {
        return this.numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    @Override
    public String toString() {
        return "{" +
                " numConta='" + getNumConta() + "'" +
                ", cliente='" + getCliente() + "'" +
                ", saldo='" + Utils.doubleToString(this.getSaldo()) + "'" +
                "}";
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
        } else {
            System.out.println("Não foi possivel realizar deposito");
        }
    }

    public void sacar(Double valor) {
        if (getSaldo() > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
        } else {
            System.out.println("Não foi possivel realizar saque");
        }
    }

    public void transferir (Double valor, Conta contaDeposito){
        if (getSaldo() > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaDeposito.saldo = contaDeposito.getSaldo()+valor;

            System.out.println(" Transferencia realizada com sucesso");
        } else {
            System.out.println("Não foi possivel realizar transferencia");
        }

    }

}

