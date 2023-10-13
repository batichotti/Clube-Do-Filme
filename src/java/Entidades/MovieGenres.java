/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "movie_genres")
@NamedQueries({
    @NamedQuery(name = "MovieGenres.findAll", query = "SELECT m FROM MovieGenres m"),
    @NamedQuery(name = "MovieGenres.findByMovieId", query = "SELECT m FROM MovieGenres m WHERE m.movieGenresPK.movieId = :movieId"),
    @NamedQuery(name = "MovieGenres.findByGenreId", query = "SELECT m FROM MovieGenres m WHERE m.movieGenresPK.genreId = :genreId"),
    @NamedQuery(name = "MovieGenres.findByMovieGenrescol", query = "SELECT m FROM MovieGenres m WHERE m.movieGenrescol = :movieGenrescol")})
public class MovieGenres implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovieGenresPK movieGenresPK;
    @Column(name = "movie_genrescol")
    private String movieGenrescol;
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Genre genre;
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;

    public MovieGenres() {
    }

    public MovieGenres(MovieGenresPK movieGenresPK) {
        this.movieGenresPK = movieGenresPK;
    }

    public MovieGenres(int movieId, int genreId) {
        this.movieGenresPK = new MovieGenresPK(movieId, genreId);
    }

    public MovieGenresPK getMovieGenresPK() {
        return movieGenresPK;
    }

    public void setMovieGenresPK(MovieGenresPK movieGenresPK) {
        this.movieGenresPK = movieGenresPK;
    }

    public String getMovieGenrescol() {
        return movieGenrescol;
    }

    public void setMovieGenrescol(String movieGenrescol) {
        this.movieGenrescol = movieGenrescol;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieGenresPK != null ? movieGenresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieGenres)) {
            return false;
        }
        MovieGenres other = (MovieGenres) object;
        if ((this.movieGenresPK == null && other.movieGenresPK != null) || (this.movieGenresPK != null && !this.movieGenresPK.equals(other.movieGenresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MovieGenres[ movieGenresPK=" + movieGenresPK + " ]";
    }
    
}
