package com.example.limonadaaula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.limonadaaula.ui.theme.LimonadaAulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaAulaTheme {
                AppLimonada()
            }
        }
    }
}
@Preview
@Composable
fun AppLimonada(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        var tela by remember { mutableStateOf(1) }

        when (tela) {
            1 -> ConteudoApp(
                R.string.limoeiro,
                R.drawable.limoeiro
            ) {
                tela = 2
            }

            2 -> ConteudoApp(
                R.string.limao,
                R.drawable.espremer_limao
            ) {
                tela = 3
            }

            3 -> ConteudoApp(
                R.string.copo_de_limonada,
                R.drawable.limonada,
                onImagemClick = {
                    tela = 4
                }
            )

            4 -> ConteudoApp(
                R.string.copo_vazio,
                R.drawable.reiniciar,
                onImagemClick = {
                    tela = 1
                }
            )
        }
    }
}
@Composable
fun ConteudoApp(
    recursoTextoId: Int,
    recursoImagemId: Int,
    onImagemClick:()->Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = stringResource(recursoTextoId),
            fontSize = 15.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Image(
            painter = painterResource(id = recursoImagemId),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .border(
                    BorderStroke(2.dp, Color.Cyan),
                    RoundedCornerShape(5.dp)
                )
                .clickable(onClick = onImagemClick)
        )
    }
}
