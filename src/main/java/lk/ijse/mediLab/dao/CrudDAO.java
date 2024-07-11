package lk.ijse.mediLab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO <T>extends SuperDAO{
    public ArrayList<T> getAll() throws SQLException;

    public  boolean save(T entity) throws SQLException;

    public boolean update(T entity) throws SQLException;

    public boolean delete(String id) throws SQLException;

    public String currentId() throws SQLException;






}
