

<h1 align="center">
<br>
  Pref-DB
  <br>
</h1>
<h4 align="center">Android SharedPreferences alternative library.</h4>
<p align="center">
    <img src="https://img.shields.io/badge/Build-v1.0-green">
    <img src="https://img.shields.io/badge/JitPack-1.0-brightgreen">
    <img src="https://img.shields.io/badge/License-Apache--2.0-red">
</p>

## Dependency
Add the JitPack repository to your build file
```kotlin
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency
```kotlin
dependencies {
	implementation 'com.github.M-Fakhri:PrefDB:1.0' //Latest Release
}
```
## How To Use
You need to initialize the `Prefs` once your application starts, it's recommended to be in your `Application` class, by using:
 - <h3>Initialization</h3>
```kotlin
	Prefs.init(this) //should be inside OnCreate
```
> **Note**: The initializing should be only once.

 - <h3>Store Data</h3>
To store new data you can use (Kotlin Indexed Access Operator), you can do it as the following:
```kotlin
//syntax: Prefs[Key] = Value
Prefs["Hello"] = "Hello"  //set `String` value for key 'Hello'
Prefs["One"] = 1  		  //Set `Int` value for key 'One'
Prefs["0.9"] = 0.9f  	  //Set `Float` value for key '0.9'
Prefs["Hello"] = "Hi" 	  //Override key 'Hello' with new value  
```
 - <h3>Retrieve Data</h3>
To retrieve stored data you can use getter methods, you can do it as the following:
```kotlin
Prefs.getString("Hello")  //get `String` value for key 'Hello'
Prefs.getInt("One")  	  //get `Int` value for key 'One'
Prefs.getFloat("0.9")  	  //get `Float` value for key '0.9'
Prefs.getInt("Two",2) 	  //get `Int` value for key 'Two' if not found return the default value which is 2. 
```
> **Note**: Currently supported data types are `Int`, `Float`, `Double`, `String` and `Boolean`.

## License
Distributed under the **Apache License 2.0**. See the [LICENSE](LICENSE) file for details.
