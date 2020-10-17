package com.example.reporter.ui.fragments.testFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.recyclerview.widget.RecyclerView
import com.example.reporter.R
import com.example.reporter.ui.fragments.BaseFragment
import com.example.reporter.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_lenta.*
import kotlinx.android.synthetic.main.fragment_test_list.*


class TestListFragment : BaseFragment(R.layout.fragment_test_list) {

    private val url = "http://192.168.1.43:80/test"


    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Тесты"

        web_view_test.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
        val webSettings = web_view_test.settings

        webSettings.javaScriptEnabled = true
        web_view_test.loadUrl(url)




    }


}