/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Produto;
import entity.Vendedor;
import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pedro
 */
@Stateless
public class ProductBean {

    @PersistenceContext
    EntityManager em;

    public List<Produto> getProducts(){
        return (List<Produto>) em.createNamedQuery("Produto.findAll").getResultList();
    }

    public Produto addProduct(Produto p) {
        em.persist(p);
        return p;
    }
    public void alterStock(int st , int pid /*, String nm*/){
        Query query = em.createNamedQuery("Produto.changeStock");
        query.setParameter( "stock", st);
        query.setParameter("prodid",pid);
        //query.setParameter("vendid",nm);
        query.executeUpdate();
        
    }    
    
    public void removeProdByVend(Vendedor nome) {
        Query query = em.createNamedQuery("Produto.remByCli");
        query.setParameter( "vendid", nome.getNome());
        query.executeUpdate();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
