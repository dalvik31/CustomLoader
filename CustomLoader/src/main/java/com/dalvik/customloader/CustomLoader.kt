package com.dalvik.customloader

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.dalvik.customloader.databinding.LoaderBinding

class CustomLoader(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {
    private var _binding: LoaderBinding? = null
    private val binding: LoaderBinding
        get() = _binding ?: throw RuntimeException("Binding must be non-null")

    private lateinit var data: Data

    fun show(data: Data? = null) {
        this.data = data ?: Data()
        showFull()
    }

    private fun showFull() = inflate()

    private fun inflate(): View {
        val view = getActivity()?.findViewById<View>(R.id.loader_container)
        if (view != null) {
            _binding = LoaderBinding.bind(view)
            return view
        }
        val root = getActivity()?.findViewById<FrameLayout>(android.R.id.content)
        _binding = LoaderBinding.inflate(LayoutInflater.from(context), root, true)
        data.progressColor?.let { progressColor ->
            binding.progressBar.indeterminateTintList =
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        context,
                        progressColor
                    )
                )
        }

        data.lottieAnimation?.let {
            binding.progressBar.visibility = GONE
            binding.lottieAnimationView.visibility = VISIBLE
        }



        return requireNotNull(_binding).root
    }

    fun hide() {
        try {
            val root = getActivity()?.findViewById<FrameLayout>(android.R.id.content)
            val view = root?.findViewById<ConstraintLayout>(R.id.loader_container)
            view?.let {
                val popOut: Animation =
                    android.view.animation.AnimationUtils.loadAnimation(
                        context,
                        android.R.anim.fade_out
                    )
                view.startAnimation(popOut)
                root.removeView(view)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}