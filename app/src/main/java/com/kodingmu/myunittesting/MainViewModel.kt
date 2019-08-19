package com.kodingmu.myunittesting

class MainViewModel(val cuboidModel: CuboidModel) {

    fun save(l: Double, w: Double, h: Double) {
        cuboidModel.save(l, w, h)
    }

    fun getCircumference(): Double {
        return cuboidModel.getCircumference()
    }

    fun getSurfaceArea(): Double {
        return cuboidModel.getSurfaceArea()
    }

    fun getVolume(): Double {
        return cuboidModel.getVolume()
    }
}