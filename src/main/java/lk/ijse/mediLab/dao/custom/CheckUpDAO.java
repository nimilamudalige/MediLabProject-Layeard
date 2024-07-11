package lk.ijse.mediLab.dao.custom;

import lk.ijse.mediLab.DB.DbConnection;
import lk.ijse.mediLab.dao.CrudDAO;
import lk.ijse.mediLab.dto.CheckUpDTO;
import lk.ijse.mediLab.entity.CheckUp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CheckUpDAO extends CrudDAO<CheckUpDTO> {
    public  List<String> getChrckUptest() throws SQLException;

    public CheckUp SearchByType(String id) throws SQLException ;
    }
