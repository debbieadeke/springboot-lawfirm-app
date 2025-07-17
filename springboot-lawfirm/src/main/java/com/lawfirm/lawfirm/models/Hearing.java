package com.lawfirm.lawfirm.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hearings")
public class Hearing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hearing_date", nullable = false)
    private LocalDate hearingDate;

    @Column(name = "judge_name", nullable = false)
    private String judgeName;

    @Column(name = "court_location", nullable = false)
    private String courtLocation;

    @Column(name = "outcome")
    private String outcome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "case_id", nullable = false)
    private LegalCase legalCase;

    // Constructors
    public Hearing() {}

    public Hearing(LocalDate hearingDate, String judgeName, String courtLocation, String outcome, LegalCase legalCase) {
        this.hearingDate = hearingDate;
        this.judgeName = judgeName;
        this.courtLocation = courtLocation;
        this.outcome = outcome;
        this.legalCase = legalCase;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public LocalDate getHearingDate() {
        return hearingDate;
    }

    public void setHearingDate(LocalDate hearingDate) {
        this.hearingDate = hearingDate;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    public String getCourtLocation() {
        return courtLocation;
    }

    public void setCourtLocation(String courtLocation) {
        this.courtLocation = courtLocation;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public LegalCase getLegalCase() {
        return legalCase;
    }

    public void setLegalCase(LegalCase legalCase) {
        this.legalCase = legalCase;
    }

    // toString() showing client and lawyer names
    @Override
    public String toString() {
        String clientName = (legalCase != null && legalCase.getClient() != null)
                ? legalCase.getClient().getFullName()
                : "N/A";

        String lawyerName = (legalCase != null && legalCase.getLawyer() != null)
                ? legalCase.getLawyer().getFullName()
                : "N/A";

        return "Hearing{" +
                "id=" + id +
                ", hearingDate=" + hearingDate +
                ", judgeName='" + judgeName + '\'' +
                ", courtLocation='" + courtLocation + '\'' +
                ", outcome='" + outcome + '\'' +
                ", clientName='" + clientName + '\'' +
                ", lawyerName='" + lawyerName + '\'' +
                '}';
    }
}
