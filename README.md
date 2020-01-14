# ActivityLauncher

告别onActivityResult，通过Callback方式进行Activity跳转

#### 添加依赖
- 在Project的Gradle文件中添加JitPack仓库：
```
allprojects {
    repositories {
        google()
        jcenter()

        // 添加JitPack仓库
        maven { url 'https://jitpack.io' }
    }
}
```
- 在app项目的Gradle文件中添加ActivityLauncher库依赖：
```
implementation 'com.github.bbssyyuui:ActivityLauncher:1.0.2'
```

#### 如何调用
```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 启动Activity（方式一）
        ActivityLauncher.init(this)
                .startActivityForResult(TestActivity.class, new ActivityLauncher.Callback() {
                    @Override
                    public void onActivityResult(int resultCode, Intent data) {
                        // 处理回调信息
                    }
                });
                
        // 启动Activity（方式二）
        Intent intent = new Intent(this, TestActivity.class);
        ActivityLauncher.init(this)
                .startActivityForResult(intent, new ActivityLauncher.Callback() {
                    @Override
                    public void onActivityResult(int resultCode, Intent data) {
                        // 处理回调信息
                    }
                });
    }
```
