package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;


public class FeatureCadastro {
    @Test
    public void CantRegisterWithoutMatchingPasswords() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Fernanda", "123", "456");

        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();
    }

    @Test
    public void RegisterSuccessfully() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();

        telaLogin = telaCadastro.Cadastrar("Fernanda", "123", "123");
        telaLogin.BuscarElementos();
    }
}
