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
@Table(name = "movie_company")
@NamedQueries({
    @NamedQuery(name = "MovieCompany.findAll", query = "SELECT m FROM MovieCompany m"),
    @NamedQuery(name = "MovieCompany.findByMovieId", query = "SELECT m FROM MovieCompany m WHERE m.movieCompanyPK.movieId = :movieId"),
    @NamedQuery(name = "MovieCompany.findByCompanyId", query = "SELECT m FROM MovieCompany m WHERE m.movieCompanyPK.companyId = :companyId"),
    @NamedQuery(name = "MovieCompany.findByMovieCompanycol", query = "SELECT m FROM MovieCompany m WHERE m.movieCompanycol = :movieCompanycol")})
public class MovieCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovieCompanyPK movieCompanyPK;
    @Column(name = "movie_companycol")
    private String movieCompanycol;
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductionCompany productionCompany;

    public MovieCompany() {
    }

    public MovieCompany(MovieCompanyPK movieCompanyPK) {
        this.movieCompanyPK = movieCompanyPK;
    }

    public MovieCompany(int movieId, int companyId) {
        this.movieCompanyPK = new MovieCompanyPK(movieId, companyId);
    }

    public MovieCompanyPK getMovieCompanyPK() {
        return movieCompanyPK;
    }

    public void setMovieCompanyPK(MovieCompanyPK movieCompanyPK) {
        this.movieCompanyPK = movieCompanyPK;
    }

    public String getMovieCompanycol() {
        return movieCompanycol;
    }

    public void setMovieCompanycol(String movieCompanycol) {
        this.movieCompanycol = movieCompanycol;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ProductionCompany getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(ProductionCompany productionCompany) {
        this.productionCompany = productionCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieCompanyPK != null ? movieCompanyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieCompany)) {
            return false;
        }
        MovieCompany other = (MovieCompany) object;
        if ((this.movieCompanyPK == null && other.movieCompanyPK != null) || (this.movieCompanyPK != null && !this.movieCompanyPK.equals(other.movieCompanyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MovieCompany[ movieCompanyPK=" + movieCompanyPK + " ]";
    }
    
}
