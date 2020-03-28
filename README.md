# mvc-mvp-mvvm

### 1.不使用任何框架
所有的逻辑的都在activity中，导致activity格外臃肿庞大油腻。

### 2. mvc
mvc是model、view、controler。
* view就是layout布局页面；
* controler就是activity；
* model是处理业务逻辑的，比如读取数据库或者请求接口数据等；

view点击事件->activity->model操作业务->更新view

这里的更新view还是通过activity，通过请求数据成功与否，接口回调给activity，activity再去操作页面。

mvc是传统的web开发的一种模式，在android端不太兼容，因为activity始终是view层的东西，这里兼职做controller，还是太过臃肿油腻。

### 3. mvp
mvp是model、view、presenter。
* model是处理业务逻辑的
* view是activity和layout
* presenter作为中间层，把view和model分隔开，所以要同时有他们两个的实例对象或者接口。

mvp的显著特点就是用presenter把view和model分隔开，为了不直接使用view和model对象，需要定义两个接口，业务复杂的时候就是很多个接口。

### 4. mvvm
mvvm是model、view、viewmodel。
* model是处理业务逻辑的
* view是activity和layout，由于使用DataBinding，layout的作用加重，activity可以专心做必须activity做的事情，比如初始化设置、申请权限等。
* viewmodel，由于layout作用增大，需要为它提供一个类似的model去配合它，于是又了viewmodel，是专职页面的model，通过DataBinding绑定model和layout，省去了好多代码。

### 5. DataBinding
#### 5.1 layout必须是DataBinding的写法
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="viewmodel"
            type="com.example.mmm.mvvm.MVVMViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <EditText
            ...
            android:text="@={viewmodel.inputStr}" />

        <Button
            ...
            android:onClick="@{viewmodel::onclick}" />

        <TextView
            ...
            android:text="@{viewmodel.result}" />
    </LinearLayout>
</layout>
```
#### 5.2 activit.setContentView改写
```
ActivityMvvmBinding binding = DataBindingUtil.setContentView(MVVMActivity.this, R.layout.activity_mvvm);
binding.setViewmodel(new MVVMViewModel(getApplication()));
```
#### 5.3 viewmodel必须实现BaseObservable
```
public class MVVMViewModel extends BaseObservable {

    private String inputStr="aaa";
    private String result;

    ...

    @Bindable
    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
        notifyPropertyChanged(BR.inputStr);
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }
}
```
#### 5.4 遗留问题
如果此时需要在viewmodel中调用activity的方法，比如申请权限等，就没有好的方法，只能用EventBus等全局的通知形式，这里推荐用liveData，使得其他东西可以监听viewmodel数据的改变。

### 6. DataBinding的原理
DataBinding在编译的时候，在正式编译前，DataBinding框架会把`layout`等编译为没有DataBinding的静态代码，`findviewById`和`setListener`都会在静态代码块中。
