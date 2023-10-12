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
public class ProductionCountryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "movie_id")
    private int movieId;
    @Basic(optional = false)
    @Column(name = "country_id")
    private int countryId;

    public ProductionCountryPK() {
    }

    public ProductionCountryPK(int movieId, int countryId) {
        this.movieId = movieId;
        this.countryId = countryId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) movieId;
        hash += (int) countryId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductionCountryPK)) {
            return false;
        }
        ProductionCountryPK other = (ProductionCountryPK) object;
        if (this.movieId != other.movieId) {
            return false;
        }
        if (this.countryId != other.countryId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ProductionCountryPK[ movieId=" + movieId + ", countryId=" + countryId + " ]";
    }
    
}
