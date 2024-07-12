package br.com.biblioteca.util;

import br.com.biblioteca.dao.AutorDao;
import br.com.biblioteca.dao.CategoriaDao;
import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.entity.Autor;
import br.com.biblioteca.entity.Categoria;
import br.com.biblioteca.entity.Livro;

import javax.persistence.EntityManager;
import java.util.List;

public class CargaDeDadosUtil {
    public static void cadastrarAutor(EntityManager entityManager){
        AutorDao autorDao = new AutorDao(entityManager);

        Autor autor1 = new Autor("Lucas");
        Autor autor2 = new Autor("Amorim");
        Autor autor3 = new Autor("Eduardo");

        autorDao.cadastrar(autor1);
        entityManager.flush();
        autorDao.cadastrar(autor2);
        entityManager.flush();
        autorDao.cadastrar(autor3);
        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarLivro(EntityManager entityManager){
        LivroDao livroDao = new LivroDao(entityManager);
        AutorDao autorDao = new AutorDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        List<Autor> autores = autorDao.buscarTodos();

        Livro livro1 = new Livro("Gato de botas", autores.get(0));
        livro1.addCategoria(categoriaDao.buscarPorId(1));
        livro1.addCategoria(categoriaDao.buscarPorId(2));

        Livro livro2 = new Livro("Harry Potter e as reliquias da morte", autores.get(0));
        livro2.addCategoria(categoriaDao.buscarPorId(2));

        Livro livro3 = new Livro("Percy Jackson e os Olimpianos", autores.get(1));
        livro3.addCategoria(categoriaDao.buscarPorId(3));



        livroDao.cadastrar(livro1);
        entityManager.flush();
        livroDao.cadastrar(livro2);
        entityManager.flush();
        livroDao.cadastrar(livro3);
        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        Categoria categoria1 = new Categoria("Romance");
        Categoria categoria2 = new Categoria("Aventura");
        Categoria categoria3 = new Categoria("Comedia");

        categoriaDao.cadastrar(categoria1);
        entityManager.flush();
        categoriaDao.cadastrar(categoria2);
        entityManager.flush();
        categoriaDao.cadastrar(categoria3);
        entityManager.clear();
    }


}
