package com.example.agenciaviajerojavaspringboot.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column
    private String nome;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String cpf;

    @Column
    private String telefone;

    @Column
    private String email;

    @Column
    private String senha;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<Pedido> pedido;

    public Usuario() {

    }

    public Usuario(int idUsuario, String nome, LocalDate dataNascimento, String cpf, String telefone, String email, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
