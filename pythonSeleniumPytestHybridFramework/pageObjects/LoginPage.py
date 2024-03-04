from selenium import webdriver
from selenium.webdriver.common.by import By


class LoginPage:
    email_id = 'Email'
    password_id = 'Password'
    login_btn_xpath = '//button[@type="submit"]'
    logout_btn_link = 'Logout'


    def __init__(self, driver):
            self.driver = driver

    # Action methods
    def setUsername(self, username):
        self.driver.find_element(By.ID, self.email_id).clear()
        self.driver.find_element(By.ID,self.email_id).send_keys(username)

    def setPassword(self, password):
        self.driver.find_element(By.ID, self.password_id).clear()
        self.driver.find_element(By.ID,self.password_id).send_keys(password)

    def clickLogin(self):
        self.driver.find_element(By.XPATH, self.login_btn_xpath).click()

    def clickLogout(self):
        self.driver.find_element(By.LINK_TEXT,self.logout_btn_link).click()

