import React from 'react'

export default function Hello(props){

    //nul 是什么都不渲染
    //<div></div>
    return <div>这是一个fun 组建+{props.name}</div>
    //无论是vue还是react props都是只读的
}