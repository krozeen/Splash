package br.com.fiap.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*
import java.nio.channels.InterruptibleChannel

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 3500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        carregar()
    }

    fun carregar(){
        val anim = AnimationUtils.loadAnimation(this, R.anim.anim)
        anim.reset()

        ivLogo.clearAnimation()
        ivLogo.startAnimation(anim)

        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            this@SplashActivity.finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}
