package net.office_planner.Boardroom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardroomRepository extends JpaRepository<Boardroom, Integer> {
    @Query("SELECT b FROM Boardroom b WHERE b.boardroom_id= ?1")
    Boardroom findByBoardroom_id(Integer boardroom_id);

    //Organization getById(Integer organization_id);

}

