package lk.nnj.mdss.fx.dao;

import lk.nnj.mdss.fx.dao.Custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public enum DAOTypes{
        CONT,CUS,DEL,ITM,ORD,TRC,QRY
    }

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes daoType) {
        switch (daoType) {
            case CONT:
                return new ConDAOImpl();
            case CUS:
                return new CusDAOImpl();
            case DEL:
                return new DelDAOImpl();
            case ITM:
                return new ItemDAOImpl();
            case ORD:
                return new OrderDAOImpl();
            case TRC:
                return new TrackDAOImpl();
            case QRY:
                return new QueryDAOimpl();
            default:
                return null;
        }
    }

}
