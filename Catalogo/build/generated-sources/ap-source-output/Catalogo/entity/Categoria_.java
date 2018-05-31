package Catalogo.entity;

import Catalogo.entity.Produto;
import Catalogo.entity.Vendedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:58:37")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, Vendedor> vendedor;
    public static volatile SingularAttribute<Categoria, Produto> produto;
    public static volatile SingularAttribute<Categoria, Integer> cateid;
    public static volatile SingularAttribute<Categoria, String> nome;
    public static volatile SingularAttribute<Categoria, Produto> prodid;

}