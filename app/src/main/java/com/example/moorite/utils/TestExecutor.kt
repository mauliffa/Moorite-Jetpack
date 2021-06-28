package com.example.moorite.utils

import java.util.concurrent.Executor

class TestExecutor: Executor {
    override fun execute(runnable: Runnable) {
        runnable.run()
    }
}