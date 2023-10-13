package com.simplify.simplify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.connector.AnalyticsConnector
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.simplify.simplify.ui.theme.SymplifyTheme

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SymplifyTheme {
                Text("hello from symplify")
                Log.i("codeReach", "inside the text file")
            }
        }
    }
}