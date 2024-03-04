from selenium import webdriver
from pageObjects.LoginPage import LoginPage
from utilities.readProperties import ReadConfig
from utilities.customLogger import LogGen


class Test_001_Login:
    baseURL = ReadConfig.getApplicationUrl()
    username = ReadConfig.getUserEmail()
    password = ReadConfig.getUserPassword()

    logger = LogGen.logGeneration()

    def test_homePagetitle(self, setup):
        # print("here")
        self.logger.info('****************Test_001_Login*************')
        self.logger.info('****************Verifying home page title*************')
        self.driver = setup
        self.driver.get(self.baseURL)
        actual_title = self.driver.title
        print(actual_title)
        if actual_title == 'Your store. Login':
            assert True
            self.driver.close()
            self.logger.info('****************Home page title test has passed*************')
        else:
            self.driver.save_screenshot('../Screenshots/' + 'test_homePagetitle.png')
            self.driver.close()
            self.logger.error('****************Home page title test has failed*************')
            # self.logger.info('****************Home page title test has failed*************')
            assert False

    def test_login(self, setup):
        self.logger.info('****************Verifying login test*************')
        self.driver = setup
        self.driver.get(self.baseURL)
        # create an obj of loginpage
        self.lp = LoginPage(self.driver)
        self.lp.setUsername(self.username)
        self.lp.setPassword(self.password)
        self.lp.clickLogin()
        actual_title = self.driver.title
        if actual_title == 'Dashboard / nopCommerce administration':
            assert True
            self.logger.info('****************Login test passed*************')
            self.driver.close()
        else:
            self.driver.save_screenshot('../Screenshots/' + 'test_login.png')
            self.driver.close()
            self.logger.error('****************Login test failed*************')
            assert False
