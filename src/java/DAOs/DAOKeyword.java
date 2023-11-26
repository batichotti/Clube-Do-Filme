package DAOs;

import static DAOs.DAOGenerico.em;
import Entidades.Keyword;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateus Batichotti Silva | 19/04/2023 - 15:49:35
 */
public class DAOKeyword extends DAOGenerico<Keyword> {

    private List<Keyword> lista = new ArrayList<>();

    public DAOKeyword() {
        super(Keyword.class);
    }

    public int autoIdArma() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.email) FROM Keyword e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Keyword> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Keyword e WHERE e.email LIKE :email")
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    public List<Keyword> listById(int id) {
        return em.createQuery("SELECT e FROM Keyword e WHERE e.nick= :id").setParameter("id", id).getResultList();
    }

    public List<Keyword> listInOrderNome() {
        return em.createQuery("SELECT e FROM Keyword e ORDER BY e.keywordName").getResultList();
    }

    public List<Keyword> listInOrderId() {
        return em.createQuery("SELECT e FROM Keyword e ORDER BY e.nick").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Keyword> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getKeywordName());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOKeyword daoKeyword = new DAOKeyword();
        List<Keyword> listaKeyword = daoKeyword.list();
        for (Keyword arma : listaKeyword) {
            System.out.println(arma.getKeywordId() + "-" + arma.getKeywordName());
        }
    }
}
