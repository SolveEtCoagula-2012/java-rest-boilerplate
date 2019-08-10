import React from 'react';
import './App.css';
import TableContainer from './containers/table/TableContainer';
import { connect } from 'react-redux';

class App extends React.Component<object, object> {
  
  public render() {

    return (
      <div className="App">
         <TableContainer />
      </div>
    );
  }

}

export default connect()(App);
