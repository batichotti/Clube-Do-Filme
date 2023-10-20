package Entidades;

import Entidades.MovieCompany;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-20T08:31:06", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ProductionCompany.class)
public class ProductionCompany_ { 

    public static volatile SingularAttribute<ProductionCompany, Integer> companyId;
    public static volatile SingularAttribute<ProductionCompany, String> companyName;
    public static volatile ListAttribute<ProductionCompany, MovieCompany> movieCompanyList;

}