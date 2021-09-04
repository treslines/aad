package br.com.programadordeelite.gdc.codelab.userinterface.recyclerview.paging

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import androidx.lifecycle.lifecycleScope
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentRecyclerViewPagingBinding

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.coroutines.flow.collect


// https://developer.android.com/topic/libraries/architecture/paging/v3-overview
// https://developer.android.com/codelabs/android-paging?index=..%2F..%2Findex#4
class RecyclerViewPagingFragment : Fragment(R.layout.fragment_recycler_view_paging) {

    private lateinit var binding: FragmentRecyclerViewPagingBinding
    private lateinit var viewModel: SearchRepositoriesViewModel
    private val adapter = ReposAdapter()

    private var searchJob: Job? = null

    private fun search(query: String) {
        // Make sure we cancel the previous job before creating a new one
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.searchRepo(query).collect {
                adapter.submitData(it)
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecyclerViewPagingBinding.bind(view)

        // +---------------------------------------------------------------------------------------------------------+
        // | ***ATENCÃO*** ESSE É UM DOS CODELABS MAIS DIFICEIS, POR ISSO DEIXEI MAIS CLASSES PRONTAS PARA TE AJUDAR |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/lAAlxi2IH0U                          |
        // +---------------------------------------------------------------------------------------------------------+
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAST_SEARCH_QUERY, binding.searchRepo.text.trim().toString())
    }

    companion object {
        private const val LAST_SEARCH_QUERY: String = "last_search_query"
        private const val DEFAULT_QUERY = "Android"
    }
}



