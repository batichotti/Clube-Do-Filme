package Entidades;

import Entidades.MovieHasUser;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-09-03T14:55:18", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, String> overview;
    public static volatile ListAttribute<Movie, MovieHasUser> movieHasUserList;
    public static volatile SingularAttribute<Movie, Integer> runtime;
    public static volatile SingularAttribute<Movie, Integer> movieId;
    public static volatile SingularAttribute<Movie, String> title;
    public static volatile SingularAttribute<Movie, Integer> budget;
    public static volatile SingularAttribute<Movie, String> homepage;

}