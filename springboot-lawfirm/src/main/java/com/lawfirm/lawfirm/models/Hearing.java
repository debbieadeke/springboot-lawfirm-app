package com.lawfirm.lawfirm.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hearings")
public class Hearing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate hearingDate;
    private String judgeName;
    private String courtLocation;
    private String outcome;

    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private LegalCase hearingCase;

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

    public LegalCase getHearingCase() {
        return hearingCase;
    }

    public void setHearingCase(LegalCase hearingCase) {
        this.hearingCase = hearingCase;
    }
}
