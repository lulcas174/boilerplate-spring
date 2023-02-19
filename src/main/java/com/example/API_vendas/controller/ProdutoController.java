package com.example.API_vendas.controller;

import com.example.API_vendas.models.Produto;
import com.example.API_vendas.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/listar")
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @PostMapping("/cadastrar")
    public Produto cadastrarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @GetMapping("/buscar/{id}")
    public Produto buscarProduto(@PathVariable int id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    @PutMapping("/atualizar/{id}")
    public Produto atualizarProduto(@PathVariable int id, @RequestBody Produto produto){
        Produto produtoAtualizado = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
        produtoAtualizado.setNome(produto.getNome());
        produtoAtualizado.setDescricao(produto.getDescricao());
        produtoAtualizado.setPreco(produto.getPreco());
        produtoAtualizado.setQuantidade(produto.getQuantidade());
        produtoAtualizado.setFormaPagamento(produto.getFormaPagamento());
        return produtoRepository.save(produtoAtualizado);
    }

}
