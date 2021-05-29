package br.com.project.othonzup;

public class UserResponse {

    private String nome;

    private String email;

    private String dataNascimento;

    UserResponse(User user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.dataNascimento = user.getDataNascimento();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
}

