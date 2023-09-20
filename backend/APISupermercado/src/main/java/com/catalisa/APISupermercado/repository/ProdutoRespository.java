package com.catalisa.APISupermercado.repository;

import com.catalisa.APISupermercado.model.ProdutoModel;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRespository extends JpaRepository<ProdutoModel, Long> {

    Optional<List<ProdutoModel>> findByNome(String nome);

}
