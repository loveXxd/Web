//webpack4.x预定大于配置用于减小地址 打包入口时 src index.js 打包后在dist main.js
const path=require("path")
//导入 在内存中自动生成 index.html
const HtmlWebPackPlugin=require("html-webpack-plugin")
//创建一个插件的实例
const  htmlPlugin=new HtmlWebPackPlugin({
    template:path.join(__dirname,'./src/index.html'),//源文件
    filename:'index.html'//生成内存文件
})

module.exports = {
    mode:"development", //development开发模式 production 生产模式
    plugins:[
        htmlPlugin,
    ]
    // entry: {
    // 	main1:"./src/index",
    // 	main2:"./src/ss"
    // }, //入口文件,从项目根目录指定
    // output: { //输出路径和文件名，使用path模块resolve方法将输出路径解析为绝对路径
    //     path: path.resolve(__dirname, "./dist/js"), //将js文件打包到dist/js的目录
    //     filename: "[name].js" //使用[name]打包出来的js文件会分别按照入口文件配置的属性来命名
    // }
    // mode: "development", //打包为开发模式
    // // 出口对象中，属性为输出的js文件名，属性值为入口文件
    // entry: ["./src/main1","./src/main2","./src/main3"], //入口文件,从项目根目录指定
    // output: { //输出路径和文件名，使用path模块resolve方法将输出路径解析为绝对路径
    //     path: path.resolve(__dirname, "../dist/js"), //将js文件打包到dist/js的目录
    //     filename: "main.js" 
    // }


}
//export default{} // 不支持 es6 导出API 对应import ** from
