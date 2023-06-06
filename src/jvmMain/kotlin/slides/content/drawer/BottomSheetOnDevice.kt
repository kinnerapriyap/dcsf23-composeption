package slides.content.drawer

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.AndroidDeviceSurface
import cupcakeIpsum

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun BottomSheetOnDevice() {
    AndroidDeviceSurface {
        val scaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
        )
        BottomSheetScaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            sheetContent = {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp),
                    border = BorderStroke(2.dp, MaterialTheme.colors.secondary),
                    elevation = 4.dp
                ) {
                    Text(text = cupcakeIpsum, modifier = Modifier.padding(24.dp))
                }
            },
            sheetPeekHeight = 150.dp
        ) {}
    }
}
