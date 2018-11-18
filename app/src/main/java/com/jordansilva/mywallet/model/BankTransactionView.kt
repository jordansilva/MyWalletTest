package com.jordansilva.mywallet.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class BankTransactionView(
    var id: String, var amount: Double,
    var description: String?, var otherAccount: String, var date: Date,
    var amountAfter: Double? = null, var amountBefore: Double? = null
    ) : Parcelable