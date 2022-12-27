# CustomLoader

> Step 1. Add the JitPack repository to your build file


```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  ```
> Step 2. Add the dependency

```
dependencies {
	        implementation 'com.github.dalvik31:CustomLoader:Tag'
	
  
  ```
  
> Step 3 Usage

```
  private val customLoader: CustomLoader by lazy { CustomLoader(this, null) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Custom loader default
        //customLoader.show()

        //Custom loader only with lottie animation
        customLoader.show(Data( lottieAnimation = com.dalvik.customloader.R.raw.progress_default))

        //Custom loader change color progress default
        //customLoader.show(Data(progressColor = android.R.color.holo_blue_bright))

    }
 
 ```


