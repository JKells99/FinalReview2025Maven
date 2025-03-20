package org.keyin.mission;

import org.keyin.database.DatabaseConnection;
import org.keyin.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MissionDAO {

    public void createNewMission(Mission mission) {
        String sql = "INSERT INTO public.missions(\n" +
                "\t mission_name, mission_type, assigned_to_user_id, status)\n" +
                "\tVALUES (?, ?, ?, ?);";

        try(Connection connection = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mission.getMission_name());
            preparedStatement.setString(2, mission.getMission_type());
            preparedStatement.setInt(3, mission.getAssigned_to_user_id());
            preparedStatement.setString(4, mission.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


}
