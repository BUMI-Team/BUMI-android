package com.dicoding.android.bumi.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dicoding.android.bumi.R
import com.dicoding.android.bumi.databinding.ActivityDetailVideoBinding
import com.dicoding.android.bumi.utils.Constants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class DetailVideoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            setupVideo(Constants.EXTRA_VIDEO_ID)
            detailVideoTitle.text = Constants.EXTRA_VIDEO_TITLE
            detailDesc.text = Constants.EXTRA_VIDEO_DESC
        }

//        youTubePlayerView.enterFullScreen()
//        youTubePlayerView.toggleFullScreen()
//        youTubePlayerView.exitFullScreen();
//        youTubePlayerView.isFullScreen();

        // here we are adding observer to our youtubeplayerview.
//        lifecycle.addObserver(youTubePlayerView)

        // below method will provides us the youtube player
        // ui controller such as to play and pause a video
        // to forward a video
        // and many more features.
//        youTubePlayerView.getPlayerUiController()

        // adding listener for our youtube player view.
//
//        binding.buttonFullScreen.setOnClickListener {
//            youTubePlayerView.enterFullScreen();
//        }


//        youTubePlayerView.exitFullScreen();
//        youTubePlayerView.isFullScreen();
//        youTubePlayerView.toggleFullScreen();
    }

    private fun setupVideo(videoId: String) {
        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                // loading the selected video into the YouTube Player
                youTubePlayer.loadVideo(videoId, 0f)
            }

            override fun onStateChange(
                youTubePlayer: YouTubePlayer,
                state: PlayerConstants.PlayerState
            ) {
                // this method is called if video has ended,
                super.onStateChange(youTubePlayer, state)
            }
        })
    }


}