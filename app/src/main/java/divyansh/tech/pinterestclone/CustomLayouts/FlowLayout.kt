package divyansh.tech.pinterestclone.CustomLayouts

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Composable
fun FlowLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Layout(
        modifier = modifier,
        content = content
    ) {measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }
        val width = constraints.maxWidth
        val height = constraints.maxHeight
        layout(width, height) {
            var yPosition = 0
            var xPosition = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(xPosition, yPosition)
                if (xPosition < width) {
                    xPosition += placeable.width
                } else {
                    yPosition += placeable.height
                    xPosition = 0
                }
            }
        }
    }
}