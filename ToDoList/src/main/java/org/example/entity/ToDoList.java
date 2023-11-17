package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ToDoList {

    private Integer id;
    private String name;
    private List<Item> itemsList;


    public void saveItem(Item item) {
        if ( itemsList.size() >= 10){
            System.out.println("La liste a déjà 10 items. Impossible d'ajouter un nouvel item.");
            return;
        }
        if ( itemsList.size() >= 8){
            //emailService
        }
        for ( Item i : itemsList){
            if (Objects.equals(i.getName(), item.getName())){
                System.out.println("Un item dans la liste à déja ce nom.");
                return;
            }
            if ( ChronoUnit.MINUTES.between(i.getCreationDate(), LocalDateTime.now()) <= 30){
                System.out.println("Un item a déjà été enregistré il y a moins de 30 minutes.");
                return;
            }
        }
        itemsList.add(item);
        System.out.println("L'item a bien été ajouté.");
    }
}
