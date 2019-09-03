
//function 方法 和class 语法糖 所有的静态方法、变量都是挂载在实例的prototype  p1.prototype下或者在原形直接访问

function person (name,age){
this.name=name
this.age=age
}
//类内属性可以是静态属性 不能被实例后的对象访问p1
person.info="staticfun"
//实例方法
person.prototype.say=function(){
    console.log("这是fun的实例方法")
}
//静态方法
person.show=function(){
    console.log("这是fun的静态方法")
}


const p1=new person("大黄",20);
//普通属性属性 能被实例后的对象访问怕
p1.info="fun"
//实例方法可以通过实例调用
p1.say()
console.log(p1)
console.log(person.info)
//fun 的静态方法都挂在构造函数上所以不能直接访问但是可以子啊constructor下访问
p1.constructor.show()
person.show()
class Animal{
    //构造函数 不写的话默认构造函数是个空函数
    constructor(name,age){
        //name age可以不再类内设定直接构造
        this.name=name
        this.age=age
    }
    //类内属性可以是静态属性 不能被实例后的对象访问c1
    static info="staticclass"
    //普通属性属性 能被实例后的对象访问c1
    info="class"
    //实例方法
    jiao(){
        console.log("这是 class的实例方法")
    }
    //静态方法
    static show(){
        console.log("这是 class的静态方法")
    }
}

const a1=new Animal("小绿","18")
a1.jiao()
console.log(a1)
console.log(Animal.info)