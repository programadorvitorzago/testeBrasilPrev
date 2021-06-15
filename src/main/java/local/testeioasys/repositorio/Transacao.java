/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.testeioasys.repositorio;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author Vitor
 */
public class Transacao {
    
    @Transactional
    public void Persist(EntityManager em, Object obj)
    {
        em.persist(obj);
    }
}
