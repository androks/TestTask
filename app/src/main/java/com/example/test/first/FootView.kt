package com.example.test.first

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.View
import com.example.test.pxToDp

class FootView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val circlePaint = Paint(ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.translate(width / 2f, height / 2f)
        coordinates.forEach {
            canvas.drawCircle(it.x, it.y, it.radius, circlePaint)
        }
    }

    private companion object {
        val radius = pxToDp(12f)
        val coordinates = arrayOf(
            Circle(18.81799f, 35.7445f, radius),
            Circle(23.13299f, 16.8974f, radius),
            Circle(16.21079f, 0f, radius),
            Circle(4.51639f, 12.8394f, radius),
            Circle(1.0195f, 30.0177f, radius),
            Circle(0f, 47.8785f, radius),
            Circle(16.79069f, 75.0814f, radius),
            Circle(17.37789f, 55.0006f, radius),
            Circle(0.09226f, 66.3364f, radius),
            Circle(1.20363f, 85.2964f, radius),
            Circle(5.23729f, 103.1604f, radius),
            Circle(10.80269f, 119.8994f, radius),
            Circle(49.83219f, 76.6024f, radius),
            Circle(48.60009f, 57.5435f, radius),
            Circle(32.11859f, 65.6744f, radius),
            Circle(34.12719f, 84.2464f, radius),
            Circle(20.07639f, 94.9624f, radius),
            Circle(28.51799f, 111.0354f, radius),
            Circle(61.30659f, 46.0354f, radius),
            Circle(56.13399f, 28.9682f, radius),
            Circle(48.50349f, 11.5261f, radius),
            Circle(34.56289f, 0.3548f, radius),
            Circle(38.17069f, 27.5453f, radius),
            Circle(35.22639f, 44.9827f, radius),
            Circle(55.04799f, 198.3864f, radius),
            Circle(55.88789f, 179.9024f, radius),
            Circle(56.84219f, 161.4354f, radius),
            Circle(43.50699f, 149.4534f, radius),
            Circle(59.07229f, 141.0914f, radius),
            Circle(62.15939f, 123.2974f, radius),
            Circle(65.10429f, 104.7454f, radius),
            Circle(66.15519f, 85.8874f, radius),
            Circle(48.01899f, 96.2824f, radius),
            Circle(64.90409f, 65.8474f, radius),
            Circle(46.53939f, 113.7714f, radius),
            Circle(40.33179f, 131.1734f, radius),
            Circle(18.88199f, 167.2574f, radius),
            Circle(19.26569f, 185.1634f, radius),
            Circle(19.54539f, 203.4754f, radius),
            Circle(54.23549f, 216.9704f, radius),
            Circle(37.64889f, 188.5244f, radius),
            Circle(38.30579f, 169.7164f, radius),
            Circle(20.17889f, 222.1694f, radius),
            Circle(24.26149f, 242.2284f, radius),
            Circle(41.02829f, 248.7884f, radius),
            Circle(36.41349f, 226.8844f, radius),
            Circle(51.71179f, 235.2194f, radius),
            Circle(37.39319f, 208.1334f, radius),
            Circle(37.39319f, 208.1334f, radius)
        )
    }

    private data class Circle(
        val x: Float,
        val y: Float,
        val radius: Float
    )
}
