var React = require('react');
var ReactDOM = require('react-dom');

var Login = React.createClass({
  
  
  render: function() {
    return (<form className='form-)
    
  
  }

});


var Test = React.createClass({
  getInitialState: function() {
    return { name: ''};
  },  
  clickEvent: function(e) {
    console.log('here');
    this.setState({name: 'Pong'});
  },
  
  render: function() {
    return (<div>
            <h1>Hello, There! {this.state.name}</h1>
              <button onClick={this.clickEvent}>Ping</button> </div>);
  }

});


ReactDOM.render( <Test />, document.getElementById('main'));
