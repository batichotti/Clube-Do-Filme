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
@Table(name = "production_country")
@NamedQueries({
    @NamedQuery(name = "ProductionCountry.findAll", query = "SELECT p FROM ProductionCountry p"),
    @NamedQuery(name = "ProductionCountry.findByMovieId", query = "SELECT p FROM ProductionCountry p WHERE p.productionCountryPK.movieId = :movieId"),
    @NamedQuery(name = "ProductionCountry.findByCountryId", query = "SELECT p FROM ProductionCountry p WHERE p.productionCountryPK.countryId = :countryId"),
    @NamedQuery(name = "ProductionCountry.findByProductionCountrycol", query = "SELECT p FROM ProductionCountry p WHERE p.productionCountrycol = :productionCountrycol")})
public class ProductionCountry implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductionCountryPK productionCountryPK;
    @Column(name = "production_countrycol")
    private String productionCountrycol;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Country country;
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;

    public ProductionCountry() {
    }

    public ProductionCountry(ProductionCountryPK productionCountryPK) {
        this.productionCountryPK = productionCountryPK;
    }

    public ProductionCountry(int movieId, int countryId) {
        this.productionCountryPK = new ProductionCountryPK(movieId, countryId);
    }

    public ProductionCountryPK getProductionCountryPK() {
        return productionCountryPK;
    }

    public void setProductionCountryPK(ProductionCountryPK productionCountryPK) {
        this.productionCountryPK = productionCountryPK;
    }

    public String getProductionCountrycol() {
        return productionCountrycol;
    }

    public void setProductionCountrycol(String productionCountrycol) {
        this.productionCountrycol = productionCountrycol;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
        hash += (productionCountryPK != null ? productionCountryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductionCountry)) {
            return false;
        }
        ProductionCountry other = (ProductionCountry) object;
        if ((this.productionCountryPK == null && other.productionCountryPK != null) || (this.productionCountryPK != null && !this.productionCountryPK.equals(other.productionCountryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ProductionCountry[ productionCountryPK=" + productionCountryPK + " ]";
    }
    
}
