package com.lawfirm.lawfirm.models;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "hearings")


public class Hearing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int caseId;
    private LocalDate hearingDate;
    private String judgeName;
    private String courtLocation;
    private String outcome;

    // Getters and Setters
    public int getCaseId() { return caseId; }
    public void setCaseId(int caseId) { this.caseId = caseId; }

    public LocalDate getHearingDate() { return hearingDate; }
    public void setHearingDate(LocalDate hearingDate) { this.hearingDate = hearingDate; }

    public String getJudgeName() { return judgeName; }
    public void setJudgeName(String judgeName) { this.judgeName = judgeName; }

    public String getCourtLocation() { return courtLocation; }
    public void setCourtLocation(String courtLocation) { this.courtLocation = courtLocation; }

    public String getOutcome() { return outcome; }
    public void setOutcome(String outcome) { this.outcome = outcome; }
}


