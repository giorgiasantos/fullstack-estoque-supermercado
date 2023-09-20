package com.catalisa.APISupermercado.controller;

import com.catalisa.APISupermercado.model.ProdutoModel;
import com.catalisa.APISupermercado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")

public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<List<ProdutoModel>> listarTodos(){
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping(path = "/buscaId/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<ProdutoModel> produtoModel = produtoService.buscarPorId(id);

        if(produtoModel.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(produtoModel);
    }

    @GetMapping(path = "/buscaNome/{nome}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<?> buscarPorId(@PathVariable String nome){
        Optional<List<ProdutoModel>> produtoModel = produtoService.buscarPorNome(nome);

        if(produtoModel.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(produtoModel);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<ProdutoModel> cadastrar (@RequestBody ProdutoModel produtoModel){
        return ResponseEntity.ok(produtoService.cadastrar(produtoModel));
    }
}
