package com.captainduckman.math.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = {"classpath:features/complex-number.feature"},
        glue = {"com.captainduckman.math.cucumber"})
public class ComplexNumberCucumberRunner {
}
