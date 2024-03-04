import logging


class LogGen:
    @staticmethod
    def logGeneration():
        format1 = '%(asctime)s %(message)s'
        logging.basicConfig(filename='../Logs/automation.log', format=format1, force=True)
        logger = logging.getLogger()
        logger.setLevel(logging.DEBUG)
        return logger
