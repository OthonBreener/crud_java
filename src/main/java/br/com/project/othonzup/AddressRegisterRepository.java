package br.com.project.othonzup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRegisterRepository extends JpaRepository<AddressRegister,Long> {
    List<AddressRegister> findByTitularId(Long id);
}
