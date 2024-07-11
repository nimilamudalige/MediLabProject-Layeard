package lk.ijse.mediLab.bo.custom;

import lk.ijse.mediLab.DB.DbConnection;
import lk.ijse.mediLab.bo.SuperBO;
import lk.ijse.mediLab.bo.custom.impl.ClientBOImpl;
import lk.ijse.mediLab.dao.SqlUtil;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dto.ClientDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientBO extends SuperBO {
        public boolean saveClient(ClientDTO dto) throws SQLException;

    public boolean updateClient(ClientDTO dto) throws SQLException;

    public boolean deleteClient(String id) throws SQLException;


    public ArrayList<ClientDTO> getAllClient() throws SQLException;

    public  String currentId1() throws SQLException;

    public ClientDTO SearchBycontact(String id) throws SQLException;
}
