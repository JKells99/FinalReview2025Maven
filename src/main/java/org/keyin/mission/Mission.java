package org.keyin.mission;

public class Mission {
    private int mission_id;
    private String mission_name;
    private String mission_type;
    private int assigned_to_user_id;
    private String status;

    public Mission(int mission_id, String mission_name, String mission_type, int assigned_to_user_id, String status) {
        this.mission_id = mission_id;
        this.mission_name = mission_name;
        this.mission_type = mission_type;
        this.assigned_to_user_id = assigned_to_user_id;
        this.status = status;
    }

    public Mission(String mission_name, String mission_type, int assigned_to_user_id, String status) {
        this.mission_name = mission_name;
        this.mission_type = mission_type;
        this.assigned_to_user_id = assigned_to_user_id;
        this.status = status;
    }

    public int getMission_id() {
        return mission_id;
    }

    public void setMission_id(int mission_id) {
        this.mission_id = mission_id;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public String getMission_type() {
        return mission_type;
    }

    public void setMission_type(String mission_type) {
        this.mission_type = mission_type;
    }

    public int getAssigned_to_user_id() {
        return assigned_to_user_id;
    }

    public void setAssigned_to_user_id(int assigned_to_user_id) {
        this.assigned_to_user_id = assigned_to_user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  @Override
    public String toString() {
        return "Mission{" +
                "mission_id=" + mission_id +
                ", mission_name='" + mission_name + '\'' +
                ", mission_type='" + mission_type + '\'' +
                ", assigned_to_user_id=" + assigned_to_user_id +
                ", status='" + status + '\'' +
                '}';
    }
}
