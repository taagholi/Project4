package dataAccess.model;

import dataAccess.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class LoanFileCRUD {

    public static long saveModel(LoanFile loanFile){
        Session sessionHibernate = HibernateUtil.getSession();
        try {
            Transaction transaction = sessionHibernate.beginTransaction();
            sessionHibernate.saveOrUpdate(loanFile);
            transaction.commit();
        } finally {
            sessionHibernate.close();
        }

        return  loanFile.getId();

    }
}
