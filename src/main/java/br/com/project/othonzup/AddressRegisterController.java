package br.com.project.othonzup;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class AddressRegisterController {
    private final UserRepository userRepository;

    private final AddressRegisterRepository addressRegisterRepository;

    public AddressRegisterController(UserRepository userRepository, AddressRegisterRepository addressRegisterRepository) {
        this.userRepository = userRepository;
        this.addressRegisterRepository = addressRegisterRepository;
    }

    @PostMapping("enderecos")
    public ResponseEntity<AddressRegisterResponse> cadastrarEndereco(@RequestBody @Valid AddressRegisterRequest addressRegisterRequest) {
        AddressRegister salvo = addressRegisterRepository.save(addressRegisterRequest.paraModelo(userRepository));

        return ResponseEntity.status(HttpStatus.CREATED).body(new AddressRegisterResponse(salvo));
    }

    @GetMapping("users/{idUsuario}/enderecos")
    public ResponseEntity<List<AddressRegisterResponse>> listarEnderecosUsuario(@PathVariable Long idUsuario) {
        List<AddressRegisterResponse> enderecos =  addressRegisterRepository.findByTitularId(idUsuario).stream().map(AddressRegisterResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(enderecos);
    }
}

