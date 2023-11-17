package org.example.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import org.apache.commons.validator.EmailValidator;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Builder
public class User {

    public static int MIN_AGE = 13;

    private Integer id;
    private String email;
    private String password;
    private String fName;
    private String lName;
    private LocalDate bdate;
    private ToDoList toDoList;

    public boolean isValid() {
        return EmailValidator.getInstance().isValid(this.email)
                && this.fName != null
                && this.fName != " "
                && this.lName != null
                && this.lName != " "
                && LocalDate.now().minusYears(MIN_AGE).isAfter(this.bdate)
                && isPasswordValid();
    }

    private boolean isPasswordValid() {
        // Vérifier la longueur du mot de passe
        if (this.password.length() < 8 || this.password.length() > 40) {
            return false;
        }
        // Vérifier la présence d'au moins une majuscule, une minuscule et un chiffre
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
        return this.password.matches(regex);
    }

}