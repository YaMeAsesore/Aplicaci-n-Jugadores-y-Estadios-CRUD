package edu.itvo.roompersistence.presentation.venue.screen

import android.Manifest
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil.compose.AsyncImage
import edu.itvo.roompersistence.core.createImageUri
import edu.itvo.roompersistence.presentation.core.components.BaseCard
import edu.itvo.roompersistence.presentation.venue.event.AddVenueEvent
import edu.itvo.roompersistence.presentation.venue.event.AddVenueUiEvent
import edu.itvo.roompersistence.presentation.venue.viewmodel.AddVenueViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddVenueScreen(
    venueId: Long? = null,
    onNavigateBack: () -> Unit,
    viewModel: AddVenueViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }

    val screenTitle = if (venueId != null) "Editar Estadio" else "Agregar Estadio"
    val saveButtonText = if (venueId != null) "Actualizar Estadio" else "Guardar Estadio"

    /*
    =========================================
    UI EVENTS
    =========================================
     */

    LaunchedEffect(Unit) {

        viewModel.uiEvent.collect { event ->

            when (event) {

                is AddVenueUiEvent.ShowSnackbar -> {

                    snackbarHostState.showSnackbar(event.message)

                    if (event.navigateBack) {
                        onNavigateBack()
                    }
                }
            }
        }
    }

    /*
    =========================================
    TEMP CAMERA URI
    =========================================
     */

    var cameraImageUri by remember {
        mutableStateOf<Uri>(createImageUri(context))
    }

    /*
    =========================================
    GALLERY PICKER
    =========================================
     */

    val imagePickerLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia()
        ) { uri ->

            uri?.let {

                viewModel.onEvent(
                    AddVenueEvent.OnPhotoSelected(it.toString())
                )
            }
        }

    /*
    =========================================
    CAMERA LAUNCHER
    =========================================
     */

    val takePictureLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.TakePicture()
        ) { success ->

            if (success) {

                viewModel.onEvent(
                    AddVenueEvent.OnPhotoSelected(cameraImageUri.toString())
                )

                cameraImageUri = createImageUri(context)
            }
        }

    /*
    =========================================
    CAMERA PERMISSION
    =========================================
     */

    val cameraPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { granted ->

            if (granted) {
                takePictureLauncher.launch(cameraImageUri)
            }
        }

    /*
    =========================================
    SCAFFOLD + FORM
    =========================================
     */

    Scaffold(

        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },

        topBar = {

            CenterAlignedTopAppBar(

                title = { Text(screenTitle) },

                navigationIcon = {

                    IconButton(onClick = onNavigateBack) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.Unspecified,
                    actionIconContentColor = Color.Unspecified
                )
            )
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            BaseCard {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),

                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    /*
                    =========================================
                    NOMBRE
                    =========================================
                     */

                    OutlinedTextField(
                        value = uiState.name,
                        onValueChange = {
                            viewModel.onEvent(AddVenueEvent.OnNameChanged(it))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Nombre del estadio") },
                        singleLine = true
                    )

                    /*
                    =========================================
                    UBICACIÓN
                    =========================================
                     */

                    OutlinedTextField(
                        value = uiState.location,
                        onValueChange = {
                            viewModel.onEvent(AddVenueEvent.OnLocationChanged(it))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Ubicación") },
                        singleLine = true
                    )

                    /*
                    =========================================
                    PAÍS
                    =========================================
                     */

                    OutlinedTextField(
                        value = uiState.country,
                        onValueChange = {
                            viewModel.onEvent(AddVenueEvent.OnCountryChanged(it))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("País") },
                        singleLine = true
                    )

                    /*
                    =========================================
                    CAPACIDAD (solo números)
                    =========================================
                     */

                    OutlinedTextField(
                        value = uiState.capacity,
                        onValueChange = {
                            viewModel.onEvent(AddVenueEvent.OnCapacityChanged(it))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Capacidad") },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )

                    /*
                    =========================================
                    FOTO
                    =========================================
                     */

                    Button(
                        onClick = {
                            imagePickerLauncher.launch(
                                PickVisualMediaRequest(
                                    ActivityResultContracts.PickVisualMedia.ImageOnly
                                )
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Icon(
                            imageVector = Icons.Default.PhotoLibrary,
                            contentDescription = null
                        )

                        Text(" Seleccionar de galería")
                    }

                    Button(
                        onClick = {
                            cameraPermissionLauncher.launch(
                                Manifest.permission.CAMERA
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Icon(
                            imageVector = Icons.Default.PhotoCamera,
                            contentDescription = null
                        )

                        Text(" Tomar foto")
                    }

                    HorizontalDivider()

                    /*
                    =========================================
                    PREVIEW FOTO
                    =========================================
                     */

                    Card(modifier = Modifier.fillMaxWidth()) {

                        if (uiState.photoUri != null) {

                            AsyncImage(
                                model = uiState.photoUri,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(240.dp),
                                contentScale = ContentScale.Crop
                            )

                        } else {

                            Text(
                                text = "Sin foto seleccionada",
                                modifier = Modifier.padding(24.dp)
                            )
                        }
                    }

                    /*
                    =========================================
                    GUARDAR
                    =========================================
                     */

                    Button(
                        onClick = {
                            viewModel.onEvent(AddVenueEvent.SaveVenue)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(saveButtonText)
                    }
                }
            }
        }
    }
}
