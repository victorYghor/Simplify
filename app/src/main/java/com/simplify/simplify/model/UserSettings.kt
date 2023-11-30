package com.simplify.simplify.model

import kotlinx.serialization.Serializable

@Serializable
data class UserSettings(
    val isFirstAccess: Boolean
)