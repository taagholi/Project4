package dataAccess.model;


public class GrandCondition {
    private long id;
    private String name;
    private long minDurationContract;
    private long maxDurationContract;
    private long minAmountContract;
    private long maxAmountContract;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMinDurationContract() {
        return minDurationContract;
    }

    public void setMinDurationContract(long minDurationContract) {
        this.minDurationContract = minDurationContract;
    }

    public long getMaxDurationContract() {
        return maxDurationContract;
    }

    public void setMaxDurationContract(long maxDurationContract) {
        this.maxDurationContract = maxDurationContract;
    }

    public long getMinAmountContract() {
        return minAmountContract;
    }

    public void setMinAmountContract(long minAmountContract) {
        this.minAmountContract = minAmountContract;
    }

    public long getMaxAmountContract() {
        return maxAmountContract;
    }

    public void setMaxAmountContract(long maxAmountContract) {
        this.maxAmountContract = maxAmountContract;
    }
}
