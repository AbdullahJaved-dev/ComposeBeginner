package com.example.composebeginner.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composebeginner.MainViewModel
import com.example.composebeginner.animatedsplash.MainScreens
import com.example.composebeginner.itempositionanimation.ComposeItemPositionAnimation
import com.google.accompanist.pager.*

@Composable
fun ComposeOnBoarding(
    navController: NavHostController,
    startDestination: String,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    SetUpBoardingNavGraph(navController, mainViewModel, startDestination)
}

@Composable
fun SetUpBoardingNavGraph(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = MainScreens.Splash.route) {
            WelcomeScreen(navController, mainViewModel)
        }
        composable(route = MainScreens.Home.route) {
            ComposeItemPositionAnimation()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(navController: NavHostController, mainViewModel: MainViewModel) {
    val pages = listOf(
        OnBoardingPage.FIRST,
        OnBoardingPage.SECOND,
        OnBoardingPage.THIRD,
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HorizontalPager(
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.weight(9f)
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f)
        )

        ComposeFinishButton(modifier = Modifier.weight(1f), pagerState = pagerState) {
            navController.popBackStack()
            navController.navigate(MainScreens.Home.route)
            mainViewModel.saveOnBoardingState(true)
        }
    }

}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            imageVector = onBoardingPage.icon,
            contentDescription = "Home Icon"
        )

        Text(
            text = onBoardingPage.title,
            modifier = Modifier.fillMaxWidth(),
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = onBoardingPage.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 20.dp),
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ComposeFinishButton(modifier: Modifier, pagerState: PagerState, onClick: () -> Unit) {
    Row(
        modifier = modifier.padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = pagerState.currentPage == 2,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onClick, colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Magenta
                )
            ) {
                Text(text = "Finish")
            }
        }
    }
}

@Composable
fun PreviewOnBoarding() {
    //ComposeFinishButton(pagerState) {}
}

@Preview
@Composable
fun PreviewFirstBoarding() {
    PagerScreen(onBoardingPage = OnBoardingPage.FIRST)
    //ComposeOnBoarding()
}

@Preview
@Composable
fun PreviewSecondBoarding() {
    PagerScreen(onBoardingPage = OnBoardingPage.SECOND)
    //ComposeOnBoarding()
}

@Preview
@Composable
fun PreviewThirdBoarding() {
    PagerScreen(onBoardingPage = OnBoardingPage.THIRD)
    //ComposeOnBoarding()
}