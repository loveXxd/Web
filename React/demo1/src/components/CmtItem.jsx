import React from 'react'

//js 样式对象引入


// //行内样式提取对象
// const styles={
// item:{border:'1px dashed #ccc',margin:'10px',padding:'10px',boxShadow:'0 0 10px #ccc'},
// user:{fontSize:'14px'},
// content:{fontSize:'12px'}
// }
//也可以把style对象统一封装
import jsstyles from '@/components/styles'

 
//CSS 样式对象引入这样直接引入的话class没有区域限制 
//import outstyle from '@/css/styles'
//如果想要显示区域要在webpack.config里面配置  ?modules 限制后的样式不能直接用className="title"访问
import cssstyle from '@/css/styles.css'



export default function CmtItem( props){
    return <div style={jsstyles.item}>
     <div  id={cssstyle.user}>评论人：{props.user}</div>
     <p >评论内容：{props.content}</p>
    </div>

}