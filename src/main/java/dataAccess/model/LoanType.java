package dataAccess.model;


import java.util.List;

public class LoanType {
    private long id;
    private String loanName;
    private long profit;
    private List<GrandCondition> grandConditions;

    public List<GrandCondition> getGrandConditions() {
        return grandConditions;
    }

    public void setGrandConditions(List<GrandCondition> grandConditions) {
        this.grandConditions = grandConditions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }
}
