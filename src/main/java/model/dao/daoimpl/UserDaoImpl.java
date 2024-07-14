package model.dao.daoimpl;

import model.connection.DBConnection;
import model.dao.IUserDao;
import model.models.UserDTO;

import java.sql.*;

public class UserDaoImpl implements IUserDao {

    private static final String INSERT_USER = "INSERT INTO user(email,password,name,nick_name,weigth, update_at) VALUES(?,?,?,?,?,?,?)";

    @Override
    public UserDTO getUser(int id) {

        return null;
    }

    @Override
    public UserDTO insertUser(UserDTO userDTO) {
        try(Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1,userDTO.getEmail());
            ps.setString(5, userDTO.getPassword());
            ps.setString(4, userDTO.getName());
            ps.setString(3, userDTO.getNick_name());
            ps.setInt(6, userDTO.getWeight());
            ps.setDate(2, new Date(userDTO.getCreate_at().getTime()));
            ps.setDate(7, new Date(userDTO.getUpdate_at().getTime()));

            int affectedRows =  ps.executeUpdate();

            //Verificamos que se haya insertado el registro
            if(affectedRows == 0){
                throw new SQLException("Crear usuario ha fallado");
            }

            //obtenemos el Id generado de la query Insert y lo asignamos al objeto usuario antes de retornarlo
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                    userDTO.setUserId(rs.getInt(1));
                }else{
                    throw new SQLException("Creacion de usuario fallida no se pudo obtener el id");
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return userDTO;
        }
    }


