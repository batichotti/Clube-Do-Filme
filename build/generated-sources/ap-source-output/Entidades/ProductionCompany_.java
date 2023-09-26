package Entidades;

import Entidades.Movie;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-09-26T11:47:44", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ProductionCompany.class)
public class ProductionCompany_ { 

    public static volatile SingularAttribute<ProductionCompany, Integer> companyId;
    public static volatile SingularAttribute<ProductionCompany, String> companyName;
    public static volatile ListAttribute<ProductionCompany, Movie> movieList;

}