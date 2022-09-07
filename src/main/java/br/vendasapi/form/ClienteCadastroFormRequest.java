package br.vendasapi.form;

import br.vendasapi.model.Cliente;
import br.vendasapi.model.Produto;

import java.time.LocalDate;

public class ClienteCadastroFormRequest {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate cadastro;

    public ClienteCadastroFormRequest() {
    }

    public ClienteCadastroFormRequest(Long id, String nome, String cpf, LocalDate dataNascimento, String endereco, String email, String telefone, LocalDate cadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cadastro = cadastro;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }

    public Cliente toModel() {
        return new Cliente(id, dataNascimento, cpf,nome, endereco, telefone, email, cadastro);
    }

    public static ClienteCadastroFormRequest fromModel(Cliente cliente) {
        return new ClienteCadastroFormRequest(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getNascimento(), cliente.getEndereco(), cliente.getEmail(), cliente.getEmail(), cliente.getDataCadastro());
    }
}
