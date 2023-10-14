package DAOs;

import Entidades.MovieGenres;
import Entidades.MovieGenresPK;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mateus Batichotti Silva | 19/04/2023 - 15:54:37
 */
public class DAOMovieGenres extends DAOGenerico<MovieGenres> {

    private List<MovieGenres> lista = new ArrayList<>();

    public DAOMovieGenres() {
        super(MovieGenres.class);
    }

    //busca com PK composta
    public MovieGenres obter(MovieGenresPK phcpk) {
        return em.find(MovieGenres.class, phcpk);
    }

    public List<MovieGenres> listInOrderNome() {
        TypedQuery<MovieGenres> query = em.createQuery("SELECT e FROM MovieGenres e ORDER BY e.escopo", MovieGenres.class);
        List<MovieGenres> resultList = query.getResultList();
        return resultList;
    }

    public List<String> listInOrderNomeStrings() {
        List<MovieGenres> lf = listInOrderNome();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getMovieGenresPK().toString());
        }
        return ls;
    }
    
    public static void main(String[] args) {
        DAOMovieGenres daoMovie = new DAOMovieGenres();
        List<MovieGenres> listaMovie = daoMovie.list();
        for (MovieGenres arma : listaMovie) {
            System.out.println(arma.getMovie().getTitle() + " - " + arma.getGenre().getGenreName());
        }
    }
}
