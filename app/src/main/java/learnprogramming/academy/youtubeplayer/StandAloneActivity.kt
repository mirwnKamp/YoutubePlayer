package learnprogramming.academy.youtubeplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*

class StandAloneActivity: AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)

        btnPlayVideo.setOnClickListener(this)
        btnPlaylist.setOnClickListener(this)


//        btnPlayVideo.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                TODO("Not yet implemented")
//            }
//        })
//        btnPlayVideo.setOnClickListener(View.OnClickListener { v->
//            TODO("Not yet implemented")
//        })
//        val listener = View.OnClickListener { v->
//            TODO("Not yet implemented")
//        }
//        btnPlayVideo.setOnClickListener(listener)
//        btnPlaylist.setOnClickListener(listener)
    }


    override fun onClick(view: View) {
       val intent = when (view.id) {
           R.id.btnPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(
               this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID, 0, true, false)
           R.id.btnPlaylist -> YouTubeStandalonePlayer.createPlaylistIntent(
               this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_PLAYLIST , 0, 0, true, true)
           else -> throw IllegalArgumentException("Undefined button clicked")
       }
        startActivity(intent)

    }
}