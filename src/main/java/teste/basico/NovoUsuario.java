package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {
    public static void main(String[] args) {
        // Indica o banco de dados que você quer conectar
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");

        EntityManager em = emf.createEntityManager(); // em criado

        Usuario novoUsuario = new Usuario("Arthur","arthur@lanche.com.br");

        em.getTransaction().begin();
        em.persist(novoUsuario); // Basicamente vai gerar um insert
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
