import React from 'react';
import { HashRouter as Router,Route,Switch} from 'react-router-dom';
import Home from './BindEvent';
import Page1 from './BindEventValue';
import Page2 from './CmList';
import Page3 from './Hello';
 
class App extends React.Component {
	render(){
		return(
		 <div>
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
			</div> 
		)
 
		}
	}
export default App;