package com.marlena.beautyschool.model;

import com.marlena.beautyschool.annotation.FieldsValueMatch;
import com.marlena.beautyschool.annotation.PasswordValidator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "pwd",
                fieldMatch = "confirmPwd",
                message = "Passwords do not match"
        ),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "confirmEmail",
                message = "Email addresses do not match"
        )
})
public class Person extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int personId;

    @NotBlank(message = "Name must not be blank")
    @Size(min=3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Phone number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Confirm email must not be blank")
    @Email(message = "Please provide a valid confirm email address")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank")
    @Size(min=5, message = "Password must be at least 5 characters long")
    @PasswordValidator
    private String pwd;

    @NotBlank(message = "Confirm password must not be blank")
    @Size(min=5, message = "Confirm password must be at least 5 characters long")
    @Transient
    private String confirmPwd;
}
