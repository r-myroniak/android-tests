package com.example.androidtestsidp

import android.content.SharedPreferences
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import kotlin.test.Test

class MyActivityTest {
    @Test
    fun `test some method`() {
        val preferencesMock = mockkObject(SharedPreferences::class)

        every { preferencesMock.edit() } returns mockk()
        every { preferencesMock.getInt("my_key", 0) } returns 42
        // Test code that uses SharedPreferences
    }
}