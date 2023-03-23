package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 5L);
        em.detach(usuario);
        usuario.setNome("patrikc alterado 2");
        usuario.setEmail("patrick.alves@lanche.com");

        em.merge(usuario);

        System.out.println(usuario.getNome());

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
