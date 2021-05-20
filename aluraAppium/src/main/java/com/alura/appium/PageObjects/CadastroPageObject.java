package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject extends PageObjectsBase {

    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private MobileElement mensagemErro;

    private final By erroId;
    private final By campoNomeId;
    private final By campoSenhaId;
    private final By campoConfirmarSenhaId;
    private final By botaoCadastrarId;

    protected CadastroPageObject(AppiumDriver driver) {
        super(driver);
        erroId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeId = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmarSenhaId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrarId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void BuscarElementos() {
        campoNome = (MobileElement) driver.findElement(campoNomeId);
        campoSenha = (MobileElement) driver.findElement(campoSenhaId);
        campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmarSenhaId);
        botaoCadastrar = (MobileElement) driver.findElement(botaoCadastrarId);
    }

    private void PreecherFormulario(String usuario, String senha, String confirmaSenha) {
        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmaSenha);
    }

    public LoginPageObject Cadastrar(String usuario, String senha, String confirmaSenha) {
        PreecherFormulario(usuario, senha, confirmaSenha);
        botaoCadastrar.click();
        return new LoginPageObject(driver);
    }

    public String MensagemErro() {

        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroId));

        mensagemErro = (MobileElement) driver.findElement(erroId);
        return mensagemErro.getText();
    }
}
