package br.com.project.othonzup;


public class AddressRegisterResponse {

    private String logradouro;

    private Integer numero;

    private String complemento;

    private String bairro;

    private String estado;

    private String CEP;


    AddressRegisterResponse(AddressRegister addressRegister) {
        this.logradouro = addressRegister.getLogradouro();
        this.numero = addressRegister.getNumero();
        this.complemento = addressRegister.getComplemento();
        this.bairro = addressRegister.getBairro();
        this.estado = addressRegister.getEstado();
        this.CEP = addressRegister.getCEP();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
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
