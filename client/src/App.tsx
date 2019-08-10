import React from 'react';
import './App.css';
import NavRouter from './routing';
import Navigation from './containers/navigation/Navigation';

class App extends React.Component<object, object> {
  
  constructor(props: any) {
    super(props);
    this.state = {
      clicked: false,
    }
  }

  public render() {

    return (
      <div className="App">
        <NavRouter />
       </div>
    );
  }
}

export default App;
