
# FBReactionDialog Library Android

An easy to use FBReactionDialog library for Android apps.

[![](https://jitpack.io/v/Abhay-cloud/FBReactionDialog-Library-Android.svg)](https://jitpack.io/#Abhay-cloud/FBReactionDialog-Library-Android)      [![CodeFactor](https://www.codefactor.io/repository/github/abhay-cloud/fbreactiondialog-library-android/badge)](https://www.codefactor.io/repository/github/abhay-cloud/fbreactiondialog-library-android) 
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/cb4cfa68dd084f1c82f552175d4443d8)](https://www.codacy.com/gh/Abhay-cloud/FBReactionDialog-Library-Android/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Abhay-cloud/FBReactionDialog-Library-Android&amp;utm_campaign=Badge_Grade)
![Stars](https://img.shields.io/github/stars/Abhay-cloud/FBReactionDialog-Library-Android.svg)
![Forks](https://img.shields.io/github/forks/Abhay-cloud/FBReactionDialog-Library-Android.svg)

> Checkout [TODO](#todo)

## Demo

![](https://j.gifs.com/OgRnKE.gif)

## Usage

### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### Step 2. Add the dependency
```
dependencies {
	        implementation 'com.github.Abhay-cloud:FBReactionDialog-Library-Android:1.2'
	}
```    

### Initialization
```java 
// FBReactionDialog fbReactionDialog = new FBReactionDialog(Context context, View view);
FBReactionDialog fbReactionDialog = new FBReactionDialog(this, binding.likeButton);
```
Here View can be button, textview, any type of view or your custom view.

### Showing FBReactionDialog
```java
fbReactionDialog.show();
```
You can call `.show()` method under onClickListener or onLongClickListener

### set setOnReactionChangedListener
```java
 fbReactionDialog.setOnReactionChangedListener(new OnReactionChangedListener() {
            @Override
            public void onReactionChange(int reaction) {
                // do something when user clicks on reaction
            }
        });
```		
Refer [Reaction Codes](#codes)

### set sound enabled/disabled
```java
// fbReactionDialog.setSoundEnabled(boolean isSoundEnabled);
fbReactionDialog.setSoundEnabled(false);
```
By default reaction sound is enabled

### getCurrentReaction
```java
int reaction = fbReactionDialog.getCurrentReaction();
```
returns the current reaction. Refer [Reaction Codes](#codes)

### dismissing FBReactionDialog
```java
fbReactionDialog.dismiss();
```

<a name="codes"></a>
### Reaction codes
  REACTION_LIKE = 0

  REACTION_LOVE = 1

  REACTION_HAHA = 2

  REACTION_WOW = 3

  REACTION_ANGRY = 4
  
  <a name="todo"></a>
  ## TODO
  > Custom emojis in next version
  
  > Custom reaction sounds 

  ## LICENSE
Project is published under the Apache 2.0 license. Feel free to clone and modify repository as you want, but don't forget to add reference to authors.

## Connect with me
If you have any difficulty then just message me on Instagram or LinkedIn.

[![](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abhaysing-bhosale-7177a91a5/)
[![](https://img.shields.io/badge/Twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/Abhay_Developer)
[![](https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/its_sn_abhay/)
[![](https://img.shields.io/badge/Telegram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/abhaycloud)


### Made with ❤️ by Abhay
