package com.example.test.second

interface EventsPublisher {

    fun publish(event: Event)
}

interface EventsSubscribersManager {

    fun addSubscriber(subscriber: BluetoothConnectionStatusSubscriber)

    fun addSubscriber(subscriber: SensorDataSubscriber)

    fun removeSubscriber(subscriber: BluetoothConnectionStatusSubscriber)

    fun removeSubscriber(subscriber: SensorDataSubscriber)
}

class EventsDispatcher : EventsPublisher, EventsSubscribersManager {

    private val blueoothStatusSubscribers = mutableListOf<BluetoothConnectionStatusSubscriber>()

    private val sensorStatusSubscribers = mutableListOf<SensorDataSubscriber>()

    override fun publish(event: Event) {
        when (event) {
            is BluetoothConnectionChangedEvent -> {
                blueoothStatusSubscribers.forEach(BluetoothConnectionStatusSubscriber::onBluetoothConnectionChanged)
            }
            is TemperatureChangedEvent -> {
                sensorStatusSubscribers.forEach { it.onTemperatureChanged(event.temperature) }
            }
            is AcceleromenerPositionChangedEvent -> {
                sensorStatusSubscribers.forEach { it.onAccelerometerPositionChanged(event.accelerometerInfo) }
            }
        }
    }

    override fun addSubscriber(subscriber: BluetoothConnectionStatusSubscriber) {
        blueoothStatusSubscribers.add(subscriber)
    }

    override fun addSubscriber(subscriber: SensorDataSubscriber) {
        sensorStatusSubscribers.add(subscriber)
    }

    override fun removeSubscriber(subscriber: BluetoothConnectionStatusSubscriber) {
        blueoothStatusSubscribers.remove(subscriber)
    }

    override fun removeSubscriber(subscriber: SensorDataSubscriber) {
        sensorStatusSubscribers.remove(subscriber)
    }
}
