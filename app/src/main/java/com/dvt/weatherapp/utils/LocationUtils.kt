/*
 *
 *  * Copyright (c) 2022 Razeware LLC
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  * furnished to do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in
 *  * all copies or substantial portions of the Software.
 *  *
 *  * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 *  * distribute, sublicense, create a derivative work, and/or sell copies of the
 *  * Software in any work that is designed, intended, or marketed for pedagogical or
 *  * instructional purposes related to programming, coding, application development,
 *  * or information technology.  Permission for such use, copying, modification,
 *  * merger, publication, distribution, sublicensing, creation of derivative works,
 *  * or sale is expressly withheld.
 *  *
 *  * This project and source code may use libraries or frameworks that are
 *  * released under various Open-Source licenses. Use of those libraries and
 *  * frameworks are governed by their own individual licenses.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  * THE SOFTWARE.
 *
 */

package com.dvt.weatherapp.utils

import android.annotation.SuppressLint
import android.os.Looper
import android.renderscript.RenderScript
import android.util.Log
import com.google.android.gms.location.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import java.lang.ref.Cleaner.create
import java.util.concurrent.TimeUnit


@SuppressLint("MissingPermission")
fun FusedLocationProviderClient.locationFlow() = callbackFlow {
  val callback = object : LocationCallback() {
    override fun onLocationResult(result: LocationResult) {
      try {
        trySend(result.lastLocation)
      } catch (e: Exception) {
        Log.e("Error", e.message.toString())
      }
    }
  }
  requestLocationUpdates(createLocationRequest(), callback, Looper.getMainLooper())
      .addOnFailureListener { e ->
        close(e)
      }

  awaitClose {
    removeLocationUpdates(callback)
  }
}

fun createLocationRequest(): LocationRequest {
  return  com.google.android.gms.location.LocationRequest.create().apply {
    // Sets the desired interval for active location updates. This interval is inexact. You
    // may not receive updates at all if no location sources are available, or you may
    // receive them less frequently than requested. You may also receive updates more
    // frequently than requested if other applications are requesting location at a more
    // frequent interval.
    //
    // IMPORTANT NOTE: Apps running on Android 8.0 and higher devices (regardless of
    // targetSdkVersion) may receive updates less frequently than this interval when the app
    // is no longer in the foreground.
    interval = TimeUnit.SECONDS.toMillis(60)

    // Sets the fastest rate for active location updates. This interval is exact, and your
    // application will never receive updates more frequently than this value.
    fastestInterval = TimeUnit.SECONDS.toMillis(30)

    // Sets the maximum time when batched location updates are delivered. Updates may be
    // delivered sooner than this interval.
    maxWaitTime = TimeUnit.MINUTES.toMillis(2)

    priority = com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
  }

}