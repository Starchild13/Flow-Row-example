// The package declaration. It is a way to organize files in Kotlin (or Java).
package com.starchild13.flowrowexample

// Import necessary modules from the Android framework and Jetpack Compose UI toolkit.
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Define the main activity. This is the entry point of the app.
class MainActivity : ComponentActivity() {
    // Override the onCreate method. This method gets called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content of this activity to the FlowRowExample composable.
        setContent {
            FlowRowExample()
        }
    }
}

// Preview annotation to provide a preview of the FlowRowExample in the IDE.
@Preview(showBackground = true)
@Composable
fun PreviewFlowRow() {
    FlowRowExample()
}

// Opt-in to using the ExperimentalLayoutApi to allow usage of FlowRow.
// Define the FlowRowExample composable. It shows a row of filter chips.
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FlowRowExample() {
    // Remember the state of a selected chip.
    val textChipRememberOneState = remember { mutableStateOf("") }
    // Arrange chips in a horizontal flow with wrapping.
    FlowRow(Modifier.padding(8.dp)) {
        // Instantiate individual chips.
        ChipItem("Team: Arsenal",textChipRememberOneState)
        ChipItem("Position: Goal Keeper",textChipRememberOneState)
        ChipItem("T-shirt number: 13",textChipRememberOneState)
        ChipItem("Players Name: Aaron Ramsdale",textChipRememberOneState)
        ChipItem("Your bet that your team wins: $100 ",textChipRememberOneState)
    }
}

// Opt-in to using the ExperimentalMaterial3Api to allow usage of FilterChip.
// Define the ChipItem composable. It shows a single chip.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipItem(text: String, selected: MutableState<String>) {
    val isSelected = selected.value == text
    val backgroundColor = if (isSelected) Color(0xFFADD8E6) else Color.White
    val contentColor = if (isSelected) Color.Blue else Color.Black

    FilterChip(
        modifier = Modifier
            .padding(end = 16.dp)
            .background(color = backgroundColor), // Set background color using modifier
        selected = isSelected,
        onClick = {
            if (isSelected) selected.value = ""
            else selected.value = text
        },
        label = { Text(text, color = contentColor) } // Display the name on the chip and set its text color.
    )
}
























