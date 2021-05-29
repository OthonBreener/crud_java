package br.com.project.othonzup;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?>cadastrarUsuario(@RequestBody @Valid UserRequest usuario) {
        if (repository.existsByEmail(usuario.getEmail()) || repository.existsByCpf(usuario.getCpf()) ) {
            return ResponseEntity.badRequest().build();

        }
        User salvo = repository.save(usuario.paraModelo());
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(salvo));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> mostrar() {
        return ResponseEntity.ok(repository.findAll().stream().map(UserResponse::new).collect(Collectors.toList()));
    }
}

//
