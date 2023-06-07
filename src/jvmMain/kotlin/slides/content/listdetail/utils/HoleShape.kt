package slides.content.listdetail.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class HoleShape(val cornerRadius: Float, val punchSize: Float, val punchDistance: Float) : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline =
        Outline.Generic(drawHolePath(size, cornerRadius, punchSize, punchDistance))

    companion object {
        fun drawHolePath(
            size: Size,
            cornerRadius: Float,
            punchSize: Float,
            punchDistance: Float,
        ): Path {
            return Path().apply {
                reset()
                moveTo(cornerRadius, 0f)
                // Top right corner
                arcTo(
                    rect = Rect(
                        offset = Offset(size.width - cornerRadius, 0f),
                        size = Size(cornerRadius, cornerRadius),
                    ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false,
                )
                val punchOffset = (size.height - 2 * cornerRadius - 2 * punchSize - punchDistance) / 2
                val topPunchHeight = cornerRadius + punchOffset
                val bottomPunchHeight = topPunchHeight + punchSize + punchDistance
                // Punch one
                arcTo(
                    rect = Rect(
                        offset = Offset(size.width - punchSize / 2, topPunchHeight),
                        size = Size(punchSize, punchSize),
                    ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = -180f,
                    forceMoveTo = false,
                )
                // Punch two
                arcTo(
                    rect = Rect(
                        offset = Offset(size.width - punchSize / 2, bottomPunchHeight),
                        size = Size(punchSize, punchSize),
                    ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = -180f,
                    forceMoveTo = false,
                )
                // Bottom right corner
                arcTo(
                    rect = Rect(
                        offset = Offset(size.width - cornerRadius, size.height - cornerRadius),
                        size = Size(cornerRadius, cornerRadius),
                    ),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false,
                )
                // Bottom left corner
                arcTo(
                    rect = Rect(
                        offset = Offset(0f, size.height - cornerRadius),
                        size = Size(cornerRadius, cornerRadius),
                    ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false,
                )
                // Top left corner
                arcTo(
                    rect = Rect(
                        offset = Offset(0f, 0f),
                        size = Size(cornerRadius, cornerRadius),
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false,
                )
                close()
            }
        }
    }
}