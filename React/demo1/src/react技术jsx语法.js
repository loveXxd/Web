//1.两个导入必须这么写
import React from 'react' //创建组建、虚拟Dom 、生命周期 
import ReactDOM from 'react-dom' //把创建好的组建和虚拟DOM放到页面


/**
 *  js混入类似html的编写方式叫做 JSX符合XML规范的js
 * 默认是不支持 的否则打包会失败 可以用babel转换
 * jsx的本质还是再运行的时候把他和转化成React.createElement();
 *
 */


 //应用{}可以把js变量添加到html标签内
//数字用{a}渲染 但是不能进行运算{a+2}显示是12 {a+a} 22
let a=11;
//字符串用{b}渲染
let b="你好啊 中国"
//bool 是不显示的 {c.toString()}
let c=true
//添加属性
let d="myid"
//添加html
let e=<div>我是动态添加的div</div>
let arr=[
    <h1 key="11" name="11">111111</h1>,
    <h2 key="22" name="22">222222222</h2>
]
const arrStr=['二道河','但hi时间','电话的力量']
const namearr=[]
// for map 等循环必须加key 需要加在最外层dom
arrStr.forEach((item ,index)=>{
    let nameout= <h5 key={item}  className={index}>{item}</h5>
    namearr.push(nameout)
})
//jsx注释
 {/*arr*/}
 {
    //arr
  }
ReactDOM.render(<div>{a+a}
<hr/>
{b+b}
<hr/>
{c?"你是真的":"你是假的"}
<hr/>
<p id={d}>这是一耳光p</p>
<hr/>
{e}
<hr/>
{arr}
<hr/>
{namearr}
<hr/>
{arrStr.map((item,index)=>{
    return <h5 key={item} className={index}>{item}</h5>
 })}
<hr/>
 {/*arr*/}
  {
      //arr
    }
<hr/>
 <label htmlFor="qqqq">11111</label>
</div>,document.getElementById("App"))