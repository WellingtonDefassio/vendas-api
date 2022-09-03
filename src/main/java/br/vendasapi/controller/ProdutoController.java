package br.vendasapi.controller;

import br.vendasapi.form.ProdutoFormRequest;
import br.vendasapi.model.Produto;
import br.vendasapi.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {


    ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody ProdutoFormRequest formProduto) {

        Produto produto = new Produto(formProduto.getNome(), formProduto.getDescricao(), formProduto.getPreco(), formProduto.getSku());

        produtoRepository.save(produto);

        return new ResponseEntity(produto, HttpStatus.OK);
    }


}
