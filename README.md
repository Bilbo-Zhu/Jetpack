# Welcome to the Jetpack wiki!

## **LifeCycle**

* **LifeCycle是什么**：是一个类，用于存储有关组件（如 Activity 或 Fragment）的生命周期状态的信息，并允许其他对象观察此状态。

* **怎么使用LifeCycle**:
需要被观察的组件实现LifeCycleObserver接口，同时注册到被观察者列表， 如下：
class MyObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
        ...
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener() {
        ...
    }
}
myLifecycleOwner.getLifecycle().addObserver(MyObserver())

* **LifeCycle可以跟踪哪些生命周期变化**：
![](https://github.com/Bilbo-Zhu/Jetpack/blob/main/pic/lifeCycle_event_status.png)

* **注意**：
1. 原生的Activity和Fragment已经继承了LifeCycleOwner接口
2. LifeCycle跟踪的生命周期还不够全，个人更建议自定义生命周期管理接口
3. 如果尝试管理整个应用的生命周期，可以使用ProcessLifeCycleOwner

**Reference**: 
1）[Jetpack官方中文文档](https://developer.android.com/topic/libraries/architecture/lifecycle?hl=zh-cn)；
2）[使用LifeCycle解耦页面与组件](https://juejin.cn/post/6987586341684920328)；

## **ViewModel**

* **ViewModel什么**：ViewModel用于为Activity和Fragment准备UI数据

* **ViewModel特点**：具有感知Activity和Fragment生命周期的特点。基于这个特点，同时ViewModel可以避免内存泄漏

* **ViewModel生命周期**：
![](https://github.com/Bilbo-Zhu/Jetpack/blob/main/pic/viewmodel-lifecycle.png)

* **ViewModel解决什么问题**：
1. ViewModel可以在界面因为系统发生变化重建时候依然可以保存数据;
2. ViewModel可以避免内存泄漏

* **ViewModel使用**：
1. 不带参数：
`
   val model: MyViewModel by viewModels()
   或者
   ViewModelProvider(this).get(ViewModel::class.java)
`
2. 带参数：
`
   ViewModelProvider(this, ViewModelFactory()).get(ViewModel::class.java)
`
3. Fragment之间共享
`
   ViewModelProvider(requireActivity(), SharedViewModelFactory()).get(ViewModel::class.java)
   或者
   private val model: SharedViewModel by activityViewModels()
`

**Reference**:
1) [Jetpack官方中文文档](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=zh-cn)；
2）[ViewModel 的职能边界](https://juejin.cn/post/6844904100493017095)；
3) [ViewModel使用以及源码解析](https://juejin.cn/post/6915012483421831175)；
4）[ViewModel基本使用以及封装](https://juejin.cn/post/6962921719522656287)

## **LiveData**


## **DataBinding**

* **引入DataBinding的意义**：让UI界面和布局解藕，原来依赖在UI界面通过findViewById找到view设置数据的模式，现在通过数据绑定库可以自动实现布局和数据类相互绑定。

* **DataBinding的使用**：
1. 在module的gradle文件中启用DataBinding:

`
    dataBinding {
        //noinspection DataBindingWithoutKapt
        enabled = true
    }
`

2. 布局：

![](https://github.com/Bilbo-Zhu/Jetpack/blob/main/pic/xml.png)

>1).layout:布局根节点必须是<layout> . 同时layout只能包含一个View标签. 不能直接包含<merge>;
>2).data:<data>标签的内容即DataBinding的数据. data标签只能存在一个;
>3).variable:通过<variable>标签可以指定类, 然后在控件的属性值中就可以使用;

3. 获取系统自动生成的绑定文件
> Activity中获取：
`
val binding: ActivityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main)
`
或者
`
val binding: ActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater())
`

> Fragment中或者适配器中获取：
`
val listItemBinding = ListItemBinding.inflate(layoutInflater, viewGroup, false)
    // or
    val listItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false)
`

4. 事件处理：
> 方法引用：
`
android:onClick="@{handlers::onClickFriend}"
` 

> 监听绑定：android:onCheckedChanged="@{(cb, isChecked) -> presenter.completeChanged(task, isChecked)}"

5. 可观察字段使用：
> 常用可观察字段（已经满足日常的开发使用）：
ObservableBoolean
ObservableByte
ObservableChar
ObservableShort
ObservableInt
ObservableLong
ObservableFloat
ObservableDouble
ObservableParcelable
ObservableFeild

**Reference**:
1) [Jetpack官方中文文档](https://developer.android.com/topic/libraries/data-binding/expressions?hl=zh-cn)；
2）[DataBinding最全使用说明](https://juejin.cn/post/6844903549223059463)
