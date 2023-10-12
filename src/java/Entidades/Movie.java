/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "movie")
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieId", query = "SELECT m FROM Movie m WHERE m.movieId = :movieId"),
    @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title"),
    @NamedQuery(name = "Movie.findByBudget", query = "SELECT m FROM Movie m WHERE m.budget = :budget"),
    @NamedQuery(name = "Movie.findByHomepage", query = "SELECT m FROM Movie m WHERE m.homepage = :homepage"),
    @NamedQuery(name = "Movie.findByOverview", query = "SELECT m FROM Movie m WHERE m.overview = :overview"),
    @NamedQuery(name = "Movie.findByRuntime", query = "SELECT m FROM Movie m WHERE m.runtime = :runtime")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "title")
    private String title;
    @Column(name = "budget")
    private Integer budget;
    @Column(name = "homepage")
    private String homepage;
    @Column(name = "overview")
    private String overview;
    @Column(name = "runtime")
    private Integer runtime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<MovieKeywords> movieKeywordsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<ProductionCountry> productionCountryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<MovieGenres> movieGenresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<MovieHasUser> movieHasUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<MovieCompany> movieCompanyList;

    public Movie() {
    }

    public Movie(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<MovieKeywords> getMovieKeywordsList() {
        return movieKeywordsList;
    }

    public void setMovieKeywordsList(List<MovieKeywords> movieKeywordsList) {
        this.movieKeywordsList = movieKeywordsList;
    }

    public List<ProductionCountry> getProductionCountryList() {
        return productionCountryList;
    }

    public void setProductionCountryList(List<ProductionCountry> productionCountryList) {
        this.productionCountryList = productionCountryList;
    }

    public List<MovieGenres> getMovieGenresList() {
        return movieGenresList;
    }

    public void setMovieGenresList(List<MovieGenres> movieGenresList) {
        this.movieGenresList = movieGenresList;
    }

    public List<MovieHasUser> getMovieHasUserList() {
        return movieHasUserList;
    }

    public void setMovieHasUserList(List<MovieHasUser> movieHasUserList) {
        this.movieHasUserList = movieHasUserList;
    }

    public List<MovieCompany> getMovieCompanyList() {
        return movieCompanyList;
    }

    public void setMovieCompanyList(List<MovieCompany> movieCompanyList) {
        this.movieCompanyList = movieCompanyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Movie[ movieId=" + movieId + " ]";
    }
    
}
