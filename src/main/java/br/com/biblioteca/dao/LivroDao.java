package br.com.biblioteca.dao;

import br.com.biblioteca.entity.Livro;

import javax.persistence.EntityManager;
import java.util.List;

public class LivroDao {
    private EntityManager entityManager;

    public LivroDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Livro livro){
        this.entityManager.persist(livro);
        System.out.println("Entidade cadastrada: " + livro);
    }

    public Livro buscarPorId(final Integer id){
        try {
            return this.entityManager.find(Livro.class, id);
        }catch (Exception e){
            return null;
        }

    }

    public List<Livro> buscarTodos(){
        try {
            String jpql = "SELECT c from Livro c";
            return this.entityManager.createQuery(jpql, Livro.class).getResultList();
        }catch (Exception e){
            return null;
        }

    }

    public List<Livro> buscarPorIdAutor(Integer id){
        try {
            String jpql = "SELECT l FROM Livro l WHERE l.autor.id = :autorID";
            return this.entityManager.createQuery(jpql, Livro.class).setParameter("autorID", id).getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public List<Livro> buscarPorCategoria(String categoria){
        try {
            String jpql = "SELECT l FROM Livro l JOIN l.categorias c WHERE c.nome = :categoria";
            return this.entityManager.createQuery(jpql, Livro.class).setParameter("categoria", categoria).getResultList();

        }catch (Exception e){
            return null;
        }
    }

    public void atualizar(Livro livro){
        this.entityManager.merge(livro);
    }

    public void atualizarTitutlo(final Integer id, String titulo){
        try {
            Livro livro = this.entityManager.find(Livro.class, id);
            livro.setTitulo(titulo);
            atualizar(livro);
            System.out.println("Livro atualizado: " + livro);
        }catch (Exception e){
            System.out.println("houve um problema");
        }

    }

    public void deletar(Livro livro){
        this.entityManager.remove(livro);
    }
}
