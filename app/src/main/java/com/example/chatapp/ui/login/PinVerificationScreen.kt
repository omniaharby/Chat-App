import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun PinVerificationScreen(
    onPinEntered: (String) -> Unit
) {
    var pin by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enter PIN:",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(4) { index ->
                PinDigitBox(
                    digit = pin.getOrNull(index) ?: ' ',
                    onDigitEntered = { digit ->
                        if (digit.isDigit()) {
                            pin = pin.take(index) + digit + pin.drop(index + 1)
                            if (index == 5) {
                                onPinEntered(pin)
                            }
                        }
                    }
                )
            }
        }
        Spacer(Modifier.height(10.dp))
        Button(
            onClick = { onPinEntered("") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("check")
        }
    }

}

@Composable
fun PinDigitBox(
    digit: Char,
    onDigitEntered: (Char) -> Unit
) {
    OutlinedTextField(
        value = digit.toString(),
        onValueChange = { newValue ->
            val newDigit = newValue.lastOrNull()
            if (newDigit != null && newDigit.isDigit()) {
                onDigitEntered(newDigit)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                // Do nothing
            }
        ),
        singleLine = true,
        modifier = Modifier
            .padding(4.dp)
            .width(56.dp)
            .height(56.dp)
    )
}
