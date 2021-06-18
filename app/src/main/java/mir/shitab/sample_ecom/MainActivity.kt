package mir.shitab.sample_ecom

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var bottomSheetFragment: ItemSizeQuantityBottomSheetFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViews()
        onClicks()

    }

    private fun setViews() {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val tvOldPrice = findViewById<View>(R.id.tvOldPrice) as AppCompatTextView
        tvOldPrice.paintFlags = tvOldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        bottomSheetFragment = ItemSizeQuantityBottomSheetFragment(0)
    }

    private fun onClicks() {
        ivFirstItem?.setOnClickListener(this)
        ivSecondItem?.setOnClickListener(this)
        rlSpecificationsSection?.setOnClickListener(this)
        rlReviewsSection?.setOnClickListener(this)
        rlHowToOrderSection?.setOnClickListener(this)
        rlFAQSection?.setOnClickListener(this)
        rlWholesaleInquirySection?.setOnClickListener(this)
        rlDescriptionsSection?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivFirstItem -> {
                bottomSheetFragment = ItemSizeQuantityBottomSheetFragment(0)
                openFragment()
            }
            R.id.ivSecondItem -> {
                bottomSheetFragment = ItemSizeQuantityBottomSheetFragment(1)
                openFragment()
            }

            R.id.rlSpecificationsSection -> {
                if (llMoreSpecifications?.isVisible == true) {
                    llMoreSpecifications?.visibility = View.GONE
                } else {
                    llMoreSpecifications?.visibility = View.VISIBLE
                    nsvScrollBody?.fullScroll(View.FOCUS_DOWN)
                }
            }
            R.id.rlReviewsSection -> {
                if (llMoreReviews?.isVisible == true) {
                    llMoreReviews?.visibility = View.GONE
                } else {
                    llMoreReviews?.visibility = View.VISIBLE
                    nsvScrollBody?.fullScroll(View.FOCUS_DOWN)
                }
            }
            R.id.rlHowToOrderSection -> {
                if (llMoreHowToOrder?.isVisible == true) {
                    llMoreHowToOrder?.visibility = View.GONE
                } else {
                    llMoreHowToOrder?.visibility = View.VISIBLE
                    nsvScrollBody?.fullScroll(View.FOCUS_DOWN)
                }
            }
            R.id.rlFAQSection -> {
                if (llMoreFAQ?.isVisible == true) {
                    llMoreFAQ?.visibility = View.GONE
                } else {
                    llMoreFAQ?.visibility = View.VISIBLE
                    nsvScrollBody?.fullScroll(View.FOCUS_DOWN)
                }
            }
            R.id.rlWholesaleInquirySection -> {
                if (llMoreWholesaleInquiry?.isVisible == true) {
                    llMoreWholesaleInquiry?.visibility = View.GONE
                } else {
                    llMoreWholesaleInquiry?.visibility = View.VISIBLE
                    nsvScrollBody?.fullScroll(View.FOCUS_DOWN)
                }
            }
            R.id.rlDescriptionsSection -> {
                if (llMoreDescriptions?.isVisible == true) {
                    llMoreDescriptions?.visibility = View.GONE
                } else {
                    llMoreDescriptions?.visibility = View.VISIBLE
                    nsvScrollBody?.fullScroll(View.FOCUS_DOWN)
                }
            }
        }
    }

    fun openFragment() {
        val ft = supportFragmentManager.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag("bottomSheetDialog")
        if (fragment != null) {
            ft.remove(fragment)
        }
        ft.addToBackStack(null)
        if (bottomSheetFragment.isAdded) return
        try {
            bottomSheetFragment.show(ft, "bottomSheetDialog")
        } catch (e: Exception) {
        }
    }
}