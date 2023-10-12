/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "movie_keywords")
@NamedQueries({
    @NamedQuery(name = "MovieKeywords.findAll", query = "SELECT m FROM MovieKeywords m")})
public class MovieKeywords implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovieKeywordsPK movieKeywordsPK;
    @Column(name = "movie_keywordscol")
    private String movieKeywordscol;
    @JoinColumn(name = "keyword_id", referencedColumnName = "keyword_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Keyword keyword;
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;

    public MovieKeywords() {
    }

    public MovieKeywords(MovieKeywordsPK movieKeywordsPK) {
        this.movieKeywordsPK = movieKeywordsPK;
    }

    public MovieKeywords(int movieId, int keywordId) {
        this.movieKeywordsPK = new MovieKeywordsPK(movieId, keywordId);
    }

    public MovieKeywordsPK getMovieKeywordsPK() {
        return movieKeywordsPK;
    }

    public void setMovieKeywordsPK(MovieKeywordsPK movieKeywordsPK) {
        this.movieKeywordsPK = movieKeywordsPK;
    }

    public String getMovieKeywordscol() {
        return movieKeywordscol;
    }

    public void setMovieKeywordscol(String movieKeywordscol) {
        this.movieKeywordscol = movieKeywordscol;
    }

    public Keyword getKeyword() {
        return keyword;
    }

    public void setKeyword(Keyword keyword) {
        this.keyword = keyword;
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
        hash += (movieKeywordsPK != null ? movieKeywordsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieKeywords)) {
            return false;
        }
        MovieKeywords other = (MovieKeywords) object;
        if ((this.movieKeywordsPK == null && other.movieKeywordsPK != null) || (this.movieKeywordsPK != null && !this.movieKeywordsPK.equals(other.movieKeywordsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MovieKeywords[ movieKeywordsPK=" + movieKeywordsPK + " ]";
    }
    
}
