//1.两个导入必须这么写
import React from 'react' //创建组建、虚拟Dom 、生命周期 
import ReactDOM from 'react-dom' //把创建好的组建和虚拟DOM放到页面

//如果使用class定义组件 与function 不同可以有自己的私有数据性和生命周期函数
// 必须让自己的组件继承自React.Component 如果引入以下面的形式 
//import React ,{Component}from 'react' // Component组件直接引入
class Movie extends React.Component{
    constructor(){
        //继承的所有必须super
        super()
        //super后可以调用自己的this创建私有数据 可读可写 叫做有状态组件区别是有无state属性 有无周期函数
        this.state={//这个this.state={}就相当于 vue中的data(){returm {}}
            msg:'大家好，我是class 创建的movie组件'
        }


    }
    //在组件内部必须有render函数 渲染虚拟DOM元素
    render(){
        //reder 函数中，必须烦恼会合适的JSX 虚拟的DOM结构
        //在class内部接收去父组件传递过来的props参数 不需要形参接收等处理直接用 this.props.***访问即可
        this.state.msg="值已经被我修改了"
        return <div> 这个组件是class创建的----{this.props.name}-----{this.props.age} 
        
        <h3>{this.state.msg}</h3>
        </div>
    }
}
const user={
    name:"aaaaaa",
    age:"bbbbbbbbb"
}

ReactDOM.render(<div>
    1111111111111
    <Movie  name="myclassDom" age="first"></Movie>
    <Movie {...user} ></Movie>
    </div>
    ,document.getElementById("App"))