package com.kodingmu.myunittesting

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify


class MainViewModelTest {

    private var mainViewModel: MainViewModel? = null
    private var cuboidModel: CuboidModel? = null
    private val dummyVolume = 504.0
    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyCircumference = 2016.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel as CuboidModel)
    }

    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel as CuboidModel)
        mainViewModel?.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel?.getVolume()
        assertEquals(dummyVolume, volume ?: 0.0, 0.0001)
    }

    @Test
    fun testCircumference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel as CuboidModel)
        mainViewModel?.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel?.getCircumference()
        assertEquals(dummyCircumference, volume ?: 0.0, 0.0001)
    }

    @Test
    fun tesSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel as CuboidModel)
        mainViewModel?.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel?.getSurfaceArea()
        assertEquals(dummySurfaceArea, volume ?: 0.0, 0.0001)
    }

    @Test
    fun testMockVolume() {
        `when`(mainViewModel?.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel?.getVolume()
        verify(cuboidModel)?.getVolume()
        assertEquals(dummyVolume, volume ?: 0.0, 0.0001)
    }

    @Test
    fun testMockCircumference() {
        `when`(mainViewModel?.getCircumference()).thenReturn(dummyCircumference)
        val volume = mainViewModel?.getCircumference()
        verify(cuboidModel)?.getCircumference()
        assertEquals(dummyCircumference, volume ?: 0.0, 0.0001)
    }

    @Test
    fun testMockSurfaceArea() {
        `when`(mainViewModel?.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val volume = mainViewModel?.getSurfaceArea()
        verify(cuboidModel)?.getSurfaceArea()
        assertEquals(dummySurfaceArea, volume ?: 0.0, 0.0001)
    }
}