package com.simplify.simplify.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object UserSettingsSerializer : Serializer<UserSettings> {
    override val defaultValue: UserSettings
        get() = UserSettings()

    override suspend fun readFrom(input: InputStream): UserSettings {
        return try {
            Json.decodeFromString(
                deserializer = UserSettings.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: UserSettings, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = UserSettings.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }
}

val Context.userSettingDataStore: DataStore<UserSettings> by dataStore(
    fileName = "user_settings.json",
    serializer = UserSettingsSerializer
)