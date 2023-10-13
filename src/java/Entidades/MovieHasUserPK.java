/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Mateus
 */
@Embeddable
public class MovieHasUserPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "movie_movie_id")
    private int movieMovieId;
    @Basic(optional = false)
    @Column(name = "user_email")
    private String userEmail;

    public MovieHasUserPK() {
    }

    public MovieHasUserPK(int movieMovieId, String userEmail) {
        this.movieMovieId = movieMovieId;
        this.userEmail = userEmail;
    }

    public int getMovieMovieId() {
        return movieMovieId;
    }

    public void setMovieMovieId(int movieMovieId) {
        this.movieMovieId = movieMovieId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) movieMovieId;
        hash += (userEmail != null ? userEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieHasUserPK)) {
            return false;
        }
        MovieHasUserPK other = (MovieHasUserPK) object;
        if (this.movieMovieId != other.movieMovieId) {
            return false;
        }
        if ((this.userEmail == null && other.userEmail != null) || (this.userEmail != null && !this.userEmail.equals(other.userEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MovieHasUserPK[ movieMovieId=" + movieMovieId + ", userEmail=" + userEmail + " ]";
    }
    
}
