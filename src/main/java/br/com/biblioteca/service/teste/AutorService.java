package br.com.biblioteca.service.teste;
import br.com.biblioteca.dao.AutorDao;
import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.util.CargaDeDadosUtil;
import br.com.biblioteca.util.JPAUtil;
import javax.persistence.EntityManager;

public class AutorService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerBlibioteca();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarAutor(entityManager);
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarLivro(entityManager);

        LivroDao livroDao = new LivroDao(entityManager);
        AutorDao autorDao = new AutorDao(entityManager);

        //livroDao.atualizarTitutlo(1, "Turma da monica");
        System.out.println("Livros por ID: " + livroDao.buscarPorId(3));
        //System.out.println("Livros por Autor: " + livroDao.buscarPorIdAutor(1));
        System.out.println("Livros por categoria: " + livroDao.buscarPorCategoria("Aventura"));
        System.out.println("Autores com mais de 1 livro: " + autorDao.buscarAutorMais5Livros());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
