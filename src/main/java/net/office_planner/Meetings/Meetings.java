package net.office_planner.Meetings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Meetings")
public class Meetings {
    @Id
    @Column(nullable = false, unique = true, length = 45)
    private int meeting_id;
    @Column(nullable = false, length = 45)
    private String meeting_name;
    @Column(nullable = false, length = 250)
    private String meeting_description;
    @Column(nullable = false, length = 45)
    private LocalDateTime meeting_start_time;
    @Column(nullable = false, length = 45)
    private LocalDateTime meeting_end_time;
    @Column(nullable = false, length = 45)
    private long meeting_capacity;
    @Column(nullable = false, length = 45)
    private int boardroom_id;
    @Column(nullable = false, length = 45)
    private int employee_id;

    public int getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }

    public String getMeeting_name() {
        return meeting_name;
    }

    public void setMeeting_name(String meeting_name) {
        this.meeting_name = meeting_name;
    }

    public String getMeeting_description() {
        return meeting_description;
    }

    public void setMeeting_description(String meeting_description) {
        this.meeting_description = meeting_description;
    }

    public LocalDateTime getMeeting_start_time() {
        return meeting_start_time;
    }

    public void setMeeting_start_time(LocalDateTime meeting_start_time) {
        this.meeting_start_time = meeting_start_time;
    }

    public LocalDateTime getMeeting_end_time() {
        return meeting_end_time;
    }

    public void setMeeting_end_time(LocalDateTime meeting_end_time) {
        this.meeting_end_time = meeting_end_time;
    }

    public long getMeeting_capacity() {
        return meeting_capacity;
    }

    public void setMeeting_capacity(long meeting_capacity) {
        this.meeting_capacity = meeting_capacity;
    }

    public int getBoardroom_id() {
        return boardroom_id;
    }

    public void setBoardroom_id(int boardroom_id) {
        this.boardroom_id = boardroom_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public String toString() {
        return "Meetings{" +
                "meeting_id=" + meeting_id +
                ", meeting_name='" + meeting_name + '\'' +
                ", meeting_description='" + meeting_description + '\'' +
                ", meeting_capacity=" + meeting_capacity +
                ", boardroom_id=" + boardroom_id +
                ", employee_id=" + employee_id +
                '}';
    }
}
