/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.ProductBean;
import entity.Produto;
import entity.Vendedor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author pedro
 */
@Named(value = "ProductCtl")
@RequestScoped
public class ProductCtl {

    @EJB
    private ProductBean pb;
    private List<Produto> productList = new ArrayList<>();

    private Produto prod = new Produto();
    private Vendedor vende = new Vendedor();

    private int aux = 0;

    /**
     * @return the pb
     */
    public ProductBean getPb() {
        return pb;
    }

    /**
     * @param pb the pb to set
     */
    public void setPb(ProductBean pb) {
        this.pb = pb;
    }

    /**
     * @return the productList
     */
    public List<Produto> getProductList() {
        this.productList = pb.getProducts();
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Produto> productList) {
        this.productList = productList;
    }

    /**
     * @return the prod
     */
    public Produto getProd() {
        return prod;
    }

    /**
     * @param prod the prod to set
     */
    public void setProd(Produto prod) {
        this.prod = prod;
    }

    

    /**
     * @return the vende
     */
    public Vendedor getVende() {
        return vende;
    }

    /**
     * @param vende the vende to set
     */
    public void setVende(Vendedor vende) {
        this.vende = vende;
    }

    /**
     * @return the aux
     */
    public int getAux() {
        return aux;
    }

    /**
     * @param aux the aux to set
     */
    public void setAux(int aux) {
        this.aux = aux;
    }

    public String mostraVendedor() {
        String nm = "";
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProdid().equals(aux)) {
                nm = productList.get(i).getNome();
                return nm;
            }
        }
        return null;
    }

   
}
