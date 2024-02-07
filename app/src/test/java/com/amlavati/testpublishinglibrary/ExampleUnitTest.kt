package com.amlavati.testpublishinglibrary

import com.amlavati.mathlibrary.Point
import com.amlavati.mathlibrary.calculateDistanceTo
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val point1 = Point(2.0, 3.0)
        val point2 = Point(2.0, 3.0)
        print(point1.calculateDistanceTo(point2))
        assertEquals(4, 2 + 2)
        assertEquals(4, 2 + 2)
    }
}