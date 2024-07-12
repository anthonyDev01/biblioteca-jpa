package br.com.biblioteca.dao;

import br.com.biblioteca.entity.Autor;

import javax.persistence.EntityManager;
import java.util.List;

public class AutorDao {
    private EntityManager entityManager;

    public AutorDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Autor autor){
        this.entityManager.persist(autor);
        System.out.println("Entidade cadastrada: " + autor);
    }

    public Autor buscarPorId(final Integer id){
        try {
            return  this.entityManager.find(Autor.class, id);
        }catch (Exception e){
            return null;
        }

    }

    public List<Autor> buscarTodos(){
        try {
            String jpql = "Select c from Autor c";
            return this.entityManager.createQuery(jpql, Autor.class).getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public List<Autor> buscarAutorMaisLivros(){
        try {
            String jpql = "SELECT a FROM Autor a JOIN a.livros l GROUP BY a HAVING COUNT(a) >= 2";
            return this.entityManager.createQuery(jpql, Autor.class).getResultList();

        }catch (Exception e){
            return null;
        }
    }

    public void atualizar(final Autor autor){
        this.entityManager.merge(autor);
    }

    public void deletar(final  Autor autor){
        this.entityManager.remove(autor);
    }
}
