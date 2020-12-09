package com.example.demo.view

import com.example.demo.fragment.CustomerEditorFragment
import com.example.demo.model.Customer
import tornadofx.*

class HomeView : View("Home View") {
    override val root = vbox {
        label("HomeView")

        button("Edit Customers") {
            action {
                val customer = Customer(1, "Jay")
                editCustomer(customer)
            }
        }
    }

    // View 的 root 與 Parent connected 的時候
    override fun onDock() {
        super.onDock()
        println("Docking HomeView!")
    }

    // ... disconnected ...
    override fun onUndock() {
        super.onUndock()
        println("Undocking HomeView!")
    }

    private fun editCustomer(customer: Customer) {
        find<CustomerEditorFragment>(mapOf(CustomerEditorFragment::customer to customer)).openWindow()
    }
}
