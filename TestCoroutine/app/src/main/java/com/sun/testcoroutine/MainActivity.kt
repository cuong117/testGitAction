package com.sun.testcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.math.log
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
    }

    fun test() {
        val a = runBlocking {
            val time = measureTimeMillis {

                val b = async {
                    delay(1000)
                    return@async "10"
                }
                val c = async {
                    delay(5000)
                    return@async 11
                }
                c.join()
                b.join()
                Log.v("tag111", b.await())
                Log.v("tag111", c.await().toString())
            }
            Log.v("tag111", "$time")
//            print(b)
//            print(c)
        }
        Log.v("tag111", a.toString())
    }
}