package DAOs;

import Entidades.Genre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateus Batichotti Silva | 19/04/2023 - 15:49:35
 */
public class DAOGenre extends DAOGenerico<Genre> {

    private List<Genre> lista = new ArrayList<>();

    public DAOGenre() {
        super(Genre.class);
    }

    public int autoIdArma() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.email) FROM Genre e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Genre> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Genre e WHERE e.email LIKE :email")
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    public List<Genre> listById(int id) {
        return em.createQuery("SELECT e FROM Genre e WHERE e.nick= :id").setParameter("id", id).getResultList();
    }

    public List<Genre> listInOrderNome() {
        return em.createQuery("SELECT e FROM Genre e ORDER BY e.email").getResultList();
    }

    public List<Genre> listInOrderId() {
        return em.createQuery("SELECT e FROM Genre e ORDER BY e.nick").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Genre> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getGenreName());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOGenre daoGenre = new DAOGenre();
        List<Genre> listaGenre = daoGenre.list();
        for (Genre arma : listaGenre) {
            System.out.println(arma.getGenreId()+ "-" + arma.getGenreName());
        }
    }
}
