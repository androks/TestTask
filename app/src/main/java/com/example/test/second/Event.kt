package com.example.test.second

import com.example.test.second.data.AccelerometerInfo

sealed class Event

object BluetoothConnectionChangedEvent : Event()

data class TemperatureChangedEvent(
    val temperature: Float
) : Event()

data class AcceleromenerPositionChangedEvent(
    val accelerometerInfo: AccelerometerInfo
): Event()
