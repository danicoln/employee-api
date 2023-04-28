package tech.getarrays.employeemanager.domain.service;

import org.springframework.transaction.annotation.Transactional;
import tech.getarrays.employeemanager.domain.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.domain.repository.FuncionarioRepository;
import tech.getarrays.employeemanager.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> buscarTodosFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Funcionario addFuncionario(Funcionario funcionario) {
        funcionario.setEmployeeCode(UUID.randomUUID().toString());
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncinario( Long id, Funcionario funcionario) throws Exception {
        Optional<Funcionario> optFuncionario = Optional.ofNullable(this.buscarPorId(id));
        if(optFuncionario.isEmpty()){
            throw new Exception("Funcionário não cadastrado");
        }
        funcionario.setId(id);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarPorId(Long id){
        return funcionarioRepository.findFuncionarioById(id)
                .orElseThrow(()-> new UserNotFoundException("Usuario com id" + id + "não foi encontrado!"));
    }

    public void deletarFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }
}
