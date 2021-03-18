package com.valuepitch.fhtestapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.valuepitch.fhtestapp.R


class SettingFragment : Fragment() {
    private lateinit var ivYourInfo:ImageView
    private lateinit var ivYouBetter:ImageView
    private lateinit var ivYourRisk:ImageView
    private lateinit var ivYourFamily:ImageView
    private lateinit var containerFragment:FrameLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_setting, container, false)
        initViews(root)
        return root
    }

    private fun initViews(root: View) {

        ivYourInfo=root.findViewById(R.id.ivYourInfo)
        ivYouBetter=root.findViewById(R.id.ivYouBetter)
        ivYourRisk=root.findViewById(R.id.ivYourRisk)
        ivYourFamily=root.findViewById(R.id.ivYourFamily)
        containerFragment=root.findViewById(R.id.containerFragment)

        ivYourInfo.setImageDrawable(activity?.getDrawable(R.drawable.dark_your_info))
        val infoFragment: Fragment =
            InfoFragment()
        replaceFragmet(infoFragment)


        ivYourInfo.setOnClickListener{

            ivYourInfo.setImageDrawable(activity?.getDrawable(R.drawable.dark_your_info))
            ivYouBetter.setImageDrawable(activity?.getDrawable(R.drawable.light_you_better))
            ivYourRisk.setImageDrawable(activity?.getDrawable(R.drawable.light_your_risk))
            ivYourFamily.setImageDrawable(activity?.getDrawable(R.drawable.light_your_family))

            val infoFragment: Fragment =
                InfoFragment()
            replaceFragmet(infoFragment)

        }

        ivYouBetter.setOnClickListener{

            ivYourInfo.setImageDrawable(activity?.getDrawable(R.drawable.light_your_info))
            ivYouBetter.setImageDrawable(activity?.getDrawable(R.drawable.dark_you_better))
            ivYourRisk.setImageDrawable(activity?.getDrawable(R.drawable.light_your_risk))
            ivYourFamily.setImageDrawable(activity?.getDrawable(R.drawable.light_your_family))

            val youBetterFragment: Fragment =
                YouBetterFragment()
            replaceFragmet(youBetterFragment)

        }
        ivYourRisk.setOnClickListener{

            ivYourInfo.setImageDrawable(activity?.getDrawable(R.drawable.light_your_info))
            ivYouBetter.setImageDrawable(activity?.getDrawable(R.drawable.light_you_better))
            ivYourRisk.setImageDrawable(activity?.getDrawable(R.drawable.dark_your_risk))
            ivYourFamily.setImageDrawable(activity?.getDrawable(R.drawable.light_your_family))

            val riskFragment: Fragment =
                RiskFragment()
            replaceFragmet(riskFragment)

        }
        ivYourFamily.setOnClickListener{

            ivYourInfo.setImageDrawable(activity?.getDrawable(R.drawable.light_your_info))
            ivYouBetter.setImageDrawable(activity?.getDrawable(R.drawable.light_you_better))
            ivYourRisk.setImageDrawable(activity?.getDrawable(R.drawable.light_your_risk))
            ivYourFamily.setImageDrawable(activity?.getDrawable(R.drawable.dark_your_family))

            val familyFragment: Fragment =
                FamilyFragment()
            replaceFragmet(familyFragment)

        }
    }

    fun replaceFragmet(fragment: Fragment){

        val fragmentManager: FragmentManager = activity?.supportFragmentManager!!
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
        fragmentTransaction.replace(R.id.containerFragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}