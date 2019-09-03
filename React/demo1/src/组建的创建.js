//1.两个导入必须这么写
import React from 'react' //创建组建、虚拟Dom 、生命周期 
import ReactDOM from 'react-dom' //把创建好的组建和虚拟DOM放到页面
import Helloout from './components/Hello'//正常.jsx后缀是不可以省略的但是在webpack.config配置后可以 resolve:{extensions:['.js','.jsx','.json']//引入的时候后缀可以省略}
import VueHelloout from '@/components/Hello'//正常@在React里面默认是不可以代替目录的的但是在webpack.config配置后可以 alias:{'@':path.join(__dirname,'./src')},//配置 @代表项目src下的绝对路径 





//定义组建的第一种方式函数 首字母必须大写
function Hello(props){

    //nul 是什么都不渲染
    //<div></div>
    return <div>这是一个fun 组建+{props.name}</div>
    //无论是vue还是react props都是只读的
}

const dog={
    name:"大黄",
    age:3,
}
const dog2={
    cl:"二代",
    ...dog
}

ReactDOM.render(<div>
    1111111111111
    {/*直接以标签的形式创建*/}
    
    <Hello name={dog.name} age={dog.age}></Hello>
    <Hello {...dog}></Hello>
    { <Helloout></Helloout> }
    <VueHelloout></VueHelloout>
    </div>
    ,document.getElementById("App"))