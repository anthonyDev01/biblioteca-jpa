package br.com.biblioteca.dao;

import br.com.biblioteca.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
        System.out.println("Entidade cadastrada: " + categoria);
    }

    public Categoria buscarPorId(final Integer id){
        try {
            return this.entityManager.find(Categoria.class, id);
        }catch (Exception e){
            return null;
        }

    }

    public List<Categoria> buscarTodos(){
        try {
            String jpql = "SELECT c FROM Categoria c";
            return this.entityManager.createQuery(jpql, Categoria.class).getResultList();
        }catch (Exception e){
            return null;
        }

    }

    public void atualizar(Categoria categoria){
        this.entityManager.merge(categoria);
    }


    public void deletar(Categoria categoria){
        this.entityManager.remove(categoria);
    }
}
