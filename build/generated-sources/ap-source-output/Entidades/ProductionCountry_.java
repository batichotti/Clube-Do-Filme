package Entidades;

import Entidades.Country;
import Entidades.Movie;
import Entidades.ProductionCountryPK;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-22T15:18:00", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ProductionCountry.class)
public class ProductionCountry_ { 

    public static volatile SingularAttribute<ProductionCountry, String> productionCountrycol;
    public static volatile SingularAttribute<ProductionCountry, Country> country;
    public static volatile SingularAttribute<ProductionCountry, Movie> movie;
    public static volatile SingularAttribute<ProductionCountry, ProductionCountryPK> productionCountryPK;

}