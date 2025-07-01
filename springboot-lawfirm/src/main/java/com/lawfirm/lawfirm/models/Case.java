package com.lawfirm.lawfirm.models;
import java.time.LocalDate;

public class Case {
    private int clientId;
    private int lawyerId;
    private String caseDetails;
    private String status;
    private LocalDate filingDate;
    private LocalDate closingDate;

    // Getters and Setters
    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public int getLawyerId() { return lawyerId; }
    public void setLawyerId(int lawyerId) { this.lawyerId = lawyerId; }

    public String getCaseDetails() { return caseDetails; }
    public void setCaseDetails(String caseDetails) { this.caseDetails = caseDetails; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getFilingDate() { return filingDate; }
    public void setFilingDate(LocalDate filingDate) { this.filingDate = filingDate; }

    public LocalDate getClosingDate() { return closingDate; }
    public void setClosingDate(LocalDate closingDate) { this.closingDate = closingDate; }
}

    

