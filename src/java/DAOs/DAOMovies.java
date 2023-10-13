package DAOs;

import Entidades.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateus Batichotti Silva | 19/04/2023 - 15:49:35
 */
public class DAOMovies extends DAOGenerico<Movie> {

    private List<Movie> lista = new ArrayList<>();

    public DAOMovies() {
        super(Movie.class);
    }

    public int autoIdArma() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.movie_id) FROM Movie e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Movie> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Movie e WHERE e.title LIKE :title")
                .setParameter("title", "%" + nome + "%")
                .getResultList();
    }

    public List<Movie> listById(int id) {
        return em.createQuery("SELECT e FROM Movie e WHERE e.movie_id= :movie_id").setParameter("movie_id", id).getResultList();
    }

    public List<Movie> listInOrderNome() {
        return em.createQuery("SELECT e FROM Movie e ORDER BY e.title").getResultList();
    }

    public List<Movie> listInOrderId() {
        return em.createQuery("SELECT e FROM Movie e ORDER BY e.movie_id").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Movie> lf;
        if (qualOrdem.equals("movie_id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getTitle());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOMovies daoMovie = new DAOMovies();
        List<Movie> listaMovie = daoMovie.list();
        for (Movie arma : listaMovie) {
            System.out.println(arma.getMovieId() + "-" + arma.getTitle());
        }
    }
}
