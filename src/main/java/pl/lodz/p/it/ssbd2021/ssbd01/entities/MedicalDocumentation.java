package pl.lodz.p.it.ssbd2021.ssbd01.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Klasa Medical documentation.
 */
@Entity
@Table(name = "medical_documentations")
@NamedQueries({
        @NamedQuery(name = "MedicalDocumentation.findAll", query = "SELECT m FROM MedicalDocumentation m"),
        @NamedQuery(name = "MedicalDocumentation.findById", query = "SELECT m FROM MedicalDocumentation m WHERE m.id = :id"),
        @NamedQuery(name = "MedicalDocumentation.findByAllergies", query = "SELECT m FROM MedicalDocumentation m WHERE m.allergies = :allergies"),
        @NamedQuery(name = "MedicalDocumentation.findByMedicationsTaken", query = "SELECT m FROM MedicalDocumentation m WHERE m.medicationsTaken = :medicationsTaken"),
        @NamedQuery(name = "MedicalDocumentation.findByVersion", query = "SELECT m FROM MedicalDocumentation m WHERE m.version = :version"),
        @NamedQuery(name = "MedicalDocumentation.findByCreationDateTime", query = "SELECT m FROM MedicalDocumentation m WHERE m.creationDateTime = :creationDateTime"),
        @NamedQuery(name = "MedicalDocumentation.findByModificationDateTime", query = "SELECT m FROM MedicalDocumentation m WHERE m.modificationDateTime = :modificationDateTime")})
public class MedicalDocumentation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "allergies")
    private String allergies;

    @Column(name = "medications_taken")
    private String medicationsTaken;

    @Basic(optional = false)
    @Column(name = "creation_date_time")
    private Long creationDateTime;

    @Column(name = "modification_date_time")
    private Long modificationDateTime;

    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account createdBy;

    @JoinColumn(name = "modified_by", referencedColumnName = "id")
    @ManyToOne
    private Account modifiedBy;

    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account patient;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentationId")
    private Collection<DocumentationEntry> documentationEntryCollection;

    @Column(name = "version")
    private Long version;

    /**
     * Tworzy nowa instancje Medical documentation.
     */
    public MedicalDocumentation() {
    }

    /**
     * Tworzy nowa instancje Medical documentation.
     *
     * @param id klucz glowny
     */
    public MedicalDocumentation(Long id) {
        this.id = id;
    }

    /**
     * Tworzy nowa instancje Medical documentation.
     *
     * @param id               klucz glowny
     * @param creationDateTime data utworzenia
     */
    public MedicalDocumentation(Long id, Long creationDateTime) {
        this.id = id;
        this.creationDateTime = creationDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedicationsTaken() {
        return medicationsTaken;
    }

    public void setMedicationsTaken(String medicationsTaken) {
        this.medicationsTaken = medicationsTaken;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Long creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Long getModificationDateTime() {
        return modificationDateTime;
    }

    public void setModificationDateTime(Long modificationDateTime) {
        this.modificationDateTime = modificationDateTime;
    }

    public Account getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Account createdBy) {
        this.createdBy = createdBy;
    }

    public Account getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Account modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Account getPatient() {
        return patient;
    }

    public void setPatient(Account patient) {
        this.patient = patient;
    }

    public Collection<DocumentationEntry> getDocumentationEntryCollection() {
        return documentationEntryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalDocumentation)) {
            return false;
        }
        MedicalDocumentation other = (MedicalDocumentation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.ssbd2021.ssbd01.entities.MedicalDocumentation[ id=" + id + " ]";
    }

}