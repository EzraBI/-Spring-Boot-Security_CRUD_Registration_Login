package net.office_planner.Organization;

import net.office_planner.Boardroom.Boardroom;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id", nullable = false, length = 45)
    private int organization_id;
    @Column(name = "organization_name",nullable = false, length = 45, unique = true)
    private String organization_name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "organization_boardrooms",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "boardroom_id")
    )
    private Set<Boardroom> boardrooms = new HashSet<>();

    public int getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public Set<Boardroom> getBoardrooms() {
        return boardrooms;
    }

    public void setBoardrooms(Set<Boardroom> boardrooms) {
        this.boardrooms = boardrooms;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organization_id=" + organization_id +
                ", organization_name='" + organization_name + '\'' +
                ", boardrooms=" + boardrooms +
                '}';
    }
}
