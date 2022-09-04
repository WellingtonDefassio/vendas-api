package br.vendasapi.form;

import br.vendasapi.model.Produto;
import br.vendasapi.repository.ProdutoRepository;

import java.math.BigDecimal;

public class ProdutoAtualizarFormRequest {
    private Long id;
    private String descricao;
    private BigDecimal preco;
    private String nome;


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


    public void atualizar(Produto produto, ProdutoRepository produtoRepository) {
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);

        produtoRepository.save(produto);

    }
}
