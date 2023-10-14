package DAOs;

import Entidades.MovieCompany;
import Entidades.MovieCompanyPK;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mateus Batichotti Silva | 19/04/2023 - 15:54:37
 */
public class DAOMovieCompany extends DAOGenerico<MovieCompany> {

    private List<MovieCompany> lista = new ArrayList<>();

    public DAOMovieCompany() {
        super(MovieCompany.class);
    }

    //busca com PK composta
    public MovieCompany obter(MovieCompanyPK phcpk) {
        return em.find(MovieCompany.class, phcpk);
    }

    public List<MovieCompany> listInOrderNome() {
        TypedQuery<MovieCompany> query = em.createQuery("SELECT e FROM MovieCompany e ORDER BY e.escopo", MovieCompany.class);
        List<MovieCompany> resultList = query.getResultList();
        return resultList;
    }

    public List<String> listInOrderNomeStrings() {
        List<MovieCompany> lf = listInOrderNome();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getMovieCompanyPK().toString());
        }
        return ls;
    }
    
    public List<String> getCompanyByMovieTitle(String movieTitle) {
        TypedQuery<MovieCompany> query = em.createQuery("SELECT e FROM MovieCompany e WHERE e.movie.title = :title", MovieCompany.class);
        query.setParameter("title", movieTitle);
        List<MovieCompany> resultList = query.getResultList();
        List<String> genresList = new ArrayList<>();

        for (MovieCompany movieCompany : resultList) {
            genresList.add(movieCompany.getProductionCompany().getCompanyName());
        }

        return genresList;
    }
    
    public static void main(String[] args) {
        DAOMovieCompany daoMovie = new DAOMovieCompany();
        List<MovieCompany> listaMovie = daoMovie.list();
        for (MovieCompany arma : listaMovie) {
            System.out.println(arma.getMovie().getTitle() + " - " + arma.getProductionCompany().getCompanyName());
        }
    }
}
