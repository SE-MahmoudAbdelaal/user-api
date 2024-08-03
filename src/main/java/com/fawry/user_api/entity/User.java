package com.fawry.user_api.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Size(max = 50, message = "First name must be less than or equal to 50 characters")
    @NotNull(message = "First name is required")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(max = 50, message = "Last name must be less than or equal to 50 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Phone number is required")
    @Size(max = 20, message = "Phone number must be less than or equal to 20 characters")
    @Column(name = "phone")
    private String phone;

    @Size(max = 255, message = "Photo URL must be less than or equal to 255 characters")
    @Column(name = "photo")
    private String photo = "default.jpg";

    @NotNull(message = "Password is required")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be less than or equal to 100 characters")

    @Column(name = "email")
    private String email;

    @Column(name = "is_active", insertable = false)
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private java.sql.Timestamp createdAt;


    @Column(name = "updated_at")
    private java.sql.Timestamp updatedAt;

    @Column(name = "deleted_at")
    private java.sql.Timestamp deletedAt;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role = new Role(1L,"user");
}

