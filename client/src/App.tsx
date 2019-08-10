import React from 'react';
import './App.css';
import NavRouter from './routing';

class App extends React.Component<object, object> {

  public render() {

    return (
      <div className="App">
        <NavRouter />
       </div>
    );
  }
}

export default App;
