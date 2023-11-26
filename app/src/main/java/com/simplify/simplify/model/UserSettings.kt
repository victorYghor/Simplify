package com.simplify.simplify.model

import kotlinx.serialization.Serializable

@Serializable
data class UserSettings(
    val isFirstAccess: FirstStates = FirstStates.LOADING,
)

@Serializable
enum class FirstStates {
    FIRST_ACCESS, OTHER, LOADING;
}