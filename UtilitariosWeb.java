package utilitarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.bb.ath.ftabb.FTABB;
import br.com.bb.ath.ftabb.FTABBContext;
import br.com.bb.ath.ftabb.utilitarios.FTABBUtils;
import utilitarios.*;


public class UtilitariosWeb extends FTABBUtils {
	WebDriver driver = (WebDriver) FTABBContext.getContext().getContextBrowserDriver().getDriver();
	
	private WebDriver driverWeb;
	
	public UtilitariosWeb(WebDriver driverWeb) {
		this.driverWeb = driverWeb;
		PageFactory.initElements(driverWeb, this);
	}
	
	public static void main (String[] args) {

}
	private Object Url;
	public void scrollAteOElemento(WebElement elemento) {
		
		((JavascriptExecutor) driverWeb).executeScript("arguments[0].scrollIntoView(true);", elemento);
	
	}
	
	public void scrollToTop() {
		
		((JavascriptExecutor) driverWeb).executeScript("window.scrollTo(0,0)");
		
	}
	public void scrollTomiddle() {
		
		((JavascriptExecutor) driverWeb).executeScript("window.scrollTo(300, 500)");
		
	}
	public void scrollToBottom() {
		
		((JavascriptExecutor) driverWeb).executeScript("window.scrollTo(0,2000)");
		
	}
		public void digitarLetra(WebElement elemento, String texto){
			int contador = 0;
			String valor = texto; 
			elemento.clear();
		    for (contador = 0; contador < valor.length(); contador++){
		        char valorTotal = valor.charAt(contador);
		        String letra = new StringBuilder().append(valorTotal).toString();
		        elemento.sendKeys(letra);
		    }
	    
		}
	
	public void AbrirUrl(java.lang.String Url) {
		
	}
	public void atualizarPaginaWeb() {
		
	}
	
	private void espera(int i) {
		int contador = 0;
		
	}
}