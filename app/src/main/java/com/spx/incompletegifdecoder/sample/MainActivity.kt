package com.spx.incompletegifdecoder.sample

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val imgUrl = "http://pic.wenwen.soso.com/pqpic/wenwenpic/0/20171116143737-1895154083_gif_398_305_3740344/0"
        // val imgUrl = "https://giphy.com/gifs/nbc-christmas-in-rockefeller-center-tree-lighting-PXCtJI8yJmCut0mhKL"
        // val imgUrl = "https://giphy.com/gifs/link-the-legend-of-zelda-NVBR6cLvUjV9C"
        val imgUrl = "https://media1.giphy.com/media/jrsWNmPJnIFv0jrLZy/200_d.gif"
        Glide.with(this)
            .asGif()
            // .asBitmap()
            .load(imgUrl)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .disallowHardwareConfig()
           .override(SIZE_ORIGINAL, SIZE_ORIGINAL)
            // .override(300, 300)
            .listener(object : RequestListener<GifDrawable?> {
                          override fun onLoadFailed(
                              @Nullable e: GlideException?,
                              model: Any?,
                              target: com.bumptech.glide.request.target.Target<GifDrawable?>,
                              isFirstResource: Boolean
                          ): Boolean {
                              // log exception
                              Log.e("TAG", "Error loading image from DataBindingAdapter helper class:", e)
                              return false // important to return false so the error placeholder can be placed
                          }

                          override fun onResourceReady(
                              resource: GifDrawable?,
                              model: Any?,
                              target: com.bumptech.glide.request.target.Target<GifDrawable?>?,
                              dataSource: DataSource?,
                              isFirstResource: Boolean
                          ): Boolean {
//                              TODO("Not yet implemented")
                              Log.e("TAG", "SUCCESS: loading image from DataBindingAdapter helper class: onResourceReady")
                              Log.d("TAG", imgUrl)
                              //设置播放次数
                              // if (resource != null) {
                              //     resource.setLoopCount(1)
                              // };
                              return false
                          }
            })
// // Bitmap        
//             .listener(object : RequestListener<Bitmap?> {
//                           override fun onLoadFailed(
//                               @Nullable e: GlideException?,
//                               model: Any?,
//                               target: com.bumptech.glide.request.target.Target<Bitmap?>,
//                               isFirstResource: Boolean
//                           ): Boolean {
//                               // log exception
//                               Log.e("TAG", "Error loading image from DataBindingAdapter helper class:", e)
//                               return false // important to return false so the error placeholder can be placed
//                           }
//                           override fun onResourceReady(
//                               resource: Bitmap?,
//                               model: Any?,
//                               target: com.bumptech.glide.request.target.Target<Bitmap?>?,
//                               dataSource: DataSource?,
//                               isFirstResource: Boolean
//                           ): Boolean {
//                               TODO("Not yet implemented")
//                           }
//             })
            .into(gifiv);
    }
}
