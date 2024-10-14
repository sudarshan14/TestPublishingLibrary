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
   ```implementation("com.amlavati:github-package-library:0.1")```
 - add github user name and api  key in local.properties file 

```
gh_username=****
gh_key=**** 
```

 - add maven depedency in setting.gradle file 

 - add maven in setting.gradle file

```
maven {
url = uri("https://maven.pkg.github.com/sudarshan14/TestPublishingLibrary")
credentials{
username = (githubProperties["gh_username"] ?: System.getenv("USERNAME")).toString()
password = (githubProperties["gh_key"] ?: System.getenv("TOKEN")).toString()
}
}


val githubProperties = Properties()
if (file("local.properties").exists()) {
githubProperties.load(FileInputStream(file("local.properties")))
}

```

## How to add gh_key  

```
Generate a Personal Access Token (PAT) 

Click on the profile picture in the right-hand menu, then SETTING > DEVELOPER SETTINGS

Click on the “Generate New Token” button.

Click on the “Generate Token” button to generate your PAT after providing it a name and select the required purpose. 
```


## Library Module - localmavenlibrary
 - showcases how to publish the library to local maven
 - use `publishToMavenLocal` task 




