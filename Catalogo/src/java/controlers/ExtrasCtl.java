/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.ProductBean;
import beans.VendedorBean;
import entity.Produto;
import entity.Vendedor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author pedro
 */
@Named(value = "ExtrasCtl")
@RequestScoped

public class ExtrasCtl {

    @EJB
    private ProductBean pb;
    @EJB
    private VendedorBean vb;

    private int aux = 0;
    private String nm = "";

    private List<Produto> productList = new ArrayList<>();
    private List<Vendedor> vendedorList = new ArrayList<>();
    //@ManagedProperty("#{param.vendedor}")
    private Vendedor vende = new Vendedor();
    private Produto prod = new Produto();

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
     * @return the vb
     */
    public VendedorBean getVb() {
        return vb;
    }

    /**
     * @param vb the vb to set
     */
    public void setVb(VendedorBean vb) {
        this.vb = vb;
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

    /**
     * @return the nm
     */
    public String getNm() {
        return nm;
    }

    /**
     * @param nm the nm to set
     */
    public void setNm(String nm) {
        this.nm = nm;
    }

    /**
     * @return the productList
     */
    public List<Produto> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Produto> productList) {
        this.productList = productList;
    }

    /**
     * @return the vendedorList
     */
    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }

    /**
     * @param vendedorList the vendedorList to set
     */
    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
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

    public String mostraVendedor() {
        for (int i = 0; i < getProductList().size(); i++) {
            if (getProductList().get(i).getProdid() == getAux()) {

                setNm(getVendedorList().get(i).getNome());

                //setNm(productList.get(i).getNome());
                return "showVendedorProd.xhmtl";
            }
        }
        return "index.xhtml";
    }

    public String dropStock() {
        int newStock;
        productList = pb.getProducts();

        //verificar se este produto é deste user
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProdid() == prod.getProdid()) {

                newStock = productList.get(i).getStock();//stock existente
                newStock -= prod.getStock();//stock novo

                pb.alterStock(newStock, prod.getProdid()/*, vende.getNome()*/);//atualizar ha lista 
                //NAO VERIFICA SE PE DO UTILIZADOR
                vende.setNome(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("vendedor"));
                return "userPage.xhmtl";

            }
        }

        return "index.xhmtl";
    }

    public String checkVendedor() {
        vendedorList = vb.getVendedor();
        for (int i = 0; i < vendedorList.size(); i++) {
            if (vendedorList.get(i).getNome().equals(vende.getNome())) {
                
                return "userPage.xhtml";
            }
        }
        return "reLogin.xhtml";
    }

    public String gotoDropStock() {
        vende.setNome(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("vendedor"));
        return "dropStock.xhtml";
    }

    public String gotoAddProd() {
        vende.setNome(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("vendedor"));
        return "addNewProduct.xhtml";
    }

    public void removeVendedor() {
        pb.removeProdByVend(getVendedorByNome(vende.getNome()));
        vb.removeVendedorBean(vende.getNome());
        vendedorList = vb.getVendedor();
        productList = pb.getProducts();
    }

    public Vendedor getVendedorByNome(String s) {
        for (int i = 0; i < vendedorList.size(); i++) {
            if (vendedorList.get(i).getNome().equals(s)) {
                return vendedorList.get(i);
            }

        }
        return null;
    }

    public String addVendedor() {
        vb.addVendedor(vende);

        vendedorList = vb.getVendedor();
        return "login.xhtml";
    }

    public String addNewProduct() {
        prod.setVendid(vende);

        pb.addProduct(prod);

        productList = pb.getProducts();

        return "userPage.xhtml";
    }

}
