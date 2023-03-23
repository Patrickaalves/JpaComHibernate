package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
* Se um objeto esta no estado gerenciadoa cada mudança no objeto o banco e a aplicação vai ficar sincroniznado
* A maior parte do tempo não vamos querer isso*/

public class AlterarUsuario3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 5L);
        usuario.setNome("patrikc alterado 2");
        usuario.setEmail("patrick.alves@lanche.com");

//        em.merge(usuario);

        System.out.println(usuario.getNome());

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
