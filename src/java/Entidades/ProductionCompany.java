/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "production_company")
@NamedQueries({
    @NamedQuery(name = "ProductionCompany.findAll", query = "SELECT p FROM ProductionCompany p"),
    @NamedQuery(name = "ProductionCompany.findByCompanyId", query = "SELECT p FROM ProductionCompany p WHERE p.companyId = :companyId"),
    @NamedQuery(name = "ProductionCompany.findByCompanyName", query = "SELECT p FROM ProductionCompany p WHERE p.companyName = :companyName")})
public class ProductionCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "company_name")
    private String companyName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productionCompany")
    private List<MovieCompany> movieCompanyList;

    public ProductionCompany() {
    }

    public ProductionCompany(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductionCompany)) {
            return false;
        }
        ProductionCompany other = (ProductionCompany) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ProductionCompany[ companyId=" + companyId + " ]";
    }
    
}
