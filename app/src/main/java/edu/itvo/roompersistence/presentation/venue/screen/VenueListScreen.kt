package edu.itvo.roompersistence.presentation.venue.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import edu.itvo.roompersistence.presentation.venue.components.VenueItem
import edu.itvo.roompersistence.presentation.venue.event.VenueListEvent
import edu.itvo.roompersistence.presentation.venue.viewmodel.VenueListViewModel

@Composable
fun VenueListScreen(
    modifier: Modifier = Modifier,
    onEditVenue: (Long) -> Unit = {},
    viewModel: VenueListViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.venues.isEmpty()) {

        /*
        =========================================
        ESTADO VACÍO
        =========================================
         */

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
                    .alpha(0.7f),
                tint = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Sin estadios registrados",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Presiona + para agregar el primero",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }

    } else {

        /*
        =========================================
        LISTA DE ESTADIOS
        =========================================
         */

        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(
                items = uiState.venues,
                key = { it.id }
            ) { venue ->

                VenueItem(
                    venue = venue,
                    onEditClick = {
                        onEditVenue(venue.id)
                    },
                    onDeleteClick = {
                        viewModel.onEvent(
                            VenueListEvent.DeleteVenue(venue)
                        )
                    }
                )
            }
        }
    }
}
