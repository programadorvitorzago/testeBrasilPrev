/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.testeBrasilPrev.controller;

import java.util.List;
import java.util.Optional;
import local.testeBrasilPrev.repositorio.RepositorioCliente;
import local.testeBrasilPrev.repositorio.entidade.Cliente;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vitor
 */
@RestController
@RequestMapping("/cliente")
public class ClienteAPIService {

    @Autowired
    private RepositorioCliente repCliente;

    /**
     * Insert new itens
     *
     * @param cliente
     * @return
     */
    @PostMapping
    public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {
        cliente = repCliente.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    /**
     * Get all
     *
     * @return
     */
    @GetMapping
    public List<Cliente> listar() {
        return repCliente.findAll();
    }

    /**
     * Find an especific iten where ID de UK for the iten
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        Optional<Cliente> result = repCliente.findById(id);

        if (!result.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result.get());
    }

    /**
     * Update the iten with new values
     *
     * @param id
     * @param cliente
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> result = repCliente.findById(id);

        if (!result.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Cliente existente = result.get();

        BeanUtils.copyProperties(cliente, existente, "id");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cliente);
    }

    /**
     * Delete the iten where ID param is the Id to delete
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Optional<Cliente> result = repCliente.findById(id);

        if (!result.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Cliente existente = result.get();

        repCliente.delete(existente);

        return ResponseEntity.noContent().build();
    }

}
