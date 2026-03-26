package tests.cucumber;

import io.cucumber.java.en.Given;

public class StepDefinitions {

    @Given("print thread count on console")
    public void print_thread_count_on_console() {
        System.out.println("*** Test started ***");
        System.out.println(Thread.currentThread().threadId());
    }
}