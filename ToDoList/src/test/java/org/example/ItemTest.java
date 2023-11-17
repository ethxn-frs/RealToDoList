package org.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.example.entity.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

public class ItemTest {

    public Item item;

    @Before
    public void setup() {
        this.item = new Item("salut",
                "errererrere");
    }

    @Test
    public void testItemEmptyItemName() {
        item.setName("");
        assertFalse(item.isNameValid());
    }

    @Test
    public void testItemEmptyItemContent() {
        item.setContent("");
        assertFalse(item.isContentValid());
    }

    @Test
    public void testItemSpaceItemName() {
        item.setName(" ");
        assertFalse(item.isNameValid());
    }

    @Test
    public void testItemSpaceItemContent() {
        item.setContent(" ");
        assertFalse(item.isContentValid());
    }

    @Test
    public void testItemNullItemName() {
        if(item.getName() == null){
            assertFalse(item.isNameValid());
        }
    }

    @Test
    public void testItemNullItemContent() {
        if(item.getContent() == null){
            assertFalse(item.isContentValid());
        }
    }


    @Test
    public void testItemContentLength() {
        if(item.getContent().length() < 1 || item.getContent().length() > 1000){
            assertFalse(item.isContentValid());
        }
    }

    @Test
    public void testItemIsContentValid() {
        if(item.getContent().length() > 1 && item.getContent().length() <= 1000){
            if(item.getContent() != null && !item.getContent().trim().isEmpty()){
                assertTrue(item.isContentValid());
            }
        }
    }
}