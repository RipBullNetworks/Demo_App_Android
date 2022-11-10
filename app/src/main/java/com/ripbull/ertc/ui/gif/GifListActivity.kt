package com.ripbull.ertc.ui.gif

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.ripbull.coreattachment.giph.Gif
import com.ripbull.coreattachment.giph.GiphyGifLoader
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.util.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_gif_list.*
import kotlinx.android.synthetic.main.layout_gif_toolbar.*

class GifListActivity : BaseActivity(), GifListAdapter.GifListAdapterListener {

  private var gifAdapter: GifListAdapter? = null
  private val disposable = CompositeDisposable()

  companion object {
    fun getIntent(context: Context): Intent {
      return Intent(context, GifListActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_gif_list)

    setGifsList()

    val mSearchView = searchToolBar(getString(R.string.search_gif))

    // listening to search query text change
    mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String): Boolean {
        // filter recycler view when query submitted
        setGifsList(query)
        return false
      }

      override fun onQueryTextChange(query: String): Boolean {
        // filter recycler view when text is changed
        if (query.isEmpty()) {
          setGifsList()
        }
        return false
      }
    })
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  private fun setGifsList(query: String = "") {
    //showProgressbar()
    disposable.add(
      GiphyGifLoader(this, query).loadInBackground()!!.subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe(
        this::onGifSuccess, this::onGifFailure
      )
    )
  }

  private fun onGifFailure(throwable: Throwable) {
    //do nothing
  }

  private fun onGifSuccess(gifs: List<Gif>?) {
    gifAdapter = gifs?.let { GifListAdapter(this, it, this) }
    rvGifList!!.layoutManager = GridLayoutManager(this, 2)
    rvGifList.adapter = gifAdapter
    dismissProgressbar()
  }

  override fun onGifSelected(gif: Gif) {
    val result = Intent()
    result.putExtra(AppConstants.EXTRA_URL, gif.gifUrl)
    setResult(RESULT_OK, result)
    finish()
  }

  private fun searchToolBar(title: String?): SearchView {
    val toolbar: Toolbar = toolbarGif
    searchViewGif.queryHint = getString(R.string.search_gif)
    searchViewGif.requestFocus()
    (searchViewGif.findViewById(androidx.appcompat.R.id.search_src_text) as EditText).setHintTextColor(
      this.resources.getColor(R.color.white)
    )
    (searchViewGif.findViewById(androidx.appcompat.R.id.search_src_text) as EditText).setTextColor(
      this.resources.getColor(R.color.white)
    )

    toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        R.id.action_search -> {

        }
        else               -> {
        }
      }
      true
    }

    toolbar.setNavigationIcon(R.drawable.ic_back_toolbar)
    toolbar.setNavigationOnClickListener {
      this.finish()
    }

    return searchViewGif;
  }
}