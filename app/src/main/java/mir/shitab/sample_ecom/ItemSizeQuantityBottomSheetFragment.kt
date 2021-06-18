package mir.shitab.sample_ecom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_size_and_quantity.view.*

class ItemSizeQuantityBottomSheetFragment  (public val fromIndex: Int?) : DialogFragment() {
    private lateinit var rootView: View

    public constructor(): this (null) {
        //empty constructor
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogFragment)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        rootView = inflater.inflate(R.layout.fragment_size_and_quantity, container, false)
        initClickListener()
        dialogAnimation(true)
        return rootView
    }

    private fun initClickListener() {

        rootView.ivClose.setOnClickListener {
            dialogAnimation(false)
        }

        rootView.ivNextButton.setOnClickListener {
            rootView.ivPrevButton.visibility = View.VISIBLE
            rootView.ivNextButton.visibility = View.GONE
        }

        rootView.ivPrevButton.setOnClickListener {
            rootView.ivPrevButton.visibility = View.GONE
            rootView.ivNextButton.visibility = View.VISIBLE
        }

    }


    private fun dialogAnimation(isStarted: Boolean) {
        if (isStarted) {
            val animation: Animation = AnimationUtils.loadAnimation(activity, R.anim.anim_up_from_bottom)
            rootView.llBottomSheet.startAnimation(animation)
        } else {
            val animation: Animation = AnimationUtils.loadAnimation(activity, R.anim.anim_down_from_top)
            rootView.llBottomSheet.startAnimation(animation)
            dismiss()
        }
    }

}