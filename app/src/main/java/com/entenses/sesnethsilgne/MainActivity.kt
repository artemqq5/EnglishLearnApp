package com.entenses.sesnethsilgne

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.entenses.sesnethsilgne.domain.ChangeTitleActionBar


class MainActivity : AppCompatActivity(), ChangeTitleActionBar {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun setNewTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun setBackButtonVisibility(state: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(state)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}