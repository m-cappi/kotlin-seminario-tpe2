package com.example.seminariotp.ui.filters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.seminariotp.ddl.models.Filter

@Composable
fun MultiSelectFilterList(
    category: String,
    filters: List<Filter>,
    selectedFilters: List<String>,
    onSelectionChanged: (List<String>) -> Unit
) {
    Column {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            filters.forEach { filter ->
                val isSelected = selectedFilters.contains(filter.slug)
                FilterChip(
                    text = filter.name,
                    isSelected = isSelected,
                    onClick = {
                        val newSelection = if (isSelected) {
                            selectedFilters - filter.slug
                        } else {
                            selectedFilters + filter.slug
                        }
                        onSelectionChanged(newSelection)
                    }
                )
            }
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//private fun PreviewMultiSelectFilterList() {
//    val filters = listOf("Action", "RPG", "Shooter", "Indie", "Adventure")
//
//    MultiSelectFilterList(
//        filters = filters,
//        selectedFilters = listOf(),
//        onSelectionChanged = { }
//    )
//}