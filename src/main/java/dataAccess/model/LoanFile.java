package dataAccess.model;


public class LoanFile {
    private long id;
    private long durationContract;
    private long amountContract;
    private LoanType loanType;

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDurationContract() {
        return durationContract;
    }

    public void setDurationContract(long durationContract) {
        this.durationContract = durationContract;
    }

    public long getAmountContract() {
        return amountContract;
    }

    public void setAmountContract(long amountContract) {
        this.amountContract = amountContract;
    }
}
