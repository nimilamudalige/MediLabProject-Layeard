package lk.ijse.mediLab.bo.custom;

import lk.ijse.mediLab.bo.SuperBO;
import lk.ijse.mediLab.dao.SqlUtil;
import lk.ijse.mediLab.dto.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    public ArrayList<EmployeeDTO> getAll() throws SQLException;



    public boolean save(EmployeeDTO dto) throws SQLException;


    public boolean update(EmployeeDTO entity) throws SQLException;


    public boolean delete(String id) throws SQLException;


    public String currentId() throws SQLException;
}
