package entity;

public class Cliente {
    private static Integer count = 1;
    private String nome, cpf, email;


    public Cliente(String nome, String cpf, String email) {

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        count +=1;

    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    @Override
    public String toString() {
        return "{" +
                ", nome='" + getNome() + "'" +
                ", cpf='" + getCpf() + "'" +
                ", email='" + getEmail() + "'" +
                "}";
    }



}

