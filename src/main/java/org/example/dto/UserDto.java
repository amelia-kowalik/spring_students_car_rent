package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.User;
import org.example.model.Vehicle;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private String login;
    private User.Role role;
    @JsonIgnore
    private Vehicle rentedVehicle;
}