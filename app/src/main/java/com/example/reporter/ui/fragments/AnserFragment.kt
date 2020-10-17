package com.example.reporter.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reporter.R
import com.example.reporter.ui.fragments.BaseFragment
import com.example.reporter.utilits.APP_ACTIVITY

class AnserFragment : BaseFragment(R.layout.fragment_anser) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "О нас"
    }
}