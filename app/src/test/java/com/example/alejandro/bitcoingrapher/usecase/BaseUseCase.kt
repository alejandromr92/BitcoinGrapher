package com.example.alejandro.bitcoingrapher.usecase

import org.junit.Before

abstract class BaseUseCase {

    /**
     * This method sets up all tests dependencies for this class. It is called BEFORE each test. In
     * this case builds the interactor under test.
     */
    @Before
    abstract fun setup()
}