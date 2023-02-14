package com.mshdabiola.model

import kotlin.test.Test
import kotlin.test.assertEquals

class CategoryTest {
    @Test
    fun create() {
        val category = Category(name = "Toi", id = "Odell", image = "Bradon")
        assertEquals("Toi", category.name)
    }
}