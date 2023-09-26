package Entidades;

import Entidades.Movie;
import Entidades.MovieHasUserPK;
import Entidades.User;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-09-26T11:47:44", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(MovieHasUser.class)
public class MovieHasUser_ { 

    public static volatile SingularAttribute<MovieHasUser, Movie> movie;
    public static volatile SingularAttribute<MovieHasUser, MovieHasUserPK> movieHasUserPK;
    public static volatile SingularAttribute<MovieHasUser, BigDecimal> rating;
    public static volatile SingularAttribute<MovieHasUser, String> comment;
    public static volatile SingularAttribute<MovieHasUser, User> user;
    public static volatile SingularAttribute<MovieHasUser, Short> favorited;

}