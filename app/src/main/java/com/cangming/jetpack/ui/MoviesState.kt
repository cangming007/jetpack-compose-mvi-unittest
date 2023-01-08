package com.cangming.jetpack.ui



data class MoviesState(
    val skipSplash: Boolean = false
)  {
    companion object {
        fun initialState(): MoviesState = MoviesState()
    }
}


