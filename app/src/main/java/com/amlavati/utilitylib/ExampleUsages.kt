package com.amlavati.utilitylib

import com.amlavati.mathlibrary.Point
import com.amlavati.mathlibrary.calculateDistanceTo


class ExampleUsages {

    val point1 = Point(12.0, 12.0)
    val point2 = Point(12.0, 12.0)

    fun calculateDistance() {

        val distance = point1.calculateDistanceTo(point2)
        println("the distance between two points is $distance")

    }





}