package model.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserDTO {
    private int userId;
    private String email;
    private String password;
    private String name;
    private String nick_name;
    private int weight;
    private int card_id;
    private Timestamp create_at;
    private Timestamp update_at;

    //Con el Loombok "@AllArgsConstructor, no es necesario armar codigo de constructurores
    /* public UserDTO(int id, String email, String password, String name, String nick_name, int weight, int card_id, Timestamp create_at, Timestamp update_at){
        this.email = email;
        this.password = password;
        this.name =  name;
        this.nick_name =  nick_name;
        this.weight = weight;
        this.card_id = card_id;
        this.create_at = create_at;
        this.update_at = update_at;
    }*/
}
