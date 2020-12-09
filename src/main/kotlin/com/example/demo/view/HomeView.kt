package com.example.demo.view

import com.example.demo.fragment.CustomerEditorFragment
import com.example.demo.model.Customer
import tornadofx.*

class HomeView : View("Home View") {

    private val view1: View1 by inject()
    private val tmpView: TmpView by inject()

    override val root = vbox {
        label("HomeView")

        button("Edit Customers") {
            action {
                val customer = Customer(1, "Jay")
                editCustomer(customer)
            }
        }

        view1.root
        tmpView.root
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
        // `xxx to xxx` 等價 `Pair(CustomerEditor::customer, customer)`
        find<CustomerEditorFragment>(mapOf(CustomerEditorFragment::customer to customer)).openWindow()
    }
}
