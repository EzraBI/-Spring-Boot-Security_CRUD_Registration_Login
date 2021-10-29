package net.office_planner.Boardroom;

import javax.persistence.*;

@Entity
@Table(name = "Boardroom")
public class Boardroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardroom_id", nullable = false, length = 45)
    private int boardroom_id;
    @Column(name = "boardroom_name", nullable = false, length = 45)
    private String boardroom_name;


    public int getBoardroom_id() {
        return boardroom_id;
    }

    public void setBoardroom_id(int boardroom_id) {
        this.boardroom_id = boardroom_id;
    }

    public String getBoardroom_name() {
        return boardroom_name;
    }

    public void setBoardroom_name(String boardroom_name) {
        this.boardroom_name = boardroom_name;
    }



    @Override
    public String toString() {
        return "Boardroom{" +
                "boardroom_id=" + boardroom_id +
                ", boardroom_name='" + boardroom_name + '\'' +
                '}';
    }
}
