import os
import random
import unittest

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select as select
from selenium.webdriver.support.wait import WebDriverWait


class MyTestCase(unittest.TestCase):

    # Init Chrome webdriver and connect to netpeak.ua
    def setUp(self):
        # Init web_driver
        self.driver = webdriver.Chrome()
        # create connection to site
        self.driver.get("https://netpeak.ua")
        # create default implicitly wait max 10 seconds
        self.driver.implicitly_wait(10)

    def test1(self):
        driver = self.driver

        # Find vacancies_button element
        vacancies_button = driver.find_element_by_xpath("/html/body/header/div[2]/div/div/div[2]/div/nav/ul/li[5]/a")
        # vacancies_button click
        vacancies_button.click()

        # Find fill_out_form_button element
        fill_out_form_button = driver.find_element_by_xpath("/html/body/div[5]/div/div/div[5]/div/a")
        # fill_out_form_button click
        fill_out_form_button.click()

        # select button upload resume and send the image.png
        upload_button = WebDriverWait(driver, 5).until(EC.presence_of_element_located((By.XPATH, "/html/body/input")))
        upload_button.send_keys(os.path.abspath("image.png"))

        # wait until class form-group has-error is invisible then get get text
        WebDriverWait(driver, 3).until(EC.invisibility_of_element((By.CLASS_NAME, "form-group has-error")))
        element = driver.find_element_by_xpath("//*[@id=\"up_file_name\"]/label").text
        # check is element have the same error
        assert element == 'Ошибка: данные файла не были переданы.'

        # init list of names and random selected value
        first_name_list = ('Will', 'Alex', 'Nick', 'Sam', 'Vasya', 'Bender', 'joe')
        name_str = random.choice(first_name_list)
        # get first name from list and input it in field randomly
        driver.find_element_by_xpath("//*[@id=\"inputName\"]").send_keys(name_str)
        # init list of last names and random selected value
        last_name_list = ('Smith', 'Johnson', 'Williams', 'Brown', 'Jones', 'Garcia')
        last_name_str = random.choice(last_name_list)
        # get last name from list and input it in field randomly
        driver.find_element_by_xpath("//*[@id=\"inputLastname\"]").send_keys(last_name_str)

        # create email address from name last name and random numbers with randint
        email = name_str + last_name_str + str(random.randint(111, 9999)) + "@gmail.com"
        # input generated email address to the form
        driver.find_element_by_xpath("//*[@id=\"inputEmail\"]").send_keys(email)

        # find select of years
        select_year = driver.find_element_by_xpath("/html/body/form/div[1]/div/div[1]/div[11]/div[2]/select")
        selector = select(select_year)
        # get values of selectors years to list
        options = selector.options
        # get random year from list getting in range 1 to option length
        # because the zero index don't have year and untput select
        year = options[random.randint(1, len(options) - 1)].text
        selector.select_by_value(year)

        # find select of month
        select_month = driver.find_element_by_xpath("/html/body/form/div[1]/div/div[1]/div[11]/div[3]/select")
        selector = select(select_month)
        # get values of selectors month to list
        options = selector.options
        # get random month from list getting in range 1 to option length because
        # the zero index don't have month and untput select
        month = options[random.randint(1, len(options) - 1)].text
        selector.select_by_visible_text(month.replace(' ', ''))

        # find select by day
        select_day = driver.find_element_by_xpath("/html/body/form/div[1]/div/div[1]/div[11]/div[4]/select")
        selector = select(select_day)
        # get values of selector days to list
        options = selector.options
        # get random day from list getting in range 1 to option length because the zero index don't have day
        day = options[random.randint(1, len(options) - 1)].text
        selector.select_by_visible_text(day)
        # click the agree rules and submit button
        driver.find_element_by_xpath("//*[@id=\"agree_rules\"]").click()
        driver.find_element_by_xpath("//*[@id=\"submit\"]").click()
        # retrieve color and check it is red?
        color = driver.find_element_by_xpath("/html/body/div[2]/div/p").value_of_css_property('color')
        assert color == "rgba(255, 0, 0, 1)"
        # click on the banner
        driver.find_element_by_xpath("/html/body/header/div[1]/div/div/div[1]/div[1]/a/img").click()
        # wait until url will changed to https://netpeak.ua/ after redirect
        WebDriverWait(driver, 5).until(EC.url_to_be("https://netpeak.ua/"))
        # is current url https://netpeak.ua/?
        assert driver.current_url == "https://netpeak.ua/"

    def tearDown(self):
        self.driver.quit()


if __name__ == "__main__":
    unittest.main()
