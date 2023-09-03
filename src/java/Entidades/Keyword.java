/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Mateus Cohuzer
 */
@Entity
@Table(name = "keyword")
@NamedQueries({
    @NamedQuery(name = "Keyword.findAll", query = "SELECT k FROM Keyword k"),
    @NamedQuery(name = "Keyword.findByKeywordId", query = "SELECT k FROM Keyword k WHERE k.keywordId = :keywordId"),
    @NamedQuery(name = "Keyword.findByKeywordName", query = "SELECT k FROM Keyword k WHERE k.keywordName = :keywordName")})
public class Keyword implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "keyword_id")
    private Integer keywordId;
    @Column(name = "keyword_name")
    private String keywordName;
    @JoinTable(name = "movie_keywords", joinColumns = {
        @JoinColumn(name = "keyword_id", referencedColumnName = "keyword_id")}, inverseJoinColumns = {
        @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")})
    @ManyToMany
    private List<Movie> movieList;

    public Keyword() {
    }

    public Keyword(Integer keywordId) {
        this.keywordId = keywordId;
    }

    public Integer getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Integer keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (keywordId != null ? keywordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keyword)) {
            return false;
        }
        Keyword other = (Keyword) object;
        if ((this.keywordId == null && other.keywordId != null) || (this.keywordId != null && !this.keywordId.equals(other.keywordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Keyword[ keywordId=" + keywordId + " ]";
    }
    
}
