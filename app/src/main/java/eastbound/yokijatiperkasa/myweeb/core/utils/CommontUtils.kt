package eastbound.yokijatiperkasa.myweeb.core.utils

import android.view.View

object CommontUtils {

    fun showLoading(view: View, state: Boolean) {
        if (state) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

}