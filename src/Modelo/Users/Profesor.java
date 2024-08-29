package Modelo.Users;

import Modelo.Users.AbstractUser;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 *
 * @author layonel
 */
public class Profesor extends AbstractUser{

    public Profesor(JSONObject userData) {
        super(userData);
    }
    
}
