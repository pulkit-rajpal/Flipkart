
# Flipkart Automation Framework 

Flipkart Demo Automation Framework is the 
Framework for the Testing various 
Functionalities for the Sause Website 

(private github Repo)

## Running Tests

To run tests, run the following command

Running test case with CHROME with NORMAL & HEADLESS MODE 


Run Terminal in Root Folder
(\Flipkart>)
```bash
(normal)
 pytest --tb=no  .\test_Tests\ -s  --browser chrome --headless False  --html=reports/report2.html  --log-cli-level=INFO
(headless)
 pytest --tb=no  .\test_Tests\ -s  --browser chrome --headless True  --html=reports/report2.html  --log-cli-level=INFO
```

Running test case with CHROME with NORMAL & HEADLESS MODE 

```bash
(normal)
 pytest --tb=no  .\test_Tests\ -s  --browser firefox --headless True  --html=reports/report2.html  --log-cli-level=INFO
(headless)
 pytest --tb=no  .\test_Tests\ -s  --browser firefox --headless False  --html=reports/report2.html  --log-cli-level=INFO
```


## Environment 

Python Virtual Environment 

## Description


 
### Packages description

 - objects  : Consists all the Pages for  Getting the locators for elements.
 - resources : Consists the static Resources necessary for Framework.
 - reports : Contains reports & screenshots on test Failures.
 - SeleniumDrivers : Contains the driver & Customising driver functionalities.
 - test_Test :  Contains all the Test cases which includes Login, Logout & products
 - utils : Contain Global Configs & other utilities
 


### test_Tests  package  description

- @Setup - to initiate the Browser Driver & initiate setup 
- @quite - to Quite the browser

**Login Test**:
- The main class which defines the logging Test

**Logout Test** : Includes Test
- to verify the logout after Login  
  
 **Product Test** : Includes test
- to verify Ordering Products 
 
**Product Sort** : Includes test
- to verify Sort product High to Low value
- to verify Sort product Low to High value

## Authors

- [@pulkit]

