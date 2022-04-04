package edu.adehnerova.recyclerproject

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        private var titles: ArrayList<String> = arrayListOf()
        private var details: ArrayList<String> = arrayListOf()
        private var images: ArrayList<Int> = arrayListOf()

        fun setValues(title: String, detail: String, image: Int) {
            titles.add(title)
            details.add(detail)
            images.add(image)
        }

        fun getTitles(): ArrayList<String> {
            return titles
        }

        fun getDetails(): ArrayList<String> {
            return details
        }

        fun getImages(): ArrayList<Int> {
            return images
        }
    }
}