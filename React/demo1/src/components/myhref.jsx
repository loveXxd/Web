import React from 'react';
import { HashRouter as Router,Route,Switch} from 'react-router-dom';
import Home from './BindEvent';
import Page1 from './BindEventValue';
import Page2 from './CmList';
import Page3 from './Hello';
 
class App extends React.Component {
	render(){
		return(
		<Router >
		 <Switch>
			<Route path="/Page1" component={Home} />
			<Route path="/" component={Page1} />                                                                                                                                                                                                                                                                                   
			<Route path="/Page2" component={Page2} />  
			<Route path="/Page3" component={Page3} />                                                                                                                                                                                                                                                                                                                                                                                                                                          
		</Switch>
		</Router>
		)
 
		}
	}
export default App;