package model.dao;

import model.models.AddressDTO;

import java.sql.SQLException;

public interface IAddressDao {
    public AddressDTO insertAddressDTO (AddressDTO addressDTO) throws SQLException;
}
