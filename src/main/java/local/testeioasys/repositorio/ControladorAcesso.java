/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.testeioasys.repositorio;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vitor
 */
public class ControladorAcesso {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesteIoasys_PU");
    private static EntityManager _EntityManager;
    
    public synchronized static EntityManager getGlobalEntityManager()
    {
        if (_EntityManager == null) {
            _EntityManager = emf.createEntityManager();
        }
        
        if(!_EntityManager.isOpen())
        {
            _EntityManager = emf.createEntityManager();
        }
        return _EntityManager;
    }
}
