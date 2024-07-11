package lk.ijse.mediLab.dao.custom;

import lk.ijse.mediLab.DB.DbConnection;
import lk.ijse.mediLab.dao.CrudDAO;
import lk.ijse.mediLab.dto.ClientDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ClientDAO extends CrudDAO<ClientDTO> {
    public  ClientDTO SearchBycontact(String id) throws SQLException;

    }