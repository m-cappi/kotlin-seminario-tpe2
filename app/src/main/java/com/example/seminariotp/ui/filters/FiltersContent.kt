package com.example.seminariotp.ui.filters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.seminariotp.R
import com.example.seminariotp.ddl.models.Filter

@Composable
fun FiltersContent(
    isLoading: Boolean,
    isError: Boolean,
    filtersMap: Map<String, List<Filter>?>,
    categories: List<String>,
    selectedCategory: String,
    selectedFilters: List<String>,
    onCategorySelected: (String) -> Unit,
    onSelectionChanged: (List<String>) -> Unit,
    orderByOptions: List<String>,
    selectedOrderBy: String,
    isReverseOrder: Boolean,
    onOrderChange: (String, Boolean) -> Unit,
    onApplyFilters: () -> Unit,
    onRetry: () -> Unit,
) {
    // Example categories

    // Currently selected category

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Button(onClick = onApplyFilters, enabled = !isLoading) {
            Text(
                text = stringResource(R.string.apply)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        OrderSelector(
            orderByOptions = orderByOptions,
            selectedOrderBy = selectedOrderBy,
            isReverseOrder = isReverseOrder,
            onOrderChange = onOrderChange
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Filter by",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        FilterCategorySelector(
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = onCategorySelected
        )

        Spacer(modifier = Modifier.height(16.dp))
        if (isLoading) {
            CircularProgressIndicator()
        } else if (isError) {
            Text(
                text = stringResource(R.string.error_msg)
            )
            Button(onClick = onRetry) {
                Text(text = stringResource(R.string.retry))
            }
        } else {
            MultiSelectFilterList(
                category = selectedCategory,
                filters = filtersMap[selectedCategory] ?: emptyList(),
                selectedFilters = selectedFilters,
                onSelectionChanged = onSelectionChanged
            )
        }
    }
}
