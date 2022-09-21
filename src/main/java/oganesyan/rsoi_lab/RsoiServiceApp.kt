package oganesyan.rsoi_lab

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

fun main(){
    RsoiServiceApp().start(arrayOf());
}

@SpringBootApplication
class RsoiServiceApp {
    fun start(args: Array<String>) {
        SpringApplication.run(RsoiServiceApp::class.java, *args)
    }
}