package net.office_planner.Organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    @Query("SELECT o FROM Organization o WHERE o.organization_id = ?1")
    Organization findByOrganization_id(Integer organization_id);

    //Organization getById(Integer organization_id);

}

