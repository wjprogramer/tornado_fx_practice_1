package com.example.demo.view

import com.example.demo.fragment.CustomerEditorFragment
import com.example.demo.model.Customer
import tornadofx.*

class HomeView : View("Home View") {

    private val view1: View1 by inject()

    override val root = vbox {
        label("HomeView")

        button("Go MainView") {
            action {
                replaceWith(MainView::class)
            }
        }

        button("Edit Customers") {
            action {
                val customer = Customer(1, "Jay")
                editCustomer(customer)
            }
        }

        button("Login") {
            action {
                replaceWith(LoginFormView::class)
            }
        }

        button("RtspView") {
            action {
                replaceWith(RtspView::class)
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
        // `xxx to xxx` 等價 `Pair(CustomerEditor::customer, customer)`
        find<CustomerEditorFragment>(mapOf(CustomerEditorFragment::customer to customer)).openWindow()
    }
}
