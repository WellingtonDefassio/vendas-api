package br.vendasapi.form;

import br.vendasapi.model.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoCadastroFormRequest {
    private Long id;
    private String descricao;
    private String sku;
    private BigDecimal preco;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate cadastro;

    public ProdutoCadastroFormRequest(Long id, String descricao, String sku, BigDecimal preco, String nome, LocalDate cadastro) {
        this.id = id;
        this.descricao = descricao;
        this.sku = sku;
        this.preco = preco;
        this.nome = nome;
        this.cadastro = cadastro;
    }

    public ProdutoCadastroFormRequest() {
    }

    public static ProdutoCadastroFormRequest toFromRequest(Produto produto) {
        return new ProdutoCadastroFormRequest(produto.getId(), produto.getDescricao(), produto.getSku(), produto.getPreco(), produto.getNome(), produto.getDataCadastro());
    }

    public Produto converter() {
        return new Produto(id, nome, descricao, preco, sku, cadastro);
    }

    public LocalDate getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
