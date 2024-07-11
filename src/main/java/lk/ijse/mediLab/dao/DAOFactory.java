package lk.ijse.mediLab.dao;

import lk.ijse.mediLab.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CLIENT,CHECKUP,APPOINTMENT,EMPLOYEE,PAYMENT,QUERY_DAO
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case CLIENT:
                return new ClientDAOImpl();
            case CHECKUP:
                return new CheckUpDAOImpl();
            case APPOINTMENT:
                return new AppointmentDAOImpl();
            case EMPLOYEE:
                    return new EmployeeDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();

                case QUERY_DAO:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }

}
