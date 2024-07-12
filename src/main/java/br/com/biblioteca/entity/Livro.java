package br.com.biblioteca.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToMany
    @JoinTable(name = "livrosCategorias",
            joinColumns = @JoinColumn(name = "livros_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    public List<Categoria> categorias = new ArrayList<>();

    public Livro() {
    }

    public void addCategoria(Categoria categoria){
        categoria.getLivroList().add(this);
        this.categorias.add(categoria);
    }

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }



    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", categorias=" + categorias +
                '}';
    }
}
