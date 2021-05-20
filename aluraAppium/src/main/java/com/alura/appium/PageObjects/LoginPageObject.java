package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPageObject extends PageObjectsBase {

    private MobileElement nomeUsuario;
    private MobileElement senhaUsuario;
    private MobileElement botaoCadastro;
    private MobileElement botaoLogar;

    private final By nomeUsuarioId;
    private final By senhaUsuarioId;
    private final By botaoCadastroId;
    private final By botaoLogarId;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
        botaoCadastroId = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        nomeUsuarioId = By.id("br.com.alura.aluraesporte:id/input_usuario");
        senhaUsuarioId = By.id("br.com.alura.aluraesporte:id/input_senha");
        botaoLogarId = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
    }

    @Override
    public void BuscarElementos() {
        nomeUsuario = (MobileElement) driver.findElement(nomeUsuarioId);
        senhaUsuario = (MobileElement) driver.findElement(senhaUsuarioId);
        botaoCadastro = (MobileElement) driver.findElement(botaoCadastroId);
        botaoLogar = (MobileElement) driver.findElement(botaoLogarId);
    }

    public void PreencherLogin(String usuario, String senha) {
        nomeUsuario.setValue(usuario);
        senhaUsuario.setValue(senha);
    }

    public CadastroPageObject IrParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);
    }
}
