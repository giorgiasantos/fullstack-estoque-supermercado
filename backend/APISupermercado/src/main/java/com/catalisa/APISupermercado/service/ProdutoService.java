package com.catalisa.APISupermercado.service;

import com.catalisa.APISupermercado.model.ProdutoModel;
import com.catalisa.APISupermercado.repository.ProdutoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRespository produtoRespository;

    public List<ProdutoModel> listarTodos (){
        return produtoRespository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId(Long id){

        Optional<ProdutoModel> produtoModel = produtoRespository.findById(id);

        if(produtoModel.isPresent()) {
            return produtoModel;
        }

        return Optional.empty();
    }

    public Optional<List<ProdutoModel>> buscarPorNome(String nome){

        Optional<List<ProdutoModel>> produtoModel = produtoRespository.findByNome(nome);

        if(produtoModel.isPresent()) {
            return produtoModel;
        }

        return Optional.empty();
    }

    public ProdutoModel cadastrar (ProdutoModel produtoModel){
        return produtoRespository.save(produtoModel);
    }
}
