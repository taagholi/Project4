package business;


import dataAccess.model.*;
import java.util.List;


public class LoanFileLogic {



    public static long decisionAllocate(String nameOfLoan, long duration, long amount, long customerID) {
        long trackingNumber = -1;
        LoanType loanType = LoanTypeCRUD.getModel(nameOfLoan);
        List<GrantConditon> grantConditons = loanType.getGrantConditons();
        for (GrantConditon grantConditon : grantConditons) {
            if (grantConditon.getMinDurationContract() <= duration & grantConditon.getMaxDurationContract() >= duration) {
                if (grantConditon.getMinAmountContract() <= amount & grantConditon.getMaxAmountContract() >= amount) {
                    LoanFile loanFile = new LoanFile();
                    loanFile.setAmountContract(amount);
                    loanFile.setDurationContract(duration);
                    loanFile.setLoanType(loanType);
                    loanFile.setCustomer(CustomerCRUD.read(customerID));
                    trackingNumber = LoanFileCRUD.saveModel(loanFile);

                    Log.logger.info("The Loan " + loanType.getLoanName() + " Allocated to Custmoer with id: " + customerID
                    +", And the Loan File ID is:" + loanFile.getId());
                    break;
                }
            }
        }
        return trackingNumber;
    }
}
