package Entidades;

import Entidades.Movie;
import Entidades.MovieCompanyPK;
import Entidades.ProductionCompany;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-16T10:09:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(MovieCompany.class)
public class MovieCompany_ { 

    public static volatile SingularAttribute<MovieCompany, Movie> movie;
    public static volatile SingularAttribute<MovieCompany, ProductionCompany> productionCompany;
    public static volatile SingularAttribute<MovieCompany, MovieCompanyPK> movieCompanyPK;
    public static volatile SingularAttribute<MovieCompany, String> movieCompanycol;

}