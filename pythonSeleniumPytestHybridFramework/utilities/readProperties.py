import configparser
configObj = configparser.RawConfigParser()
configObj.read('../Configurations/config.ini')

class ReadConfig():
    @staticmethod
    def getApplicationUrl():
        url = configObj.get('common data', 'baseURL')
        return url

    @staticmethod
    def getUserEmail():
        username = configObj.get('common data', 'username')
        return username



    @staticmethod
    def getUserPassword():
        password = configObj.get('common data', 'password')
        return password

