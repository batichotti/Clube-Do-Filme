/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "keyword")
    private List<MovieKeywords> movieKeywordsList;

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

    public List<MovieKeywords> getMovieKeywordsList() {
        return movieKeywordsList;
    }

    public void setMovieKeywordsList(List<MovieKeywords> movieKeywordsList) {
        this.movieKeywordsList = movieKeywordsList;
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
