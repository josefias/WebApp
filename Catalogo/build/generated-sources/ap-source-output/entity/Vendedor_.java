package entity;

import entity.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T22:24:59")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile SingularAttribute<Vendedor, Integer> contacto;
    public static volatile SingularAttribute<Vendedor, String> nome;
    public static volatile CollectionAttribute<Vendedor, Produto> produtoCollection;

}