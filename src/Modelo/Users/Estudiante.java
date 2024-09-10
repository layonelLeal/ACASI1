package Modelo.Users;

import org.json.JSONObject;

public class Estudiante extends AbstractUser{
    private Float joint_responsability_hours = 0F;

    public Estudiante(JSONObject userData) {
        super(userData);
    }

    public Float getJoint_responsability_hours() {
        return joint_responsability_hours;
    }

    public void setJoint_responsability_hours(Float joint_responsability_hours) {
        this.joint_responsability_hours = joint_responsability_hours;
    }

}
