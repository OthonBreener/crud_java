package br.com.project.othonzup;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressRegisterRequest {
    @NotNull
    private Long idTitular;

    @NotBlank
    private String logradouro;

    @NotNull
    private Integer numero;

    @NotBlank
    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String estado;

    @NotBlank
    @JsonProperty
    private String CEP;

    public AddressRegister paraModelo(UserRepository repository) {
        User titular = repository.getById(idTitular);
        return new AddressRegister(this.logradouro, this.numero, this.complemento, this.bairro, this.estado, this.CEP, titular);
    }

    public Long getIdTitular() {
        return idTitular;
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

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
