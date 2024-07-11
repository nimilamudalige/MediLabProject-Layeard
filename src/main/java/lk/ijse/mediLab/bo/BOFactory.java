package lk.ijse.mediLab.bo;

import lk.ijse.mediLab.bo.custom.impl.*;
import lk.ijse.mediLab.dao.custom.impl.MachineDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CLIENT,CHECKUP,APPOINTMENT,EMPLOYEE,MACHINE,PAYMENT
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case CLIENT:
                return new ClientBOImpl();
            case CHECKUP:
                return new CheckUpBOImpl();
            case APPOINTMENT:
                return new AppointmentBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
                case MACHINE:
                    return new MachineBOImpl();
                case PAYMENT:
                    return new PaymentBOImpl();

            default:
                return null;
        }
    }
}
