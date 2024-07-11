package lk.ijse.mediLab.bo.custom.impl;

import lk.ijse.mediLab.bo.custom.ClientBO;
import lk.ijse.mediLab.dao.DAOFactory;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dto.ClientDTO;
import lk.ijse.mediLab.entity.Client;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClientBOImpl implements ClientBO {
    ClientDAO clientDAO = (ClientDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CLIENT);
    @Override
    public boolean saveClient(ClientDTO dto) throws SQLException {
        return clientDAO.save(new Client(dto.getId(), dto.getName(), dto.getAge(), dto.getAddress(), dto.getTel(), dto.getEmail(), dto.getUserId()));

    }

    @Override
    public boolean updateClient(ClientDTO dto) throws SQLException {
        return clientDAO.update(new Client(dto.getId(), dto.getName(), dto.getAge(), dto.getAddress(), dto.getTel(), dto.getEmail(), dto.getUserId()));
    }

    @Override
    public boolean deleteClient(String id) throws SQLException {
        return clientDAO.delete(id);
    }

    @Override
    public ArrayList<ClientDTO> getAllClient() throws SQLException {
        ArrayList<ClientDTO> allClients = new ArrayList<>();
        ArrayList<Client> all = clientDAO.getAll();
        for (Client client : all) {
            allClients.add(new ClientDTO(client.getId(), client.getName(), client.getAge(), client.getAddress(), client.getTel(), client.getEmail(), client.getUserId()));
        }
        return allClients;
    }



    @Override
    public String currentId1() throws SQLException {
        return clientDAO.currentId();
    }

    @Override
    public ClientDTO SearchBycontact(String id) throws SQLException {
        return clientDAO.SearchBycontact(id);
    }
}
