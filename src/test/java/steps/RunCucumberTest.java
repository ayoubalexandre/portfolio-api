package steps;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value="pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
//classe executora (runner) dos cen�rios de teste cucumber
public class RunCucumberTest {
}
