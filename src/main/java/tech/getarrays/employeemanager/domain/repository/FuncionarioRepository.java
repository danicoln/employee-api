package tech.getarrays.employeemanager.domain.repository;

import org.springframework.stereotype.Repository;
import tech.getarrays.employeemanager.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findFuncionarioById(Long id);
}
