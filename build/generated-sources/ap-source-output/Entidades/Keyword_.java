package Entidades;

import Entidades.MovieKeywords;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-26T17:18:37", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Keyword.class)
public class Keyword_ { 

    public static volatile SingularAttribute<Keyword, Integer> keywordId;
    public static volatile SingularAttribute<Keyword, String> keywordName;
    public static volatile ListAttribute<Keyword, MovieKeywords> movieKeywordsList;

}