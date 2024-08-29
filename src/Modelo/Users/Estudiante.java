package Modelo.Users;

import Modelo.Users.AbstractUser;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author layonel
 */
public class Estudiante extends AbstractUser{
    private Integer horasCorresponsabilidad;

    public Estudiante(JSONObject userData) {
        super(userData);
        this.horasCorresponsabilidad = 1;
    }
  
}
