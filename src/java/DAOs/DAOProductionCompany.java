package DAOs;

import Entidades.ProductionCompany;
import Entidades.MovieCompanyPK;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mateus Batichotti Silva | 19/04/2023 - 15:54:37
 */
public class DAOProductionCompany extends DAOGenerico<ProductionCompany> {

    private List<ProductionCompany> lista = new ArrayList<>();

    public DAOProductionCompany() {
        super(ProductionCompany.class);
    }

    //busca com PK composta
    public ProductionCompany obter(MovieCompanyPK phcpk) {
        return em.find(ProductionCompany.class, phcpk);
    }

    public List<ProductionCompany> listInOrderNome() {
        TypedQuery<ProductionCompany> query = em.createQuery("SELECT e FROM ProductionCompany e ORDER BY e.companyName", ProductionCompany.class);
        List<ProductionCompany> resultList = query.getResultList();
        return resultList;
    }

    public List<String> listInOrderNomeStrings() {
        List<ProductionCompany> lf = listInOrderNome();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCompanyName());
        }
        return ls;
    }
    
    public List<String> getCompanyByProductionTitle(String movieTitle) {
        TypedQuery<ProductionCompany> query = em.createQuery("SELECT e FROM ProductionCompany e WHERE e.movie.title = :title", ProductionCompany.class);
        query.setParameter("title", movieTitle);
        List<ProductionCompany> resultList = query.getResultList();
        List<String> genresList = new ArrayList<>();

        for (ProductionCompany movieCompany : resultList) {
            genresList.add(movieCompany.getCompanyName());
        }

        return genresList;
    }

    public static void main(String[] args) {
        DAOProductionCompany daoProduction = new DAOProductionCompany();
        List<ProductionCompany> listaProduction = daoProduction.list();
        for (ProductionCompany arma : listaProduction) {
            System.out.println(arma.getCompanyId()+ " - " + arma.getCompanyName());
        }
    }
}
