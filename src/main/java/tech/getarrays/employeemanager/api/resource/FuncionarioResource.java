package tech.getarrays.employeemanager.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import tech.getarrays.employeemanager.domain.model.Funcionario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.domain.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private final FuncionarioService funcionarioService;

    public FuncionarioResource(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Funcionario>> buscarTodosFuncionarios(){
        List<Funcionario> funcionarios = funcionarioService.buscarTodosFuncionarios();
        return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable("id") Long id){
        Funcionario funcionario = funcionarioService.buscarPorId(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Funcionario> addFuncionario(@RequestBody Funcionario funcionario){
        Funcionario novoFuncionario = funcionarioService.addFuncionario(funcionario);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable("id") Long id, @RequestBody Funcionario funcionario) throws Exception {
        Funcionario atualizarFuncionario = funcionarioService.atualizarFuncinario(id, funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(atualizarFuncionario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarFuncionario(@PathVariable("id") Long id){
        funcionarioService.deletarFuncionario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

