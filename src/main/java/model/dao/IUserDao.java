package model.dao;

import model.models.UserDTO;

public interface IUserDao {
    public UserDTO getUser(int id);
    public UserDTO insertUser(UserDTO userDTO);
}
