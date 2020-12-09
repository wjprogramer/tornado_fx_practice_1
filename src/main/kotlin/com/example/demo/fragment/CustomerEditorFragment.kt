package com.example.demo.fragment

import com.example.demo.model.Customer
import tornadofx.*

class CustomerEditorFragment : View("My View") {
    /** Method 1 */
    val customer: Customer by param()

    /** Method 2 */
//    init {
//        val customer = params["customer"] as? Customer
//        if (customer != null) {
//            // ...
//        }
//    }

    override val root = vbox {
        label(customer.id.toString())
        label(customer.name)
    }
}
