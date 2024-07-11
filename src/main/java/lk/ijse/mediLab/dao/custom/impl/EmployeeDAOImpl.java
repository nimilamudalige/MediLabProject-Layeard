package lk.ijse.mediLab.dao.custom.impl;

import lk.ijse.mediLab.dao.SqlUtil;
import lk.ijse.mediLab.dao.custom.EmployeeDAO;
import lk.ijse.mediLab.dto.EmployeeDTO;
import lk.ijse.mediLab.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public ArrayList<EmployeeDTO> getAll() throws SQLException {
        ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM Employee");
        while (rst.next()) {
            EmployeeDTO employeeDTO = new EmployeeDTO(rst.getString("employeeId"), rst.getString("name"), rst.getString("Address"), rst.getInt("contact"), rst.getString("Type"), rst.getString("branchId"));
            allEmployees.add(employeeDTO);
        }
        return allEmployees;
    }


    @Override
    public boolean save(EmployeeDTO dto) throws SQLException {
        return SqlUtil.execute("INSERT INTO Employee VALUES(?, ?, ?, ?, ?, ?)", dto.getEmployeeId(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getType(), dto.getBId());
    }

    @Override
    public boolean update(EmployeeDTO entity) throws SQLException {
        return SqlUtil.execute("UPDATE Employee SET name=?, address=?, contact=?, type=?, branchId=? WHERE employeeId=?",entity.getEmployeeId(),entity.getName(),entity.getAddress(),entity.getContact(),entity.getType(),entity.getBId());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM Employee WHERE employeeId=?",id);
    }

    @Override
    public String currentId() throws SQLException {
        return SqlUtil.execute("SELECT id FROM Employee ORDER BY id DESC LIMIT 1");
    }
}
