/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.testeioasys.repositorio;

import com.google.gson.Gson;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.NotSupportedException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

/**
 *
 * @author Vitor
 */
public abstract class RepositorioBase<T> {
    
    private Class<T> tipo;
    private Gson conversorJSON = new Gson();

    protected abstract EntityManager getEntityManager();
    
    public RepositorioBase(Class<T> entityClass) {
        this.tipo = entityClass;
    }

    public void INSERT(T entidade) {
        this.getEntityManager().persist(entidade);
        this.getEntityManager().close();
    }
    
    @Transactional
    public void UPDATE(T entity) {
        getEntityManager().merge(entity);
        this.getEntityManager().close();
    }

    @Transactional
    public void DELETE(T entity) {
        getEntityManager().remove(entity);
        this.getEntityManager().close();
    }

    public T GET(Object id) {
        T t = getEntityManager().find(this.tipo, id);
        return t;
    }
    
    public List<T> getAll() {
        CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(this.tipo);
        Root<T> rootEntry = cq.from(this.tipo);
        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = this.getEntityManager().createQuery(all);
        return allQuery.getResultList();
    }

    public int COUNT() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(this.tipo);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public String toJson(Object objeto)
    {
        return conversorJSON.toJson(objeto);
    }
    
    public T fromJson(String json)
    {
        return conversorJSON.fromJson(json, this.tipo);
    }
}