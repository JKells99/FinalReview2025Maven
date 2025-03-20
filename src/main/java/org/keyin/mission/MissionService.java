package org.keyin.mission;

public class MissionService {

    private MissionDAO missionDAO = new MissionDAO();

    public void createMission(Mission mission) {
        if(mission.getMission_name() == null || mission.getMission_name().isEmpty()) {
            throw new IllegalArgumentException("Mission name cannot be empty");
        }

        if( mission.equals(null)) {
            throw new IllegalArgumentException("Mission cannot be null");
        }

        missionDAO.createNewMission(mission);
        System.out.println("Mission created successfully");
    }
}
