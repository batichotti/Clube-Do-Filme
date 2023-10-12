/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Mateus
 */
@Embeddable
public class MovieKeywordsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "movie_id")
    private int movieId;
    @Basic(optional = false)
    @Column(name = "keyword_id")
    private int keywordId;

    public MovieKeywordsPK() {
    }

    public MovieKeywordsPK(int movieId, int keywordId) {
        this.movieId = movieId;
        this.keywordId = keywordId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) movieId;
        hash += (int) keywordId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieKeywordsPK)) {
            return false;
        }
        MovieKeywordsPK other = (MovieKeywordsPK) object;
        if (this.movieId != other.movieId) {
            return false;
        }
        if (this.keywordId != other.keywordId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MovieKeywordsPK[ movieId=" + movieId + ", keywordId=" + keywordId + " ]";
    }
    
}
