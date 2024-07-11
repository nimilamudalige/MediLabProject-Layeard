package lk.ijse.mediLab.bo.custom.impl;

import lk.ijse.mediLab.bo.custom.CheckUpBO;
import lk.ijse.mediLab.dao.DAOFactory;
import lk.ijse.mediLab.dao.custom.CheckUpDAO;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dto.CheckUpDTO;
import lk.ijse.mediLab.entity.CheckUp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckUpBOImpl implements CheckUpBO {
    CheckUpDAO checkUpDAO = (CheckUpDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CHECKUP);


    @Override
    public ArrayList<CheckUpDTO> getAllCheckUp() throws SQLException {
        ArrayList<CheckUp> allEntityData = checkUpDAO.getAll();
        ArrayList<CheckUpDTO> allDTOData= new ArrayList<>();
        for (CheckUp check : allEntityData) {
            allDTOData.add(new CheckUpDTO(check.getCheckId(), check.getType(), check.getPrice()));
        }
        return allDTOData;

    }

    @Override
    public boolean saveCheckUp(CheckUpDTO dto) throws SQLException {
        return checkUpDAO.save(new CheckUp(dto.getCheckId(), dto.getType(), dto.getPrice()));
    }

    @Override
    public boolean updateCheckUp(CheckUpDTO dto) throws SQLException {
        return checkUpDAO.update(new CheckUp(dto.getCheckId(), dto.getType(), dto.getPrice()));
    }

    @Override
    public boolean deleteCheckUp(String id) throws SQLException {
        return checkUpDAO.delete(id);
    }

    @Override
    public String currentId() throws SQLException {
        return checkUpDAO.currentId();
    }

    @Override
    public List<String> getChrckUptest() throws SQLException {
        return checkUpDAO.getChrckUptest();
    }

    @Override
    public CheckUp SearchByTypeCheck(String id) throws SQLException {
        return checkUpDAO.SearchByTypeCheck(id);
    }
}
