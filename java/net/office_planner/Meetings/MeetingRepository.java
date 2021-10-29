package net.office_planner.Meetings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MeetingRepository extends JpaRepository<Meetings, Integer> {
    @Query("SELECT m FROM Meetings m WHERE m.meeting_id = ?1")
    Meetings findByMeeting_id(Integer meeting_id);

    //Organization getById(Integer organization_id);

}

