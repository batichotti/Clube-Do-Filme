package Entidades;

import Entidades.Genre;
import Entidades.Movie;
import Entidades.MovieGenresPK;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-18T11:50:12", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(MovieGenres.class)
public class MovieGenres_ { 

    public static volatile SingularAttribute<MovieGenres, String> movieGenrescol;
    public static volatile SingularAttribute<MovieGenres, Movie> movie;
    public static volatile SingularAttribute<MovieGenres, MovieGenresPK> movieGenresPK;
    public static volatile SingularAttribute<MovieGenres, Genre> genre;

}