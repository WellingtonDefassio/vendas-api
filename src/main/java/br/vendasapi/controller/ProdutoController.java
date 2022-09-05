package br.vendasapi.controller;

import br.vendasapi.form.ProdutoAtualizarFormRequest;
import br.vendasapi.form.ProdutoCadastroFormRequest;
import br.vendasapi.model.Produto;
import br.vendasapi.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {


    ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody ProdutoCadastroFormRequest formProduto) {
        Produto produto = formProduto.converter();
        produtoRepository.save(produto);
        ProdutoCadastroFormRequest produtoCadastroFormRequest = ProdutoCadastroFormRequest.toFromRequest(produto);

        return new ResponseEntity(produtoCadastroFormRequest, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody ProdutoAtualizarFormRequest formProduto) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (!optionalProduto.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        formProduto.atualizar(optionalProduto.get(), this.produtoRepository);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity listar() {

        return new ResponseEntity(produtoRepository.findAll().stream().map(ProdutoCadastroFormRequest::toFromRequest).toList(), HttpStatus.OK);
    }


}
