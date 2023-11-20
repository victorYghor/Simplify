package com.simplify.simplify.model

import kotlinx.serialization.Serializable

@Serializable
data class UserSettings(
    val isFirstAccess: IsFirstAccess = IsFirstAccess.LOADING,
)

@Serializable
enum class IsFirstAccess {
    FIRST_TIME, NORMAL, LOADING;
}