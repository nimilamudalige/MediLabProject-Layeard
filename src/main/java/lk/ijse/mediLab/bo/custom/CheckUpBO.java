package lk.ijse.mediLab.bo.custom;

import lk.ijse.mediLab.bo.SuperBO;
import lk.ijse.mediLab.dao.SqlUtil;
import lk.ijse.mediLab.dto.CheckUpDTO;
import lk.ijse.mediLab.entity.CheckUp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CheckUpBO extends SuperBO {
    public ArrayList<CheckUpDTO> getAllCheckUp() throws SQLException;


    public boolean saveCheckUp(CheckUpDTO dto) throws SQLException;

    public boolean updateCheckUp(CheckUpDTO dto) throws SQLException;


    public boolean deleteCheckUp(String id) throws SQLException;


    public String currentId() throws SQLException;


    public List<String> getChrckUptest() throws SQLException;


    public CheckUp SearchByTypeCheck(String id) throws SQLException;
}
