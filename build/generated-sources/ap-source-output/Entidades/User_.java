package Entidades;

import Entidades.MovieHasUser;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-09-26T11:47:44", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> nick;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Integer> role;
    public static volatile ListAttribute<User, MovieHasUser> movieHasUserList;
    public static volatile SingularAttribute<User, String> email;

}