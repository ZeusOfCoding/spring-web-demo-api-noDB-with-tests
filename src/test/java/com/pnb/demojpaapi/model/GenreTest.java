package com.pnb.demojpaapi.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenreTest {

    @Test
    public void testGenre() {
        Genre masculin = Genre.MASCULIN;
        Genre feminin = Genre.FEMININ;

        Assertions.assertEquals("MASCULIN", masculin.name());
        Assertions.assertEquals("FEMININ", feminin.name());

        Assertions.assertSame(masculin, Genre.valueOf("MASCULIN"));
        Assertions.assertSame(feminin, Genre.valueOf("FEMININ"));

        Assertions.assertEquals(2, Genre.values().length);
    }
}
