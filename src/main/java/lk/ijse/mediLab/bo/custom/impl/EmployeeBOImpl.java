package lk.ijse.mediLab.bo.custom.impl;

import lk.ijse.mediLab.bo.BOFactory;
import lk.ijse.mediLab.bo.custom.EmployeeBO;
import lk.ijse.mediLab.dao.custom.EmployeeDAO;
import lk.ijse.mediLab.dao.custom.PaymentDAO;
import lk.ijse.mediLab.dto.EmployeeDTO;
import lk.ijse.mediLab.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO  = (EmployeeDAO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    @Override
    public ArrayList<EmployeeDTO> getAll() throws SQLException {
        ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();
        ArrayList<EmployeeDTO> all = employeeDAO.getAll();
        for (EmployeeDTO employee : all) {
            allEmployees.add(new EmployeeDTO(employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getContact(), employee.getType(), employee.getBId()));
        }
        return allEmployees;
    }

    @Override
    public boolean save(EmployeeDTO dto) throws SQLException {
        return employeeDAO.save(new Employee(dto.getEmployeeId(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getType(), dto.getBId()));
    }

    @Override
    public boolean update(EmployeeDTO entity) throws SQLException {
        return employeeDAO.update(new Employee(entity.getEmployeeId(), entity.getName(), entity.getAddress(), entity.getContact(), entity.getType(), entity.getBId()));
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return employeeDAO.delete(id);
    }

    @Override
    public String currentId() throws SQLException {
        return employeeDAO.currentId();
    }
}
