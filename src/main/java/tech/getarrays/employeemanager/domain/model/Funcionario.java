package tech.getarrays.employeemanager.domain.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "funcionarios")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cargoTitulo;
    private String telefone;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    public Funcionario() {
    }

    public Funcionario(String nome, String email, String cargoTitulo, String telefone, String imageUrl, String employeeCode) {
        this.nome = nome;
        this.email = email;
        this.cargoTitulo = cargoTitulo;
        this.telefone = telefone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargoTitulo() {
        return cargoTitulo;
    }

    public void setCargoTitulo(String cargoTitulo) {
        this.cargoTitulo = cargoTitulo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cargoTitulo='" + cargoTitulo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}
