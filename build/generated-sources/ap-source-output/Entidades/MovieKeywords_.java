package Entidades;

import Entidades.Keyword;
import Entidades.Movie;
import Entidades.MovieKeywordsPK;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-26T21:31:43", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(MovieKeywords.class)
public class MovieKeywords_ { 

    public static volatile SingularAttribute<MovieKeywords, Movie> movie;
    public static volatile SingularAttribute<MovieKeywords, String> movieKeywordscol;
    public static volatile SingularAttribute<MovieKeywords, Keyword> keyword;
    public static volatile SingularAttribute<MovieKeywords, MovieKeywordsPK> movieKeywordsPK;

}