package com.plcoding.cryptocurrencyappyt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.cryptocurrencyappyt.presentation.coinDetailScreen.components.CoinDetailScreen
import com.plcoding.cryptocurrencyappyt.presentation.coinListScreen.components.CoinListScreen
import com.plcoding.cryptocurrencyappyt.presentation.ui.theme.CryptocurrencyAppYTTheme
import com.plcoding.cryptocurrencyappyt.utilis.COIN_ID_PARAM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinList.route
                    ) {
                        composable(route = Screen.CoinList.route) {
                            CoinListScreen(navController = navController)
                        }

                        composable(route = "${Screen.CoinDetail.route}/{$COIN_ID_PARAM}") {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}