package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterUsuarios {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        String jpql = "select u from Usuario u";

        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setMaxResults(5); // Limitar quantos resultados no maximo vai ter

        List<Usuario> usuarios = query.getResultList();

        for(Usuario u:usuarios){
            System.out.println("ID: "+u.getId());
            System.out.println("Nome: "+u.getNome());
            System.out.println("Email: "+u.getEmail());
        }

        List<Usuario> usus = em
                .createQuery(jpql, Usuario.class)
                .setMaxResults(5)
                .getResultList(); // Da de fazer dessa forma tambem

        for(Usuario u:usus){
            System.out.println("ID: "+u.getId());
            System.out.println("Nome: "+u.getNome());
            System.out.println("Email: "+u.getEmail());
        }

        em.close();
        emf.close();
    }
}
