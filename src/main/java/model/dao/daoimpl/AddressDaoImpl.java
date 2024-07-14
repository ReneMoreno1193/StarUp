package model.dao.daoimpl;

import com.mysql.cj.MysqlConnection;
import model.connection.DBConnection;
import model.dao.IAddressDao;
import model.models.AddressDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDaoImpl implements IAddressDao {
    private static final String INSERT_ADDRESS = "INSERT INTO addresses (name, number,id_user) VALUES(?,?,?)";

    @Override
    public AddressDTO insertAddressDTO(AddressDTO addressDTO) throws SQLException {
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_ADDRESS)){

                //Getter and Setter
                ps.setString(1, addressDTO.getName());
                ps.setInt(2, addressDTO.getNumber());
                ps.setInt(3, addressDTO.getId_user());


                int affectedRows = ps.executeUpdate();
                if(affectedRows == 0){
                    throw new SQLException("No se pudo insertar la fila de Direcciones");
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return addressDTO;
        }
    }