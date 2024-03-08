package runners;

import br.com.bb.ath.ftabb.runner.FTABBCucumberRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;

@RunWith(FTABBCucumberRunner.class)
@CucumberOptions(plugin = {"pretty",
							"html:target/cucumber-report",
					        "junit:target/cucumber-report/junitResult.xml",
					        "json:target/cucumber-report/jsonResult.json"},

               features = "classpath:features/000_DEB_Extrato.feature",              
               snippets = SnippetType.CAMELCASE,
             monochrome = true,
             
             glue = {"steps","utilitarios"},
             
             tags = {"@001_DEB_Extrato_ContaCorrente_AcessoExtratoContaCorrente"}
				)

public class DEB_Extrato {

	
}
