package DAOs;

import Entidades.MovieKeywords;
import Entidades.MovieKeywordsPK;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mateus Batichotti Silva | 19/04/2023 - 15:54:37
 */
public class DAOMovieKeywords extends DAOGenerico<MovieKeywords> {

    private List<MovieKeywords> lista = new ArrayList<>();

    public DAOMovieKeywords() {
        super(MovieKeywords.class);
    }

    //busca com PK composta
    public MovieKeywords obter(MovieKeywordsPK phcpk) {
        return em.find(MovieKeywords.class, phcpk);
    }

    public List<MovieKeywords> listInOrderNome() {
        TypedQuery<MovieKeywords> query = em.createQuery("SELECT e FROM MovieKeywords e ORDER BY e.escopo", MovieKeywords.class);
        List<MovieKeywords> resultList = query.getResultList();
        return resultList;
    }

    public List<String> listInOrderNomeStrings() {
        List<MovieKeywords> lf = listInOrderNome();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getMovieKeywordsPK().toString());
        }
        return ls;
    }

    public List<String> getKeywordsByMovieTitle(String movieTitle) {
        TypedQuery<MovieKeywords> query = em.createQuery("SELECT e FROM MovieKeywords e WHERE e.movie.title = :title", MovieKeywords.class);
        query.setParameter("title", movieTitle);
        List<MovieKeywords> resultList = query.getResultList();
        List<String> genresList = new ArrayList<>();

        for (MovieKeywords movieKeywords : resultList) {
            genresList.add(String.valueOf(movieKeywords.getMovieKeywordsPK().getKeywordId()));
        }

        return genresList;
    }

    public static void main(String[] args) {
        DAOMovieKeywords daoMovie = new DAOMovieKeywords();
        List<MovieKeywords> listaMovie = daoMovie.list();
        for (MovieKeywords arma : listaMovie) {
            System.out.println(arma.getMovie().getTitle() + " - " + arma.getKeyword().getKeywordName());
        }
    }
}
