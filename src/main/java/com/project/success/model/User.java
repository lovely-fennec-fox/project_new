package com.project.success.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @Column(name= "Idx_User")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name= "Name_User")
    private String name;

    @NotEmpty
    @Column(name= "Email")
    private String email;

    @Column(name= "Pw_User")
    private String password;

    @Column(name= "salt")
    private String salt;

    @Column(name= "Phone_User")
    private String phone;

    @Column(name= "Address_User")
    private String address;

    @Column(name= "Role")
    private String role;

    @Column(name= "Create_at")
    private LocalDateTime createdAt;

    @Column(name= "Update_at")
    private LocalDateTime updatedAt;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }

//    @Override
//    public String getUsername() {
//        return null;
//    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
}
