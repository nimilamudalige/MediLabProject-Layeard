package lk.ijse.mediLab.dao.custom.impl;

import lk.ijse.mediLab.DB.DbConnection;
import lk.ijse.mediLab.dao.SqlUtil;
import lk.ijse.mediLab.dao.custom.CheckUpDAO;
import lk.ijse.mediLab.dto.CheckUpDTO;
import lk.ijse.mediLab.entity.CheckUp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckUpDAOImpl implements CheckUpDAO {
    @Override
    public ArrayList<CheckUpDTO> getAll() throws SQLException {
        ArrayList<CheckUpDTO> allCheckUps = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM CheckUp");
        while (rst.next()) {
            CheckUpDTO checkUpDTO = new CheckUpDTO(rst.getString("checkId"), rst.getString("type"), rst.getDouble("price"));
            allCheckUps.add(checkUpDTO);
        }
        return allCheckUps;
    }

    @Override
    public boolean save(CheckUpDTO dto) throws SQLException {
        return SqlUtil.execute("INSERT INTO CheckUp VALUES(?, ?, ?)", dto.getCheckId(), dto.getType(), dto.getPrice());
    }

    @Override
    public boolean update(CheckUpDTO dto) throws SQLException {
        return SqlUtil.execute("UPDATE CheckUp SET type=?, price=?, appointmentId=? WHERE checkId=?",dto.getCheckId(),dto.getType(),dto.getPrice());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM CheckUp WHERE checkId=?",id);
    }

    @Override
    public String currentId() throws SQLException {
        return SqlUtil.execute("SELECT checkId FROM CheckUp ORDER BY checkId DESC LIMIT 1");


    }

    @Override
    public List<String> getChrckUptest() throws SQLException {
        return SqlUtil.execute("SELECT DISTINCT type FROM CheckUp");
    }

    @Override
    public CheckUp SearchByType(String id) throws SQLException {
        return SqlUtil.execute("SELECT * FROM CheckUp WHERE Type=?",id);
    }
}
