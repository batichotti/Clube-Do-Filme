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
@Table(name = "movie_has_user")
@NamedQueries({
    @NamedQuery(name = "MovieHasUser.findAll", query = "SELECT m FROM MovieHasUser m"),
    @NamedQuery(name = "MovieHasUser.findByMovieMovieId", query = "SELECT m FROM MovieHasUser m WHERE m.movieHasUserPK.movieMovieId = :movieMovieId"),
    @NamedQuery(name = "MovieHasUser.findByUserEmail", query = "SELECT m FROM MovieHasUser m WHERE m.movieHasUserPK.userEmail = :userEmail"),
    @NamedQuery(name = "MovieHasUser.findByComment", query = "SELECT m FROM MovieHasUser m WHERE m.comment = :comment"),
    @NamedQuery(name = "MovieHasUser.findByRating", query = "SELECT m FROM MovieHasUser m WHERE m.rating = :rating"),
    @NamedQuery(name = "MovieHasUser.findByFavorited", query = "SELECT m FROM MovieHasUser m WHERE m.favorited = :favorited")})
public class MovieHasUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovieHasUserPK movieHasUserPK;
    @Column(name = "comment")
    private String comment;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "favorited")
    private Integer favorited;
    @JoinColumn(name = "movie_movie_id", referencedColumnName = "movie_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;
    @JoinColumn(name = "user_email", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public MovieHasUser() {
    }

    public MovieHasUser(MovieHasUserPK movieHasUserPK) {
        this.movieHasUserPK = movieHasUserPK;
    }

    public MovieHasUser(int movieMovieId, String userEmail) {
        this.movieHasUserPK = new MovieHasUserPK(movieMovieId, userEmail);
    }

    public MovieHasUserPK getMovieHasUserPK() {
        return movieHasUserPK;
    }

    public void setMovieHasUserPK(MovieHasUserPK movieHasUserPK) {
        this.movieHasUserPK = movieHasUserPK;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getFavorited() {
        return favorited;
    }

    public void setFavorited(Integer favorited) {
        this.favorited = favorited;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieHasUserPK != null ? movieHasUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieHasUser)) {
            return false;
        }
        MovieHasUser other = (MovieHasUser) object;
        if ((this.movieHasUserPK == null && other.movieHasUserPK != null) || (this.movieHasUserPK != null && !this.movieHasUserPK.equals(other.movieHasUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MovieHasUser[ movieHasUserPK=" + movieHasUserPK + " ]";
    }
    
}
