package br.com.biblioteca.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static final EntityManagerFactory BLIBIOTECA = Persistence.createEntityManagerFactory("blibioteca");

    public static EntityManager getEntityManagerBlibioteca() {return BLIBIOTECA.createEntityManager();}
}
