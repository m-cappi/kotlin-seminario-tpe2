package com.example.seminariotp.ui.filters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OrderSelector(
    orderByOptions: List<String>,
    selectedOrderBy: String,
    isReverseOrder: Boolean,
    onOrderChange: (String, Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Order by",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Order options
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(orderByOptions) { option ->
                    val isSelected = option == selectedOrderBy
                    FilterChip(
                        text = option.replaceFirstChar { it.uppercase() },
                        onClick = { onOrderChange(option, isReverseOrder) },
                        isSelected = isSelected
                    )
                }
            }

            // Reverse order toggle
            IconButton(
                onClick = {
                    onOrderChange(selectedOrderBy, !isReverseOrder)
                },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(
                    imageVector = if (isReverseOrder)
                        Icons.Default.KeyboardArrowUp //Icons.Default.ArrowDownward
                    else
                        Icons.Default.KeyboardArrowDown,//ArrowUpward,
                    contentDescription = "Toggle order direction"
                )
            }
        }
    }
}
