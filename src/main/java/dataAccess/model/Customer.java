package dataAccess.model;

import java.util.List;

public class Customer {
    private long id;
    private String name;
    private String family;
    private String fatherName;
    private long codeMelli;
    private List<LoanFile> loanFiles;

    public List<LoanFile> getLoanFiles() {
        return loanFiles;
    }

    public void setLoanFiles(List<LoanFile> loanFiles) {
        this.loanFiles = loanFiles;
    }

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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public long getCodeMelli() {
        return codeMelli;
    }

    public void setCodeMelli(long codeMelli) {
        this.codeMelli = codeMelli;
    }
}
