//#region 介绍react 中绑定事件的标准模式


//#endregion 


import React from 'react'
import 'bootstrap/dist/css/bootstrap.css'
import { Link } from 'react-router-dom';
function alertfunit(){
    alert("这是一个一般外部方法");
}

export  default class BindEvent extends React.Component{
 constructor(){

    super()
    this.state={
        msg:'my state message',
        name:'ssss',
        age:'23'
    }
 }
 render(){
     return<div>
        {/* 内部方法和外部方法绑定不同 类似静态方法 和实例方法*/}
     <div className="btn btn-primary" onClick={alertfunit}>一般外部方法</div>
     <hr/>
     <div className="btn btn-primary" onClick={this.confun}>一般内部方法</div>
     <hr/>
     {/*onClick只接收函数 箭头函数就是一个匿名函数  箭头函数的this永远是外部的this 逐层向外查找*/}
     <div className="btn btn-primary" onClick={()=>this.contrue('传参')}>正确内部方法调用</div>
     <hr/>
     <div className="btn btn-primary" onClick={()=>this.statefun('【表情】')}>修改state</div>
    <h3>{this.state.msg }</h3>
    <hr/>
    {/* <div>
				<div>This is Home!</div>
				<div>
				<Link to="/Page1/" style={{color:'black'}}>
				<div>点击跳转到Page1</div>
				</Link>
				<Link to="/Page2/" style={{color:'black'}}>
				<div>点击跳转到Page2</div>
				</Link>
				<Link to="/Page3/" style={{color:'black'}}>
				<div>点击跳转到Page3</div>
				</Link>
				</div>
			</div> */}
      </div>
 }

  confun (params) {
    alert("这是一个一般内部方法");
 }
 contrue=(arg)=>{
    alert("这是一个正确的内部方法"+arg);
 }
 statefun=(arg)=>{
     alert("修改state" +arg)
     //react中数据的修改state数据 重新赋值 不能直接使用this.state.***=值
      //this.state.msy='修改后的数据'
     //应该使用react提供的this.setState()来修改 其中对应的值得到修改 只是更新对应的数据 其他数据不会覆盖
     this.setState({ msg:'修改后的值'+arg},function(){
        console.log('回调函数的'+this.state.msg)
     })
     //this.setState() 是一个异步函数 在其下面获取修改数据可能得到的不是急事更新数据
     //如果必须在后面获取数值必须要跟在后面的回调函数
     console.log('逻辑的'+this.state.msg)
     console.log(this.state.name)
 }
}