# Jetpack

Welcome to the Jetpack wiki!

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
![](https://github.com/CaptainsZhu/Jetpack/blob/main/lifeCycle_event_status.png)

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
![](https://github.com/Bilbo-Zhu/Jetpack/blob/main/viewmodel-lifecycle.png)

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


