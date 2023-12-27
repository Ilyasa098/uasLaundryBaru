package com.example.uaslaundry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PembayaranViewModel : ViewModel() {
    var _listLaudry: MutableLiveData<List<LaundryModel>> = MutableLiveData(listBaju)

    val listLaundry: LiveData<List<LaundryModel>>
        get() = _listLaudry

    var _hargaTotal: MutableLiveData<Int> = MutableLiveData(0)

    val hargaTotal: LiveData<Int>
        get() = _hargaTotal

    val _counter: MutableLiveData<Int> = MutableLiveData(0)

    val counter: LiveData<Int>
        get() = _counter

    var _listHargaSementara: MutableLiveData<MutableList<Int>> = MutableLiveData(listHargaSementara)




    fun setTotalHarga(){
        _listHargaSementara.value!!.clear()
        var counterTemp = 0
        for (i in _listLaudry.value!!){
           listHargaSementara.add(i.counter*i.hargaLaundry)
            counterTemp+=i.counter
        }
        _counter.value = counterTemp
        _hargaTotal.value = listHargaSementara.sum()


    }

    fun resetCounter(){
        for (i in _listLaudry.value!!){
            i.counter = 0
        }
    }

}