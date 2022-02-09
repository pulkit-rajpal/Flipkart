# Flipkart Automation Framework 

## Description

Flipkart Automation Framework is the  Framework for the Testing various 
Functionalities for the Flipkart Website  from home page to Login & adding products to Cart etc.


[![Build Status]

(github Repo)
git clone https://github.com/pulkit-rajpal/Flipkart.git



## Running Tests

### To run tests, Follow one of the Below Ways ###


- Running Flipkart Test Cases Using Maven command  (prerequisite- Maven Installed)

Run Terminal in Root Folder
***(\Flipkart\>)***

```
mvn clean test 
```

- Running Flipkart Test Cases Using bash file  


Run Terminal in Root Folder
***(\Flipkart\>)***

```
Flipkart.bat 
```


- Running Flipkart Test Cases Using Eclipse   
    - Go to Eclipse 
    - File> Open Project from File Sytem 
    - Select the Root Folder (Flipkart>)
    - Wait to project to Load 
    - Ensure that you have require maven dependencies and testng libraries 
    - Update Maven project & install dependencies
    - Got to **testng.xml** double tap & click Run as testNG Suite 
 


## Environment 

Java Runtime Environment 

 ### Packages description

#### com.flipkart.pages  :- 
- Consists all the Pages for Getting the locators for elements.
 
#### com.flipkart.utils  :- 
 - Consists the static Resources necessary for Framework.

#### com.flipkart.tests  :- 
- Contains Test Cases required for the Flipkart test Classes 


#### com.flipkart.tests  package  description
 
**Base Test**:

    - @BeforeSuite -> Starting Extente Report & reading Excel File 
    - @AfterSuite  -> To close & flush Extent Reporting 
    - @BeforeMethod -> To initiate driver & get the home url
    - @AfterMethod -> To quite driver & check for failure after every Method 

**HomePage Test** : Includes Test

    -- *dropDownElectronics*  -> to verify drop Down working on Home page. 
    -- *verifyTitle*  -> to verify title of the Home Page.

**Login Test** : Includes Test

    -- *validLogin*  -> Login using valid Creds
    -- *invalidLogin* -> uanbel to Login using Invalid Creds

**Logout Test** : Includes Test

    -- *logout*  -> to verify the logout after Login  


  
 **Product Test** : Includes test
 
    -- *relevantProducts* -> Verify that the result that one get after searching for a product is similar to search keyword. 
    -- *sortProductByPriceHtoL* -> Verify that the result are sorted in Descending Price when Sorted from High to Low Price.
    -- *sortProductByPriceLtoH* -> Verify that the result are sorted in Ascending Price when Sorted from Low to High Price.
    -- *chooseProductBrand* -> Verify that the Brand Filter is working Fine.
    -- *chooseProductRating* ->Verify that the result that Filter  Product By Rating  is achiveable .

 
**Product Details Test** : Includes test

    -- *checkImageDisplayed* -> Verify that an Image is Displayed corresponding to a Product
    -- *changeColorofProduct* -> Verify that the User can change the Color of the Particular Product Like Shirt
    -- *changeSizeofProduct* -> Verify that the User can change the Size of the Particular Product Like Shirt



**addToCart  Test** : Includes test

    -- *addToCart* -> Verify adding a Product to Cart
    -- *addtoCartOutofStock* -> Verify Unable to Add to Cart for Out of Stock Product Test


**Address  Test** : Includes test

    -- *addValidAddress*   -> Verify adding a valid Address
    --  *addInValidAddress*   -> Verify that the user won't be able to save an Invalid Address
   
   
**FlipkartProfile  Test** : Includes test

    -- *changeName*   -> Verify that the User is able to change Name for the Flipkart Account
    -- *changegender*  -> Verify that the User is able to change Gender for the Flipkart Account

   
**Wishlist  Test** : Includes test
   
    -- *changeName*   -> Verify Add a product To WishList.
    -- *getProductsInwishlist*   -> Verify Getting  product To WishList.
    

## Project Usefull Directories & Files:

- ./Drivers :- Contains chrome , Firefox & Edge Drivers
- ./FailedScreenshots :- Contains Screenshots clicked on Failure of a Test.
-  ./Log :- Contains Logs .  
-  ./Resource :- Contains Config files & Excel File  .
-  ./Reports :- Contains Extent Report  .  
- testng.xml -  testNG file to run test Cases 
- pom.xml - Contains the Maven dependencies 
- Flipkart.bat -  To run Test Cases 

# jenkins :
## Visit the jenkins.docx file for Jenkins integation with Github for Flipkart Automation Framwork 



## Attaching Final Result Out Screenshot 
![Screenshot (168)](https://user-images.githubusercontent.com/32858985/153196950-4b06b4e5-cdab-4133-872b-786da9fa33d2.png)

## Authors

### @pulkit

