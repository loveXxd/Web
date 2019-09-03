//webpack4.x预定大于配置用于减小地址 打包入口时 src index.js 打包后在dist main.js
const path=require("path")
//导入 在内存中自动生成 index.html
const HtmlWebPackPlugin=require("html-webpack-plugin")
//创建一个插件的实例
const  htmlPlugin=new HtmlWebPackPlugin({
    template:path.join(__dirname,'./src/index.html'),//源文件
    filename:'index.html'//生成内存文件
})
//webpack 默认只能打包处理.js 后缀名类型的文件 像.png .vue 无法处理要配置第三方
module.exports = {
    mode:"development", //development开发模式 production 生产模式
    plugins:[
        htmlPlugin,
    ],
    module:{//所有第三方 模块的配置规则
        rules:[//第三方配置规则
             {test:/\.js|jsx$/,use:'babel-loader',exclude:/node_modules/},//需要排除多余文件夹 
            // //打包处理css样式 第三方loader ?modules样式表启动模块化 限制后的样式不能直接用className="title"访问
            // //后面可以&参数localIdentName 表示css对象的命名方式其中有一些后面带-或者不带”-“为了规范拼接时候需要注意[path][name]-[local]-[hash:length] 
            // // [path][name]_[local]_[hash:base64:5]
            // //[path] 项目的根目录
            // //[name] 文件名称
            // //[local] 样式的定义名 每个class 或id名称
            // //[hash:length] 防止冲突的hash码 最长32位 可以自己定义长度
            // {test:/\.css$/,use:['style-loader','css-loader']},
            // {test:/\.ttf|woff|woff2|eot|svg$/,use:'url-loader'},//打包处理字体文件的loader 安装url-laoder 和file-loader
            // {test:/\.scss$/,use:['style-loader', 'css-loader?modules', 'sass-loader']},//模块化scss的样式文件
        ]
    },
    resolve:{
        extensions:['.js','.jsx','.json','.vue'],//引入的时候后缀可以省略
        alias:{'@':path.join(__dirname,'./src')},//配置 @代表项目src下的绝对路径 
    },
    entry: {
    	my1:"./src/my1",
    	//main2:"./src/ss"
    }, //入口文件,从项目根目录指定
    output: { //输出路径和文件名，使用path模块resolve方法将输出路径解析为绝对路径
        path: path.resolve(__dirname, "./dist/js"), //将js文件打包到dist/js的目录
        filename: "[name].js" //使用[name]打包出来的js文件会分别按照入口文件配置的属性来命名
    }
    // mode: "development", //打包为开发模式
    // // 出口对象中，属性为输出的js文件名，属性值为入口文件
    // entry: ["./src/main1","./src/main2","./src/main3"], //入口文件,从项目根目录指定
    // output: { //输出路径和文件名，使用path模块resolve方法将输出路径解析为绝对路径
    //     path: path.resolve(__dirname, "../dist/js"), //将js文件打包到dist/js的目录
    //     filename: "main.js" 
    // }


}
//export default{} // 不支持 es6 导出API 对应import ** from
