package com.jordansilva.mywallet.domain.model

import java.util.*

class BankTransaction(var amount: Double,
                  var description: String?,
                  var otherAccount: String,
                  var date: Date) : BaseModel() {

    var afterAmount : Double? = null

}