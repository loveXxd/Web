import React from 'react'
import CmtItem from "@/components/CmtItem"
import cssstyle from '@/css/styles.css'
//引用已经安装在modules的组件可以省略modules文件夹直接引用 默认回去modules目录下寻找直接以包明开始
//这样加载的css都是以模块化的方式加载 如果用配置来排除modules的话引入有会有冲突所以不可行
//所以第三方一般是以.css 结尾的我们可以用.scss或者.less来表示自己的样式文件这样就可以只启用自己模式的模块
import bootcss from 'bootstrap/dist/css/bootstrap.css'
console.log(cssstyle)
export default class CmList extends React.Component{

    constructor(){
        super()
        this.state={
            CommenrList:[
                {id:1,user:'李四',content:"哈哈哈"},
                {id:2,user:'撒大',content:"阿发阿道夫"},
                {id:3,user:'爱上',content:"暗示法"},
                {id:4,user:'发发',content:"啊发生的"},
                {id:5,user:'对开',content:"大发光火"},
                {id:6,user:'发来',content:"地方很多"}
            ]

        } 
    }
    render(){
return <div>
    {/* 注意如果在jsx中书写行内样式 不能直接style 设置字符串 */}
    {/* 而是这么写 style={{color:'red',fontSize:'30px'，zIndex:3}} 多字符的时候使用驼峰的书写格式*/}
    {/* 行内样式如果是数值类型 则可以不用引号 如果字符串类型的样式值必须用引号包裹 className="title" 一个标签不能同时存在多个class name */}
    {/* <h1 className={cssstyle.title  + ' test'}>这是评论组建</h1> 模块化样式和非模块化样式公用 切记 ' test'引号内部有一个空格 或者 
        className={[cssstyle.title , 'test'].join(' ')
    */}
    <h1 className={[cssstyle.title , 'test'].join(' ')}>这是评论组建</h1>
    {console.log(cssstyle)}
     {/* <button className={[bootcss.btn,bootcss['btn-primary']].join(' ')}>模块化的调用方式</button>  */}
     <button className="btn btn-primary">确定按钮</button>
   {this.state.CommenrList.map(item=><CmtItem{...item}  key={item.id} ></CmtItem>)}
</div>
    }

}