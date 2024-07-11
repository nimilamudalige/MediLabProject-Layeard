package lk.ijse.mediLab.dao.custom.impl;

import lk.ijse.mediLab.DB.DbConnection;
import lk.ijse.mediLab.dao.SqlUtil;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dto.ClientDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    public boolean save(ClientDTO dto) throws SQLException {
//        In here you can now save your customer
        return SqlUtil.execute("INSERT INTO Client VALUES(?, ?, ?, ?, ?, ?, ?)", dto.getId(), dto.getName(), dto.getAge(), dto.getAddress(), dto.getTel(), dto.getEmail(), dto.getUserId());

    }

    public boolean update(ClientDTO dto) throws SQLException {
       return SqlUtil.execute("UPDATE Client SET name=?, age=?, address=?, contact=?, email=?, userId=? WHERE clientId=?",dto.getId(),dto.getName(),dto.getAge(),dto.getAddress(),dto.getTel(),dto.getEmail(),dto.getUserId());
    }


 /*   public static Client SearchById(String id) throws SQLException {
        String sql = "SELECT * FROM Client WHERE clientId=?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, id);
        ResultSet resultSet = pstm.executeQuery();

        Client client = null;

        if (resultSet.next()) {
            String ClientId = resultSet.getString(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String address = resultSet.getString(4);
            String tel = resultSet.getString(5);
            String Email = resultSet.getString(6);
            String UserId = resultSet.getString(7);

            client = new Client();


        }
        return client;
    }
    */


    public boolean delete(String id) throws SQLException {
        return  SqlUtil.execute("DELETE FROM Client WHERE clientId = ?",id);

    }


    public ArrayList<ClientDTO> getAll() throws SQLException {
        ArrayList<ClientDTO> allCustomers = new ArrayList<>();

        ResultSet rst = SqlUtil.execute("SELECT * FROM Client");

        while (rst.next()) {
            ClientDTO customerDTO = new ClientDTO(rst.getString("id"), rst.getString("name"), rst.getInt("age"), rst.getString("address"), rst.getString("contact"), rst.getString("email"), rst.getString("userId"));
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }


    public  String currentId() throws SQLException {
        String sql = "SELECT clientId FROM Client ORDER BY clientId DESC LIMIT 1";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString(1);
        } else {
            return null;
        }
    }

    public ClientDTO SearchBycontact(String id) throws SQLException {
        String sql = "SELECT * FROM Client WHERE contact=?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, id);
        ResultSet resultSet = pstm.executeQuery();

        ClientDTO dto = null;

        if (resultSet.next()) {
            String ClientId = resultSet.getString(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String address = resultSet.getString(4);
            String tel = resultSet.getString(5);
            String email = resultSet.getString(6);
            String UserId = resultSet.getString(7);

            dto = new ClientDTO(ClientId, name, age, address, tel, email, UserId);


        }
        return dto;
    }
}
