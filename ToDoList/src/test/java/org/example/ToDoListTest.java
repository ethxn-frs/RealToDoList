package org.example;

import org.example.entity.Item;
import org.example.entity.ToDoList;
import org.example.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cglib.proxy.UndeclaredThrowableException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class ToDoListTest {

    public User u;
    public ToDoList toDoList;
    List<Item> itemList = new ArrayList<>();
    @BeforeEach
    public void setup() {
        this.itemList = new ArrayList<>();
        this.toDoList = new ToDoList(1, "toDoList1", this.itemList);
        this.u = new User(1,
                "email@esgi.fr",
                "T3stTest11",
                "soso",
                "maness",
                LocalDateTime.now().minusYears(20),
                this.toDoList);
    }
    @Test
    public void addItemToToDoList(){

        Item item = new Item("item1", "Bonjour");
        toDoList.saveItem(item);

        Assertions.assertEquals(1, toDoList.getItemsList().size());
    }

    @Test
    public void addItemWithSameNameToToDoList(){

        Item item = new Item("item1", "Bonjour");

        System.out.print("Ajout du premier item :\n ");
        toDoList.saveItem(item);

        Item item2 = new Item("item1", "Aurevoir");
        System.out.print("Ajout du deuxieme item :\n ");

        this.toDoList = mock(ToDoList.class);
        when(this.toDoList.saveItem(item2).thenTrow(new RuntimeException("Une exception a été lancée")));

        Assertions.assertFalse(toDoList.saveItem(item2));
    }

    @Test
    public void addTwoItemsLessThanThirtyMinutes(){

        Item item = new Item("item1", "Bonjour");
        System.out.print("Ajout du premier item \n ");
        toDoList.saveItem(item);

        Item item2 = new Item("item2", "Aurevoir");
        System.out.print("Ajout du deuxieme item \n ");
        toDoList.saveItem(item2);

        this.toDoList = mock(ToDoList.class);
        when(this.toDoList.saveItem(item2).thenThrow(new RuntimeException("Une exception a été lancée")));

        Assertions.assertEquals(1, toDoList.getItemsList().size());
    }

    @Test
    public void addItemToFullList(){

        Item item = new Item("item1", "Bonjour");
        System.out.print("Ajout du premier item \n ");
        toDoList.saveItem(item);

        Item item2 = new Item("item2", "Aurevoir");
        item2.setCreationDate(LocalDateTime.now().minusMinutes(31));
        System.out.print("Ajout du deuxieme item \n ");
        toDoList.saveItem(item2);

        Item item3 = new Item("item3", "troisiemeitem");
        item3.setCreationDate(LocalDateTime.now().minusMinutes(62));
        System.out.print("Ajout du troisieme item \n ");
        toDoList.saveItem(item3);

        Item item4 = new Item("item4", "quatriemeitem");
        item4.setCreationDate(LocalDateTime.now().minusMinutes(93));
        System.out.print("Ajout du quatrieme item \n ");
        toDoList.saveItem(item4);

        Item item5 = new Item("item5", "cinquiemeItem");
        item5.setCreationDate(LocalDateTime.now().minusMinutes(124));
        System.out.print("Ajout du cinquieme item \n ");
        toDoList.saveItem(item5);

        Item item6 = new Item("item6", "sixiemeItem");
        item6.setCreationDate(LocalDateTime.now().minusMinutes(155));
        System.out.print("Ajout du siexieme item \n ");
        toDoList.saveItem(item6);

        Item item7 = new Item("item7", "spetiemeItem");
        item7.setCreationDate(LocalDateTime.now().minusMinutes(186));
        System.out.print("Ajout du septieme item \n ");
        toDoList.saveItem(item7);

        Item item8 = new Item("item8", "huitiemeItem");
        item8.setCreationDate(LocalDateTime.now().minusMinutes(217));
        System.out.print("Ajout du huitieme item \n ");
        toDoList.saveItem(item8);

        Item item9 = new Item("item9", "neuviemeItem");
        item9.setCreationDate(LocalDateTime.now().minusMinutes(248));
        System.out.print("Ajout du neuvieme item \n ");
        toDoList.saveItem(item9);

        Item item10 = new Item("item10", "DixiemeItem");
        item10.setCreationDate(LocalDateTime.now().minusMinutes(279));
        System.out.print("Ajout du diexieme item \n ");
        toDoList.saveItem(item10);

        Item item11 = new Item("item11", "onziemeIteme");
        item11.setCreationDate(LocalDateTime.now().minusMinutes(310));
        System.out.print("Ajout du onzieme item \n ");
        toDoList.saveItem(item11);

        this.toDoList = mock(ToDoList.class);
        when(this.toDoList.saveItem(item11).thenThrow(new RuntimeException("Une exception a été lancée")));

        Assertions.assertEquals(10, toDoList.getItemsList().size());

    }
    @Test
    public void addItemWithValidUser(){

        Item item = new Item("item1", "Bonjour");
        System.out.print("Ajout du premier item \n ");

        if(u.isValid()){
            toDoList.saveItem(item);
        }

        Assertions.assertEquals(1, toDoList.getItemsList().size());
    }
    @Test
    public void addItemWithNonValidUser(){
        u.setEmail("test");

        Item item = new Item("item1", "Bonjour");
        System.out.print("Ajout du premier item \n ");

        if(u.isValid()){
            toDoList.saveItem(item);
        }

        this.toDoList = mock(ToDoList.class);
        when(this.toDoList.saveItem(item).thenThrow(new RuntimeException("Une exception a été lancée")));

        Assertions.assertEquals(0, toDoList.getItemsList().size());
    }

    @Test
    public void sendEmail(){


    }

}

