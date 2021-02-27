package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test.second.*
import com.example.test.second.data.AccelerometerInfo
import com.example.test.third.rxTask

class MainActivity : AppCompatActivity() {

    private val eventsDispatcher = EventsDispatcher()

    private val eventsSubsribersManager: EventsSubscribersManager = eventsDispatcher
    private val eventsPublisher: EventsPublisher = eventsDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testPubSub()
        rxTask()
    }

    private fun testPubSub() {
        eventsSubsribersManager.addSubscriber(object : BluetoothConnectionStatusSubscriber {
            override fun onBluetoothConnectionChanged() {
                Log.d(this::class.simpleName, "onBluetoothConnectionChanged")
            }
        })
        eventsSubsribersManager.addSubscriber(object : SensorDataSubscriber {
            override fun onTemperatureChanged(temperature: Float) {
                Log.d(this::class.simpleName, "onTemperatureChanged $temperature")
            }

            override fun onAccelerometerPositionChanged(accelerometerInfo: AccelerometerInfo) {
                Log.d(this::class.simpleName, "onAccelerometerPositionChanged $accelerometerInfo")
            }
        })
        eventsPublisher.publish(BluetoothConnectionChangedEvent)
        eventsPublisher.publish(TemperatureChangedEvent(50f))
        eventsPublisher.publish(AcceleromenerPositionChangedEvent(AccelerometerInfo(5, 5)))
    }
}
