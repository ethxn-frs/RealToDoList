package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Setter
@Builder
public class ToDoList {

    private Integer id;
    private String name;
    private List<Item> itemsList;


    public void saveItem(Item item) {
        if ( itemsList.size() > 8){
            System.out.println("La liste a déjà 8 items. Impossible d'ajouter un nouvel item.");
            return;
        }
        for ( Item i : itemsList){
            if (Objects.equals(i.getName(), item.getName())){
                System.out.println("Un item dans la liste à déja ce nom.");
                return;
            }
        }
        itemsList.add(item);
        System.out.println("L'item a bien été ajouté.");
    }
}
