package br.com.project.othonzup;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email; //unico

    @Column(nullable = false, unique = true)
    private String cpf; //unico

    @Column(nullable = false)
    private String dataNascimento;

    @OneToMany(mappedBy = "titular")
    private List<AddressRegister> address = new ArrayList<>();

    public User(String nome, String email, String cpf, String dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Deprecated
    public User() {
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getId() {
        return id;
    }

    public List<AddressRegister> getAddress() {
        return address;
    }
}
