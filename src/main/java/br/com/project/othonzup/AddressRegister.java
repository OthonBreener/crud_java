package br.com.project.othonzup;

import javax.persistence.*;

@Entity
public class AddressRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String estado;
    private String CEP;

    @ManyToOne
    private User titular;

    @Deprecated
    public AddressRegister() {
    }

    public AddressRegister(String logradouro, Integer numero, String complemento, String bairro, String estado, String CEP, User titular) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
        this.CEP = CEP;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getCEP() {
        return CEP;
    }

}
