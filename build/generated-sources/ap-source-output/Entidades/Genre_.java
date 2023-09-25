package Entidades;

import Entidades.Movie;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-09-25T15:05:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Genre.class)
public class Genre_ { 

    public static volatile SingularAttribute<Genre, Integer> genreId;
    public static volatile SingularAttribute<Genre, String> genreName;
    public static volatile ListAttribute<Genre, Movie> movieList;

}