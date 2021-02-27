package com.example.test.second

import com.example.test.second.data.AccelerometerInfo

interface Subscriber

interface BluetoothConnectionStatusSubscriber: Subscriber {

    fun onBluetoothConnectionChanged()
}

interface SensorDataSubscriber: Subscriber {

    fun onTemperatureChanged(temperature: Float)

    fun onAccelerometerPositionChanged(accelerometerInfo: AccelerometerInfo)
}
