
# react-native-emoji-android

## Getting started

`$ npm install react-native-emoji-android --save`

### Mostly automatic installation

`$ react-native link react-native-emoji-android`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-emoji-android` and add `RNEmojiAndroid.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNEmojiAndroid.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNEmojiAndroidPackage;` to the imports at the top of the file
  - Add `new RNEmojiAndroidPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-emoji-android'
  	project(':react-native-emoji-android').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-emoji-android/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-emoji-android')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNEmojiAndroid.sln` in `node_modules/react-native-emoji-android/windows/RNEmojiAndroid.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Emoji.Android.RNEmojiAndroid;` to the usings at the top of the file
  - Add `new RNEmojiAndroidPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNEmojiAndroid from 'react-native-emoji-android';

// TODO: What to do with the module?
RNEmojiAndroid;
```
  