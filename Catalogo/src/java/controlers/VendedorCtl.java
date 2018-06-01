/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import entity.Vendedor;
import beans.VendedorBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Utilizador
 */
@Named(value = "VendedorCtl")
@RequestScoped
public class VendedorCtl {

    @EJB
    private VendedorBean vb;
    private List<Vendedor> vendedorList = new ArrayList<>();

    private Vendedor novoVendedor = new Vendedor();

    //Vendedor x = new Vendedor();
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
     * @return the vendedorList
     */
    public List<Vendedor> getVendedorList() {
        vendedorList = vb.getVendedor();
        return vendedorList;
    }

    /**
     * @param vendedorList the vendedorList to set
     */
    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }

    public void addNewVendedor() {
        vb.addVendedor(getNovoVendedor());
        vendedorList = vb.getVendedor();
    }

    public void removeVendedor() {

    }

    /**
     * @return the novoVendedor
     */
    public Vendedor getNovoVendedor() {
        return novoVendedor;
    }

    /**
     * @param novoVendedor the novoVendedor to set
     */
    public void setNovoVendedor(Vendedor novoVendedor) {
        this.novoVendedor = novoVendedor;
    }

    public String checkVendedor() {
        vendedorList = vb.getVendedor();
        for (int i = 0; i < vendedorList.size(); i++) {
            if (vendedorList.get(i).getNome().equals(novoVendedor.getNome())) {
                return "userPage.xhtml";
            }
        }
        return "reLogin.xhtml";
    }
    
    public String addVendedor(){
        vb.addVendedor(novoVendedor);
        
        vendedorList = vb.getVendedor();
    return "userPage.xhtml";
    }

}
