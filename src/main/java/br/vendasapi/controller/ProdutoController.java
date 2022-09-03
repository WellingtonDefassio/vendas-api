package br.vendasapi.controller;

import br.vendasapi.form.ProdutoFormRequest;
import br.vendasapi.model.Produto;
import br.vendasapi.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {


    ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody ProdutoFormRequest formProduto) {
        Produto produto = formProduto.converter();
        produtoRepository.save(produto);
        ProdutoFormRequest produtoFormRequest = ProdutoFormRequest.toFromRequest(produto);

        return new ResponseEntity(produtoFormRequest, HttpStatus.OK);
    }


}
