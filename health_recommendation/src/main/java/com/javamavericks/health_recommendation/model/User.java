package com.javamavericks.health_recommendation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "user_name")
    @Setter
    private String userName;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Getter
    @Setter
    private Role role;


    @Enumerated(value = EnumType.STRING)
    @Getter
    @Setter
    private Gender gender;

    @Column(name = "contact")
    @Getter
    @Setter
    private String contact;

    @Column(name = "address")
    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    @JoinColumn(name = "health_data_id")
    private HealthData healthData;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    @JoinColumn(name = "track_id")
    private Track track;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
