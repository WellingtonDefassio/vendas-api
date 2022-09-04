package br.vendasapi.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity()
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nome;
    @Column(length = 255)
    private String descricao;
    @Column(scale = 2, precision = 16)
    private BigDecimal preco;
    @Column(length = 100)
    private String sku;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    public Produto() {
    }

    public Produto( String nome, String descricao, BigDecimal preco, String sku) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.sku = sku;
    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, String sku, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.sku = sku;
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
