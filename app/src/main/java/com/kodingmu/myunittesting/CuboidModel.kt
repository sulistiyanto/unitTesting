package com.kodingmu.myunittesting

class CuboidModel {
    var width: Double = 0.toDouble()
    var length: Double = 0.toDouble()
    var height: Double = 0.toDouble()

    fun save(width: Double, length: Double, height: Double) {
        this.width = width
        this.length = length
        this.height = height
    }

    fun getVolume(): Double {
        return width * length * height
    }

    fun getSurfaceArea(): Double {
        val wl = width * length
        val wh = width * height
        val lh = length * height
        return 2 * (wl + wh + lh)
    }

    fun getCircumference(): Double {
        return 4 * (width * length * height)
    }
}