package DAOs;

import Entidades.Country;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateus Batichotti Silva | 19/04/2023 - 15:49:35
 */
public class DAOCountry extends DAOGenerico<Country> {

    private List<Country> lista = new ArrayList<>();

    public DAOCountry() {
        super(Country.class);
    }

    public int autoIdArma() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.email) FROM Country e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Country> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Country e WHERE e.email LIKE :email")
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    public List<Country> listById(int id) {
        return em.createQuery("SELECT e FROM Country e WHERE e.nick= :id").setParameter("id", id).getResultList();
    }

    public List<Country> listInOrderNome() {
        return em.createQuery("SELECT e FROM Country e ORDER BY e.countryName").getResultList();
    }

    public List<Country> listInOrderId() {
        return em.createQuery("SELECT e FROM Country e ORDER BY e.nick").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Country> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCountryName());
        }
        return ls;
    }
    
    public Integer getIdByCountryName(String countryName) {
        List<Integer> result = em.createQuery("SELECT e.countryId FROM Country e WHERE e.countryName = :countryName")
                .setParameter("countryName", countryName)
                .getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        DAOCountry daoCountry = new DAOCountry();
        List<Country> listaCountry = daoCountry.listInOrderNome();
        for (Country arma : listaCountry) {
            System.out.println(arma.getCountryId()+ "-" + arma.getCountryName());
        }
    }
}
