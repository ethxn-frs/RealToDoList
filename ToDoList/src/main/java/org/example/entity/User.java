package org.example.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.commons.validator.EmailValidator;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Autowired
    EmailSenderService emailSenderService;

    public static int MIN_AGE = 13;

    private Integer id;
    private String email;
    private String password;
    private String fName;
    private String lName;
    private LocalDateTime bdate;
    private ToDoList toDoList;

    public boolean isValid() {
        return //EmailValidator.getInstance().isValid(this.email)
                 this.fName != null
                && this.fName != " "
                && this.lName != null
                && this.lName != " "
                && LocalDateTime.now().minusYears(MIN_AGE).isAfter(this.bdate)
                && isPasswordValid();
    }

    private void sendEmailToUser() {

        if ( this.toDoList.getItemsList().size() >= 8)
        emailSenderService.sendEmail(this.email, "Objet : ", "contenu");
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