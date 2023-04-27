package service;

import domain.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FuncionarioRepository;
import exception.UserNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario addFuncionario(Funcionario funcionario) {
        funcionario.setEmployeeCode(UUID.randomUUID().toString());
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> buscarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Funcionario atualizarFuncinario( Funcionario funcionario){
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
