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
public class MovieCompanyPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "movie_id")
    private int movieId;
    @Basic(optional = false)
    @Column(name = "company_id")
    private int companyId;

    public MovieCompanyPK() {
    }

    public MovieCompanyPK(int movieId, int companyId) {
        this.movieId = movieId;
        this.companyId = companyId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) movieId;
        hash += (int) companyId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieCompanyPK)) {
            return false;
        }
        MovieCompanyPK other = (MovieCompanyPK) object;
        if (this.movieId != other.movieId) {
            return false;
        }
        if (this.companyId != other.companyId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MovieCompanyPK[ movieId=" + movieId + ", companyId=" + companyId + " ]";
    }
    
}
