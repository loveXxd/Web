//父类
class person{
    //公用的一些属性和方法可以放在父类里面统一管理继承
    //不同子类不同的属性应该在子类里面自己实现 如果还需要父类的一些属性则需要自己实现构造函数并且 用super调用父类的构造函数
    //如果有参数的话需要逐层传递 子类特有元素要放在super之下
    constructor(name,age){
        this.name=name
        this.age=age
    }
    say(){
        console.log("你好")
    }
}

//子类继承父类 使用extens关键字
class Chiness extends person{
    //如果想自己实现构造函数 如果想有参数构造必须要逐层传递
    constructor(name,age,IDNum){
        //父类的构造函数 如果想有参数构造必须要逐层传递
        super(name,age) 
        //一些子类独有的属性需要放在子类里面 并且必须写在super下面
        this.IDNum=IDNum
    }

}
class America extends person{
    

}

const c1=new Chiness("张三",12,"220724wewwew")
c1.say()
console.log(c1.name+"----------"+c1.age)