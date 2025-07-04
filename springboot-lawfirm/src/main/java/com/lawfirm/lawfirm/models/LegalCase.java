package com.lawfirm.lawfirm.models;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "cases")
public class LegalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;

    private String caseDetails;
    private String status;
    private LocalDate filingDate;
    private LocalDate closingDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "lawyer_id", nullable = false)
    private Lawyer lawyer;

    // Getters and Setters
    public Long getCaseId() {
        return caseId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public String getCaseDetails() {
        return caseDetails;
    }

    public void setCaseDetails(String caseDetails) {
        this.caseDetails = caseDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(LocalDate filingDate) {
        this.filingDate = filingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }
}
