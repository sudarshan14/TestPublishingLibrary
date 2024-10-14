# Demo Project - Publish library on github packages
 ### Note
- This will work within the organization/self
- or the publisher will have to share the username and password(gh access token) with the library
- kotlin DSL is used for gradle

## Library Module - githubpackagelibrary
 - showcases how to publish the library to git hub packages
 - use `publish` task 

## How to add library in android project
 - add the following dependency in  app module gradle file
   ```implementation("com.amlavati:github-package-library:0.0.2")```
 - add github user name and password in local.properties file 

```
gh_username=****
gh_key=**** 
```


## Library Module - localmavenlibrary
 - showcases how to publish the library to local maven
 - use `publishToMavenLocal` task 




