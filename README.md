## About 

---
This task was done using:
    Java 8, Rest Assured BDD framework, Junit 5  and Gradle build tool
   
### Running tests
Mac OS
* ```./gradlew test```

Windows
* ```gradlew.bat test```

### Separate commands to run Test 1 and Test 2 separately from Test 3:
* ```./gradlew petManipulations```

### To specify the application web site name during test execution via command-line

* ```./gradlew test -Dserver.url=https://petstore.swagger.io/v2```

```server.url``` - optional parameter (https://petstore.swagger.io/v2 is used by default)

### To view test report
Open ./build/reports/tests/test/index.html file in browser.
