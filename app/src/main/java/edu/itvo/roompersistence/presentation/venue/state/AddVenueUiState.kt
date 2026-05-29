package edu.itvo.roompersistence.presentation.venue.state

data class AddVenueUiState(

    val name: String = "",

    val location: String = "",

    val country: String = "",

    // Se guarda como texto para facilitar el OutlinedTextField;
    // se convierte a Int al guardar en el ViewModel.
    val capacity: String = "",

    val photoUri: String? = null,

    val isLoading: Boolean = false,

    val errorMessage: String? = null
)
