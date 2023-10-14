package DAOs;

import Entidades.MovieHasUser;
import Entidades.MovieHasUserPK;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mateus Batichotti Silva | 19/04/2023 - 15:54:37
 */
public class DAOMovieHasUser extends DAOGenerico<MovieHasUser> {

    private List<MovieHasUser> lista = new ArrayList<>();

    public DAOMovieHasUser() {
        super(MovieHasUser.class);
    }

    //busca com PK composta
    public MovieHasUser obter(MovieHasUserPK phcpk) {
        return em.find(MovieHasUser.class, phcpk);
    }

    public List<MovieHasUser> listInOrderNome() {
        TypedQuery<MovieHasUser> query = em.createQuery("SELECT e FROM MovieHasUser e ORDER BY e.escopo", MovieHasUser.class);
        List<MovieHasUser> resultList = query.getResultList();
        return resultList;
    }

    public List<String> listInOrderNomeStrings() {
        List<MovieHasUser> lf = listInOrderNome();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getMovieHasUserPK().toString());
        }
        return ls;
    }
    
    public static void main(String[] args) {
        DAOMovieHasUser daoMovie = new DAOMovieHasUser();
        List<MovieHasUser> listaMovie = daoMovie.list();
        for (MovieHasUser arma : listaMovie) {
            System.out.println(arma.getMovie().getTitle() + " - " + arma.getUser().getNick());
        }
    }
}
