/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Vendedor;
import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Utilizador
 */
@Stateless
public class VendedorBean {

    @PersistenceContext
    EntityManager em;

    public List<Vendedor> getVendedor() {
        return (List<Vendedor>) em.createNamedQuery("Vendedor.findAll").getResultList();
    }

    public Vendedor addVendedor(Vendedor v) {
        em.persist(v);
        return (v);
    }

    public void removeVendedorBean(String nome) {
        Query query = em.createNamedQuery("Vendedor.removeVend");
        query.setParameter( "remCli", nome);
        //query.setParameter("vendid",nm);
        query.executeUpdate();
        
    }
}
