/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.testeBrasilPrev.repositorio;

import local.testeBrasilPrev.repositorio.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vitor
 */
public interface RepositorioCliente extends JpaRepository<Cliente, Long> {

}