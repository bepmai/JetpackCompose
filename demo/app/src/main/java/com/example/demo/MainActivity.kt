package com.example.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.constraintlayout.compose.Dimension
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import coil.compose.rememberAsyncImagePainter
import com.example.demo.ui.theme.DemoTheme
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoTheme {
                Surface(
                    modifier = Modifier .fillMaxSize(),
                    color = Color.White
                ) {
                    HomeScreen(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Ingredients(modifier = modifier.fillMaxSize())
}


@Composable
fun Ingredients(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.padding(16.dp).fillMaxSize()) {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val itemWidth = (screenWidth.value * 0.25).dp

        val (tvIngredients, imgArrow) = createRefs()

        Text(
            text = "Ingredients", style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 14.sp,
                color = Color(0xffFB7D8A)
            ), modifier = Modifier.constrainAs(tvIngredients) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 16.dp)
            })

        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight,
            contentDescription = null,
            tint = Color(0xffFB7D8A),
            modifier = Modifier
                .size(24.dp)
                .constrainAs(imgArrow) {
                    start.linkTo(tvIngredients.end, margin = 6.dp)
                    bottom.linkTo(tvIngredients.bottom)
                })

        val (lineOne, lineTwo) = createRefs()

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(lineOne) {
                    start.linkTo(tvIngredients.start)
                    top.linkTo(tvIngredients.bottom, margin = 14.dp)
                }) {
            val (e1, e2, e3) = createRefs()
            val lineOneChain = createHorizontalChain(e1, e2, e3, chainStyle = ChainStyle.Spread)
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 9,
                unit = null,
                name = "Mint Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e1) {
                        lineOneChain
                    })

            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 9,
                unit = null,
                name = "Mint Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e2) {
                        lineOneChain
                    })
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 9,
                unit = null,
                name = "Mint Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e3) {
                        lineOneChain
                    })
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(lineTwo) {
                    start.linkTo(tvIngredients.start)
                    top.linkTo(lineOne.bottom, margin = 14.dp)
                }) {
            val (e1, e2, e3) = createRefs()
            val lineOneChain = createHorizontalChain(e1, e2, e3, chainStyle = ChainStyle.Spread)
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 99,
                unit = null,
                name = "Mint Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e1) {
                        lineOneChain
                    })

            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 9,
                unit = null,
                name = "Mint Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e2) {
                        lineOneChain
                    })
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 9,
                unit = null,
                name = "Mint Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e3) {
                        lineOneChain
                    })
        }
    }
}

@Composable
fun Ingredient(
    @DrawableRes icon: Int, value: Int, unit: String?, name: String, modifier: Modifier = Modifier
) {
    val backgroundColor = Color(0xFFFEF9E4)
    val borderColor = Color(0xFBE897B2).copy(alpha = 0.7f)

    ConstraintLayout(
        modifier = modifier.background(color = backgroundColor, shape = CircleShape)
//            .border(
//                BorderStroke(width = 1.dp, color = borderColor)
//            )
    ) {
        val horizontalGuideLine = createGuidelineFromTop(0.5f)
        val imgIcon = createRef()
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.constrainAs(imgIcon) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(horizontalGuideLine)
                height = Dimension.fillToConstraints

            },
            contentScale = ContentScale.FillHeight
        )

        val (tvValue, tvUnit, tvName) = createRefs()

        val verticaGuideLine = createGuidelineFromStart(0.5f)
        val valueTextColor = Color(0xFFFB7D8A)
        Text(
            text = value.toString(), style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                lineHeight = 14.sp,
                color = valueTextColor
            ), modifier = Modifier.constrainAs(tvValue) {
                top.linkTo(horizontalGuideLine, margin = 2.dp)
                end.linkTo(verticaGuideLine, margin = 2.dp)
            })

        unit?.let {
            Text(
                text = unit, style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    color = valueTextColor,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ), modifier = Modifier.constrainAs(tvUnit) {
                    top.linkTo(tvValue.bottom, margin = 2.dp)
                    end.linkTo(tvValue.end)
                })
        }

        val bottomBarrier = createBottomBarrier(tvValue, tvUnit)
        val endGuideLine20 = createGuidelineFromEnd(0.2f)

        Text(
            text = name, style = TextStyle(
                color = Color(0xff1E2742),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 14.sp
            ), modifier = Modifier.constrainAs(tvName) {
                start.linkTo(verticaGuideLine)
                bottom.linkTo(bottomBarrier)
                top.linkTo(tvValue.top)
                end.linkTo(endGuideLine20)
                width = Dimension.fillToConstraints
            }, maxLines = 2, textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientPreview() {
    Row {
        Ingredient(
            icon = R.drawable.ic_lemon,
            value = 30,
            unit = "ml",
            name = "Lemon\nWedges",
            modifier = Modifier.size(130.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    DemoTheme {
        HomeScreen()
    }
}

